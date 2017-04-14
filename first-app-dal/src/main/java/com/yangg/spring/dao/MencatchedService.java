package com.yangg.spring.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.whalin.MemCached.MemCachedClient;
@Repository
public class MencatchedService {
	private  Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	 private  MemCachedClient client;
	@Autowired
	private CacheTemplateService cacheTemplate;
	
	 private Integer count = 0; //由于是spring加载的 是全一般不建议使用
	 public Integer getCount(){
		 return count;
	 }
	 public Map<String,Object> query1(){
		 String key="laoy";
		 Date expire =DateUtils.addSeconds(new Date(), 300);
		 /*Map<String,Object>findCache=*/ 
		 return cacheTemplate.findCache(key, expire, new TypeReference<Map<String,Object>>(){},
				 new LoadCallback<Map<String,Object>>() {

			@Override
			public Map<String, Object> load() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(300);
					++count;
					logger.info("====================1000个线程就一个进SQL===================="+count);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			Map<String,Object> result = new HashMap<String ,Object>	();
			result.put("name", "laoy");
			result.put("ss", "（DZ15LE-100/2901漏电断路器内盒）-270彩箱");
			result.put("dd", "mgU6wUHLSGatiJ89Ku0NmO0kyzc=");
			result.put("ff", "mgU6wUHLSGatiJ89Ku0NmO0kyzc=2");		
			return result;
			}
		});
		 
		//return null;
		 
	 }
	public Map<String,Object> query(){
		
		String key = "yg";
		String json = client.get(key)+"";
		if(StringUtils.isBlank(json)|| json.equalsIgnoreCase("null")){
		
			synchronized(this){
				json=client.get(key)+"";
				if(StringUtils.isBlank(json)||json.equalsIgnoreCase("null")){
					logger.info("========cache 只有一次 SQL=======================");
					try {
						Thread.sleep(10);
						++count;
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				Map<String,Object> result = new HashMap<String ,Object>	();
				result.put("name", "yg");
				result.put("ss", "（DZ15LE-100/2901漏电断路器内盒）-270彩箱2");
				result.put("s2s", "（DZ15LE-100/2901漏电断路器内盒）-270彩箱1");
				result.put("ss3", "（DZ15LE-100/2901漏电断路器内盒）-270彩箱");
				result.put("dd", "mgU6wUHLSGatiJ89Ku0NmO0kyzc=");
				json=JSON.toJSONString(result);
				client.set(key, json, DateUtils.addMinutes(new Date(), 3000));
				return result;
				}
				else{
					return JSON.parseObject(json);
				}
			}
			
		}
		else{
			return JSON.parseObject(json);
		}
		
		
	}

}
