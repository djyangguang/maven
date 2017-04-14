package com.laoyang.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class NIOServer {
	private static ServerSocketChannel server;
	private static int port=8080;
	ByteBuffer rcBuffer = ByteBuffer.allocate(1024);
	ByteBuffer sendBuffer = ByteBuffer.allocate(1024);
	private static Selector selector; //多路复用器
	//维护事件标签的集合 配个seleceor使用
	Map<SelectionKey,String> sessionMsg = new HashMap<SelectionKey,String>();
	public NIOServer(int port) throws IOException{
		this.port=port;
		server = ServerSocketChannel.open();
		server.socket().bind(new InetSocketAddress(port));//发布的ip地址
		server.configureBlocking(false);//配置文件 设置位非柱塞
		selector = Selector.open(); //多路复用器 打开
		server.register(selector,SelectionKey.OP_ACCEPT );//在server注册多路复用器才能为server工作 	OP_ACCEPT ：可接受的状态第一次
		System.out.println("NIO启动=============>端口是"+this.port);
	}
	//监听请求模块
	public void listener() throws IOException{
		while (true){
			//t通过selector来看有没有注册事件
			int eventCount=selector.select();
			if(eventCount<=0){
				//继续轮询NIO内部机制：
				continue;
				
			}
			Set<SelectionKey>keys =selector.selectedKeys();
			Iterator<SelectionKey> iterator = keys.iterator();
			while(iterator.hasNext()){
				process(iterator.next());
				//处理完了移除
				iterator.remove();
			}
			
			
		}
		
	}
	//客户端
	private void process(SelectionKey key) throws IOException {
		// TODO Auto-generated method stub
		SocketChannel client =null;
		if(key.isValid()&&key.isAcceptable()){
			client = server.accept();//接受客户端
			client .configureBlocking(false);
			server.register(selector,SelectionKey.OP_READ );//在server注册多路复用器才能为server工作 	OP_ACCEPT ：读取

		}else if(key.isValid()&&key.isReadable()){
			//读到缓冲区
			rcBuffer.clear();
			client =(SocketChannel) key.channel();
			int len = client.read(rcBuffer);
			if(len>0){
				String msg = new String(rcBuffer.array(),0,len);
				sessionMsg.put(key, msg);
				//高速我们复用器，下次可以写数据
				client.register(selector,SelectionKey.OP_WRITE);			
			}				
		}
		else if(key.isValid()&&key.isWritable()){
			if(!sessionMsg.containsKey(key)){
				return;
				
			}
			//有消息就回复消息 上线下线推送
			client =(SocketChannel) key.channel();
			sendBuffer.clear();
			sendBuffer.put((new String(sessionMsg.get(key)+"请求已经处理")).getBytes());
			sendBuffer.flip();//设置我们的读取位；优化读写 ；标志位
			client.write(sendBuffer);
			client.register(selector, SelectionKey.OP_READ);//可以读了
			
		}
		key.cancel();//释放
		client.socket().close();
	}
	public static void main (String[] args){
		try {
			new NIOServer(port).listener();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
