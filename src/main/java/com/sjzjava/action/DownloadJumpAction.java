package com.sjzjava.action;
/**
 * 将upload中的文件显示在下载页面
 */

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sjzjava.logic.DownloadJumpLogic;
import com.sjzjava.util.HttpInterface;

public class DownloadJumpAction implements HttpInterface {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse resp) {
		
		//调用下载页逻辑方法
		DownloadJumpLogic downloadJumpLogic = new DownloadJumpLogic();
		return downloadJumpLogic.downloadJumpMethod(request, resp);		
	}
}
