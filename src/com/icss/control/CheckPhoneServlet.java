package com.icss.control;

import com.icss.service.CustomerService;
import com.icss.service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CheckPhoneServlet")
public class CheckPhoneServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
            throws ServletException, IOException {
        //对电话号码进行判断，数据库中有没有
        String phone=  arg0.getParameter("phone");
        //
        CustomerService us=new CustomerServiceImpl();
        boolean flag=  us.isPhoneExit(phone);
        if(flag){
            arg1.getWriter().print("false");
        }else{
            arg1.getWriter().print("true");
        }

    }
}
