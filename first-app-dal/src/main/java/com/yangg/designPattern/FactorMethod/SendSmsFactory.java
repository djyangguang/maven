package com.yangg.designPattern.FactorMethod;

public class SendSmsFactory implements Provider {

	@Override
	public Sender priduct() {
		// TODO Auto-generated method stub
		return new SmsSender();
	}

}
