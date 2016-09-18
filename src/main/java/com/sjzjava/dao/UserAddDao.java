package com.sjzjava.dao;

import org.apache.ibatis.session.SqlSession;

import com.sjzjava.dto.UserDto;
import com.sjzjava.util.MybatisConnect;

public class UserAddDao extends MybatisConnect {
	
	// ������ִ��ӳ���ļ���sql��sqlSession
	private SqlSession session;
	// ӳ��sql�ı�ʶ�ַ�
	private String statement;
	private String statementParemet = "com.sjzjava.dao.UserAddAction.";

	//��������û�ID
	public Integer selectMaxUserId() {

		// ��ݿ��������
		session = dbMybatisConnect();

		// ӳ��sql�ı�ʶ�ַ�
		statement = statementParemet + "userMaxId";

		// �����û���Ϣ
		Integer maxUserId = session.selectOne(statement);
		
		if (maxUserId > 0) {
			return maxUserId + 1;
		} else {
			return 10001;
		}
		
		
	}

	// ����û�
	public void userAdd(UserDto user) {

		// ��ݿ��������
		session = dbMybatisConnect();

		// ӳ��sql�ı�ʶ�ַ�
		statement = statementParemet + "insertUser";

		// �����û���Ϣ
		int insertResult = session.insert(statement, user);
		// ȷ������ݸ��º�commit��
		if (insertResult > 0) {
			session.commit();
		}
	}

}
