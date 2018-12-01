package com.icss.dao;

import java.util.List;
import java.util.Map;

import com.icss.entity.Customer;

public interface CustomerDao {
    /**
     *
     * @param id
     * @return
     * 根据id查找一个用户
     */
    public Customer getCustomerById(int id);


    /**
     *
     * @param phone
     * @return
     * 根据电话号码找一个用户
     */
    public Customer getCustomerByPhone(String phone);

    /**
     *
     * @param map
     * @return
     *
     * 根据 多个条件进行查找： 用户名和密码
     */
    public Customer  getCustomerByPhonePwd(Map map);

    /**
     *
     * @param cus
     * @return
     * 插入一个客户
     */
    public  int  insertCustomer(Customer cus);

    /***
     *
     * @param cus
     * @return
     * 修改一个用户信息
     */
    public int updateCustomer(Customer cus);

    /**
     *
     * @param id
     * @return
     * 根据id删除一个用户
     */
    public  int deleteById(int id);

    /**
     * 多条件查找
     */
    public List<Customer> getCustomersByParams(Map<String,Object> map);

}
