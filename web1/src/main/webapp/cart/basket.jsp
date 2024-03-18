<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" 
import="java.util.ArrayList"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<% 
    // 장바구니 가져오기
    // String products =(String)session.getAttribute("product");

 ArrayList<String> products = (ArrayList<String>) session.getAttribute("products");
%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h3>장바구니 목록</h3>
    <ul>
    <%   for(String product:products){   %>
        <li><%=product%></li>
        <% } %>
    </ul>
    <div>
        <a href="/cart/cart.html">상품 선택</a>
    </div>
    <div>
        <a href="/cart/delete.jsp">장바구니 비우기</a>
    </div>
</body>
</html>