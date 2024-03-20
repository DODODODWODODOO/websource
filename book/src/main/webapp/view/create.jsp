<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/include/header.jsp" %>
<h3 class="border-bottom mb-3">도서추가</h3>
<form action='<c:url value="/create" />' method="post">
<div class="mb-3">
  <label for="code" class="form-label">code</label>
  <input type="text" class="form-control" id="code"  name="code">
</div>
<div class="mb-3">
  <label for="title" class="form-label">title</label>
  <input type="text" class="form-control" id="title"  name="title">
</div>
<div class="mb-3">
  <label for="writer" class="form-label">writer</label>
  <input type="text" class="form-control" id="writer"  name="writer">
</div>
<div class="mb-3">
  <label for="price" class="form-label">price</label>
  <input type="text" class="form-control" id="price"  name="price">
</div>
<div class="mb-3">
  <label for="decription" class="form-label">decription</label>
  <textarea class="form-control" id="decription" rows="3" name="decription" ></textarea>
</div>
<div class="mb-3">
<button type="submit"  class="btn btn-success">추가</button>
    <a href='<c:url value="/list" />' class="btn btn-primary">목록</a>
</div>
</form>
<%@ include file="/include/section.jsp" %>
<script src='<c:url value="/js/create.js" />'></script>
<%@ include file="/include/footer.jsp" %>