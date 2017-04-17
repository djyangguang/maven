package com.yangg.designPattern.FactorMethod;


public class duogeSendFactory {
	public Sender productMail(){
		return new MailSender();
		
	}
	public Sender prodictSms(){
		return new SmsSender();
	}
}
