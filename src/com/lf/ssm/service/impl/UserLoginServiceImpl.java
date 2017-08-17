package com.lf.ssm.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lf.ssm.dao.impl.UserLoginDaoImpl;
import com.lf.ssm.service.UserLoginService;

@Service
public class UserLoginServiceImpl implements UserLoginService {

	@Autowired
	private UserLoginDaoImpl userLoginDaoImpl;
	

	@Override
	public List<Map<String,Object>> userLogin(Map<String, Object> params) {
		    List<Map<String, Object>> userList = this.userLoginDaoImpl.userLogin(params);
		return userList;
	}

}
