<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<table
	class="table table-hover table-condensed table-striped table-bordered">
	<thead>
		<tr>
			<th style="width: 10%">#</th>
			<th style="width: 50%">Name</th>
			<th style="width: 20%">Category</th>
			<th style="width: 10%">Edit</th>
			<th style="width: 10%">Delete</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${ingredients}" var="ingredient">
			<tr data-id="${ingredient.id}">
				<td>${ingredient.id}</td>
				<td>${ingredient.name}</td>
				<td>${ingredient.category}</td>
				<td><button type="button" class="btn btn-warning btn-edit">Edit</button></td>
				<td><button type="button" class="btn btn-danger btn-delete">Delete</button></td>
			</tr>
		</c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="5">Registered ingredients: <span id="quantity-ingredients">${ingredients.size()}</span></td>
		</tr>
		<tr>
			<td colspan="5">
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#modal-ingredient">Register Ingredient</button>
			</td>
		</tr>
	</tfoot>
</table>