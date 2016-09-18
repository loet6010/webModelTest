package com.sjzjava.logic;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sjzjava.dao.UserLoginDao;
import com.sjzjava.dto.UserDto;

public class PageSplitLogic {
	
	//每一页显示的用户数
	private static final int PAGE_SIZE = 5;
	private int pageNumber;
	
	//分页显示
	public String pageSplit(HttpServletRequest request, HttpServletResponse resp) {
		
		//获取当前页数
		String currentPageString = request.getParameter("pageNumber");
		
		if (currentPageString == null) {
			pageNumber = 1;
		} else {
			pageNumber = Integer.parseInt(currentPageString);
		}
		
		//获取用户列表
		UserLoginDao userLoginDao = new UserLoginDao();
		
		//总页数
		int usersCount = userLoginDao.usersCount();
		int totalPages = (usersCount%PAGE_SIZE == 0) ? (usersCount/PAGE_SIZE) : (usersCount/PAGE_SIZE + 1);

		//pageNumber始终不能大于totalPages
		if (pageNumber > totalPages) {
			pageNumber = totalPages;
		}
		
		//获取用户列表
		List<UserDto> userList = userLoginDao.usersSelect(pageNumber);
		
		// 设置到request属性范围中
		request.setAttribute("userList", userList);
		
		request.setAttribute("pageNumber", pageNumber);
		request.setAttribute("totalPages", totalPages);
		
		//存在返回显示页面
		return "WEB-INF/jsp/show.jsp";
		
	}

}
