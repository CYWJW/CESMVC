<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="/tab/Basics .jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.font {
	font-size: 15px;
	color: #033D61;
	f
}

.tablel {
	/*设置边框  */
	width: 100%;
	border-collapse: collapse;
}

.tablel th,.tablel td {
	border: 1px solid #33A9D0;
}

th {
	background-color: #E7F2FA;
}
</style>
</head>
<body>

	<span>当前位置:用户管理>>用户编辑</span>
	<form action="${path}/UpdateServlet" method="post"
		enctype="multipart/form-data">
		<!-- 加入隐藏域 -->
		<input type="hidden" name="userId" value="${userId}">
		<table class="tablel">
			<tr align="center">
				<td style="background-color:#E7F2FA ">用户名</td>
				<td><input type="text" name="username"
					value="${user.getUsername() }"></td>
			</tr>
			<tr align="center">
				<td style="background-color:#E7F2FA ">头像</td>
				<td><input type="file" name="userpic" value="${user.getPic()}"></td>
			</tr>
			<tr align="center">
				<td style="background-color:#E7F2FA ">密码</td>
				<td><input type="password" name="password"
					value="${user.getPassword()}"></td>
			</tr>
			<tr align="center">
				<td style="background-color:#E7F2FA ">性别</td>
				<td><input type="radio" name="gender" value="1"
					<c:if test="${user.getGender() == 1}">
					checked="checked"</c:if>>男
					&nbsp; <input type="radio" name="gender" value="0"
					<c:if test="${user.getGender() == 0}">
					checked="checked"</c:if>>女;

				</td>
			<tr align="center">
				<td style="background-color:#E7F2FA ">生日</td>
				<td><input type="text" name="brithday"
					value="${user.getBrithday()}"></td>
			</tr>
			<tr align="center">
				<td style="background-color:#E7F2FA ">住址</td>
				<td><input type="text" name="address"
					value="${ user.getAddress()}"></td>
			</tr>
			<tr align="center">
				<td style="background-color:#E7F2FA ">工资</td>
				<td><input type="text" name="sal" value="${user.getSal()}">
				</td>
			</tr>
			<tr>
				<td colspan="2" style="background-color:#E7F2FA " align="right">
					<a href="${path}/QueryServlet">取消</a>&nbsp;|&nbsp; <input
					type="submit" value="修改">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>