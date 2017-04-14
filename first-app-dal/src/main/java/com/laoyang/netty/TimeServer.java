package com.laoyang.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class TimeServer {
	public static void main (String[] args){
		int port =8088;
		 try {
			new TimeServer().bind(port);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void bind (int port) throws InterruptedException{
		//事件模型 线程组 他来做网络的客户端调度
		//eventloopGroup 是接口 后面是实现类
		//bossGroup 上面这个处理客户端conn
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		//workerGroup 实际业务处理 读和写
		
		//启动方式复杂 构成的参数是变化的
		//
		try{
		ServerBootstrap bootstrap = new ServerBootstrap(); //引入辅助启动类 Builder 模式
		bootstrap.group(bossGroup,workerGroup)	//将线程组 放进去	
		.channel(NioServerSocketChannel.class) //创建一个服务器的管道类型 工厂模式
		.option(ChannelOption.SO_BACKLOG, 1024)//套接字的排队列数 1024
		.childHandler(new ChildChannelHandler());//绑定调度处理类
		
		ChannelFuture  future= bootstrap.bind(port).sync();//和我们的并发包类似；Future 属于异步操作 拿计算完成结果 同步；sunc() 同步的
		future.channel().closeFuture().sync();
		}finally{
		bossGroup.shutdownGracefully();
		workerGroup.shutdownGracefully();
		
	}
	}
	
	
	
	/*
	 * 责任链模式
	 */
	private class ChildChannelHandler extends ChannelInitializer<SocketChannel> {
        @Override
        protected void initChannel(SocketChannel arg0) throws Exception {
           // System.out.println("server initChannel..");
            arg0.pipeline().addLast(new TimeServerHandler());
        }
    }
}

