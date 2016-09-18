package com.sjzjava.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sjzjava.action.DeleteUsersAction;
import com.sjzjava.action.DownloadImageAction;
import com.sjzjava.action.DownloadJumpAction;
import com.sjzjava.action.PageSplitAction;
import com.sjzjava.action.RecoverUserAction;
import com.sjzjava.action.UploadImageAction;
import com.sjzjava.action.UserAddAction;
import com.sjzjava.action.UserDeleteAction;
import com.sjzjava.action.UserExistCheckAction;
import com.sjzjava.action.UserLogin;
import com.sjzjava.action.UserModifyAction;
import com.sjzjava.action.UserRecoverAction;
import com.sjzjava.action.UsersRecoverAction;
import com.sjzjava.action.UsersSearchAction;
import com.sjzjava.util.HttpInterface;

public class ActionServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//获取页面传的actionName
		String cmd = req.getParameter("actionName");
		
		HttpInterface httpInterface = (HttpInterface) getServletContext().getAttribute(cmd);
		// ͨ利用方法回调方式调用execute方法
		String url = httpInterface.execute(req, resp);
				
		//有URL返回时，返回信息回页面
		if (url == "") {
			return;
		}
		
		if (url != null) {
			req.getRequestDispatcher(url).forward(req, resp);
		} else {
			//没有URL返回时返回错误页面
			req.getRequestDispatcher("WEB-INF/jsp/error.jsp").forward(req, resp);
		}
		
	}
	
	@Override
	public void init() throws ServletException {
		//获取application
		ServletContext application = getServletContext();
		//将action方法添加到application
		application.setAttribute("userLogin", new UserLogin());
		application.setAttribute("userModifyAction", new UserModifyAction());
		application.setAttribute("userDeleteAction", new UserDeleteAction());
		application.setAttribute("userAddAction", new UserAddAction());
		application.setAttribute("pageSplitAction", new PageSplitAction());
		application.setAttribute("deleteUsersAction", new DeleteUsersAction());
		application.setAttribute("recoverUserAction", new RecoverUserAction());
		application.setAttribute("userRecoverAction", new UserRecoverAction());
		application.setAttribute("usersRecoverAction", new UsersRecoverAction());
		application.setAttribute("usersSearchAction", new UsersSearchAction());
		application.setAttribute("userExistCheckAction", new UserExistCheckAction());
		application.setAttribute("uploadImageAction", new UploadImageAction());
		application.setAttribute("downloadJumpAction", new DownloadJumpAction());
		application.setAttribute("downloadImageAction", new DownloadImageAction());				
	}
}
