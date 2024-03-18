<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>

<%-- <% %> : 자바코드 작성
<%= %> : html 코드랑 섞일 때 사용
<%! %> : 자바코드 작성 => 변수 선언, 메소드 선언(잘 사용하지는 않음) --%>


<% 
    // 쿠키 가져오기
    Cookie[] cookies = request.getCookies();

    String name = "";
    String value = "";
        for(Cookie c:cookies){
            if(c.getName().equals("name")) {
                name = c.getName();
                value = c.getValue();

            }
        }
%>
<h4>쿠키 이름 : <%=name%></h4>
<h4>쿠키 값 : <%=value%></h4>
