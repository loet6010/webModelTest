package com.sjzjava.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import com.sjzjava.dto.UserDto;
import com.sjzjava.util.MybatisConnect;

public class UserModifyDao extends MybatisConnect {

	//创建能执行映射文件中sql的sqlSession
	private SqlSession session;
	//映射sql的标识字符串
	private String statement;
    private String statementParemet = "com.sjzjava.dao.UserModifyAction.";
    
    //查找用户
  	public UserDto userSelect(String userId) {
  		
  		//数据库连接相关
  		session = dbMybatisConnect();
  		
  		//映射sql的标识字符串
          statement = statementParemet + "userSelect";
          
          //获取用户信息
  		List<UserDto> userList = session.selectList(statement,userId);
  		
  		UserDto user = userList.get(0);
  		
  		return user;
  	}
    
	//更新用户
	public void userUpdate(UserDto user) {
		
		//数据库连接相关
		session = dbMybatisConnect();
		
		//映射sql的标识字符串
        statement = statementParemet + "userModify";
        
        //更新用户信息
		int updateResult = session.update(statement,user);
		//确定有数据更新后commit；
		if (updateResult > 0) {
			session.commit();
		}
	}
}
