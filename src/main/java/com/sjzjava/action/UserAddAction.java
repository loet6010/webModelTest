package com.sjzjava.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sjzjava.dao.UserAddDao;
import com.sjzjava.dto.UserDto;
import com.sjzjava.logic.PageSplitLogic;
import com.sjzjava.util.HttpInterface;

public class UserAddAction implements HttpInterface {
	
	//定义用户属性
	private String userId;
	private String userName;
	private int age;
	private String birthday;
	private String address;
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse resp) {
		
		UserAddDao userAddDao = new UserAddDao();

		//获取用户ID
		userId = userAddDao.selectMaxUserId().toString();

		//获取要添加的用户信息
		age = Integer.parseInt(request.getParameter("age"));
		
		//将用户名等含中文信息进行转码
		try {			
			userName = new String( request.getParameter("userName").getBytes("iso8859-1"), "utf-8");
			birthday = new String( request.getParameter("birthday").getBytes("iso8859-1"), "utf-8");
			address = new String( request.getParameter("address").getBytes("iso8859-1"), "utf-8");			
		} catch (UnsupportedEncodingException e) {
			//异常信息
			e.printStackTrace();
		}
		
		//设置用户信息
		UserDto user = new UserDto();
		user.setUserId(userId);
		user.setUserName(userName);
		user.setAge(age);
		user.setBirthday(birthday);
		user.setAddress(address);

		//调用添加DAO
		userAddDao.userAdd(user);

		//调用显示方法
		PageSplitLogic pageSplitLogic = new PageSplitLogic();
		String url = pageSplitLogic.pageSplit(request, resp);
		
		//返回URL
		return url;	
	}
}
