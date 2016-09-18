package com.sjzjava.dao;

import org.apache.ibatis.session.SqlSession;

import com.sjzjava.util.MybatisConnect;

public class UserDeleteDao extends MybatisConnect {
	
		
		private SqlSession session;
		
		private String statement;
	    private String statementParemet = "com.sjzjava.dao.UserDeleteAction.";
	    
		public void userDelete(String userId) {
			
			
			session = dbMybatisConnect();
			
			
	        statement = statementParemet + "userDelete";
	        
	        
			int deleteResult = session.update(statement,userId);
			
			if (deleteResult > 0) {
				session.commit();
			}
		}

}
