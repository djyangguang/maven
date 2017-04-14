package com.yangg.firstapp.dao.template.test;


import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * 
 * @author dj
 * 配置(粒度->方法)
 * -反射（代理）
 * -注解@Transactional
 * 方法内部
 * -编程式的事务(1.2-2.0)
 * -现在是transactionTemplate
 *  *  */
@RunWith(org.springframework.test.context.junit4.SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:application-test.xml"})
@TransactionConfiguration(defaultRollback=false) //true 就是不提交数据 insert 不会插入数据
public class TransactionTemplateTest {
	@Autowired
	private TransactionTemplate template;
	@Autowired
	private DataSource datasource;
	@Test
	public void test1() throws Exception{
		final NamedParameterJdbcTemplate t = new NamedParameterJdbcTemplate(datasource);
		final String sql ="INSERT INTO TB_GOODS_INFO (GOOD_CODE,AMOUNT,SINGLE_AMOUNT) VALUES (:goodCode,:amount,:singleAmount)";
		final Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("goodCode", "yg");
		paramMap.put("amount", BigDecimal.ONE);
		paramMap.put("singleAmount", BigDecimal.TEN);
		template.execute(new TransactionCallback<Object>() {
			@Override
			public Object doInTransaction(TransactionStatus status) {
				// TODO Auto-generated method stub
				t.update(sql, paramMap);
				//status.setRollbackOnly();//回滚
				return null;
			}
		
		});
	
	}
	/**
	 * 存储过程
	 * 好处（游标，处理快，控制内存）
	 * -方便
	 * -没有网络流量，性能好
	 * -不用管理连接池
	 * 对于开发来说 是黑盒
	 */
	public void test2() throws Exception{
		final NamedParameterJdbcTemplate t = new NamedParameterJdbcTemplate(datasource);
		final String sql ="SELECT * FROM TB_GOODS_INFO ";
		t.query(sql, new HashMap(), new ResultSetExtractor<Object>(
				
				) {

					@Override
					public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
						// TODO Auto-generated method stub
						rs.setFetchSize(1000); //zhongyao 
						NamedParameterJdbcTemplate  insertemplate= new NamedParameterJdbcTemplate(datasource);
						String insertSql="INSERT INTO TB_GOODS2()";
						List<Map<String,Object>> paramList = new ArrayList<Map<String,Object>>();
						int maxCount =3000;
						int count =0;
						while(rs.next()){
							Map<String,Object> paramMap = new HashMap<String,Object>();
							paramMap.put("", rs.getString(""));
							paramMap.put("", rs.getString(""));
							paramMap.put("", rs.getString(""));
							//insertemplate.update(sql, paramMap);
							paramList.add(paramMap);
						}
						//防止内存挂掉
						if(paramList.size()>=maxCount){
							insertemplate.batchUpdate(insertSql, paramList.toArray(new Map[0]));
							paramList.clear();
							//count =maxCount;
						}
//						else{
//							count ++;
//						}
						insertemplate.batchUpdate(insertSql, paramList.toArray(new Map[0]));

						return null;
					}
		});
	}

}
