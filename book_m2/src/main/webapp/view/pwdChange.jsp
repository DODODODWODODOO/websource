<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/include/header.jsp" %>
<div class="d-flex align-items-center justify-content-center h-100">
    <form action='<c:url value="/change.do" />' method="post">
        <div class="card" style="width:40rem;">
            <div class="card-header">
                <h4>비밀번호 변경</h4>
            </div>
            <div class="card-body">
                <div class="form-group row justify-content-center mb-3">
                    <div class="col-sm-10">
                        <input type="password" name="password" id="password" class="form-control" placeholder="현재 비밀번호">
                    </div>
                </div>
                <div class="form-group row justify-content-center mb-3">
                    <div class="col-sm-10">
                        <input type="password" name="new-password" id="new-password" class="form-control" placeholder="변경 비밀번호">
                    </div>
                </div>
                <div class="form-group row justify-content-center mb-3">
                    <div class="col-sm-10">
                        <input type="password" name="confirm-password" id="confirm-password" class="form-control" placeholder="새 비밀번호 확인">
                    </div>
                </div>
                <div class="form-group text-center">
                    <button type="submit" class="btn btn-primary">수정</button>
                </div>
            </div>
        </div>
    </form>
</div>
<%@ include file="/include/section.jsp" %>
<%@ include file="/include/footer.jsp" %>
