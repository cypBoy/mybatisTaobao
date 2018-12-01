<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登录</title>
</head>
<body>
<h3>欢迎登录</h3>
<form action="LoginServlet" method="post" >
    <lable>手机号:</lable> <input type="text" name="phone"/> <br/>
    <lable>密  码:</lable> <input type="password" name="pwd"/> <br/>
    <button type="submit">登录</button>
</form>


</body>
</html>