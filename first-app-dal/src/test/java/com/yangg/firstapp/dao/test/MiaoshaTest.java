package com.yangg.firstapp.dao.test;

import java.sql.SQLException;
import java.util.concurrent.CountDownLatch;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;


import com.yangg.spring.dao.GoodInfoDAO;
import com.yangg.spring.dao.MiaoshaService;
import com.yangg.spring.model.GoodInfo;
@RunWith(org.springframework.test.context.junit4.SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:application-test.xml"})
public class MiaoshaTest {
	@Autowired
	private MiaoshaService service;
	@Autowired
	private GoodInfoDAO daoq;
	private  Integer id=0;
	@Before
	public void init() throws Exception{
		GoodInfo info  = new  GoodInfo();
		info.setAmount(100L);
		info.setGoodCode("111111");
		info.setSingleAmount(100L);
		daoq.insert(info);
		System.out.print("++++"+id);
	}
	
	@After
	public void after() throws Exception{
		daoq.deleteByPrimaryKey(id);
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
		 System.out.println(totalCount+"人"+total+"++卖出++");
		
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
			
			try {
				boolean result =service.modifyAmount("111111", amount);
				if(result){
					total +=amount; //总共卖出去多少成成功多少 total=total+amount
					totalCount+=1;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
