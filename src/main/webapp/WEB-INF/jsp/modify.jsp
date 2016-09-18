<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改用户</title>
</head>
<body>
	<form
		action="modify.do?actionName=userModifyAction&userId=${user.userId}&pageNumber=${pageNumber}"
		method="post">
		<table align="center" style="text-align: center; width: 400px;">
			<tr>
				<td>用户头像:</td>
				<td><img src="/i/eg_mouse.jpg" width="128" height="128"></td>
			</tr>
			<tr>
				<td>用户ID:</td>
				<td>${user.userId }</td>
			</tr>
			<tr>
				<td width="200">用户名:</td>
				<td width="150"><input type="text" name="userName"
					onblur="if(this.value == '')this.value='${user.userName }';"
					onclick="if(this.value == '${user.userName }')this.value='';"
					value="${user.userName }" /></td>
			</tr>
			<tr>
				<td>年龄:</td>
				<td><input type="text" name="age"
					onblur="if(this.value == '')this.value='${user.age }';"
					onclick="if(this.value == '${user.age }')this.value='';"
					value="${user.age }" /></td>
			</tr>
			<tr>
				<td>民族:</td>
				<td><input type="text" name="birthday"
					onblur="if(this.value == '')this.value='${user.birthday }';"
					onclick="if(this.value == '${user.birthday }')this.value='';"
					value="${user.birthday }" /></td>
			</tr>
			<tr>
				<td>住址:</td>
				<td><input type="text" name="address"
					onblur="if(this.value == '')this.value='${user.address }';"
					onclick="if(this.value == '${user.address }')this.value='';"
					value="${user.address }" /></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" value="修改" /></td>
			</tr>
			<tr>
				<td colspan="3"><a
					href="pageSplitAction.do?actionName=pageSplitAction">返回</a></td>
			</tr>
		</table>
	</form>

</body>
</html>