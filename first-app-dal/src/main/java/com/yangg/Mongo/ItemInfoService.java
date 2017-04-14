package com.yangg.Mongo;

import java.util.List;

import com.alibaba.fastjson.JSONObject;

public interface ItemInfoService {

    // 查询
    public List<ItemInfo> getItemInfo(JSONObject json) throws Exception;
    
    // 保存
    public int save(ItemInfo itemInfo) throws Exception;
    
    // 更新
    public void update(ItemInfo intemInfo) throws Exception;
}