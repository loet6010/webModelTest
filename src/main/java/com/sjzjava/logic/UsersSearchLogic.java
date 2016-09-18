package com.sjzjava.logic;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sjzjava.dao.UsersSearchDao;
import com.sjzjava.dto.UserDto;
import com.sjzjava.dto.UsersSearchDto;

public class UsersSearchLogic {
	
	//每一页显示的用户数
	private static final int PAGE_SIZE = 5;
	//部分匹配常量
	private static final String PARTMATCH = "partMatch";
	//完全匹配常量
	private static final String WHOLEMATCH = "wholeMatch";
	
	private static String searchName;
	private static String  matchName;
	private static String  columnName;
	private static UsersSearchDto usersSearchDto;
	
	private String currentSearchName = null;
	private int pageNumber;
	private int usersCount;
	private int totalPages;
	private List<UserDto> searchUserList;


	//分页显示
	public String searchPageSplit(HttpServletRequest request, HttpServletResponse resp) {
		
		//获取当前页数
		String currentPageString =  request.getParameter("pageNumber");
		
		//获取要检索的用户信息
		currentSearchName = request.getParameter("searchName");
		
		if (currentSearchName != null) {
			try {
				searchName = new String(currentSearchName.getBytes("iso8859-1"), "utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			//获取检索选项
			matchName = request.getParameter("matchName");
			columnName = request.getParameter("customers");
			
			//检索Dto
			usersSearchDto = new UsersSearchDto();
			usersSearchDto.setSearchName(searchName);
			usersSearchDto.setColumnName(columnName);
		}
		
		if (currentPageString == null) {
			pageNumber = 1;
		} else {
			pageNumber = Integer.parseInt(currentPageString);
		}
		
		//检索DAO
		UsersSearchDao usersSearchDao = new UsersSearchDao();
		
		//判断匹配类型(部分匹配)
		if (PARTMATCH.equals(matchName)) {
			//总页数
			usersCount = usersSearchDao.partSearchUsersCount(usersSearchDto);
			totalPages = (usersCount%PAGE_SIZE == 0) ? (usersCount/PAGE_SIZE) : (usersCount/PAGE_SIZE + 1);

			//pageNumber始终不能大于totalPages
			if (pageNumber > totalPages) {
				pageNumber = totalPages;
			}
			
			//获取用户列表
			searchUserList = usersSearchDao.partSearchUsersSelect(pageNumber, usersSearchDto);
			
		} else if(WHOLEMATCH.equals(matchName)) {
			//总页数
			usersCount = usersSearchDao.wholeSearchUsersCount(usersSearchDto);
			totalPages = (usersCount%PAGE_SIZE == 0) ? (usersCount/PAGE_SIZE) : (usersCount/PAGE_SIZE + 1);

			//pageNumber始终不能大于totalPages
			if (pageNumber > totalPages) {
				pageNumber = totalPages;
			}
			
			//获取用户列表
			searchUserList = usersSearchDao.wholeSearchUsersSelect(pageNumber, usersSearchDto);
		}
		
		// 设置到request属性范围中
		request.setAttribute("searchUserList", searchUserList);
		
		request.setAttribute("pageNumber", pageNumber);
		request.setAttribute("totalPages", totalPages);
		
		//存在返回显示页面
		return "WEB-INF/jsp/searchResult.jsp";		
	}

}
