<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>manage</title>
</head>
<body>
<p>登陆成功</p>
<p>当前登陆用户: ${user.uname}</p>
<p>${msg}</p>
<form action="/MyLibrary/AdminController/admin.action" method="post">     
    <input type="submit" value="添加用户" name="submit">
        <br>
        <br>
        <input type="submit" value="删除用户" name="submit">
        <br>
        <br>
        <input type="submit" value="修改用户信息" name="submit">
        <br>
        <br>
        <input type="submit" value="添加图书" name="submit"> 
        <br>
        <br>
        <input type="submit" value="删除图书" name="submit">
        <br>
        <br>
        <input type="submit" value="修改图书信息" name="submit">
        <br>
        <br>
        <input type="submit" value="退出登陆" name="submit">
 </form>
</body>
</html>