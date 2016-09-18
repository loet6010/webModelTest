<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>被删除用户详细列表</title>
</head>
<body>

	<script type="text/javascript">

		function gotoSelectedPage() {
			var x = document.getElementById("navigatorForm");
			//alert("Original action: " + x.action)
			x.submit();
		}
		
		if(document.getElementById("checkboxall").checked){
		    alert("checkbox is checked");
		}

		function chickAll() {
			// 全选方法
			var chickBoxs = document.getElementsByName("userIds");
			for (var i = 0; i < chickBoxs.length; i++) {

				chickBoxs[i].checked = "checked";
			}
		}
		
		function Nochick() {
			// 全选方法
			var chickBoxs = document.getElementsByName("userIds");
			for (var i = 0; i < chickBoxs.length; i++) {

				chickBoxs[i].checked = !chickBoxs[i].checked;
			}
		}
	</script>

	<c:if test="${not empty userList}">
		<form action="recoverAll.do?actionName=usersRecoverAction&pageNumber=${pageNumber}"
			method="post">
			<table align="center" style="width: 600px; text-align: center;"
				cellpadding="0" cellspacing="0" border="1">
				<tr>
					<th></th>
					<th>用户ID</th>
					<th>用户名</th>
					<th>年龄</th>
					<th>民族</th>
					<th>地址</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${userList}" var="user">
					<tr>
						<td><input type="checkbox" name="userIds"
							value="${user.userId}"></td>
						<td>${user.userId }</td>
						<td>${user.userName }</td>
						<td>${user.age }</td>
						<td>${user.birthday }</td>
						<td>${user.address }</td>
						<td>
							<a
							href="recover.do?actionName=userRecoverAction&userId=${user.userId}&pageNumber=${pageNumber}">恢复</a>
						</td>
					</tr>
				</c:forEach>
			</table>
			<table align="center">
				<tr>
					<td><input type="button" value="全选" name="checkall"
						id="checkall" onclick="chickAll()" /></td>
					<td><input type="button" value="反选" name="nocheck"
						id="nocheck" onclick="Nochick()" /></td>
					<td><input type="submit" value="批量恢复" /></td>
				</tr>
			</table>
		</form>


		<form action="pageSplitAction.do?actionName=pageSplitAction"
			method="post" id="navigatorForm">
			<table align="center">
				<tr>
					<td><a
						href="recoverUser.do?actionName=recoverUserAction&pageNumber=1">首页</a>
					</td>
					<td><c:if test="${pageNumber>1}">
							<a
								href="recoverUser.do?actionName=recoverUserAction&pageNumber=${pageNumber-1}">上一页</a>
						</c:if></td>
					<td><c:if test="${pageNumber<totalPages}">
							<a
								href="recoverUser.do?actionName=recoverUserAction&pageNumber=${pageNumber+1}">下一页</a>
						</c:if></td>
					<td>跳转到第 <select name="pageNumber"
						onchange="gotoSelectedPage();">
							<c:forEach begin="1" end="${totalPages}" step="1" var="pageIndex">
								<c:choose>
									<c:when test="${pageIndex eq pageNumber}">
										<option value="${pageIndex}" selected="selected">${pageIndex}</option>
									</c:when>
									<c:otherwise>
										<option value="${pageIndex}">${pageIndex}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
					</select>页
					</td>
					<td><a
						href="recoverUser.do?actionName=recoverUserAction&pageNumber=${totalPages}">末页</a>
					</td>
				</tr>
			</table>
		</form>
		<br />
		<table align="center">
			<tr>
				<td><a href="pageSplitAction.do?actionName=pageSplitAction">返回</a></td>
			</tr>
		</table>

	</c:if>



	<c:if test="${empty userList}">
		<h2 align="center">
			暂时还没有任何数据，点击<a href="pageSplitAction.do?actionName=pageSplitAction">此处</a>返回
		</h2>
	</c:if>

</body>
</html>