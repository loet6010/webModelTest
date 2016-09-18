package com.sjzjava.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sjzjava.logic.UsersSearchLogic;
import com.sjzjava.util.HttpInterface;

public class UsersSearchAction implements HttpInterface {
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse resp) {
		
		// 调用分页显示方法
		UsersSearchLogic usersSearchLogic = new UsersSearchLogic();
		String url = usersSearchLogic.searchPageSplit(request, resp);

		// 返回URL
		return url;
		
	}
}
