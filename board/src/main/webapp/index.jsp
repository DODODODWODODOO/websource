<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>답변형게시판</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<link rel="stylesheet" href='<c:url value="/css/mystyle.css" />'>
</head>
<body>
<div class="jumbotron jumbotron-fluid">
	<div class="container">
	  <h1 class="display-4">Anonymous Bulletin Board</h1>
	  <p class="lead" style="font-family: 'Nanum Pen Script', cursive;font-size: 40px">계층형 게시판</p>
	  <hr class="my-4">  
	  <a class="btn btn-primary btn-lg" href='<c:url value="/qList.do" />' role="button">Start Board</a>
	</div>
</div>
</body>
</html>

