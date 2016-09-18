package com.sjzjava.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import com.sjzjava.dto.UserDto;
import com.sjzjava.dto.UsersSearchDto;
import com.sjzjava.util.MybatisConnect;

public class UsersSearchDao extends MybatisConnect {
	
	private SqlSession session;
	private String statement;
    private String statementParemet = "com.sjzjava.dao.UsersSearchAction.";
	
    
    //部分匹配检索获取的用户列表
	public List<UserDto> partSearchUsersSelect(int pageNumber,UsersSearchDto usersSearchDto) {		
		session = dbMybatisConnect();		
        statement = statementParemet + "partSearchUsersSelect"; 
        if (pageNumber < 1) {
			return null;
		}
        int limitFirst = (pageNumber - 1) * 5;
        usersSearchDto.setLimitFirst(limitFirst);
        
		List<UserDto> listUsers = session.selectList(statement,usersSearchDto);
		return listUsers;
	}
	
	//部分匹配检索获取的用户数量
	public int partSearchUsersCount(UsersSearchDto usersSearchDto) {		
		session = dbMybatisConnect();		
        statement = statementParemet + "partSearchUsersCount";      
		int usersCount = session.selectOne(statement,usersSearchDto);
		return usersCount;
	}
	
    //完全匹配检索获取的用户列表
	public List<UserDto> wholeSearchUsersSelect(int pageNumber,UsersSearchDto usersSearchDto) {		
		session = dbMybatisConnect();		
        statement = statementParemet + "wholeSearchUsersSelect"; 
        if (pageNumber < 1) {
			return null;
		}
        int limitFirst = (pageNumber - 1) * 5;
        usersSearchDto.setLimitFirst(limitFirst);
        
		List<UserDto> listUsers = session.selectList(statement,usersSearchDto);
		return listUsers;
	}
	
	//完全匹配检索获取的用户数量
	public int wholeSearchUsersCount(UsersSearchDto usersSearchDto) {		
		session = dbMybatisConnect();		
        statement = statementParemet + "wholeSearchUsersCount";      
		int usersCount = session.selectOne(statement,usersSearchDto);
		return usersCount;
	}
}
