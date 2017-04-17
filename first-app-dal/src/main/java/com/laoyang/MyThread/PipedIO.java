package com.laoyang.MyThread;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 任务间使用管道进行输入、输出
 * 
 * @author yg
 *  任务间使用管道进行输入/输出
 *  可以看诚是生产者和消费者的变体：
 *  这个管道是个封装好的解决方案；管道基本上是一个组赛队列；
 *  下面是使用2个任务使用一个管道进行通信
 *  http://blog.csdn.net/liangrui1988/article/details/40260163
 */
class Sender implements Runnable {
	private Random rand = new Random(47);
	private PipedWriter out = new PipedWriter();

	public PipedWriter getPipedWriter() {
		return out;
	}

	@Override
	public void run() {
		try {
			while (true) {
				for (char c = 'A'; c <= 'z'; c++) {
					out.write(c);
					TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));

				}
			}
		} catch (IOException e) {
			System.out.println(e + " sender write Exception");
		} catch (InterruptedException e) {
			System.out.println(e + " sender sleep interrupted");
		}

	}

}

class Receiver implements Runnable {

	private PipedReader in;

	public Receiver(Sender sender) throws IOException {
		in = new PipedReader(sender.getPipedWriter());
	}

	@Override
	public void run() {
		try {
			while (true) {
				// blocks until characters are there
				System.out.println("Read:" + (char) in.read() + ",");

			}
		} catch (IOException e) {
			System.out.println(e+"receiver read execption");
		}

	}

}

public class PipedIO {
	// 接收器 Receiver
	public static void main(String[] args) throws IOException, InterruptedException {
		Sender sender = new Sender();
		Receiver receiver = new Receiver(sender);
		
		ExecutorService exec=Executors.newCachedThreadPool();
		exec.execute(sender);
		exec.execute(receiver);
		
		TimeUnit.SECONDS.sleep(4);
		exec.shutdownNow();
		
	}
}

/**outpt:
Read:A,
Read:B,
Read:C,
Read:D,
Read:E,
Read:F,
Read:G,
Read:H,
Read:I,
Read:J,
Read:K,
Read:L,
Read:M,
Read:N,
Read:O,
Read:P,
java.lang.InterruptedException: sleep interrupted sender sleep interrupted
Read:Q,
java.io.IOException: Write end deadreceiver read execption

 */
