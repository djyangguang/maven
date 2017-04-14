package com.yangg.firstapp.dao.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.alibaba.fastjson.JSONObject;
import com.yangg.Mongo.ItemInfo;
import com.yangg.Mongo.ItemInfoService;
@RunWith(org.springframework.test.context.junit4.SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:application-test.xml"})
public class MongoTest {

	
	 	@Autowired
	    private ItemInfoService itemInfoService;
	    
	 	@Ignore
	    @Test
	    public void testSave(){
	        ItemInfo itemInfo = new ItemInfo();
	        itemInfo.setDesc("desc");;
	        itemInfo.setItemId("123123");
	        itemInfo.setItemName("yygygygy");
	        itemInfo.setPrice(6.35);
	        try {
	            this.itemInfoService.save(itemInfo);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    
	 	@Ignore
	    @Test
	    public void testGetItemInfo(){
	        List<ItemInfo> list = new ArrayList<ItemInfo>();
	        JSONObject json = new JSONObject();
	        //json.put("item_id", "47a09d51-bf24-442b-9076-4701dcb614b9");
	        json.put("item_id", "i1234567890123");
	        try {
	            list = this.itemInfoService.getItemInfo(json);
	            if(null != list && list.size() > 0){
	                //System.out.println(list.get(0).toString());
	                for (ItemInfo itemInfo : list) {
	                    //itemInfo.setItemName("======");
	                    this.itemInfoService.getItemInfo(json);
	                    System.out.println(itemInfo);
	                }
	            }
	           // System.out.println(1 / 0);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    
	    @Test
	    public void testUpdate(){
	        JSONObject json = new JSONObject();
	        //json.put("item_id", "47a09d51-bf24-442b-9076-4701dcb614b9");
	        json.put("item_id", "i1234567890123");
	        List<ItemInfo> list = new ArrayList<ItemInfo>();
	        try {
	            list = this.itemInfoService.getItemInfo(json);
	            
	            if(null != list && list.size() > 0){
	                for (ItemInfo itemInfo : list) {
	                	itemInfo.setDesc("水印开槽钉针成品箱");
	                    //itemInfo.setItemId("嘉利工业	143.7X110.4	70X70X39.8	P1-DJ00279-0222.cdr-A.02	柔版");
	                    itemInfo.setItemName("（934）14024CRT外箱 93.6X41.7X35.1	D848H	5BC");
	                    itemInfoService.update(itemInfo);
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
}
