package com.yangg.spring.dao;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class ExtGoodsInfoDAOImpl extends SqlMapClientTemplate implements ExtGoodsInfoDAO {
	//private Logger  logger  =   LoggerFactory.getLogger(getClass());
	private  Logger logger = LoggerFactory.getLogger(getClass());
	@Override
	public Integer modifyAmount(String code, Long amount) throws SQLException {
		// TODO Auto-generated method stub
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("code", code);
		paramMap.put("amount", amount)	;
		logger.info("===================="+paramMap);
		return this.getSqlMapClient().update("tb_goods_info.modifyAmount",paramMap);
	}

}
