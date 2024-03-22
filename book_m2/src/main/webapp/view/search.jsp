<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/include/header.jsp" %>
<h3 class="border-bottom mb-3">도서검색</h3>
<form action='<c:url value="/search.do" />' method="post">
<div class="row mb-3">
  <div class="col">
    <select name="criteria" id="criteria" class="form-select">
      <option selected>검색 조건 선택</option>
      <option value="code">코드</option>
      <option value="writer">작가</option>
    </select>
  </div>
  <div class="col">
    <input type="text" class="form-control" placeholder="검색어" name="keyword" id="keyword">
  </div>
</div>
<div>
    <button type="submit" class="btn btn-success">검색</button>
    <a href='<c:url value="/list.do" />' class="btn btn-primary">목록</a>
</div>
</form>
<%@ include file="/include/section.jsp" %>
<script src='<c:url value="/js/search.js" />'></script>
<%@ include file="/include/footer.jsp" %>