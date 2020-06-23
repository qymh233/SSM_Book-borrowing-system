<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>success</title>
</head>
<body>
<p>登陆成功</p>
<p>当前登陆用户: ${user.uname}</p>
<p>当前用户账号: ${user.uid}</p>
<p>当前借用书籍: ${ret}</p>
<p>${msg}</p>
<form action="/MyLibrary/SuccessController/suc.action" method="post">     
    <input type="submit" value="借用书籍" name="submit">
        <br>
        <br>
        <input type="submit" value="归还书籍" name="submit">
        <br>
        <br>
        <input type="submit" value="修改密码" name="submit">
        <br>
        <br>
        <input type="submit" value="退出登陆" name="submit"> 
 </form>
</body>
</html>