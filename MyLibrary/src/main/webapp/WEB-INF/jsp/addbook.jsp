<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加图书</title>
</head>
<body>
<p>添加图书</p>
<p>${msg}</p>
<form action="/MyLibrary/AdminBookOperateController/addbook.action" method="post">     
   请输入图书编号：<input type="text" name="bid" placeholder="bookid">eg:2020011
   <br>
   <br> 
   请输入图书名字：<input type="text" name="bname" placeholder="bookname">
   <br>
   <br>
   请输入图书数量：<input type="text" name="quantity" placeholder="booksum">                 
   <input type="submit" value="提交">   
</form>
</body>
</html>