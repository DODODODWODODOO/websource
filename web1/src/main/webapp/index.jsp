<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<html>
<body>
<h2>Hello World!</h2>
<h3>안녕하세요</h3>
<ul>
    <% if(loginDto.getUserId()==null) {%>
    <li><a href="/member/login.jsp">로그인</a></li>
    <% } else{ %>
    <li><a href="/logout">로그아웃</a></li>
    <% }%>
    <li><a href="/basic/add.jsp">계산기(덧셈)</a></li>
    <li><a href="/basic/add2.jsp">계산기(사식연산)</a></li>

</ul>
</body>
</html>
