package com.icss.service.impl;

import com.icss.dao.GoodsDao;
import com.icss.entity.Goods;
import com.icss.entity.PageUtil;
import com.icss.service.GoodsService;
import com.icss.util.SQLSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GoodsServiceImpl implements GoodsService {
    @Override
    public PageUtil<Goods> listByPage(int curIndex, int pageSize) {
        SqlSession sqlSession=SQLSessionUtil.getSqlSession();
        GoodsDao dao=sqlSession.getMapper(GoodsDao.class);
        PageUtil<Goods>  page=new PageUtil<Goods>();
        page.setCurIndex(curIndex);
        page.setPageSize(pageSize);
        page.setTotalNum(dao.getCount());
        // 20    --->  12   1.4   2
        //20/12=1
        int pages=(int)Math.ceil((double)dao.getCount()/pageSize);//向上取整，获取页数

        page.setTotalPage(pages);
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("index", (curIndex-1)*pageSize);
        map.put("pageSize",pageSize);
        List<Goods> list=dao.listByPage(map);
        page.setList(list);
        return page;
    }
}
