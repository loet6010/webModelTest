package com.sjzjava.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sjzjava.logic.PageSplitLogic;
import com.sjzjava.util.HttpInterface;

public class PageSplitAction implements HttpInterface {
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse resp) {
			
		//调用分页显示方法
		PageSplitLogic pageSplitLogic = new PageSplitLogic();
		return pageSplitLogic.pageSplit(request, resp);		
	}
}
