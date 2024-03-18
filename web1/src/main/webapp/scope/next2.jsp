<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<%
    String id = (String)session.getAttribute("id");
    String name = (String)session.getAttribute("name");
    String age = (String)session.getAttribute("age");
%>
<h2>세션에서 데이터 가져오기</h2>
<h3>id : <%=id%></h3>
<h3>name : <%=name%></h3>
<h3>age : <%=age%></h3>

