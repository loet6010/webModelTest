package com.sjzjava.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sjzjava.logic.PageSplitLogic;
import com.sjzjava.logic.UploadImageLogic;
import com.sjzjava.util.HttpInterface;

/**
 * 
 * @author liurh
 * @date   2016年1月8日
 * @intro  上传图片及文件
 *
 */

public class UploadImageAction implements HttpInterface {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse resp) {
		
		//调用逻辑方法
		UploadImageLogic uploadImageLogic = new UploadImageLogic();
		try {
			uploadImageLogic.uploadFile(request, resp);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		//调用显示方法
		PageSplitLogic pageSplitLogic = new PageSplitLogic();
		String url = pageSplitLogic.pageSplit(request, resp);
		
		//返回URL
		return url;	
	}
}
