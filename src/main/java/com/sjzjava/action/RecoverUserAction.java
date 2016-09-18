package com.sjzjava.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sjzjava.logic.RecoverUserLogic;
import com.sjzjava.util.HttpInterface;

public class RecoverUserAction  implements HttpInterface{
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse resp) {
			
		//调用删除用户分页显示方法
		RecoverUserLogic recoverUserLogic = new RecoverUserLogic();
		return recoverUserLogic.recoverUsersSplit(request, resp);		
	}
}
