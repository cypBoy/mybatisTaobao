package com.icss.dao;

import com.icss.entity.Goods;

import java.util.List;
import java.util.Map;

public interface GoodsDao {

    /**
     * 根据页码进行查询
     * @param map
     * @return
     */
    public List<Goods> listByPage(Map map);

    /**
     * 获取user的总数量
     */
    public int getCount();
}
