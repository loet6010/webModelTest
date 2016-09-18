package com.sjzjava.dao;

import org.apache.ibatis.session.SqlSession;

import com.sjzjava.util.MybatisConnect;

public class UserRecoverDao extends MybatisConnect {
	
	private SqlSession session;
	
	private String statement;
    private String statementParemet = "com.sjzjava.dao.UserRecoverAction.";
    
	public void userRecover(String userId) {
		
		
		session = dbMybatisConnect();
		
		
        statement = statementParemet + "userRecover";
        
        System.out.println("recoverUserId:"+userId);
        
		int recoverResult = session.update(statement,userId);
		
		if (recoverResult > 0) {
			session.commit();
		}
	}

}
