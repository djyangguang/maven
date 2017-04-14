package com.yangg.Mongo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;



@Service(value="itemInfoService")
public class ItemInfoServiceImpl implements ItemInfoService {

    @Autowired
    private MongoTemplate mongoTemplate;
    private final static String COLLECTION_NAME = "item_info"; 
    Logger logger = LoggerFactory.getLogger(getClass());
    
    @Override
    @SuppressWarnings("static-access")
    public List<ItemInfo> getItemInfo(JSONObject json) throws Exception{
        List<ItemInfo> list = new ArrayList<ItemInfo>();
        // 判断查询的json中传递过来的参数
        DBObject query = new BasicDBObject();
        // item_id,item_name,price,desc
        if(json.containsKey("item_id")){
            
            query.put("item_id", json.getString("item_id"));
        }else if(json.containsKey("item_name")){
            query.put("item_name", json.getString("item_name"));
        }
        logger.info("query=========="+query);
        
        DBCursor results = mongoTemplate.getCollection("item_info").find(query);
        if(null != results){
            Iterator<DBObject> iterator = results.iterator();
            while(iterator.hasNext()){
                //Document doc = (Document) iterator.next();
                BasicDBObject obj = (BasicDBObject) iterator.next();
                //System.out.println(obj.toJson());
                // json 字符串
                String objStr = obj.toString();
                //JSONObject itemInfoJson = new JSONObject().fromObject(objStr);
                //itemInfoJson.put("_id", itemInfoJson.getJSONObject("_id").getString("$oid"));
                ItemInfo itemInfo = new ItemInfo();
                itemInfo = BeanUtil.dbObject2Bean(obj, itemInfo);
                logger.info("itemInfo=========="+itemInfo);
                list.add(itemInfo);
            }
        }
        
        
        return list;
    }

    @Override
    public int save(ItemInfo itemInfo) throws Exception {
        itemInfo.setDesc("水印开槽钉针成品箱");
        itemInfo.setItemId("嘉利工业	143.7X110.4	70X70X39.8	P1-DJ00279-0222.cdr-A.02	柔版");
        itemInfo.setItemName("（934）14024CRT外箱 93.6X41.7X35.1	D848H	5BC");
        itemInfo.setPrice(110.0);
        
        DBCollection collection = this.mongoTemplate.getCollection("item_info");
        int result = 0;
        DBObject iteminfoObj = BeanUtil.bean2DBObject(itemInfo);
        
        //iteminfoObj.removeField("serialVersionUID");
        //result = collection.insert(iteminfoObj).getN();
        WriteResult writeResult = collection.save(iteminfoObj);
        result = writeResult.getN();
        return result;
    }

    @Override
    public void update(ItemInfo intemInfo) throws Exception {
        
        DBCollection collection = this.mongoTemplate.getCollection(COLLECTION_NAME);
        ItemInfo queryItemInfo = new ItemInfo();
        queryItemInfo.setItemId(intemInfo.getItemId());
        DBObject itemInfoObj = BeanUtil.bean2DBObject(intemInfo);
        DBObject query =  BeanUtil.bean2DBObject(queryItemInfo);
        logger.info("update=========="+query);
        logger.info("update=========="+itemInfoObj);
        collection.update(query, itemInfoObj);
      
    }



    

}