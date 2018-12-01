<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2018/7/9
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人中心</title>
</head>
<body>
当前登录:${sessionScope.customer.phone}
<img src="${sessionScope.customer.imgurl}">
<form action="/UpdateImgServlet" method="post" enctype="multipart/form-data">
    <input type="file" name="fileName"/>   <br/>
    性别:    <input type="text" name="sex" value="${sessionScope.customer.sex==0?"男":"女"}" readonly="readonly"/>  <br/>
    真实姓名:  <input type="text" name="realName" value="${sessionScope.customer.realName}"/> <br/>
    <button type="submit" >修改</button>
</form>
</body>
</html>
