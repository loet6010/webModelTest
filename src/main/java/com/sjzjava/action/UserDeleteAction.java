package com.sjzjava.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sjzjava.dao.UserDeleteDao;
import com.sjzjava.logic.PageSplitLogic;
import com.sjzjava.util.HttpInterface;

public class UserDeleteAction implements HttpInterface {
	
private String userId = null;
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse resp) {
		
		//获取要删除的用户ID
		userId = request.getParameter("userId");

		//调用删除DAO
		UserDeleteDao userDeleteDao = new UserDeleteDao();
		userDeleteDao.userDelete(userId);

		//调用分页显示方法
		PageSplitLogic pageSplitLogic = new PageSplitLogic();
		String url = pageSplitLogic.pageSplit(request, resp);

		//返回URL
		return url;
		
	}

}
