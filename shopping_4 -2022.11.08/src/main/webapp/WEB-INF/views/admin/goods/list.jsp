<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/index">이전으로</a>

	<h1>상품목록</h1>
	<p>
	<form>
		<input type="text" placeholder="검색" name="keyword" value="${keyword}" />
		<input type="submit" value="검색" />
	</form>
	</p>
	<table border='1'>
		<thead>
			<tr>
				<td>상품코드</td>
				<td>상품명</td>
				<td>상품 가격</td>
				<td>상품 이미지</td>
				<td>상품 카테고리1</td>
				<td>상품 카테고리2</td>
				<td>상품수정/삭제</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="row" items="${data}">
				<tr>
					<td>${row.pd_num}</td>
					<td>${row.pd_name}</td>
					<td><fmt:formatNumber type="number" maxFractionDigits="3"
							value="${row.price}" /></td>
					<td>${row.img}</td>
					<td>${row.pd_category}</td>
					<td>${row.pd_category_big}</td>
					<td><a href="/admin/goods/detail?pd_num=${row.pd_num}">수정/삭제</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>