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
  <style>
        

.search-wrapper {
width: 500px;
height: 400px;
margin: 0 auto;
box-shadow:0px 0px 5px #BDBDBD;
border-radius: 10px;
margin-top: 50px;
text-align: center;
}

.btn-search{
background-color: #BDBDBD;
width: 300px; border-radius: 10px; 
border: none;  height: 45px; 
font-size: 13px;
color: white; margin-bottom: 5px;
margin-top:5%;	
}
.btn-search:hover {
background-color: white;
	color: #BDBDBD;
	border: 1px solid #BDBDBD;	
}
#note {
opacity: 0.7;
 margin-bottom: 30px;
 font-size: 13px;
}

#content {
 font-size: 15px;
 margin: 100px 0;
 line-height: 30px;
}
        
.moveLogin{
background-color: #6e6e6e;
width: 300px; border-radius: 10px; 
border: none;  height: 45px; 
font-size: 13px;
color: white; margin-bottom: 5px;
	
}
.moveLogin:hover {
background-color: white;
	color: #BDBDBD;
	border: 1px solid #BDBDBD;	
}
.moveform{
background-color: #6e6e6e;
width: 300px; border-radius: 10px; 
border: none;  height: 45px; 
font-size: 13px;
color: white; margin-bottom: 5px;
	
}
.moveform:hover {
background-color: white;
	color: #BDBDBD;
	border: 1px solid #BDBDBD;	
}

#email{
width: 300px;
	height: 45px;
	border-radius: 10px;
	border: 1px solid #BDBDBD;
	margin-bottom: 4px;
	margin-top: 4px;
	font-size: 13px;
	box-shadow: none;
	 outline: none;
}
#search-form b{

margin-right: 250px;
}

    </style>
    <script>
        $(document).ready(function () {
            $("#result-form").hide();
            $(".btn-search").click(function () {
                let email = $("#email").val();
                $.ajax({
                    type: "get",
                    url: "membersearchpass",
                    data: {"email":email},
                    success: function(res) {
                        $("#search-form").hide();
                        $("#result-form").show();
                        $(".moveform").hide();
                        if (res===1) {
                        	
                            $("#content").innerHTML("입력하신 이메일로 임시 비밀번호를 전송하였습니다.");
                            
                        } else {
                            $("#content").append("가입된 이메일이 존재하지 않습니다.");
                            $("#note").hide();
                            $(".moveLogin").hide();
                            $(".moveform").show();
                        }
                       
                    }
                });
            });
        });
    </script>
</head>
<body>
<div class="search-wrapper">
    <br><br>
				<b>비밀번호 찾기</b> <br> <br>
   
    <div id="note" align="center">가입 시 등록하신 이메일을 입력하시면,<br>이메일로 임시 비밀번호를 전송해 드립니다.</div>
    
    
    <form id="search-form">
        <b>이메일</b><br>
        <input type="text" name="email" id="email" required="required" autofocus="autofocus" 
        placeholder="이메일을 입력해주세요." autocomplete='off'>
		<br>
        <button type="button" value="임시 비밀번호 전송" class="btn-search submitBtn">임시 비밀번호 전송</button>
        
    </form>
    
    <form id="result-form">
        <div id="content" align="center"></div>
        
        
        <button type="button" class="moveLogin" value="로그인"   onclick="location.href='loginform'" >로그인</button> 
        <button type="button" class="moveform" value="회원가입"   onclick="location.href='memberform'" >회원가입</button> 
             	  
    </form>
</div>
</body>
</html>
