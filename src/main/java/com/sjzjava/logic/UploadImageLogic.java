package com.sjzjava.logic;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

/**
 * 
 * @author liurh
 * @date   2016年1月8日
 * @intro  图片文件上传的逻辑类
 *
 */

public class UploadImageLogic {
	
	//图片及文件上传方法
	public boolean uploadFile(HttpServletRequest request, HttpServletResponse resp) throws UnsupportedEncodingException {

		request.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//为解析类提供配置信息
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//创建解析类的实例
		ServletFileUpload sfu = new ServletFileUpload(factory);
		//开始解析
		sfu.setFileSizeMax(1024*400);
		//每个表单域中数据会封装到一个对应的FileItem对象上
		try {
			List<FileItem> items = sfu.parseRequest((RequestContext) request);
			//区分表单域
			for (int i = 0; i < items.size(); i++) {
				FileItem item = items.get(i);
				//isFormField为true，表示这不是文件上传表单域
				if(!item.isFormField()){
					//获得存放文件的物理路径
					//upload下的某个文件夹   得到当前在线的用户  找到对应的文件夹
					
					String path = "D:\\JAVA\\workspace\\javaWebTest\\WebContent\\upload";
					System.out.println("UploadImageAction-path:"+path);
					//获得文件名
					String fileName = item.getName();
					System.out.println("UploadImageAction-fileName:"+fileName);
					//该方法在某些平台(操作系统),会返回路径+文件名
					fileName = fileName.substring(fileName.lastIndexOf("/")+1);
					File file = new File(path+"\\"+fileName);
					if(!file.exists()){
						item.write(file);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return true;
	}
}
