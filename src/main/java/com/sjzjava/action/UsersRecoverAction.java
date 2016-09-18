package com.sjzjava.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sjzjava.dao.UserRecoverDao;
import com.sjzjava.logic.RecoverUserLogic;
import com.sjzjava.util.HttpInterface;

public class UsersRecoverAction implements HttpInterface {
	
	private String userIds[] = null;
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse resp) {
		
		//获取批量删除的用户ID数组
		userIds = request.getParameterValues("userIds");
		
		//数组有值
		if (userIds != null) {
			//对数组进行循环操作
			for (String userId :userIds ) {
				//调用恢复DAO
				UserRecoverDao userRecoverDao = new UserRecoverDao();
				userRecoverDao.userRecover(userId);
			}
		}
					
		// 调用删除用户分页显示方法
		RecoverUserLogic recoverUserLogic = new RecoverUserLogic();
		String url = recoverUserLogic.recoverUsersSplit(request, resp);

		//返回URL
		return url;
		
	}

}
