package com.icss.service;

import com.icss.entity.Goods;
import com.icss.entity.PageUtil;

import java.util.List;

public interface GoodsService {
    /**
     *   分页显示商品
     */
    public PageUtil<Goods> listByPage(int curIndex, int pageSize);

}
