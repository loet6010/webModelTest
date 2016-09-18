package com.sjzjava.util;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sjzjava.dao.UserLoginDao;

public abstract class MybatisConnect {

	// 数据库连接
	public SqlSession dbMybatisConnect() {

		// mybatis的主配置文件
		String resource = "/SqlMapConfig.xml";

		// 使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
		InputStream is = UserLoginDao.class.getClassLoader().getResourceAsStream(resource);

		// 构建sqlSession的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);

		// 创建能执行映射文件中sql的sqlSession
		SqlSession session = sessionFactory.openSession();

		// mybatis需要重构，代码需要整合
		return session;

	}

}
