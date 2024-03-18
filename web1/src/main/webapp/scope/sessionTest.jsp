<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<%
    // 세션 저장
    // session.setAttribute("키",값);
    // 세션 조회
    // session.getAttribute("키");
    // 특정 세션 삭제
    // session.removeAttribute("키");
    // 전체 세션 삭제
    // session.invalidate();

    // 세션 값 확인
    String name = (String)session.getAttribute("name");
    String age = (String)session.getAttribute("age");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h2>세션 값 : <%=name%></h2>
    <h2>세션 값 : <%=age%></h2>
    <div>
        <button type="button">세션 값 저장</button>
        <button type="button">세션 값 삭제</button>
        <button type="button">세션 값 초기화</button>
    </div>
    <script src="/js/session.js"></script>
</body>
</html>