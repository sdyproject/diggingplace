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



</head>
<style>
#find-wrapper {
	width: 500px;
	height: 500px;
	margin: 0 auto;
	box-shadow:0px 0px 5px #BDBDBD;
	border-radius: 10px;
	margin-top: 50px;
	text-align: center;
	
}
input[type="file"]+label {
	background-color: #6E6E6E;
	width: 80px;
	border-radius: 10px;
	border: none;
	height: 25px;
	font-size: 10px;
	color: white;
	cursor: pointer;
	text-align: center;
	line-height: 21px;
	align-items: center;
	justify-content: center;
	margin-left: 15px;
}
#contents input{
	width: 300px;
	height: 45px;
	border-radius: 10px;
	border: 1px solid #BDBDBD;
	margin-bottom: 4px;
	margin-top: 4px;
	font-size: 13px;
	}
.content-inputbox{
	margin-bottom: 30px;
}

	
.content-inputbox span{
	margin-right: 250px;
	font-size: 12px;

}
.content-inputbox div{
	margin-bottom: 5px;
}

.btn-search{
background-color: #BDBDBD;
	width: 300px; border-radius: 10px; 
	 border: none;  height: 45px; 
	 font-size: 13px;
	color: white; margin-bottom: 5px;
	
}
.btn-search:hover {
background-color: white;
	color: #BDBDBD;
	border: 1px solid #BDBDBD;	
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

.movefindemail{
background-color: #BDBDBD;
	width: 300px; border-radius: 10px; 
	 border: none;  height: 45px; 
	 font-size: 13px;
	color: white; margin-bottom: 5px;
	
}
.movefindemail:hover {
background-color: white;
	color: #BDBDBD;
	border: 1px solid #BDBDBD;	
}
#content{
font-size: 15px;
margin-bottom: 100px;
margin-top: 50px;
}
.page-back{
background-color: #6e6e6e;
	width: 300px; border-radius: 10px; 
	 border: none;  height: 45px; 
	 font-size: 13px;
	color: white; margin-bottom: 5px;
}
.page-back:hover{
background-color: white;
	color: #BDBDBD;
	border: 1px solid #BDBDBD;	
}
	
	
</style>
<script>
        $(document).ready(function () {
            $("#result-form").hide();
           
            $(".btn-search").click(function () {
                let member_name = $("#member_name").val();
                let member_email = $("#member_email").val();
                let member_hp = $("#member_hp").val();
                $.ajax({
                    type: "get",
                    url: "findmemberpass",
                    data: {
                        "member_name": member_name,
                        "member_email": member_email,
                        "member_hp": member_hp
                    },
                    success: function (res) {
                    			
                    	$("find-wrapper").hide();
                        $("#search-form").hide();
                        $(".page-back").hide();
                        if (res.findpass == 1) {
                            $("#content").append("회원님의 비밀번호는<br> " + res.mpass + " 입니다.<br>");
                           
                        } else {
                            $("#content").append("가입된 회원이 존재하지 않습니다.");
                            $(".moveLogin").hide();
                            $(".movefindemail").hide();
                            $(".page-back").show();
                            $(".page-back").click(function() {
                            	location.reload();
                    		});
                        }
                        $("#result-form").show();
                    }
                });
            });
        });
        
       
    </script>
<body>
<div id="find-wrapper">
<br><br>
				<b>비밀번호 찾기</b> <br> <br>
			<div id="contents">
				<br>
				<form>
				<div class="content-inputbox"  id="search-form">
					<div>
						<span style="margin-right: 280px;"><b>이름</b></span> <br> <input type="text"
							  name="member_name" id="member_name" required="required">
					</div>
					<div>
						<span style="margin-right: 260px;"><b>이메일</b></span><br> <input type="email"
							name="member_email" id="member_email" required="required">
					</div>
					<div>
						<span style="margin-right: 270px;"><b>연락처</b></span><br> <input type="text" maxlength="11"
							 oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*?)\..*/g, '$1');"
							name="member_hp" id="member_hp" required="required">
					</div>
					
					<button type="button" class="btn-search" >찾기</button>			
					
				</div>
				
				
				</form>
			</div>
				 <form id="result-form">
        	<div id="content" align="center"></div>
        	
        		<button type="button" class="moveLogin" 
               onclick="location.href='/member/loginform'">로그인</button>
               <button type="button" class="page-back">이전</button>
               <br>
               <br>
                <button type="button" class="movefindemail" 
               onclick="location.href='/member/memberfindemail'" >이메일 찾기</button>
               
    </form>
			
				
</div>
</body>
</html>