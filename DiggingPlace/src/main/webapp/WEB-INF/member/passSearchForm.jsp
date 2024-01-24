<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap"
          rel="stylesheet">
    <title>Treasure</title>
    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script type="application/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.2.js"
            charset="utf-8"></script>
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
                    url: "passSearchMailSender",
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