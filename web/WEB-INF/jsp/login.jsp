<%--
  Created by IntelliJ IDEA.
  User: zhaishaoping
  Date: 2019-07-01
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/item/login" method="post">
    <table>
        <tr>
            <td>用户名</td>
            <td><input name="username"/></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input name="password"/></td>
        </tr>
    </table>

    <button type="submit">登录</button>
</form>
</body>
</html>
