<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<%-- jsp 주석 

    자바코드는 <% %> 안에 작성한다(위치는 상관없음)
    자바코드 화면 출력 - <%= %>

--%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <% 
    // for(int i=1;i<11;i++){
    //     out.print(i);
    // }

    // JSP 내장객체
    // 1) HttpServletRequest - request 객체명 고정(변경불가)
    // 2) HttpServletResponse - response 객체명 고정(변경불가)
    // 3) JSPWriter - out

    request.setCharacterEncoding("utf-8");
    
    String id = request.getParameter("id");
    String name = request.getParameter("name");
    String[] dogs = request.getParameterValues("dog");
    %>
    <ul>
        <li>id : <%=id%></li>
        <li>name : <%=name%></li>
        <li>name : <% out.print(name);%></li>
        <%
            for (String dog : dogs) {
                out.print("<li>dog : " + dog + "</li>");
            }
        %>
    </ul>
</body>
</html>