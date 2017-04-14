package com.yangg.firstapp.dao.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.cyfonly.flogger.FLogger;
import com.yangg.spring.dao.MenuInfoDAO;
import com.yangg.spring.dao.MenuInfoService;
import com.yangg.spring.model.MenuInfoExample;
@RunWith(org.springframework.test.context.junit4.SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:application-test.xml"})
//@TransactionConfiguration(defaultRollback=false) //true 就是不提交数据 insert 不会插入数据
//@Transactional
public class MenuInfoServiceTest {
	FLogger logger = FLogger.getInstance();
	
	@Autowired
	private MenuInfoService service;
	@Autowired
	private MenuInfoDAO menuInfoDao;
		@Test
		public void test1() throws Exception{
			logger.error("++++++++++test1 begin+++++++++++++");
			service.parentTransaction();
			MenuInfoExample example = new MenuInfoExample();
			MenuInfoExample.Criteria critrtia = example.createCriteria();
			critrtia.andNameEqualTo("parent");
			Assert.assertTrue(menuInfoDao.countByExample(example)==1);
			logger.error("++++++++++test1 end+++++++++++++");
		}
		@Test
		public void test2() throws Exception{
			logger.error("++++++++++test2 begin+++++++++++++");
			service.childTransaction();
			MenuInfoExample example1 = new MenuInfoExample();
			MenuInfoExample.Criteria critrtia1 = example1.createCriteria();
			critrtia1.andNameEqualTo("child");
			Assert.assertTrue(menuInfoDao.countByExample(example1)==1);
			logger.error("++++++++++test2 end+++++++++++++");
		}
}
