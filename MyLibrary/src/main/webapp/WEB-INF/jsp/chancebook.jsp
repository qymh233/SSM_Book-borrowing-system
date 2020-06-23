<%@page import="java.util.List"%>
<%@page import="library.pojo.Book" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%List<Book> list=(List<Book>)session.getAttribute("books"); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改图书数量</title>
</head>
<body>
<p>修改图书数量</p>
<p>${msg}</p>
<form action="/MyLibrary/AdminBookOperateController/chancebook.action" method="post">
        请输入图书编号: <input type="text" name="bid" placeholder="bookId">
        <br>
        <br>
         请输入图书数量: <input type="text" name="quantity" placeholder="bookquantity">
        <br>
        <br>
        <input type="submit" value="确认修改" name="submit">
    </form>
    <table class="table">
		<tr>
		    <td>图书编号</td>
		    <td>图书名称</td>
		    <td>图书数量</td>
		</tr>
		<%for(int i=0;i<list.size();i++){ %>
		    <tr>
		        <td><%=list.get(i).getBid() %></td>
		        <td><%=list.get(i).getBname() %></td>
		        <td><%=list.get(i).getQuantity() %></td>
		    </tr>
		<%} %>
	</table>
</body>
</html>