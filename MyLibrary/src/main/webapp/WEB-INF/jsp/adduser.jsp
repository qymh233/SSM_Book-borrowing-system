<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加用户</title>
</head>
<body>
<p>添加用户</p>
<p>${msg}</p>
<form action="/MyLibrary/AdminOperateController/adduser.action" method="post">     
   请输入用户账号：<input type="text" name="uid" placeholder="userid">eg:123001
   <br>
   <br> 
   请输入用户密码：<input type="text" name="upw" placeholder="usepassword">eg:123456lll
   <br>
   <br>
   请输入用户姓名：<input type="text" name="uname" placeholder="username">                 
   <input type="submit" value="提交">   
</form>
</body>
</html>