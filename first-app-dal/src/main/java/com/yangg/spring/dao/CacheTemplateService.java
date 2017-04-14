package com.yangg.spring.dao;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.whalin.MemCached.MemCachedClient;
//模仿Spring template模式
public class CacheTemplateService {
	@Autowired
	private MemCachedClient client;
	
	public <T>  T findCache(String key,Date expire,TypeReference<T> clazz,LoadCallback<T> load){
		String json = client.get(key)+"";
		
		if(StringUtils.isBlank(json)||json.equalsIgnoreCase("null")){
			synchronized (this) {
				json =client.get(key)+"";
				if(StringUtils.isBlank(json)||json.equalsIgnoreCase("null")){
					T t = load.load();
					client.set(key, JSON.toJSONString(t),expire);
					return t;
				}
			}
		}else{
			return JSON.parseObject(json,clazz); 
		}
		
		
		return JSON.parseObject(json,clazz); 
		
	}
}
