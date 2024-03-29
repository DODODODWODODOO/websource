<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/include/header.jsp"%>
<!-- Main content -->
<section class="content">
	<div class="box box-primary">
		<div class="box-header">
			<h3 class="box-title">Read Board</h3>
		</div>
		<div style="height:20px"></div>
		<form action="" method="post" role="form">
			<div class="box-body">
				<div class="form-group row">
					<label for="name" class="col-sm-2 col-form-label">글쓴이</label>
					<div class="col-sm-10">
						<input type="text" name="name" readonly class="form-control" maxlength='10' value="${dto.name}">
					</div>
				</div>
				<div class="form-group  row">
					<label for="title" class="col-sm-2 col-form-label">제목</label>
					<div class="col-sm-10">
						<input type="text" name="title" readonly class="form-control"	maxlength='100' value="${dto.title}">
					</div>
				</div>
				<div class="form-group  row">
					<label for="content" class="col-sm-2 col-form-label">내용</label>
					<div class="col-sm-10">
						<textarea name='content' readonly class="form-control" rows='15' >${dto.content}</textarea>
					</div>
				</div>
				<div class="form-group  row">
					<label for="filename" class="col-sm-2 col-form-label">파일첨부</label>
					<div class="col-sm-10">
						<a href='<c:url value="/view/download.jsp?fileName=${dto.attach}" />'>${dto.attach}</a>
					</div>
				</div>
				<div style="height:10px"></div>
				<div class="box-footer text-center">
					<button type="button" class="btn btn-success" id="reply">답변</button>
					<button type="button" class="btn btn-warning" id="modify">수정</button>
					<button type="button" class="btn btn-danger" id="delete">삭제</button>
					<button type="button" class="btn btn-primary" id="list">목록보기</button>
				</div>
				<div style="height:20px"></div>
			</div>
		</form>
	</div>
</section>
<form action='<c:url value="/qList.do" />' method="get" id="actionForm">
	<input type="hidden" name="page" value="${searchDto.page}">
	<input type="hidden" name="amount" value="${searchDto.amount}">
	<input type="hidden" name="criteria" value="${searchDto.criteria}">
	<input type="hidden" name="keyword" value="${searchDto.keyword}">
</form>
<script>
	const bno = ${dto.bno};
</script>
<script src='<c:url value="/js/read.js" />'></script>
<%@include file="/include/footer.jsp"%>
