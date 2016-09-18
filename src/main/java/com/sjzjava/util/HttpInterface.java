package com.sjzjava.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface HttpInterface {
	/**
	 * HttpInterface接口，让各个action实现
	 * 
	 * @param request
	 * @return
	 */
	public String execute(HttpServletRequest request,HttpServletResponse resp);

}
