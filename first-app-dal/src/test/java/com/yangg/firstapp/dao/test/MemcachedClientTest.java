package com.yangg.firstapp.dao.test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.fastjson.JSON;
import com.whalin.MemCached.MemCachedClient;
import com.yangg.spring.dao.MencatchedService;

import junit.framework.Assert;

@RunWith(org.springframework.test.context.junit4.SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:application-test.xml"})
@TransactionConfiguration(defaultRollback=true) //true 就是不提交数据 insert 不会插入数据
@Transactional
public class MemcachedClientTest {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private MencatchedService catched;
	 @Test
	 public void test() throws Exception {
		 Map<String,Object> reuslt = catched.query();
		 logger.info("++++++++++++++++++++++++="+reuslt);
		 Assert.assertTrue(reuslt !=null);
	 }	
	 /**
	 private CountDownLatch latch= new CountDownLatch(100); 	  
	 private class ExecuteThread implements Runnable{
		public void run() {				
			try {
				//logger.info("===========>"); 
				latch.await();//等到100才开始
				
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
			//catched.query();
			catched.query1();//抽象后的方法
		}		 		 
	 }	 
	 
	 @Test
	 public void test1() throws Exception{
		 for(int i=0;i<100;i++){
			  Thread t = new Thread( new ExecuteThread());
			  logger.info("========"+i);
			  t.start();
			  latch.countDown();//减掉一个
			  
		 }
		 Thread.sleep(3000);//等待2秒这秒数少了会死循环
		 Integer count = catched.getCount();
		 Assert.assertTrue(count==1);		 
			 
	 } **/	
	
//	@Test
//	public void test(){
//		catched.query1();
//		
//	}
}
