package com.yangg.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.yangg.service.IuserService;
@Service("userService") 
public class UserServiceImpl implements IuserService {

	 private Logger logger = LoggerFactory.getLogger(getClass());
	@Override
	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		logger.info("user：[username:{}, password:{}]", username, password);
        if (username != null && password != null && username.equals(password)) {
            logger.info("pass。[username:{}]", username);
            return true;
        }
        logger.info("jiaoyanshibai！[username:{}]", username);
        return false;
	  
	   

}
}
