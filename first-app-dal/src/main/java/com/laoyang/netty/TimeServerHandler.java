package com.laoyang.netty;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
/**
 * 实际处理类
 * @author master-hadoop
 *
 */
import io.netty.channel.ChannelInboundHandlerAdapter;
public class TimeServerHandler extends ChannelInboundHandlerAdapter {

    
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {
        System.out.println("server channelRead..");
        ByteBuf buf = (ByteBuf) msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body = new String(req, "UTF-8");
        System.out.println("The time server receive order:" + body);
        			//客户端登陆后 服务器给出登陆时间并返回到客户端
         DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ? format.format(new Date(
                System.currentTimeMillis())).toString() : "BAD ORDER";
                currentTime ="老杨欢迎登陆"+currentTime;
        ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
        ctx.write(resp);
    }

   
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("server channelReadComplete..");
        ctx.flush();//刷新后才将数据发出到SocketChannel
    }

    
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        System.out.println("server exceptionCaught..");
        ctx.close();
    }

}
