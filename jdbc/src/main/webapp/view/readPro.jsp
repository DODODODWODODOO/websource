<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import="dao.TodoDao"%>
<%@ page import="dto.TodoDto"%>
<% 
    // 한글처리
    request.setCharacterEncoding("utf-8");

    // 제목 클릭 시 no 가져오기
    String no = request.getParameter("no");
    

    // DB작업
    TodoDao dao = new TodoDao();
    TodoDto todo = dao.getRow(no);

    // todo 를 read.jsp 에 보여주기
    request.setAttribute("todo",todo);

    // 화면 이동(read)
    pageContext.forward("read.jsp");








%>
