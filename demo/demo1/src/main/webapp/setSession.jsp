 <%@ page language="java" pageEncoding="UTF-8"%>
 <%
 String val = request.getParameter("value");
 
 
    HttpSession s = request.getSession(); 
    s.setAttribute("name",val);
    %>