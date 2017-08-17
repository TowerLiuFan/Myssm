package com.lf.ssm.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lf.ssm.dao.UserLoginDao;
import com.lf.ssm.database.DbBaseDao;

@Repository
public class UserLoginDaoImpl extends DbBaseDao implements UserLoginDao {

	
	@Override
	public List<Map<String,Object>> userLogin(Map<String, Object> params) {
		return super.selectLoinUser("com.lf.ssm.dao.impl.UserLoginDaoImpl.verifyUser", params);
	}

}
