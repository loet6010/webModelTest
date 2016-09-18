package com.sjzjava.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.sjzjava.dto.UserDto;
import com.sjzjava.util.MybatisConnect;

public class RecoverUserDao extends MybatisConnect {
		//定义SqlSession
		private SqlSession session;
		//定义statement
		private String statement;
	    private String statementParemet = "com.sjzjava.dao.RecoverUserAction.";

		//查找被删除用户
		public List<UserDto> deleteUsersSelect(int pageNumber) {
			
			//session赋值
			session = dbMybatisConnect();
			
			//statement赋值
	        statement = statementParemet + "deleteUsersSelect";
	        
	        //范围记录起点,页面数小于1时直接返回
	        if (pageNumber < 1) {
				return null;
			}
	        
	        int limitFirst = (pageNumber - 1) * 5;
	        //获取list
			List<UserDto> listUsers = session.selectList(statement,limitFirst);
			
			return listUsers;
		}
		
		//获取被删除用户数量
		public int deleteUsersCount() {
			
			//session赋值
			session = dbMybatisConnect();
			
			//statement赋值
	        statement = statementParemet + "deleteUsersCount";
	        
	        //获取被删除用户数量
			int usersCount = session.selectOne(statement);
			
			return usersCount;
		}

}
