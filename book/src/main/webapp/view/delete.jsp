<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/include/header.jsp" %>
<h3 class="border-bottom mb-3">도서삭제</h3>
<form action='<c:url value="/delete" />' method="post">
<div class="mb-3">
  <label for="code" class="form-label">code</label>
  <input type="text" class="form-control" id="code"  name="code">
  <small class="text-info">도서코드를 4자리로 입력해 주세요</small>
</div>
<div class="mb-3">
<button type="submit"  class="btn btn-success">삭제</button>
    <a href='<c:url value="/list" />' class="btn btn-primary">목록</a>
</div>
</form>
<%@ include file="/include/section.jsp" %>
<script src='<c:url value="/js/delete.js" />'></script>
<%@ include file="/include/footer.jsp" %>