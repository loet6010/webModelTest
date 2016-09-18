package com.sjzjava.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sjzjava.dao.UserExistCheckDao;
import com.sjzjava.util.HttpInterface;

public class UserExistCheckAction implements HttpInterface {
	
private String userName = null;
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse resp) {
		
		//获取要检查是否存在的用户名
		try {
			userName =  new String( request.getParameter("userName").getBytes("iso8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		System.out.println("UserExistCheckAction_userName:"+userName);
		
		//调用DAO
		UserExistCheckDao userExistCheckDao = new UserExistCheckDao();
		int intExistResult = userExistCheckDao.userExistCheck(userName);

		System.out.println("UserExistCheckAction_intExistResult:"+intExistResult);
		
		//查到有用户存在，返回结果
		if (intExistResult > 0) {
			System.out.println("addUser.jsp");
			return "addUser.jsp";
		}

		//没有当前用户名
		return "not exist";

	}

}
