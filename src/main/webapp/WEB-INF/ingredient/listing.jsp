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
		<section class="container">
			<table
				class="table table-hover table-condensed table-striped table-bordered">
				<thead>
					<tr>
						<th>#</th>
						<th>Name</th>
						<th>Category</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ingredients}" var="ingredient">
						<tr>
							<td>${ingredient.id}</td>
							<td>${ingredient.name}</td>
							<td>${ingredient.category}</td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="3">Registered ingredients: ${ingredients.size()}</td>
					</tr>
					<tr>
						<td colspan="3">
							<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal-ingredient">
								Register Ingredient
							</button>
						</td>
					</tr>
				</tfoot>
			</table>
		</section>
		
		<jsp:include page="modal-ingredient.jsp" />
	
		<script type="text/javascript" src="${path}/static/js/jquery-2.1.3.min.js"></script>
		<script type="text/javascript" src="${path}/static/bootstrap/js/bootstrap.min.js"></script>
	</body>
</html>