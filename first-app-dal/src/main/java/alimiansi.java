import java.util.Scanner;

public class alimiansi {

	
	 
	/**
	 * 有一个消息队列集群，集群里每台Broker的响应时间RT都不一样，
	 * 但是每台Broker的极限服务QPS都是一样的，超过这个QPS会出现过载雪崩。
	 * 而消息的生产者客户端，每次发送都会选择其中的一台broker来发送，一般来说发送逻辑是运行在一个线程池里面。
	 * 假设cpu资源充足，通过实现一个负载均衡算法，使得生产者能够达到最大吞吐量，最优的平均响应时间，但是又不能把任何一台服务器压垮。
	 * 已知每个broker的rt、极限qps，消息生产者的线程数量，请求总数，如果采用吞吐量最优的算法，求处理完所有请求需要的耗时，单位毫秒。
	 * 	QPS：query per second， 每秒请求量
		RT：response time，请求的响应时间
		Broker：消息队列的服务器
	 * @since 17/3/20
	 */
	
	 
	    public static void main(String[] args)  {
	        Scanner in = new Scanner(System.in);
	        int maxQps= Integer.valueOf(in.nextLine());
	        final String[] rtList = in.nextLine().split(",");
	        final int requestNum = Integer.valueOf(in.nextLine());
	        final int threadNum = Integer.valueOf(in.nextLine());
	        System.out.println(doneTime(maxQps, rtList, requestNum, threadNum));
	    }
	    /**
	     * 如果使用最优的最大吞吐量负载均衡算法，按照最优模型多久能够处理完所有请求，单位毫秒。
	     * @return
	     */
	    static long doneTime(int maxQps,String[] rtList,int requestNum,int threadNum) {
	        //TODO
	        int qpsSum = 0;
	        for (String rtString : rtList) {
	            int singleMaxQps = threadNum * 1000 / Integer.valueOf(rtString);
	            if (singleMaxQps > maxQps) {
	                qpsSum += maxQps;
	            }else {
	                qpsSum += singleMaxQps;
	            }
	        }
	 
	        return requestNum / qpsSum * 1000;
	    }
	}

