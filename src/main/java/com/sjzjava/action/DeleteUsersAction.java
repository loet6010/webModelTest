package com.sjzjava.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sjzjava.dao.UserDeleteDao;
import com.sjzjava.logic.PageSplitLogic;
import com.sjzjava.util.HttpInterface;

public class DeleteUsersAction implements HttpInterface {
	
private String userIds[] = null;
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse resp) {
		
		//获取批量删除的用户ID数组
		userIds = request.getParameterValues("userIds");
		
		//数组有值
		if (userIds != null) {
			//对数组进行循环操作
			for (String userId :userIds ) {
				//调用删除DAO
				UserDeleteDao userDeleteDao = new UserDeleteDao();
				userDeleteDao.userDelete(userId);
			}
		}					

		//调用分页显示方法并返回URL
		PageSplitLogic pageSplitLogic = new PageSplitLogic();
		return pageSplitLogic.pageSplit(request, resp);
		
	}

}
