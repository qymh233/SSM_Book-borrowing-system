<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>修改密码</title>
</head>

<body>
    <p>修改密码</p>
    <p>用户: ${user.uname}</p>
    <P>${msg}</P>
    <form action="/MyLibrary/UserOperateController/newpw.action" method="post">
        请输入新密码: <input type="text" name="newpw" placeholder="newpassword">
        <br>
        <br>
        <input type="submit" value="确认修改" name="submit">

    </form>
</body>

</html>