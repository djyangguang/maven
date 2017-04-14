package com.yangg.spring.page;

public interface Dialect {
	
	public static final String RS_COUNT="rs_count";
	//分页语句的数据库方言
	public String getLimitString(String sql,int offest,int limit);
	//connt 语句的方言
	public String getCountCountSqlString(String sql);
	
		

}
