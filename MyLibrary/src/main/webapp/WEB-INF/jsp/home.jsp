<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎你</title>
</head>
<body>
<p>这是欢迎页面</p>
<p>${msg}</p>
<form action="/MyLibrary/UserController/one.action" method="post">     
   <input type="text" name="uid" placeholder="userid"> 
   <input type="text" name="upw" placeholder="usepassword">                
     <input type="submit" value="提交">   
</form>
</body>
</html>