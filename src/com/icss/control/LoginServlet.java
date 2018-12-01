package com.icss.control;

import com.icss.entity.Customer;
import com.icss.service.CustomerService;
import com.icss.service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//第一：获取请求的参数

        String phone= request.getParameter("phone");
        String pwd= request.getParameter("pwd");

        //  第二步：调用业务层：注册的业务即可
        // 父类的应用指向子类的实例
        CustomerService us=new CustomerServiceImpl();
        //第二调用业务层逻辑
        boolean flag= us.login(phone, pwd);
        if(flag){
            //登录
            Customer customer=us.getCustomerByPhonePwd(phone,pwd);
            HttpSession session=  request.getSession();
            session.setAttribute("customer", customer);
            if(customer!=null){
                request.getRequestDispatcher("ListByPageServlet").forward(request, response);
            }
        }else{
            response.sendRedirect("login.jsp");
        }

        //第三：根据业务逻辑调整页面
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
