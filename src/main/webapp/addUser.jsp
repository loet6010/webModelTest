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

	<script type="text/javascript">	
	
		var userNameFlag = false; 	
		var ageFlag = false;
		var birthdayFlag = false;
		var addressFlag = false;
		<!--用户名check-->
		function userNameCheck(str) {
			if (str == "") {				
				document.getElementById("userNameHint").innerHTML="用户名不能为空";
			} else {
				
				<!--ajax调用后台验证用户名是否重复-->
				var xmlhttp =  new XMLHttpRequest();
				xmlhttp.onreadystatechange=function()
				  {
				  if (xmlhttp.readyState==4) {
					  if (xmlhttp.status==200) {
						  document.getElementById("userNameHint").innerHTML="用户名已存在";
					  } else {
						  document.getElementById("userNameHint").innerHTML="";
						  userNameFlag = true;
					  }
				    }
				  }
				xmlhttp.open("GET","userExistCheck.do?actionName=userExistCheckAction&userName="+str,true);
				xmlhttp.send();
			}
		}
		<!--年龄check-->
		function ageCheck() {
			if (addUser.age.value == "") {
				document.getElementById("ageHint").innerHTML="年龄不能为空";
			} else {
				if (isNaN(addUser.age.value)) {
					document.getElementById("ageHint").innerHTML="请输入数字";
				} else {
					document.getElementById("ageHint").innerHTML="";
					ageFlag = true;
				}
			}
		}
		<!--民族check-->
		function birthdayCheck() {
			if (addUser.birthday.value == "") {
				document.getElementById("birthdayHint").innerHTML="民族不能为空";
			} else {
				document.getElementById("birthdayHint").innerHTML="";
				birthdayFlag = true;
			}
		}
		<!--地址check-->
		function addressCheck() {
			if (addUser.address.value == "") {
				document.getElementById("addressHint").innerHTML="地址不能为空";
			} else {
				document.getElementById("addressHint").innerHTML="";
				addressFlag = true;
			}
		}

		function submitCheck() {
			var checkFlag = userNameFlag&&ageFlag&&birthdayFlag&&addressFlag;
			if (checkFlag) {
				document.getElementById("addUserSubmit").submit();
			} else {
				alert("存在不合法输入！")
			}
		}
	</script>

	<form name="addUser" action="add.do?actionName=userAddAction"
		method="post" id="addUserSubmit">
		<table align="center" style="text-align: center; width: 500px;">
			<tr>
				<td width="200">用户名:</td>
				<td width="150"><input type="text" name="userName"
					onblur="userNameCheck(this.value)" /></td>
				<td><span id="userNameHint" style="color:red"></span></td>
			</tr>
			<tr>
				<td>年龄:</td>
				<td><input type="text" name="age" onblur="ageCheck()" /></td>
				<td><span id="ageHint" style="color:red"></span></td>
			</tr>
			<tr>
				<td>民族:</td>
				<td><input type="text" name="birthday" onblur="birthdayCheck()" /></td>
				<td><span id="birthdayHint" style="color:red"></span></td>
			</tr>
			<tr>
				<td>住址:</td>
				<td><input type="text" name="address" onblur="addressCheck()" /></td>
				<td><span id="addressHint" style="color:red"></span></td>
			</tr>
			<tr>
				<td colspan="3"><input type="button" value="添加"
					onclick="submitCheck()" /></td>
			</tr>
			<tr>
				<td colspan="3"><a
					href="pageSplitAction.do?actionName=pageSplitAction">返回</a></td>
			</tr>
		</table>
	</form>

</body>
</html>