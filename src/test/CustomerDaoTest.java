package test;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.icss.dao.CustomerDao;
import com.icss.entity.Customer;
import com.icss.util.SQLSessionUtil;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class CustomerDaoTest {

    SqlSession  sqlsession=SQLSessionUtil.getSqlSession();
    CustomerDao  dao= sqlsession.getMapper(CustomerDao.class);
    @Test
    public void testGetCustomerById() {
        //
        Customer  cus= dao.getCustomerById(1);
        System.out.println(cus);
        sqlsession.close();
    }

    @Test
    public void testGetCustomerByPhone() {
        Customer customer=dao.getCustomerByPhone("18820412867");
        System.out.println(customer);
        sqlsession.close();
    }

    @Test
    public void testGetCustomerByPhonePwd() {
        Map<String, String> map=new HashMap<String, String>();
        map.put("phone", "18820412867");
        map.put("pwd", "123");
        Customer customer=dao.getCustomerByPhonePwd(map);
        System.out.println(customer);
        sqlsession.close();
    }

    @Test
    public void testInsertCustomer() {
        Customer customer=new Customer("13823410087","456",null,null,null,null);
        int num=dao.insertCustomer(customer);
        sqlsession.commit();
        if(num>0){
            System.out.println("success");
        }
        sqlsession.close();
    }

    @Test
    public void testUpdateCustomer() {
        Customer customer=new Customer(2,"13680769152","123",null,null,null,null);
        int num=dao.updateCustomer(customer);
        sqlsession.commit();
        if(num>0){
            System.out.println("success");
        }
        sqlsession.close();
    }

    @Test
    public void testDeleteById() {
        int num=dao.deleteById(2);
        sqlsession.commit();
        if(num>0){
            System.out.println("success");
        }
        sqlsession.close();
    }

}