<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2018/7/6
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>淘宝商品</title>
    <style>
      table{
        border-collapse: collapse;

      }
      table td{
        padding:4px 10px;

      }

    </style>
  </head>
  <body>
  <c:choose>
    <c:when test="${empty sessionScope.customer}">
      <a href="login.jsp">请登陆</a>
      <a href="register.jsp">免费注册</a>
    </c:when>
    <c:otherwise>
      <h2>欢迎你:
        <c:out value="${sessionScope.customer.realName}"></c:out>
      </h2>
    </c:otherwise>
  </c:choose>
  <a href="admin/selfcenter.jsp">个人中心</a>

    <h2 style="color: red">淘宝商品</h2>

    <table cellspacing="0" cellspadding="0" border="1">
      <tr>
        <td>序号</td>
        <td>商品编号</td>
        <td>商品名称</td>
        <td>商品类型</td>
        <td>商品价格</td>
      </tr>
      <c:forEach var="goods" items="${pages.list}" varStatus="status">
        <tr>
          <td>${(status.index+1)+(pages.curIndex-1)*pages. pageSize}</td>
          <td>${goods.no}</td>
          <td>${goods.name}</td>
          <td>${goods.type}</td>
          <td>${goods.price}</td>
        </tr>
      </c:forEach>
    </table>

    <a href="ListByPageServlet?curIndex=${pages.curIndex==1?1:pages.curIndex-1}">上一页</a>
    <c:forEach var="i" begin="1" end="${pages.totalPage}" step="1">
      <a href="ListByPageServlet?curIndex=${i}">${i}</a>
    </c:forEach>
    <a href="ListByPageServlet?curIndex=${pages.curIndex==pages.totalPage?pages.totalPage:pages.curIndex+1}">下一页</a>
  </body>
</html>
