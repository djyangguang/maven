package com.laoyang.MyThread;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Latch 锁存器 
 * 新类库中的构件 countDownLatch
 * 
 * @author yg
 * 
 * CountDownLatch :他被用来同步一个活多个任务;强制他们等待由其他任务执行的一组操作完成
 * 将一个程序分为N个相互独立的可解决任务；并创建值为0的CountDownLath.当每个任务完成时
 * 都会在这个锁存器上调用ciuntDown(),等待问题被解决的任务在这个锁存器上调用await().将他们自己拦住
 * 直到锁存器计数结束
 */
class TaskPortion implements Runnable {

	private static int counter = 0;
	private final int id = counter++;
	private static Random rand = new Random(47);

	private final CountDownLatch latch;

	public TaskPortion(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			doWork();
			latch.countDown();
		} catch (InterruptedException e) {
			// acceptable way to exit
		}

	}

	// 处理业务代码
	public void doWork() throws InterruptedException {
		TimeUnit.MILLISECONDS.sleep(rand.nextInt(2000));
		System.out.println(this + " 完成");
	}

	public String toString() {
		return String.format("%1$-3d", id);
	}

}

// waits on the countDownLatch
class WaitingTask implements Runnable {
	private static int counter = 0;// 计数
	private final int id = counter++;
	private static Random rand = new Random(47);

	private final CountDownLatch latch;

	WaitingTask(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			// 调用countDown()的任务在产生调用时并没有被阻塞，只有对await的调用会被阻塞，直至计数值到达0
			// 等待问题被解决的任务在这个锁存器上调用await(),将它们自已拦住，直至锁存器计数结束
			latch.await();
			System.out.println("latch 障碍被认为 " + this);
		} catch (InterruptedException e) {
			System.out.println(this + " interrupted");
		}
	}

	public String toString() {
		return String.format("waitingTask %1$-3d", id);
	}
}

/**
 * TaskPortio将随机地休眠一段时间，以模拟这部分工作的完成，而WaitingTask表示系统中等待的部分，它要等待到问题的初始部分成完为止，
 * 所有的任务都使用了在main中定义同一个单一的counDownLacth
 * 
 * @author lenovo
 * 
 */
public class CountDownLatchDemo {
	static final int SIZE = 100;

	public static void main(String[] args) throws InterruptedException {
		ExecutorService exec = Executors.newCachedThreadPool();
		CountDownLatch latch = new CountDownLatch(SIZE);

		// 都必须共享一个countDownLatch对象
		for (int i = 0; i < 10; i++) {
			exec.execute(new WaitingTask(latch));// 这个要等待 latch上面的为0时才会执行
		}
		for (int i = 0; i < SIZE; i++) {
			exec.execute(new TaskPortion(latch));
		}

		// latch.await();
		System.out.println("launched all tasks");
		exec.shutdown();// quit when all task complete
	}

}
