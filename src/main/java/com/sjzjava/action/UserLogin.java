package com.sjzjava.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sjzjava.dao.UserLoginDao;
import com.sjzjava.logic.PageSplitLogic;
import com.sjzjava.util.HttpInterface;

public class UserLogin implements HttpInterface {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse resp) {
		
		
		//获取登陆用户名
		String userName = request.getParameter("userName");
		//获取登陆密码
		String password = request.getParameter("password");
		
		UserLoginDao userLoginDao = new UserLoginDao();
		
		//验证用户名密码
		if (userLoginDao.userExsit(userName, password)) {
			
			//分页显示并返回
			PageSplitLogic pageSplitLogic = new PageSplitLogic();
			return pageSplitLogic.pageSplit(request, resp);
			
		} else {
			//返回错误页
			 return "WEB-INF/jsp/error.jsp";
		}
		
	}

}
