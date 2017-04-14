package com.yangg.firstapp.dao.test;

import java.sql.SQLException;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

import org.apache.commons.lang.time.DateUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.cyfonly.flogger.FLogger;
import com.whalin.MemCached.MemCachedClient;
import com.yangg.spring.dao.GoodInfoDAO;
import com.yangg.spring.dao.MiaoshaCacheService;
import com.yangg.spring.dao.MiaoshaService;
import com.yangg.spring.model.GoodInfo;
@RunWith(org.springframework.test.context.junit4.SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:application-test.xml"})
public class MiaoshaCacheTest {
	@Autowired
	private MiaoshaCacheService service;
	@Autowired
	private MemCachedClient client;
	
	private  Integer id=0;
	FLogger logger = FLogger.getInstance();
	@Before
	public void init() throws Exception{
		client.setPrimitiveAsString(true);
		client.set("A1701061146", 100L,DateUtils.addSeconds(new Date(), 1000));
		
	}
	
	@After
	public void after() throws Exception{
		client.delete("A1701061146");
	}
	@Test
	//100个商品 100个人买每个人买3件； 
	public void test1() throws Exception{
		 for (int i=0;i<100;i++){
			 Thread t = new Thread(new ExecuteThread(3L));
			 t.start();
			 latch.countDown();
		 }
		 Thread.currentThread().sleep(3000);
		// System.out.println(totalCount+"人"+total+"++卖出++");
		 logger.error(totalCount+"人"+total+"++卖出++");
		
	}
	private CountDownLatch latch = new CountDownLatch(100);
	private Long total =0L;
	private Integer totalCount=0;
	private class ExecuteThread implements Runnable{
		private Long amount;
		public ExecuteThread(long amount){
			this.amount=amount;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				latch.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
				boolean result =service.modifyAmount("A1701061146", amount);
				if(result){
					total +=amount; //总共卖出去多少成成功多少 total=total+amount
					totalCount+=1;
				}
			
			
		}
		
	}

}
