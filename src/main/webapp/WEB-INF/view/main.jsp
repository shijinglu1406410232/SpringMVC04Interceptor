<%--
  Created by IntelliJ IDEA.
  User: shijinglu
  Date: 2019/2/3
  Time: 18:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>系统主页</title>
</head>
<body>
      当前用户是:${USER_SESSION.username}<br/>
              <a href="${pageContext.request.contextPath}/logout">点我退出</a>
</body>
</html>
<!--回忆一下EL表达式，这里是用EL表达式获取用户的信息,回忆一下session，看看旧笔记和代码-->

<!--/logout  清除session，并退出重新登录-->