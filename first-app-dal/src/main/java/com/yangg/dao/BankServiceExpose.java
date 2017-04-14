package com.yangg.dao;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.yangg.bank.BankService;
import com.yangg.bank.model.BankResponse;
import com.yangg.bank.model.OrderVO;
@Service("BankService")
public class BankServiceExpose implements BankService {
	private Logger logger = org.slf4j.LoggerFactory.getLogger(getClass());
	@Override
	public BankResponse moneyOut(OrderVO orderInfo) {
		// TODO Auto-generated method stub
		logger.info("==============出库=============");		
		BankResponse response = new BankResponse();
		response.setCode("S");
		response.setMessage("出库成功");
		return response;
	}
	@Override
	public BankResponse monetOuy() {
		// TODO Auto-generated method stub
		logger.info("++++++++++++++++");
		BankResponse response = new BankResponse();
		response.setCode("ss");
		return response;
	}
	
	

}
