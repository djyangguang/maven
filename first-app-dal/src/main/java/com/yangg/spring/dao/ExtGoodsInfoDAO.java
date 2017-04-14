package com.yangg.spring.dao;

import java.math.BigDecimal;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;


@Repository
public interface ExtGoodsInfoDAO {
	
	public Integer modifyAmount(String codel,Long amount) throws SQLException;
}
