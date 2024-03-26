<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../include/header.jsp"%>
<!-- Main content -->
<section class="content">
	<div class="box box-primary">
		<div class="box-header">
			<h3 class="box-title">Password Check</h3>
		</div>
		<div style="height:20px"></div>
		<form name="pwdCheck" method="post" action="">
			<div class="box-body">
				<div class="form-group">
					<input type="password" name="password" class="form-control" size="10" maxlength='10'>
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-primary">확인</button>
				</div>
			</div>
		</form>
	</div>
</section>
<%@include file="../include/footer.jsp"%>
