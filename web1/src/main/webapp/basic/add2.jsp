<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<%@ page import="member.MemberDTO" %>
<%
    // 세션 scope 담긴 속성 가져오기
    MemberDTO loginDto = (MemberDTO)session.getAttribute("loginDto");
%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
      crossorigin="anonymous"
    />
</head>
<body>
    <div class="container mt-5">
    
      <div>
        name : <%=loginDto.getName() %>
        <button type="button" id="logout">로그아웃</button>
      </div>
     <form action="result2.jsp" method="post">
        <div class="row mb-3 g-3">
        <div class="col">
         <input type="text" class="form-control" id="num1" placeholder="숫자1" name="num1" />
        </div>
        <div class="col">
          <select name="op" id="op" class="form-select">
           <option selected>사칙연산 선택</option>
           <option value="+">+</option>
           <option value="-">-</option>
           <option value="*">*</option>
           <option value="/">/</option>
          </select>
        </div>
        <div class="col">
          <input type="text" class="form-control" id="num2" placeholder="숫자2" name="num2" />
        </div>
        </div>
        <div>
          <button type="submit" class="btn btn-success">사칙연산</button>
        </div>
     </form>
    </div>
    <script src="/js/logout.js"></script>
</body>
</html>