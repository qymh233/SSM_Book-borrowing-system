<%@page import="java.util.List"%>
<%@page import="library.pojo.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%List<User> list=(List<User>)session.getAttribute("readers"); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>删除用户</title>
</head>
<body>
<p>删除用户</p>
<p>${msg}</p>
<form action="/MyLibrary/AdminOperateController/deluser.action" method="post">
        请输入用户编号: <input type="text" name="uid" placeholder="userId">
        <br>
        <br>
        <input type="submit" value="删除用户" name="submit">
    </form>
    <table class="table">
		<tr>
		    <td>用户编号</td>
		    <td>用户姓名</td>
		    <td>用户借用书籍</td>
		</tr>
		<%for(int i=0;i<list.size();i++){ %>
		    <tr>
		        <td><%=list.get(i).getUid() %></td>
		        <td><%=list.get(i).getUname()%></td>
		        <td><%=list.get(i).getBname()%></td>
		    </tr>
		<%} %>
	</table>
</body>
</html>