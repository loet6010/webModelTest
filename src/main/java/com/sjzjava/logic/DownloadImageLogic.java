package com.sjzjava.logic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadImageLogic {

	// 下载文件成功返回true
	public boolean downloadImageMethod(HttpServletRequest request, HttpServletResponse resp) {
		// 得到要下载的文件名
		String fileName = request.getParameter("filename");
		try {
			fileName = new String(fileName.getBytes("iso8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		// 上传的文件都是保存在/WEB-INF/upload目录下的子目录当中
		String fileSaveRootPath = "D:\\JAVA\\workspace\\javaWebTest\\WebContent\\upload";
		// 得到要下载的文件
		File file = new File(fileSaveRootPath + "\\" + fileName);
		// 如果文件不存在
		if (!file.exists()) {
			System.out.println("您要下载的资源不存在");
			request.setAttribute("message", "您要下载的资源已被删除！！");
			
			return false;
		}
		// 处理文件名
		String realname = fileName.substring(fileName.indexOf("_") + 1);
		// 设置响应头，控制浏览器下载该文件
		try {
			resp.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(realname, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		// 读取要下载的文件，保存到文件输入流
		FileInputStream in = null;
		try {
			in = new FileInputStream(fileSaveRootPath + "\\" + fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		// 创建输出流
		OutputStream out = null;
		try {
			out = resp.getOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 创建缓冲区
		byte buffer[] = new byte[1024];
		int len = 0;
		// 循环将输入流中的内容读取到缓冲区当中
		try {
			while ((len = in.read(buffer)) > 0) {
				// 输出缓冲区的内容到浏览器，实现文件下载
				out.write(buffer, 0, len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 关闭文件输入/输出流
		try {
			in.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("下载成功");
		return true;
	}

}
