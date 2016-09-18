package com.sjzjava.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sjzjava.dao.UserRecoverDao;
import com.sjzjava.logic.RecoverUserLogic;
import com.sjzjava.util.HttpInterface;

public class UserRecoverAction implements HttpInterface {
	
	private String userId = null;
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse resp) {
		
		//获取要恢复的用户ID
		userId = request.getParameter("userId");

		//调用恢复DAO
		UserRecoverDao userRecoverDao = new UserRecoverDao();
		userRecoverDao.userRecover(userId);

		// 调用删除用户分页显示方法
		RecoverUserLogic recoverUserLogic = new RecoverUserLogic();
		String url = recoverUserLogic.recoverUsersSplit(request, resp);

		//返回URL
		return url;
		
	}

}
