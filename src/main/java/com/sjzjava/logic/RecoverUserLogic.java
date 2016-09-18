package com.sjzjava.logic;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sjzjava.dao.RecoverUserDao;
import com.sjzjava.dto.UserDto;

public class RecoverUserLogic {
	//每一页显示的用户数
		private static final int PAGE_SIZE = 5;
		private int pageNumber;
		
		//分页显示
		public String recoverUsersSplit(HttpServletRequest request, HttpServletResponse resp) {
			
			//获取当前页数
			String currentPageString = request.getParameter("pageNumber");
			
			if (currentPageString == null) {
				pageNumber = 1;
			} else {
				pageNumber = Integer.parseInt(currentPageString);
			}
			
			//获取被删除用户列表
			RecoverUserDao recoverUserDao = new RecoverUserDao();
			
			//总页数
			int usersCount = recoverUserDao.deleteUsersCount();
			int totalPages = (usersCount%PAGE_SIZE == 0) ? (usersCount/PAGE_SIZE) : (usersCount/PAGE_SIZE + 1);

			//pageNumber始终不能大于totalPages
			if (pageNumber > totalPages) {
				pageNumber = totalPages;
			}
			
			//获取用户列表
			List<UserDto> userList = recoverUserDao.deleteUsersSelect(pageNumber);
			
			// 设置到request属性范围中
			request.setAttribute("userList", userList);
			
			request.setAttribute("pageNumber", pageNumber);
			request.setAttribute("totalPages", totalPages);
			
			//存在返回显示页面
			return "WEB-INF/jsp/recover.jsp";
			
		}

}
