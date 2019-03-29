<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/tab/Basics .jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.font{
font-size: 15px;
color: #033D61;
f
}
.tablel {
/*设置边框  */
	width:100%;
	border-collapse: collapse;
}
.tablel th, .tablel td {
	border: 1px solid #33A9D0;
	
}
th{
background-color: #E7F2FA;
}
</style>
</head>
<body>
<h4>用户信息</h4>

</table>
<table width="100%"  >
<tr align="right" >
<td ><a href="${path}/tab/toAdd.jsp" ><img alt="无法显示" src="${path}/tab/images/22.gif">添加</a></td>
</tr>
</table>
<table class="font tablel" >
<tr>
	<th>头像</th>
	<th>用户名</th>
	<th>密码</th>
	<th>性别</th>
	<th>生日</th>
	<th>住址</th>
	<th>工资</th>
	<th>管理</th>
</tr>
<!--域对象取值 循环数组 赋给cs  -->

<c:forEach items="${list}" var="cs">
<tr align="center" >
<td width="50" height="50"><img alt="无法显示" src="${path}${cs.getPic()} "></td>
<td>${cs.getUsername()}</td>
<td>${cs.getPassword()}</td>
<td>
<c:if test="${cs.getGender()==1}">男</c:if>
<c:if test="${cs.getGender()==0}">女</c:if>
</td>
<td>${cs.getBrithday()}</td>
<td>${cs.getAddress()}</td>
<td>${cs.getSal()}</td>
<td>
<a href="${path }/SelectServlet?userId=${cs.getUserId()}"><img alt="无法显示" src="${path }/tab/images/edt.gif">编辑</a>&nbsp;|&nbsp;
<a href="${path }/DeleteServlet?userId=${cs.getUserId()}"><img alt="无法显示" src="${path }/tab/images/del.gif">删除</a> 
</td>
</tr>
</c:forEach>

</body>
</html>