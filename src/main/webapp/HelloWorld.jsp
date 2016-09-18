<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员登陆界面</title>
</head>
<body>
<form action="userLogin.do?actionName=userLogin" method="post">
			<table align="center" style="text-align: center; width: 400px;">
				<tr>
					<td width="200">管理员用户名:</td>
					<td width="150"><input type="text" name="userName" value="${userName}" /></td>
				</tr>
				<tr>
					<td>管理员密码:</td>
					<td><input type="password" name="password"  value="${password }" /></td>
				</tr>
				<tr>
					<td colspan="3"><input type="submit" value="登陆"/></td>
				</tr>
			</table>
</form>
</body>
</html>