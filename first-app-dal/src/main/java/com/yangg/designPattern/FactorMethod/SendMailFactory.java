package com.yangg.designPattern.FactorMethod;

public class SendMailFactory implements Provider {

	@Override
	public Sender priduct() {
		// TODO Auto-generated method stub
		return new MailSender();
	}

}
