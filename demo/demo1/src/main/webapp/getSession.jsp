 <%@ page language="java" pageEncoding="UTF-8"%>
 <%
    HttpSession s = request.getSession(); 
    %>
    得到Session的值是<%=s.getAttribute("name") %>