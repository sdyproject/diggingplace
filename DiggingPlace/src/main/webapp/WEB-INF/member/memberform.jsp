<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<script src="https://code.jquery.com/jquery-3.6.3.js"></script>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Jua&family=Stylish&family=Sunflower&display=swap"
	rel="stylesheet">
<style type="text/css">
#mform {
	margin: 0 auto;
	border-radius: 10px;
	width: 400px;
	height: 880px;
	text-align: center;
	margin-top: 30px;
	box-shadow: 0px 0px 5px #BDBDBD;
}

#genderbtn {
	width: 200px;
	margin-left: 50px;
	font-size: 13px;
	height: 30px;
}

.form-inline {
	width: 400px;
	height: 830px;
	margin: 0 auto;
}

.passsuccess {
	margin-right:50px;
	font-size: 11px;
	color: #6E6E6E;
	
}

.idsuccess {
	margin-right:50px;
	font-size: 11px;
	color: #6E6E6E;
}
.nicknameok{
	margin-right:50px;
	font-size: 11px;
	color: #6E6E6E;

}

.form-inline b {
	font-size: 12px;
	margin-right: 170px;
	margin-top: 20px;
}

.form-inline input {
	width: 400px;
	height: 45px;
	border-radius: 10px;
	border-color: #BDBDBD;
	margin: 0 auto;
}

input[type=radio] {
	accent-color: #6E6E6E;
	width: 15px;
	vertical-align: -5px;
	height: 20px;
}

.gaipbtn {
	background-color: #BDBDBD;
	width: 200px;
	border-radius: 10px;
	border: 1px solid #BDBDBD;
	height: 40px;
	font-size: 13px;
	color: white;
	margin-bottom: 5px;
	box-shadow: 0px 0px 5px #BDBDBD; 
}
.gaipbtn:hover {
	background-color: white;
	color: #BDBDBD;
	border: 1px solid #BDBDBD;
}
#btnidcheck{
	background-color: #6E6E6E;
	border-radius: 10px;
	border:none;
	width: 30px;
	color: white;
	margin-bottom: 10px;
	height: 45px;
	font-size: 8px;
	float: left;
	margin-left: 3px;
	margin-bottom: 10px;
}
#btnidcheck:hover {
	background-color: white;
	color: #BDBDBD;
	border: 1px solid #BDBDBD;
}

/*placeholder 글자 크기조절  */
input::placeholder {
  font-size:13px;
}
</style>

</head>
<body>


	<div id="mform">
		<br> <b> 회원 가입</b>

		<form action="memberinsert" method="post" id="totalform">


			<br>

			<div class="form-inline">

				<b>이름</b> 
				<br>
				<input type="text" name="member_name"
					class="form-control" placeholder="이름을 입력해주세요." required="required"
					autofocus="autofocus" autocomplete='off' style="outline: none; box-shadow: none; border-color: #BDBDBD;">
				<br>
				<br>
				
				<b>닉네임</b> 
				<br> 
				<input type="text"
					name="member_nickname" id="member_nickname" class="form-control" autocomplete='off'
					placeholder="사용할 닉네임을 입력해주세요." required="required"  style="outline: none; box-shadow: none; border-color: #BDBDBD;">
					<br>
					<span class="nicknameok"></span>
				<br>
				
				<b>이메일</b> 
				<br> 
				<input type="email" id="member_email" name="member_email" placeholder="사용할 이메일을 입력해주세요." 
					class="form-control" required="required" autocomplete='off'style="outline: none; box-shadow: none; border-color: #BDBDBD; ">
				<br>
					<span class="idsuccess"></span> 
				<br>
				
				<b style="margin-left: 5px;">비밀번호</b> 
				<br> 
				<input
					type="password" class="form-control" name="member_pass" id="member_pass"
					placeholder="비밀번호를 입력해주세요." autocomplete='off' required="required"
					style="outline: none; box-shadow: none; border-color: #BDBDBD;">
				<br>
				<br>	
				<b style="margin-left: 40px;">비밀번호 확인</b> 
				<br> 
				<input type="password" class="form-control" id="member_pass2"
					placeholder="다시 입력해주세요." autocomplete='off' required="required"
					style="outline: none; box-shadow: none; border-color: #BDBDBD; ">
				<br> 
					<span class="passsuccess" ></span>
				<br> 
				<b>연락처</b>
				<br>
				<!--on input 숫자만 입력되게 -->
				<input type="text" maxlength="11"
					oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*?)\..*/g, '$1');"
					name="member_hp" class="form-control" autocomplete='off'
					placeholder="(-)없이 숫자만입력하세요." required="required"
					style="outline: none; box-shadow: none; border-color: #BDBDBD;">
				<br>
				<br> 
				<b>성별</b>
				<div id="genderbtn">
					<input type="radio" name="member_gender" value="male" 	><strong>남성</strong>
					<input type="radio" name="member_gender" value="female"><strong>여성</strong>
				</div>
				<br>
				<b style="margin-right:150px;">생년월일</b> <br> <input type="date" name="member_birth"
					class="form-control"
					style=" border-radius: 10px; margin-right:50px; box-shadow: none; outline: none; border-color: #BDBDBD; margin-bottom: 20px;"
					placeholder="Birthday" required="required" >
					<br>

				<button type="submit" class="gaipbtn">회원 가입</button>





			</div>




		</form>

	</div>
