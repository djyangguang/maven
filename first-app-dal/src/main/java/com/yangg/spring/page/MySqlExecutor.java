package com.yangg.spring.page;

import java.sql.Connection;
import java.sql.SQLException;

import com.ibatis.sqlmap.engine.execution.SqlExecutor;
import com.ibatis.sqlmap.engine.mapping.statement.RowHandlerCallback;
import com.ibatis.sqlmap.engine.scope.StatementScope;

public class MySqlExecutor  extends SqlExecutor{
	//ibast有分页的api但是没有用我们需要重写
	//要在application.xml中配置
	@Override
	public void executeQuery(StatementScope statementScope, Connection conn, String sql, Object[] param, int skipResults, int maxResults,
			RowHandlerCallback callback) throws SQLException {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer(sql); //这里SQL必须的写减去
		if(maxResults>0){ //取的条数>0又通过分页
			sb.insert(0, "SELECT * FROM (");
			sb.append(") _TEMP LIMIT ").append(skipResults).append(",").append(maxResults);
		}
		//super.executeQuery(statementScope, conn, sql, param, skipResults, maxResults, callback);
		super.executeQuery(statementScope, conn, sb.toString(), param, 0, 0, callback);
	}
	

}
