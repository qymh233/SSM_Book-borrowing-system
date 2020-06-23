<%@page import="java.util.List"%>
<%@page import="library.pojo.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%List<User> list=(List<User>)session.getAttribute("readers"); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改用户信息</title>
</head>
<body>
<p>修改用户信息</p>
<p>${msg}</p>
<form action="/MyLibrary/AdminOperateController/chanceuser.action" method="post">     
   请输入用户编号: <input type="text" name="uid" placeholder="userId">123001
        <br>
        <br>
   请输入新的密码: <input type="text" name="newpw" placeholder="newpassword">eg:123456kkk
        <br>
        <br>
        <input type="submit" value="确认修改" name="submit">  
</form>
 <table class="table">
		<tr>
		    <td>用户编号</td>
		    <td>用户密码</td>
		    <td>用户姓名</td>
		    <td>用户借用书籍</td>
		</tr>
		<%for(int i=0;i<list.size();i++){ %>
		    <tr>
		        <td><%=list.get(i).getUid() %></td>
		        <td><%=list.get(i).getUpw()%></td>
		        <td><%=list.get(i).getUname()%></td>
		        <td><%=list.get(i).getBname()%></td>
		    </tr>
		<%} %>
</table>
</body>
</html>