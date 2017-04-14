package com.yangg.spring.page;

public class MysqlDialect implements Dialect {

	@Override
	public String getLimitString(String sql, int offest, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCountCountSqlString(String sql) {
		// TODO Auto-generated method stub
		if(sql!=null && sql.length()>0){
			//StringBuffer sb = new StringBuffer("select count(*) as"+RS_Count+"");
		}
		return null;
	}

}