<script type="text/javascript">
$(document).ready(function() {
	  // 폼 제출 이벤트 핸들러 함수
	  $("#totalform").submit(function(event) {
	    // 이메일 중복 체크 결과가 0이 아니면 폼 제출 방지
	    if ($("span.idsuccess").data("count") !== 0) {
	      event.preventDefault();
	      alert("이메일을 다시 입력해주세요");
	    }else if ($("span.passsuccess").text() !== "비밀번호가 일치 합니다") {
	        event.preventDefault();
	        alert("비밀번호 일치 확인을 해주세요");
	      }else if($("span.nicknameok").data("nickcount")!==0){
	    	  event.preventDefault();
		      alert("닉네임을 다시 입력해주세요");	  
	      }else if(!validatePassword()){
	    	  event.preventDefault();
	    	    alert("비밀번호는 8자리 이상 16자리 이하이며, 영어 대소문자와 숫자, 특수문자가 모두 포함되어야 합니다.");
	      }else{
	    	  alert("회원 가입이 완료 되었습니다");
	      }
});
	  
	  // 이메일 중복 체크 함수
	  function memberemailcheck() {
		    var member_email = $("#member_email").val();
		    $.ajax({
		      type: "get",
		      dataType: "json",
		      url: "memberemailcheck",
		      data: {"member_email": member_email},
		      success: function(res) {
		        var message = res.count == 0 ? "사용 가능한 이메일 입니다." : "사용 불가능한 이메일 입니다.";
		        $("span.idsuccess").text(message).data("count", res.count);
		        if(member_email==""){
		        	$("span.idsuccess").text("이메일 중복 확인을 해주세요")
		        }
		      }
		    });
	  };
	  
	  //닉네임 중복 체크 함수
	  function membernicknamecheck() {
		  var member_nickname = $("#member_nickname").val();
		  $.ajax({
			  type:"get",
			  dataType:"json",
			  url:"membernicknamecheck",
			  data:{"member_nickname": member_nickname},
			  success:function(res){
				  var nickmessage=res.nickcount==0?"사용 가능한 닉네임 입니다.":"사용 불가능한 닉네임 입니다.";
				  $("span.nicknameok").text(nickmessage).data("nickcount",res.nickcount);
				  if(member_nickname==""){
					  $("span.nicknameok").text("닉네임 중복 확인을 해주세요")
				  }
			  }
			  
		  });
		
	};
	  
	  // 이메일 중복 체크 이벤트 핸들러 함수 등록
	  $("#member_email").on("keydown blur",memberemailcheck);
	    
	  // 이메일 입력란 클릭 시 이메일 중복 체크 결과 초기화
	  $("#member_email").click(function() {
	    $("span.idsuccess").text("").data("count", 0);
	  });
	  
	  // 닉네임 중복 체크 이벤트 핸들러 함수 등록
	  $("#member_nickname").on("keydown blur",membernicknamecheck);
	  
	  // 닉네임 입력란 클릭 시 닉네임 중복 체크 결과 조회
	  $("#member_nickname").click(function(){
		  $("span.nicknameok").text("").data("nickcount",0);
	  });
	   
	});
	
	//비밀번호 일치확인
	$("#member_pass2").blur(function(){
	    var pass1 = $("#member_pass").val();
	    var pass2 = $("#member_pass2").val();
	    if (pass1 == pass2) {
	        $("span.passsuccess").text("비밀번호가 일치 합니다");
	    } else{
	        $("span.passsuccess").text("비밀번호가 불일치 합니다");
	    }
	    
	    if(pass1==""||pass2==""){
	    	 $("span.passsuccess").text("비밀번호 일치 확인을 해주세요");
	    }
	});
	
	function validatePassword() {
		  var password = document.getElementById("member_pass").value;
		  var passwordPattern = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*]).{8,16}$/;
		  return passwordPattern.test(password);
	}
</script>

</body>
</html>