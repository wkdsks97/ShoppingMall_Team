<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
</head>

<body>
	<h1>상품 등록</h1>


<form method="post" >

		<select name="pd_category" onchange="categoryChange(this)">
		<option value>카테고리 선택</option>
		<option value="OUTER">OUTER</option>
		<option value="TOP">TOP</option>
		<option value="BOTTOM">BOTTOM</option>
		<option value="DRESS">DRESS</option>	
		</select>
		
		<select name="pd_category_big" id="pd_category_big">
	  <option>세부 카테고리</option>
	  
	  
		</select>
		<p>제품코드: <input type="text" name="pd_num" /></p>
		<p>상 품 명: <input type="text" name="pd_name" /></p>
		<p>가   격 : <input type="text" name="price" /></p>
		<p>상품이미지: <input type="file" name="img" /></p>
		
		

		<p><input type="submit" value="상품등록" />
	</form>

	<script>
		function categoryChange(e) {
			var target = document.getElementById("pd_category_big");

			const OUTER = [ "CARDIGAN", "JUMPER", "COAT", "JACKET" ];
			const TOP = [ "KNIT", "TEE&SHIRT", "MTM&HOOD", "BLOUSE" ];
			const BOTTOM = [ "STRAIGHT", "WIDE", "MTM&SLACKS" ];
			const DRESS = [ "SKIRT", "DRESS" ];
			const ACC = [ "SKIRT", "DRESS" ];

			if (e.value == "OUTER") {
				var d = OUTER;
			} else if (e.value == "TOP") {
				var d = TOP;
			} else if (e.value == "BOTTOM") {
				var d = BOTTOM;
			} else if (e.value == "DRESS") {
				var d = DRESS;
			} else if (e.value == "ACC") {
				var d = ACC;
			}

			target.options.length = 0;

			for (property in d) {
				let opt = document.createElement("option");
				opt.value = d[property];
				opt.innerHTML = d[property];
				target.appendChild(opt);
			}
		}
	</script>
</body>
</html>