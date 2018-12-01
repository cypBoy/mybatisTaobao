package com.icss.control;

import com.icss.service.CustomerService;
import com.icss.service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
        //处理注册的业务
        arg1.setContentType("text/html;charset=utf-8");
        arg0.setCharacterEncoding("utf-8");
        arg1.setCharacterEncoding("utf-8");

        //第一获取客户输入的手机号和密码
        String phone = arg0.getParameter("phone");
        String pwd = arg0.getParameter("pwd");

        //  第二步：调用业务层：注册的业务即可
        // 父类的引用指向子类的实例
        CustomerService us = new CustomerServiceImpl();
        boolean flag = us.register(phone, pwd);
        if (flag) {
            //跳转到登陆界面
            arg1.sendRedirect("index.jsp");
        } else {
            arg1.sendRedirect("register.jsp");
        }
    }
}
