<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/9
  Time: 17:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
</head>
<body>
  <from:form modelAttribute="user" action="">
      <form:errors path="userName" cssClass="errorClass"/>
      <input name="username" type="text">
      <input type="password" name="password">
      <input type="submit" value="提交">
      <input type="reset" value="取消">
  </from:form>
</body>
</html>
