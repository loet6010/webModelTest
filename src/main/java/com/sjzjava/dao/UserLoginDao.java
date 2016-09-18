package com.sjzjava.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import com.sjzjava.dto.AdminDto;
import com.sjzjava.dto.UserDto;
import com.sjzjava.util.MybatisConnect;

public class UserLoginDao extends MybatisConnect {
	
	//������ִ��ӳ���ļ���sql��sqlSession
	private SqlSession session;
	//ӳ��sql�ı�ʶ�ַ�
	private String statement;
    private String statementParemet = "com.sjzjava.dao.UserLogin.";
	
	//�жϹ���Ա�û��Ƿ����
	public boolean userExsit(String userName, String password) {
		
		Integer count = loginCheck(userName, password);
		
		if (count > 0 ) {
			return true;
		}
		
		return false;
	}
	
	//���ҳ������û�
	public List<UserDto> usersSelect(int pageNumber) {
		
		//��ݿ��������
		session = dbMybatisConnect();
		
		//ӳ��sql�ı�ʶ�ַ�
        statement = statementParemet + "usersSelect";
        
        //范围记录起点,页面数小于1时直接返回
        if (pageNumber < 1) {
			return null;
		}
        
        int limitFirst = (pageNumber - 1) * 5;
        //ִ�в�ѯ����list
		List<UserDto> listUsers = session.selectList(statement,limitFirst);
		
		return listUsers;
	}
	
	//���ҳ������û�
	public int usersCount() {
		
		//��ݿ��������
		session = dbMybatisConnect();
		
		//ӳ��sql�ı�ʶ�ַ�
        statement = statementParemet + "usersCount";
        
        //ִ�в�ѯ����list
		int usersCount = session.selectOne(statement);
		
		return usersCount;
	}
	
	//��ѯ��ݿ�
	private Integer loginCheck(String userName, String password) {
		
		//����Ա�˻�ģ��
        AdminDto admin = new AdminDto();
        admin.setUserName(userName);
        admin.setPassword(password);
        
        //��ݿ��������
        session = dbMybatisConnect();
        
        //ӳ��sql�ı�ʶ�ַ�
        statement = statementParemet + "loginCheck";
        
        //ִ�в�ѯ����һ��Ψһuser�����sql
        Integer countNum = session.selectOne(statement,admin);
			
		return countNum;
	}
}
