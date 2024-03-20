<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import="dao.TodoDao"%>
<%@ page import="dto.TodoDto"%>
<% 
    // 한글처리
    request.setCharacterEncoding("utf-8");

    // no 가져오기
    String no = request.getParameter("no");
    
    

    // DB작업
    TodoDao dao = new TodoDao();
    int result = dao.delete(no);

    // 화면 이동(read)
    response.sendRedirect("list.jsp");








%>
