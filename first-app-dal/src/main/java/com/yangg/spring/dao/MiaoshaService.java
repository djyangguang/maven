package com.yangg.spring.dao;

import java.math.BigDecimal;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class MiaoshaService {
	
	//private GoodInfoDAO dao;
	@Autowired
	private ExtGoodsInfoDAO dao;
	
	/**
	 * int i = update good set amount = amount -#buy#
	 *  where code = XXX and amount-#buy# >=0;
	 *返回0 && 1
	 * 最大并发量 看存储的机械硬盘 300 ssd 700左右 这种锁有限制并发量不够
	 * Memcached 实现 写的是后台多线程 100000/s 高
	 * @throws SQLException 
	 */
	public boolean modifyAmount(String code,Long amount) throws SQLException{
	return dao.modifyAmount(code, amount)== 1;
	}
}
