package com.yangg.spring.dao;

import java.lang.reflect.Field;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.util.ReflectionUtils;

import com.ibatis.sqlmap.engine.execution.SqlExecutor;
import com.ibatis.sqlmap.engine.impl.SqlMapClientImpl;
import com.ibatis.sqlmap.engine.impl.SqlMapExecutorDelegate;
import com.yangg.spring.model.QueryBean;
import com.yangg.spring.model.TbGradeInfo;
import com.yangg.spring.model.TbGradeInfoExample;
import com.yangg.spring.page.Page;
@Repository
public class ExGradeInfoDaoImpl extends SqlMapClientTemplate implements ExGradeInfoDao  , InitializingBean {

//	@Override
//	public List<TbGradeInfo> findByPage(QueryBean queryBeeqn) {
//		// TODO Auto-generated method stub
//		//tb_grade_info 是exGrade/xml中的<sqlMap namespace="tb_grade_info">
//		//findByPage 就是实现的接口名称
//		//能调用到xml中额一条SQL语句
//		//return this.getSqlMapClientTemplate().queryForList("tb_grade_info.findByPage", queryBeeqn);
//		return this.getSqlMapClientTemplate().queryForList(statementName, parameterObject, skipResults, maxResults)
//	}
	private SqlExecutor sqlExecutor;
	
	


	public List<TbGradeInfo> findbyPage(TbGradeInfoExample example, Page page) {
		// TODO Auto-generated method stub
		//return this.getSqlMapClientTemplate().queryForList("tb_grade_info.selectByExample", example, page.getStartIndex(), page.getPageSize());

		return this.queryForList("tb_grade_info.selectByExample", example, page.getStartIndex(), page.getPageSize());
	}


	//spring 初始化的时候 吧bean 替换掉 反射
	public void afterPropertiesSet() {
		// TODO Auto-generated method stub
		//super.afterPropertiesSet();
		Field field = ReflectionUtils.findField(SqlMapExecutorDelegate.class, "sqlExecutor"); //得到field类
		ReflectionUtils.makeAccessible(field);
		//在这个delegate()里面吧sqlExecutor射进去
		ReflectionUtils.setField(field, ((SqlMapClientImpl)this.getSqlMapClient()).getDelegate(), sqlExecutor);
	}

	

	public void setSqlExecutor(SqlExecutor sqlExecutor) {
		this.sqlExecutor = sqlExecutor;
	}
	
	
	
	

}
