<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
		<title>${title}</title>
		<c:set var="path" value="${pageContext.request.contextPath}"
			scope="request" />
		<style type="text/css">
			@import url("${path}/static/bootstrap/css/bootstrap.min.css");
			@import url("${path}/static/bootstrap/css/bootstrap-theme.min.css");
		</style>
	</head>
	<body>
		<c:if test="${not empty errorMessage}">
			<div class="container">
				<div class="alert alert-danger">${errorMessage}</div>
			</div>
		</c:if>
		<c:if test="${not empty errorInfo}">
			<div class="container">
				<div class="alert alert-info">${errorInfo}</div>
			</div>
		</c:if>
		<section class="container" id="section-ingredients">
			<jsp:include page="table-ingredients.jsp"/>
		</section>
		
		<jsp:include page="modal-ingredient.jsp" />
	
		<script type="text/javascript" src="${path}/static/js/jquery-2.1.3.min.js"></script>
		<script type="text/javascript" src="${path}/static/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="${path}/static/js/ingredients.js"></script>
	</body>
</html>