package com.icss.control;

import com.icss.entity.Customer;
import com.icss.service.CustomerService;
import com.icss.service.impl.CustomerServiceImpl;
import com.oreilly.servlet.MultipartRequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "UpdateImgServlet")
public class UpdateImgServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
            throws ServletException, IOException {
        //将图片上传到哪里，路径： 一般发布路径
        String path=arg0.getServletContext().getRealPath("admin");
        System.out.println(path);
        MultipartRequest request =new MultipartRequest(arg0, path, "utf-8");
        System.out.println("图片上传成功！");
        //获取图片的 名字的 b1.jpg

        String imgurl= request.getFilesystemName("fileName");
        //修改数据库中url
        CustomerService cs=new CustomerServiceImpl();
        HttpSession session=  arg0.getSession();
        Object obj=  session.getAttribute("customer");
        if(obj!=null){
            Customer cus=(Customer) obj;
            boolean flag= cs.updatePersonLogo(imgurl, cus.getId());
            if(flag){
                System.out.println("修改成功");
                //重新从数据中拿到更新后在用户对象
                Customer cus2=  cs.getCustomerById(cus.getId());
                System.out.println(cus2);
                // 重新设置session
                session.setAttribute("customer",cus2);
                arg0.getRequestDispatcher("admin/selfcenter.jsp").forward(arg0, arg1);
            }else{
                System.out.println("修改失败");
            }
        }

    }

}
