<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="../include/header.jsp" %>
<h1 class="mt-5">Todo List</h1>
<table class="table">
  <thead>
    <tr>
      <th scope="col">번호</th>
      <th scope="col">제목</th>
      <th scope="col">작성일</th>
      <th scope="col">완료여부</th>
    </tr>
  </thead>
  <tbody>
  <%--jsp 에서 java 코드를 태그처럼 사용할수 있게 해줌 --%>

  <c:forEach var="dto" items="${list}">
    <tr>
      <th scope="row">${dto.no}</th>
      <td><a href='<c:url value="/read?no=${dto.no}" />' class="text-decoration-none text-reset">${dto.title}</a></td>
      <td>${dto.createdAt}</td>
      <td>
        <input type="checkbox" name="completed" id="completed" class="form-check-input" name="completed" value="true" <c:out value="${dto.completed?'checked':''}" />>
      </td>
    </tr>
    </c:forEach>
  </tbody>
</table>
<%@ include file="../include/footer.jsp" %>