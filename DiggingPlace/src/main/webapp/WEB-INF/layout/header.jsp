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
<!-- Plugin -->
<link rel="stylesheet" href="https://rawgit.com/enyo/dropzone/master/dist/dropzone.css" />
<script src="https://rawgit.com/enyo/dropzone/master/dist/dropzone.js"></script>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans&family=Noto+Sans+KR&display=swap" rel="stylesheet">
<style type="text/css">
.logo{

float: left;
width: 120px;
height: 200px;
margin-top: 5px;

}
.menu{
  float: right;
  width: 90px;
  
 
}


.menubtn{
border:none;
background-color: white;
  width :90px;
  height: 80px;
  cursor : pointer;
  margin: 0 auto;
  margin-top: 5px;
  
}
.menucontent{
  display : none;
  position : absolute;
  z-index : 1; /*다른 요소들보다 앞에 배치*/
  font-weight: 400;
  background-color: #f9f9f9;
  width: 90px;
  text-align: center;
}

.menucontent a{
  display : block;
  text-decoration : none;
  color : rgb(37, 37, 37);
  font-size: 10px;
  padding : 12px 20px;
}

.menucontent a:hover{
  background-color : #ececec
}

.menu:hover .menucontent {
  display: block;
}
.menubtn img{
filter: opacity(0.2) drop-shadow(0 0 0 #BDBDBD); 
}


</style>


</head>

<body>
	<c:set var="root" value="<%=request.getContextPath()%>" />

<div class="logo">
<a href="/">
 <img alt="logo"  src="../../image/logoimage.png" style="width:110px; height: 80px; margin-top: 10px;">
 </a>
 </div>
 
 <div class="menu">
<button class="menubtn" >
<img alt="" src="../../image/menuimage.png" style="width: 30px; ">
</button>
<div class="menucontent">
 		<c:set var="loginok" value="${sessionScope.loginok}"></c:set>
 		<c:if test="${empty loginok}"> 
		<a href="/member/loginform">로그인</a>
	  	</c:if>
	  
	  <c:if test="${not empty loginok}"> 
	 		 
		<a href="/login/logoutprocess">로그아웃</a>
	  </c:if>
	  
        <a href="/member/memberform">회원가입</a>
        
        <c:if test="${not empty loginok}">
        <a href="/myinfo">My</a>
        </c:if>
        <%-- <c:if test="${empty loginok}">	
		<a id="noLoginMy">My</a>
		</c:if> --%>
       	<hr style="border: 1.5px solid #BDBDBD;">
        <a href="/exhibition/exhibitionlist">전시회</a>
        <a href="/popup/popuplist" >팝업스토어</a>
      </div>
      
      
      
      
      
 
 
 
 </div>

</body>

</html>