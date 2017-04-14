package com.yangg.spring.dao;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.cyfonly.flogger.FLogger;
import com.whalin.MemCached.MemCachedClient;


public class MiaoshaCacheService {
	//private  Logger logger = LoggerFactory.getLogger(getClass());
	FLogger logger = FLogger.getInstance();
	@Autowired
	private MemCachedClient client;
	
	public boolean modifyAmount(String code,Long amount){
	//	logger.info(code+"",amount+"");
		Long result =client.decr(code, amount);//这个decr有毒
		logger.error("+++++++"+result);
		if(result>0){
			return true;
		}else{
		return false;
		}
		
	}
}
