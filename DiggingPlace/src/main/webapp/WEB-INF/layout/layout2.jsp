<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<script src="https://code.jquery.com/jquery-3.6.3.js"></script>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans&family=Noto+Sans+KR&display=swap" rel="stylesheet">
<style type="text/css">
div.layout2 {
	font-size: 1.3em;
	font-family: 'Noto Sans KR';
	width: 100%;
	height: 100%;
}

	div.layou2t div.header {
	
	position: absolute;
      width:100%;
      height: 15%;
	
}

div.layout2 div.main {
	
	 position: absolute;
      top: 100px;
      width:100%;
      height: 800px;
		
		
	
}

/*input num 화살표 버튼 없애기   */
input::-webkit-inner-spin-button {
  appearance: none;
  -moz-appearance: none;
  -webkit-appearance: none;
}

</style>

</head>
<body>
<div class="layout2">
	<div class="main">
		<tiles:insertAttribute name="main"/>
	</div>
	<div class="header">
		<tiles:insertAttribute name="header"/>
	</div>
	
	
</div>
</body>
</html>