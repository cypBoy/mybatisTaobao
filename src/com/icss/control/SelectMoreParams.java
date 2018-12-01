package com.icss.control;

import com.icss.entity.Customer;
import com.icss.service.CustomerService;
import com.icss.service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "SelectMoreParams")
public class SelectMoreParams extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String phone=	req.getParameter("phone");
        String sex=  req.getParameter("sex");
        String name= req.getParameter("realName");
        Map<String,Object> map=new HashMap<String,Object>();

        if(phone!=null && phone.trim().length()!=0){
            map.put("phone", "%"+phone+"%");
        }

        if(sex!=null && !"-1".equals(sex)){
            if("0".equals(sex)){
                map.put("sex", 0);
            }else{
                map.put("sex",1);
            }
        }

        if(name!=null && name.trim().length()!=0){
            map.put("realName", name);
        }

        System.out.println(map);
        CustomerService cs=new CustomerServiceImpl();
        List<Customer> list=  cs.showByParams(map);
        req.setAttribute("list", list);

        req.getRequestDispatcher("selectMore.jsp").forward(req, resp);
    }
}
