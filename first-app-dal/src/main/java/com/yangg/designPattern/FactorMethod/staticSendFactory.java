package com.yangg.designPattern.FactorMethod;

public class staticSendFactory {
	
	public static Sender productMail(){
		
		return new MailSender();
	}
	public static Sender productSms(){
		
		return new SmsSender();
	}
}
