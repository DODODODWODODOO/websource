<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<%
   // info2.jsp 에 부여된 request 를 forward.jsp 에 넘겨주는 것
   // info2.jsp에서 할 수 있는 작업들을 forward.jsp에서 할 수 있게 됨
    pageContext.forward("forward.jsp");
%>