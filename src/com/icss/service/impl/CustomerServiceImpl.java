package com.icss.service.impl;

import org.apache.ibatis.session.SqlSession;

import com.icss.dao.CustomerDao;
import com.icss.entity.Customer;
import com.icss.service.CustomerService;
import com.icss.util.SQLSessionUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements CustomerService {

	SqlSession   sqlSession=SQLSessionUtil.getSqlSession();
	CustomerDao dao=sqlSession.getMapper(CustomerDao.class);
	@Override
	public boolean register(String phone, String pwd) {
		Customer cus=new Customer(phone,pwd,"logo.png");
		int  num=dao.insertCustomer(cus);
		sqlSession.commit();
		if(num>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean isPhoneExit(String phone) {
		 Customer cus=dao.getCustomerByPhone(phone);
		 sqlSession.close();
		 if(cus!=null){
			 return true;
		 }
		return false;
	}

	@Override
	public boolean login(String phone, String pwd) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("phone", phone);
		map.put("pwd",pwd);
		Customer customer=dao.getCustomerByPhonePwd(map);
		if(customer!=null){
			return true;
		}
		return false;
	}

	@Override
	public Customer getCustomerByPhonePwd(String phone, String pwd) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("phone", phone);
		map.put("pwd",pwd);
		return dao.getCustomerByPhonePwd(map);
	}

	@Override
	public boolean updatePersonLogo(String url, int id) {
		Customer  customer= dao.getCustomerById(id);
		customer.setImgurl(url);
		int  num= dao.updateCustomer(customer);
		sqlSession.commit();
		if(num>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean updatePwd(String pwd, int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateCustomer(Customer cus) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Customer getCustomerById(int id) {
		Customer  customer= dao.getCustomerById(id);
		sqlSession.commit();
		return customer;
	}

	@Override
	public List<Customer> showByParams(Map<String, Object> map) {
		return dao.getCustomersByParams(map);
	}

}
