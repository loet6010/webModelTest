package com.sjzjava.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sjzjava.logic.DownloadImageLogic;
import com.sjzjava.util.HttpInterface;

public class DownloadImageAction implements HttpInterface {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse resp) {

		//调用下载方法
		DownloadImageLogic downloadImageLogic = new DownloadImageLogic();
		//下载成功返回下载页
		if (downloadImageLogic.downloadImageMethod(request, resp)) {
			//返回空，页面不跳转
			return "";
		}
		
		//下载失败
		return null;
	}
}
