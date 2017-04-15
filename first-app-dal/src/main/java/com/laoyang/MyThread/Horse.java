package org.rui.thread.newc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


/**
 * 赛马游戏 CyclicBarrier
 * CyclicBarrier: 你希望创建一组任务，他们并行的执行工作；然后在进行下一个步骤之前等待
 直到所有的任务都完成（像join()）.他使得所有的并行任务都将在删栏处列队，因此可以一致的向前移动；
 这像 CountDownLatch,只是CountDownLatch是只触发一次的事件，尔CyclicBarrier可多次重用
 
 * @author lenovo
 * 
 */
class Horse implements Runnable {
	private static int counter = 0;
	private final int id = counter++;
	private int strides = 0;
	private static Random rand = new Random(47);
	private static CyclicBarrier barrier;

	public Horse(CyclicBarrier b) {
		barrier = b;
	}

	public synchronized int getStrides() {
		return strides;
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				synchronized (this) {
					//每场比赛都会加上随机 跨过的数字 0,1 or 2
					strides += rand.nextInt(3);// produces 0,1 or 2
				}
				// 等待所有的马都准备完毕，当所有的马向前移动时，cyclicBarrier将自动调用runnable栅栏动作任务，按顺序显示马和终点的位置
				barrier.await();

			}

		} catch (InterruptedException e) {

		} catch (BrokenBarrierException e) {
			throw new RuntimeException(e);
		}
	}

	public String toString() {
		return "Horse" + id + " ";
	}

	// 轨道
	public String tracks() {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < getStrides(); i++) {
			s.append("*");
		}
		s.append(id);
		return s.toString();
	}
}

public class HorseRace {
	static final int FINISH_LINE = 75;// 结束 行
	private List<Horse> horses = new ArrayList<Horse>();
	private ExecutorService exec = Executors.newCachedThreadPool();
	private CyclicBarrier barrier;

	public HorseRace(int nHorses, final int pause) {
		
		barrier = new CyclicBarrier(nHorses/*等待的数量*/, new Runnable() {

			@Override
			public void run() {
				//打印信息 
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < FINISH_LINE; i++) {
					sb.append("=");// 赛马场上的栅栏
				}
				System.out.println(sb);
				for (Horse horse : horses) {
					System.out.println(horse.tracks());
				}
				for (Horse horse : horses) {
					//System.out.println("strides:@@@@@@@" + horse.getStrides());
					if (horse.getStrides() >= FINISH_LINE) {//
						System.out.println(horse + "赢得!");
						exec.shutdownNow();
						return;
					}
				}

				try {
					TimeUnit.MILLISECONDS.sleep(pause);
				} catch (InterruptedException e) {
					System.out.println("barrier-action sleep interrupted");
				}
			}
		});

		// 一旦所有的马都越过了栅栏，它就会自动地为下一回合比赛做好准备
		for (int i = 0; i < nHorses; i++) {
			Horse horse = new Horse(barrier);//每个马都分配一个barrier
			horses.add(horse);
			exec.execute(horse);
		}
	}

	/**
	 * main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int nHorses = 7; //指定马的数量
		int pause = 200;//停顿时间
		String[] arg = {};

		if (arg.length > 0) {// optional argument
			int n = new Integer(arg[0]);
			nHorses = n > 0 ? n : nHorses;
		}
		if (arg.length > 1) {// optional argument
			int p = new Integer(arg[1]);
			pause = p > -1 ? p : pause;
		}

		// 竞赛
		new HorseRace(nHorses, pause);

	}

}
/**
 ===========================================================================
**0
**1
*2
**3
*4
**5
*6
===========================================================================
**0
***1
*2
**3
*4
***5
***6
===========================================================================
***0
****1
***2
***3
**4
*****5
****6
===========================================================================
*****0
****1
*****2
****3
**4
******5
****6
===========================================================================
******0
****1
******2
*****3
****4
******5
*****6
===========================================================================
******0
******1
******2
******3
****4
*******5
*****6
===========================================================================
*******0
******1
*******2
******3
*****4
********5
*******6
===========================================================================
********0
******1
********2
*******3
*******4
*********5
*********6
===========================================================================
********0
******1
*********2
*******3
*********4
*********5
*********6
===========================================================================
**********0
*******1
**********2
********3
*********4
***********5
*********6
===========================================================================
**********0
*******1
************2
*********3
*********4
*************5
*********6
===========================================================================
************0
*******1
*************2
***********3
**********4
***************5
***********6
===========================================================================
************0
********1
*************2
*************3
***********4
***************5
*************6
===========================================================================
**************0
********1
*************2
*************3
*************4
...
...
