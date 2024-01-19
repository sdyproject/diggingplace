<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<script src="https://code.jquery.com/jquery-3.6.3.js"></script>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Jua&family=Stylish&family=Sunflower&display=swap" rel="stylesheet">
<style type="text/css">
.login-wrapper{

margin: 0 auto;
border-radius: 10px;
width: 450px; height: 400px; 
text-align: center;
box-shadow:0px 0px 5px #BDBDBD;
margin-top: 30px;
}
.gaip{
background-color: #6E6E6E;
width: 300px; border-radius: 10px; 
 border: none;  height: 45px; font-size: 15px;
color: white;  margin-top: 5px;
margin-bottom: 3px;
}
.gaip:hover{
background-color: white;
	color: #BDBDBD;
	border: 1px solid #BDBDBD;
}

.mlogin{
background-color: #BDBDBD;
width: 300px; border-radius: 10px; 
 border: none;  height: 45px; font-size: 15px;
color: white; margin-bottom: 5px;
box-shadow: 0px 0px 5px #BDBDBD; 
}
.mlogin:hover{
background-color: white;
	color: #BDBDBD;
	border: 1px solid #BDBDBD;
}
input[type=checkbox] {
	accent-color: #6E6E6E;
	
}
.v-line {
	border-left: 1px solid #BDBDBD;
	height: 5px;
	margin-left: 3px;
	margin-right: 7px;
	
}
.findandgaip{
/* margin-left: 100px; */
margin: 0 auto;
width: 200px;
margin-top: 5px;
}

.findandgaip b:hover{
color: #BDBDBD;
}
.findandgaip b{
color: #5d6361;
font-size: 10px;
}






</style>
<script>
$(document).ready(function() {
	$(".mlogin").click(function() {
		let member_email = $("#member_email").val();
		let member_pass = $("#member_pass").val();
		$.ajax({
			type : "get",
			url : "loginError",
			data : {
				"member_email" : member_email,
				"member_pass" : member_pass
			},
			success : function(res) {
				if (res == 0) {
					alert("이메일 혹은 비밀번호를 확인해주세요");
				}
					
				
			}
		});
	});
});

</script>

</head>
<body>


<div class="login-wrapper">
<br>
<b >로그인</b> <br><br>
<form action="loginprocess" method="post"  >
	
		
	<input type="email" name="member_email" class="form-control"  placeholder="이메일을 입력해주세요." id="member_email" 
	required="required" autofocus="autofocus" style="width: 300px; margin-bottom: 5px; border-radius: 10px; box-shadow: none; outline: none; border-color: #BDBDBD; margin: 0 auto;"
				value="${sessionScope.cbsave==null?'':sessionScope.loginemail }">


<input type="password" name="member_pass" class="form-control" autocomplete='off' placeholder="바밀번호를 입력해주세요." id="member_pass"
	required="required"  style="width: 300px;  margin-bottom: 5px; border-radius: 10px;  box-shadow: none; outline: none; border-color: #BDBDBD; margin: 0 auto;">

			<input type="checkbox" name="cbsave" class="idcheck"
			${sessionScope.cbsave==null?"":"checked"} style="vertical-align: -3px;"><b style="font-size: 10px; margin-right: 230px; "> 아이디저장</b>
			<br><br>
<button type="submit" class="mlogin">로그인</button> <br>

<div class="findandgaip">
	<a href="/member/memberform" style=" color: black;	text-decoration: none;"><b>회원 가입</b></a>
	<span class='v-line'></span>
	<a href="/member/memberfindemail" style=" color: black;	text-decoration: none;"><b>이메일 찾기</b></a> 
	<span class='v-line'></span>
	<a href="/member/memberfindpass" style=" color: black;	text-decoration: none;"><b >비밀번호 찾기</b></a> 
</div>


<hr style="width: 310px;  border-top: 1px solid #bbb; border-bottom: 1px solid #fff;"> 


 
<a class="kakaologin" href=" https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=b3c89b327a8911aa45ecf2c1e3649af7&redirect_uri=http://43.200.224.241/kakao/login"> 
<img src="../image/kakao_login_medium_wide.png"></a>
</form>



 
 

</div>


</body>
</html>