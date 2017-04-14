package com.yangg.bank;

import com.yangg.bank.model.BankResponse;
import com.yangg.bank.model.OrderVO;
//检出
public interface BankService  {
	public BankResponse moneyOut(OrderVO orderInfo);
	public BankResponse monetOuy();

}
