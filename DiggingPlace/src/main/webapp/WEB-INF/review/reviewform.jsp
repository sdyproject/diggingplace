<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
<!-- Plugin -->
<link rel="stylesheet"
	href="https://rawgit.com/enyo/dropzone/master/dist/dropzone.css" />
<script src="https://rawgit.com/enyo/dropzone/master/dist/dropzone.js"></script>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans&family=Noto+Sans+KR&display=swap"
	rel="stylesheet">
<style type="text/css">
#review-wrapper {
	width: 500px;
	height: 450px;
	margin: 0 auto;
	box-shadow: 0px 0px 5px #BDBDBD;
	border-radius: 10px;
	margin-top: 50px;
	text-align: center;
}
.review-content{
width:450px;
margin: 0 auto;
margin-bottom: 3px;
}
.reviewwrite {
	background-color: #BDBDBD;
	width: 350px;
	border-radius: 10px;
	border: none;
	height: 45px;
	font-size: 13px;
	color: white;
	margin-bottom: 5px;
	box-shadow: 0px 0px 5px #BDBDBD; 
}


.reviewwrite:hover {
	background-color: white;
	color: #BDBDBD;
	border: 1px solid #BDBDBD;
}

#reviewinsert fieldset {
	display: inline-block;
	direction: rtl;
	border: 0;
	margin-bottom: 20px; 
}

#reviewinsert fieldset legend {
	text-align: right;
}

#reviewinsert input[type=radio] {
	display: none;
}

#reviewinsert label {
	font-size: 3em;
	color: transparent;
	text-shadow: 0 0 0 #f0f0f0;
}

#reviewinsert label {
	font-size: 15px;
}

#reviewinsert label:hover {
	text-shadow: 0 0 0 rgba(109, 99, 71, 0.5);
}

#reviewinsert label:hover ~ label {
	text-shadow: 0 0 0 rgba(109, 99, 71, 0.5);
}

#reviewinsert input[type=radio]:checked ~ label {
	text-shadow: 0 0 0 rgba(109, 99, 71, 0.5);
}

hr {
	width: 70%;
	border: 1.8px solid #f5f5f5;
}


</style>


</head>
<body>
<br>
	<div id="review-wrapper">
	<br>
		<b>후기</b> <br><br>
		<div>


			<form id="reviewinsert" action="reviewinsert" method="post" onsubmit="backpage()">
				
				<input type="hidden" name="exhibition_num" value="${exhibition_num}">
				<input type="hidden" name="member_num" value="${member_num}">
				<fieldset>
					<span class="text-bold"><b style="font-size: 13px;">별점을 선택해주세요</b></span><br> 
					<input type="radio"
						name="review_score" value="5" id="rate1" class="form-control">
					<label for="rate1">★</label> <input type="radio"
						name="review_score" value="4" id="rate2" class="form-control"><label
						for="rate2">★</label> <input type="radio" name="review_score"
						value="3" id="rate3" class="form-control"><label
						for="rate3">★</label> <input type="radio" name="review_score"
						value="2" id="rate4" class="form-control"><label
						for="rate4">★</label> <input type="radio" name="review_score"
						value="1" id="rate5" class="form-control"><label
						for="rate5">★</label>
						
				</fieldset>
				
				<hr>
				
				
				<div class="review-content">
					<b style="font-size: 14px;">후기 내용</b><br><br>
					<textarea type="text" class="form-control" 
						name="review_content" required="required" placeholder="후기를 통해 경험을 공유하세요!" maxlength="100"
						style="width: 350px; height: 130px; border-radius: 10px; 
						border: 1px solid #BDBDBD;  margin-top: 4px; font-size: 13px; margin: 0 auto; 
						outline: none; box-shadow: none; resize: none;" ></textarea>
				</div>

				<button type="submit" class="reviewwrite" id="reviewwrite" 
					>작성</button>
				
			</form>
				


		</div>
	</div>
</body>
<script type="text/javascript">
	
	
	function backpage() {
		 alert("작성 완료되었습니다.");
		 
	}
	 
	 
</script>
</html>