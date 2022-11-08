<%@ page pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세보기</title>
</head>
<body>
	<h1>상품 상세</h1>
	<p>상품명: ${data.pd_name}</p>
	<p>상품 가격:<fmt:formatNumber type="number" maxFractionDigits="3" value="${data.price}" /></p> 
	<p>상품 이미지: ${data.img}</p>
	<p>상품 카테고리1: ${data.pd_category}</p>
	<p>상품 카테고리2: ${data.pd_category_big}</p>


  <p>
   <a href="/admin/goods/update?pd_num=${pd_num}">수정</a>
  </p>
	
  <form method="POST" action="/admin/goods/delete">
   <input type="hidden" name="pd_num" value="${pd_num}" />
   <input type="submit" value="삭제" />
  </form>
  <p>
   <a href="/admin/goods/list">목록으로</a>
  </p>
 </body>
</html>