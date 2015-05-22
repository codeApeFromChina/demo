<%@ page language="java" import="cn.tj.fnzi.controller.AuthService" %>
<html>
<body>
<h2>Hello World!</h2>

resource test...

web:<img src="resources/accept.png" />
auth:<img src="resources/add.png" />
user:<img src="resources/cancel.png" />

<a href="index.jsp">web</a>
<a href="auth/list">auth</a>
<a href="user/list">user</a>
<%
AuthService auth = new AuthService();
out.print(auth.out());

%>
</body>
</html>
