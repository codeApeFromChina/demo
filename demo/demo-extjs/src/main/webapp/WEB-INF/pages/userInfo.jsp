<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户</title>
	<script type="text/javascript">
		var userInfo = new UserInfoPanel();
		var tabId = Ext.getCmp('mainTab').getActiveTab().id.split('_')[1];
		juage(tabId,"userInfo",userInfo,"userInfoDiv");
	</script>
	
  </head>
  <body>
  	<div id="userInfoDiv" ></div>
  </body>
</html>
