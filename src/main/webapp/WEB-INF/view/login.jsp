<%--
  Created by IntelliJ IDEA.
  User: shijinglu
  Date: 2019/2/3
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>
      ${msg}
      <form action="${pageContext.request.contextPath}/login" method="post">
          用户名:<input name="username" id="username"/><br/>
          密&nbsp;&nbsp;&nbsp;码：<input type="password" name="password" id="password"/><br/>
          <input type="submit" value="登录">
      </form>
</body>
</html>
<!--其他的好像区分大小？但是post不知道是否区分，试试-->
