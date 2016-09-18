package com.sjzjava.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sjzjava.dao.UserModifyDao;
import com.sjzjava.dto.UserDto;
import com.sjzjava.logic.PageSplitLogic;
import com.sjzjava.util.HttpInterface;

public class UserModifyAction implements HttpInterface {

	//定义用户属性
	private String userId = null;
	private String userName;
	private int age;
	private String birthday;
	private String address;
	
	private int pageNumber;
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse resp) {
		
		//获取要修改的用户ID
		userId = request.getParameter("userId");
		
		System.out.println("userId："+userId);
		
		//获取用户名
		userName = request.getParameter("userName");

		UserModifyDao userModifyDao = new UserModifyDao();
		
		//判断用户名是否存在
		if (userName == null || userName == "") {				
			UserDto user = userModifyDao.userSelect(userId);
			request.setAttribute("user", user);
			
			//获取当前页数
			String currentPageString = request.getParameter("pageNumber");
			pageNumber = Integer.parseInt(currentPageString);
			
			System.out.println("UserModifyAction_pageNumber:"+pageNumber);
			
			//将当前页面传给显示页面
			request.setAttribute("pageNumber", pageNumber);	
			//返回修改页面
			return "WEB-INF/jsp/modify.jsp";
		} else {
			//获取修改信息
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
			
			//设置修改信息
			UserDto user = new UserDto();
			user.setUserId(userId);
			user.setUserName(userName);
			user.setAge(age);
			user.setBirthday(birthday);
			user.setAddress(address);
			
			//调用修改DAO
			userModifyDao.userUpdate(user);
					
			//调用分页显示方法
			PageSplitLogic pageSplitLogic = new PageSplitLogic();
			String url = pageSplitLogic.pageSplit(request, resp);
			
			//返回URL
			return url;	
		}
		
	}

}
