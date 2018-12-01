package com.icss.service;

import com.icss.entity.Customer;

import java.util.List;
import java.util.Map;

public interface CustomerService {
	/**
	 *
	 * @param phone
	 * @param pwd
	 * @return
	 *   根据电话号码，和密码 进行注册
	 */
	public boolean register(String phone,String pwd);
	/**
	 *
	 * @param phone
	 * @return
	 * 判断手机是否存在
	 */
	public boolean  isPhoneExit(String phone);

	/**
	 *
	 * @param phone
	 * @param pwd
	 * @return
	 *  根据电话号码，和密码 进行登陆
	 */

	public boolean login(String phone,String pwd);

	/**
	 *
	 * @param phone
	 * @param pwd
	 * @return
	 * 根据电话号码，和密码 得到一个用户
	 */
	public Customer  getCustomerByPhonePwd(String phone,String pwd);
	/**
	 *
	 * @param url
	 * @param id
	 * @return
	 * 修改个人头像
	 */
	public boolean updatePersonLogo(String url,int id);

	/**
	 *
	 * @param pwd
	 * @param id
	 * @return
	 * 修改密码
	 */
	public boolean updatePwd(String pwd,int id);


	/**
	 *
	 * @param cus
	 * @return
	 * 修改个人信息
	 */
	public boolean updateCustomer(Customer cus);
	/**
	 *
	 * @param id
	 * @return
	 * 通过id得到一个用户
	 */
	public Customer  getCustomerById(int id);

    /***
     * 根据多个条件查数据
     */

    public List<Customer> showByParams(Map<String,Object> map);


}
