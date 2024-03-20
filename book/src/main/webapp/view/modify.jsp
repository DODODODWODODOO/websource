<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/include/header.jsp" %>
<h3 class="border-bottom mb-3">도서수정</h3>
<form action='<c:url value="/modify" />' method="post">
<div class="row mb-3">
  <div class="col">
    <input type="text" class="form-control" placeholder="코드" name="code">
  </div>
  <div class="col">
    <input type="text" class="form-control" placeholder="가격" name="price">
  </div>
</div>
<div>
    <button type="submit" class="btn btn-success">수정</button>
    <a href='<c:url value="/list" />' class="btn btn-primary">목록</a>
</div>
</form>
<%@ include file="/include/section.jsp" %>
<%@ include file="/include/footer.jsp" %>