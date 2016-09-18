package com.sjzjava.dao;

import org.apache.ibatis.session.SqlSession;

import com.sjzjava.util.MybatisConnect;

public class UserExistCheckDao extends MybatisConnect {
	
		
		private SqlSession session;
		
		private String statement;
	    private String statementParemet = "com.sjzjava.dao.UserExistCheckAction.";
	    
		public int userExistCheck(String userName) {
			
			
			session = dbMybatisConnect();
			
			
	        statement = statementParemet + "userExistCheck";
	        
	        
			int existResult = session.selectOne(statement,userName);
			
			return existResult;
		}

}
