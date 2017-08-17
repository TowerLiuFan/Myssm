package com.lf.ssm.database;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DbBaseDao {

			 @Autowired
			 public SqlSessionFactory  sqlSessionFactory;
			 
			 public SqlSession session;
			 
			 public SqlSession getSession(){
				 session = sqlSessionFactory.openSession();
				 return session;
				 
			 }
			 
			 public List<Map<String,Object>> selectLoinUser(String sql,Map<String,Object> params){
				 session = getSession();
				 
				 List<Map<String,Object>> list = session.selectList(sql, params);
				 
				 return list;
				 
			 }
			 
}
