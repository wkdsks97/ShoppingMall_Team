<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>



<style>
body {
	font-family: '맑은 고딕', verdana;
	padding: 0;
	margin: 0;
}

ul {
	padding: 0;
	margin: 0;
	list-style: none;
}

div#root {
	width: 90%;
	margin: 0 auto;
}

header#header {
	font-size: 30px;
	padding: 20px 0;
}

header#header h1 a {
	color: #000;
	font-weight: bold;
}

nav#nav {
	padding: 10px;
	text-align: right;
}

nav#nav ul li {
	display: inline-block;
	margin-left: 10px;
}

section#container {
	padding: 20px 0;
	border-top: 2px solid #eee;
	border-bottom: 2px solid #eee;
}

section#container::after {
	content: "";
	display: block;
	clear: both;
}

aside {
	float: left;
	width: 200px;
}

div#container_box {
	float: right;
	width: calc(100% - 200px - 20px);
}

aside ul li {
	text-align: center;
	margin-bottom: 10px;
}

aside ul li a {
	display: block;
	width: 100%;
	padding: 10px 0;
}

aside ul li a:hover {
	background: #eee;
}

footer#footer {
	background: #f9f9f9;
	padding: 20px;
}

footer#footer ul li {
	display: inline-block;
	margin-right: 10px;
}
</style>


</head>



<body>
	<div id="root">
		<header id="header">
			<div id="header_box">
				<%@ include file="../include/header.jsp"%>
			</div>
		</header>

		<nav id="nav">
			<div id="nav_box">
				<%@ include file="../include/nav.jsp"%>
			</div>
		</nav>

		<section id="container">
			<aside>
				<%@ include file="../include/aside.jsp"%>
			</aside>

			<form>
				<input type="text" placeholder="검색" name="keyword"
					value="${keyword}" /> <input type="submit" value="검색" />
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


		</section>

		<footer id="footer">
			<div id="footer_box">
				<%@ include file="../include/footer.jsp"%>
			</div>
		</footer>

	</div>
</body>
</html>
