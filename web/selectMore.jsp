<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2018/7/9
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>多查询条件</title>
</head>
<body>
<form action="SelectMoreParams">
    请输入: <input type="text" name="phone" placeholder="电话"/>
    <select name="sex">
        <option value="-1">全选</option>
        <option value="0">男</option>
        <option value="1">女</option>
    </select>
    <input type="text" name="realName" placeholder="姓名"/>
    <input type="submit" value="搜索"/>
</form>

<table border="2">

    <c:forEach items="${list}" var="cus">
        <tr>

            <td>${cus.phone}</td>
            <td>${cus.realName}</td>
            <td>${cus.sex==0?"男":"女"}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
