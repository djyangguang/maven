package com.yangg.spring.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yangg.spring.model.MenuInfo;
import com.yangg.spring.model.MenuInfoExample;
import com.yangg.spring.page.Page;

public class MenuInfoService {
	@Autowired
	private MenuInfoDAO menuInfoDao;
	public MenuInfo findMenuInfoById (Integer id){
		return menuInfoDao.selectByPrimaryKey(id);
	}
	public List<MenuInfo> findByName(String name,Page page){
		MenuInfoExample example = new MenuInfoExample();
		MenuInfoExample.Criteria criteria = example.createCriteria();
		if(StringUtils.isNotBlank(name)){
			criteria.andNameLike("%"+name+"%");
		}
		return menuInfoDao.selectByExample(example);
	}
	public void saveMenuInfo(MenuInfo menuInfo){
		if(menuInfo !=null){
			 menuInfoDao.insertSelective(menuInfo);
		}
	}
	/**
	 * 测试事务不回滚 
	 * 父亲事务 这就说明开启了事务
	 * DEBUG datasource.DataSourceTransactionManager - Creating new transaction with name [test1]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT; ''
		DEBUG datasource.DriverManagerDataSource - Creating new JDBC DriverManager Connection to [jdbc:mysql://127.0.0.1:3306/test_db]
		DEBUG datasource.DataSourceTransactionManager - Acquired Connection [com.mysql.jdbc.JDBC4Connection@194eab6] for JDBC transaction
		DEBUG datasource.DataSourceTransactionManager - Switching JDBC Connection [com.mysql.jdbc.JDBC4Connection@194eab6] to manual commit
		如果想要回滚 级必须是RuntimeException 或者他的子类
	 */
	/**
	 *带事务的方法里面在加方法这个方法如果报错的华也不会回滚的
	 *解决方法是MenuInfoService.childTransaction()这样写也不行
	 *要放到另外的对象中加方法;
	 *避免方法中加本类的方法;
	 * ctrl+shift+/ 批量注释
	 */
	@Transactional
	public void parentTransaction(){
		try{
			childTransaction();
		}catch(Exception e){
			
		}
		MenuInfo menuInfo = new MenuInfo();
		menuInfo.setMemo("parent");
		menuInfo.setName("yg parent");
		menuInfoDao.insertSelective(menuInfo);
		
	}
	//@Transactional(propagation = Propagation.REQUIRES_NEW )传播属性
	@Transactional
	public void childTransaction(){
		MenuInfo menuInfo = new MenuInfo();
		menuInfo.setMemo("child");
		menuInfo.setName("yg child");
		menuInfoDao.insertSelective(menuInfo);
		throw new RuntimeException("child异常！！！！！！");
		
	}
}
