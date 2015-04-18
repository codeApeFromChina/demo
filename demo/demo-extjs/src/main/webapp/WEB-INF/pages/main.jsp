<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="cn.tj.baseextweb.fw.util.CurrentDate"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
  	<base href="<%=basePath%>"/>
    <title>MIS</title>
    	<link rel="stylesheet" type="text/css"
			href="js/extjs/resources/css/ext-all.css"/>
		<link rel="stylesheet" type="text/css"
			href="css/common.css"/>
		<link rel="stylesheet" type="text/css"
			href="css/icon.css"/>
		<link rel="stylesheet" type="text/css"
			href="css/loading.css"/>
		<script type="text/javascript" src="js/extjs/ext-base.js"></script>
		<script type="text/javascript" src="js/extjs/ext-all.js"></script>
		<!-- ext插件 -->
		<script type="text/javascript" src="js/extjs/plugin/TabCloseMenu.js"></script>
		<link rel="stylesheet" type="text/css" href="js/extjs/plugin/css/fileuploadfield.css"/>
		<script type="text/javascript" src="js/extjs/plugin/FileUploadField.js"></script>
		<script type="text/javascript" src="js/extjs/plugin/TreeCheckNodeUI.js"></script>
		<!-- script type="text/javascript" src="js/extjs/plugin/ext-basex.js"></script> -->
		<!-- 树形表格 -->
		<script type="text/javascript" src="js/extjs/treegrid/TreeGridSorter.js"></script>
		<script type="text/javascript" src="js/extjs/treegrid/TreeGridColumnResizer.js"></script>
		<script type="text/javascript" src="js/extjs/treegrid/TreeGridNodeUI.js"></script>
		<script type="text/javascript" src="js/extjs/treegrid/TreeGridLoader.js"></script>
		<script type="text/javascript" src="js/extjs/treegrid/TreeGridColumns.js"></script>
		<script type="text/javascript" src="js/extjs/treegrid/TreeGrid.js"></script>
		<script type="text/javascript" src="js/extjs/treegrid/edittreegrid-pkg.js"></script>
		<link rel="stylesheet" type="text/css" href="js/extjs/treegrid/treegrid.css"/>
		<link rel="stylesheet" type="text/css" href="js/extjs/treegrid/edittreegrid.css"/>
		<!-- 公共 JS -->
		<script type="text/javascript" src="js/util/gridOperate.js"></script>
		<script type="text/javascript" src="js/override/dialog.js"></script>
		<script type="text/javascript" src="js/util/juage.js"></script>
		<script type="text/javascript" src="js/util/winSize.js"></script>
		<script type="text/javascript" src="js/util/Tooltip.js"></script>
		<script type="text/javascript" src="js/util/common.js"></script>
		<!-- 主页 -->
  		<script type="text/javascript" src="js/main.js"></script>

		<!-- 用户管理 -->
		<script type="text/javascript" src="js/userInfo.js"></script>
	
  		<script type="text/javascript">
	  		Ext.onReady(function(){
	  			
	  					Ext.get('loading').remove();
						Ext.get('loading-mask').fadeOut({remove:true});
	  				
//	  			setTimeout(function() {
//				}, 1000); 
	  			var username = "张三"; //获取登录用户
	  			var date = "<%=CurrentDate.getDateWeek()%>";
	  			var main = new mainPage(username, date);
			});
  		</script>
  </head>
  
  <body style="margin:0px;">
  	<div id="loading">
             <div  class="loading-indicator">
                  <img src="img/extanim32.gif" alt="" width="32" height="32" style="margin-right:8px;" align="absmiddle"/>
         正在加载,请稍候......
             </div>
         </div>
         <div id="loading-mask">
         </div>
  </body>
</html>
