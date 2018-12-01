package com.icss.control;

import com.icss.entity.Goods;
import com.icss.entity.PageUtil;
import com.icss.service.GoodsService;
import com.icss.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListByPageServlet")
public class ListByPageServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doPost(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //分页？   int　index :第几页
        //      int  总共有多少页
        //       int    每一页显示数量　
        //初始化
        int curIndex = 1;
        int pageSize = 3;
        //
        String cur = request.getParameter("curIndex");
        if (cur != null) {
            curIndex = Integer.parseInt(cur);
        }


        GoodsService us = new GoodsServiceImpl();
        PageUtil<Goods> pages = us.listByPage(curIndex, pageSize);

        request.setAttribute("pages", pages);
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }
}
