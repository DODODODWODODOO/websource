<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import="dao.TodoDao"%>
<%@ page import="dto.TodoDto"%>
<% 
    // 한글처리
    request.setCharacterEncoding("utf-8");

    // value 가 없는 경우 checkbox, radio 의 경우에는 on 값을 가지고 오게 됨
    String completed = request.getParameter("completed");
    String description = request.getParameter("description");
    String no = request.getParameter("no");
    
    

    // DB작업
    TodoDao dao = new TodoDao();

    TodoDto dto = new TodoDto();
    dto.setCompleted(Boolean.parseBoolean(completed));
    dto.setDescription(description);
    dto.setNo(Integer.parseInt(no));

    int result = dao.update(dto);

    // 화면 이동(read)
    response.sendRedirect("list.jsp");








%>
