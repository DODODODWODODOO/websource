<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/include/header.jsp" %>
<link rel="stylesheet" href='<c:url value="/css/sign-in.css" />'>
<div class="d-flex align-items-center py-4 mt-5">
    <main class="form-signin w-100 m-auto">
        <form action='<c:url value="/leave.do" />' method="post">
    <h1 class="h3 mb-3 fw-normal">회원탈퇴</h1>

    <div class="form-floating">
      <input type="text" class="form-control" id="userid" placeholder="아이디" name="userid" value="${loginDto.userid}" readonly>
      <label for="floatingInput">아이디</label>
    </div>
    <div class="form-floating">
      <input type="password" class="form-control" id="password" placeholder="비밀번호" name="password">
      <label for="password">비밀번호</label>
    </div>

   
    <button class="btn btn-danger w-100 py-2" type="submit">회원탈퇴</button>
    <p class="mt-5 mb-3 text-body-secondary">&copy; 2017–2024</p>
        </form>
    </main>
</div>
<%@ include file="/include/section.jsp" %>
<%@ include file="/include/footer.jsp" %>
