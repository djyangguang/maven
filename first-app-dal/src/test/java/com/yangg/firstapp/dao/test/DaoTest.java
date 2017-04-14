package com.yangg.firstapp.dao.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.whalin.MemCached.MemCachedClient;
import com.yangg.spring.dao.ExGradeInfoDao;
import com.yangg.spring.dao.TbGradeInfoDAO;
import com.yangg.spring.model.QueryBean;
import com.yangg.spring.model.TbGradeInfo;
import com.yangg.spring.model.TbGradeInfoExample;
import com.yangg.spring.page.Page;

import junit.framework.Assert;

@RunWith(org.springframework.test.context.junit4.SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:application-test.xml"})
@TransactionConfiguration(defaultRollback=true) //true 就是不提交数据 insert 不会插入数据
@Transactional
public class DaoTest {
   
	private  Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private TbGradeInfoDAO gradeInfoDao;
	@Autowired
	private ExGradeInfoDao exGradeInfoDao;
	private MemCachedClient clinet;
	/*@Before
	public void init() throws Exception{
		logger.info("-----------------before");
		TbGradeInfo g = new TbGradeInfo();
		g.setGrade("2");
		g.setId("3");
		g.setStudentId("4");
		g.setSubjecctId("6");
		gradeInfoDao.insert(g);
		
	
				
		
	} 
	*/
	/*
	@Test
	public void test1() throws Exception{
		for(int i=1 ;i<100;i++){
			TbGradeInfo g = new TbGradeInfo();
			g.setGrade(i+"");
			g.setId(i+"");
			g.setStudentId(i+"");
			g.setSubjecctId(i+"");
			gradeInfoDao.insert(g);
		}
		}
	*/
		
		
//		TbGradeInfoExample example = new  TbGradeInfoExample();
//		TbGradeInfoExample.Criteria criteria= example.createCriteria();
//		criteria.andSubjecctIdEqualTo("6");
//		List<TbGradeInfo> infolist= gradeInfoDao.selectByExample(example);
//		System.out.println(infolist);
//		logger.info(""+infolist);
	/*@Test
	//老的分页
	public void testPage() throws Exception{
		QueryBean bean = new QueryBean();
		bean.setPage(new Page());
		bean.setStudentId(3+"");
		List<TbGradeInfo> list =exGradeInfoDao.findByPage(bean);
		
	}
	*/
	
	//新 的分页
//	@Test
//	public void testPage() throws Exception{
//		TbGradeInfoExample example = new TbGradeInfoExample();
//		TbGradeInfoExample.Criteria  criteria=example.createCriteria();
//		criteria.andStudentIdEqualTo("1");
//		criteria.andSubjecctIdEqualTo("2");
//		
//		List<TbGradeInfo> list =exGradeInfoDao.findbyPage(example, new Page());
//		
//	}
	//(XXX=xx and XXX=XXX) or (XXX=XX)
	//(XXX=XX and XXX like XXX)
	//不支持(aaa=xx or bbb=xxx) and (ccc=xxx)
	//group by  不支持
	//(aaa=xx and ccc=xxx) or (bbb =xx and ccc=xxx)
	@Test
	public void test1() throws Exception{
		TbGradeInfoExample example = new TbGradeInfoExample();
		TbGradeInfoExample.Criteria criteria =example.createCriteria();
		criteria.andSubjecctIdEqualTo("1");
		criteria.andSubjecctIdEqualTo("2");
		
		TbGradeInfoExample.Criteria orCriteria =example.createCriteria();
		orCriteria.andSubjecctIdEqualTo("2");
		example.or(orCriteria);
		List<TbGradeInfo> list=gradeInfoDao.selectByExample(example);
		logger.info("list========={}",list);
		Assert.assertTrue(list!=null);;
	}
	
	
}
	
	

