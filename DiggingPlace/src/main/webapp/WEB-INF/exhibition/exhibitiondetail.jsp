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
	 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
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
.exhibition_info {
	height: 1700px;
	text-align: center;
	width: 100%;
	margin-top: 70px;
}

.exhibition_detailimg {
	height: 380px;
	width: 550px;
	margin: 0 auto;
}

.exhibition_data {
	width: 60%;
	height: 350px;
	margin: 0 auto;
	text-align: left;
}

.exhibition_data ul li {
	list-style-type: none;
	font-size: 15px;
	line-height: 30px;
}

.exhibition_detailcontent {
	height: 200px;
	width: 40%;
	margin: 0 auto;
	font-size: 12px;
	text-align: left;
	margin-top: 20px;
}

ul, li {
	margin: 0;
	padding: 0;
}

.exhibition_info hr {
	width: 40%;
	border: 1.8px solid #f5f5f5;
}

.Likecount {
	color: #6E6E6E;
	margin-right: 10px;
	font-size: 1.5em;
}
/*좋아요 css  */
.like_exhibition {
	float: right;
	width: 30px;
	text-align: right;
	font-size: 10px;
	height: 50px;
}

.like_exhibition a {
	text-decoration: none;
	color: inherit;
	cursor: pointer;
	float: right;
}

.like_exhibition .icon {
	display: flex;
	align-items: center;
	justify-content: center;
	width: calc(100vw * ( 50/ 1920));
	height: calc(100vw * ( 50/ 1920));
	border-radius: 50%;
	border: solid 1.5px #eaeaea;
	background-color: #fff;
}

.icon.heart img {
	width: calc(100vw * ( 24/ 1920));
	height: calc(100vw * ( 24/ 1920));
}

.icon.heart.fas {
	color: red
}

.heart {
	transform-origin: center;
}

.heart.active img {
	animation: animateHeart .3s linear forwards;
}

@
keyframes animateHeart { 0%{
	transform: scale(.2);
}

40


%
{
transform


:


scale
(


1
.2


)
;


}
100


%
{
transform


:


scale
(


1


)
;


}
}
.writebtn button {
	background-color: #BDBDBD;
	width: 500px;
	border-radius: 5px;
	border: none;
	height: 40px;
	font-size: 10px;
	color: white;
	box-shadow: 0px 0px 5px #BDBDBD; 
}

.writebtn button:hover {
	background-color: white;
	color: #BDBDBD;
	border: 1px solid #BDBDBD;
}

#profile-img {
	width: 30px;
	height: 25px;
	border-radius: 50%;
	border: 1px solid gray;
	
}

.reviewbox {
	margin-bottom: 10px;
	width: 300px;
	height: 110px;
	display: inline-flex;
	margin-right: 15px; /*아이템별 간격  */
	margin-left: 10px;
	border: 1px solid #BDBDBD;
	box-shadow: 0px 0px 5px #BDBDBD;
}

.reviewbox b {
	font-size: 10px;
}

.reviewmeberinfo {
	width: 100%;
}

.reviewinfo {

}

.reviewtop {
 	text-align: left; 
}

.reviewtop label {
	font-size: 9px;
}

/*후기 전체보기 css  */
.totalreviewlist {
	float: right;
	color: black;
	font-size: 12px;
	outline: none;
	margin-right: 165px;
	text-decoration: underline;
	cursor: pointer;
}

#nototalreviewlist {
	float: right;
	color: black;
	font-size: 12px;
	outline: none;
	margin-right: 165px;
	text-decoration: underline;
}

.totalreviewlist:hover {
	color: #BDBDBD;
}

#nototalreviewlist:hover {
	color: #BDBDBD;
}

#reveiw-list {
	width: 100%;
	margin: 0 auto;
}


#btnupdate{
font-size: 9px;
}
#detailreviewdel  {
font-size: 9px;
}
.rmenu{
  float: right;
}


.rmenubtn{
border:none;
background-color: white;
  cursor : pointer;
  margin-top: 5px;
  margin-right: 15px;

  
}
.rmenucontent{

  display : none;
  position : absolute;
  z-index : 1; 
  font-weight: 400;
  background-color: rgb(189, 189, 189, 0.1);
   height: 40px;
  text-align: center;


}


.rmenucontent li a{
  height: 20px;
  display : block;
  text-decoration : none;
  color : rgb(37, 37, 37);
  cursor: pointer;
  color: black;
  border: 1px solid #BDBDBD;
}

.rmenucontent a:hover{
  background-color : white;
  color: #BDBDBD;

}

.rmenu:hover .rmenucontent {
  display: block;

}
.rmenubtn img{
filter: opacity(0.2) drop-shadow(0 0 0 #BDBDBD); 
}
#updatecontent{
height: 100px;
resize: none;

}
.form-group1 fieldset {
	display: inline-block;
	direction: rtl;
	border: 0;
	margin-bottom: 20px; 
}

.form-group1 fieldset legend {
	text-align: right;
}

.form-group1 input[type=radio] {
	display: none;
}

.form-group1 label {
	font-size: 3em;
	color: transparent;
	text-shadow: 0 0 0 #f0f0f0;
}

.form-group1 label {
	font-size: 15px;
	
}

.form-group1 label:hover {
	text-shadow: 0 0 0 rgba(109, 99, 71, 0.5);
}

.form-group1 label:hover ~ label {
	text-shadow: 0 0 0 rgba(109, 99, 71, 0.5);
}

.form-group1 input[type=radio]:checked ~ label {
	text-shadow: 0 0 0 rgba(109, 99, 71, 0.5);
}
.form-group1 {
	text-align: center;
}
.form-group {
	text-align: center;
}
.lists a {
cursor: pointer;
}

</style>


<script type="text/javascript">


$(function(){
    var likeBtn =$('.icon.heart');
    
    likeBtn.click(function(){
    	
    		if(likeBtn.hasClass('active')){
                $(this).removeClass('active')
                $(this).find('img').attr({
                    'src': '../../image/heart.png',
                     alt:"찜하기"
                });
                var exhibition_num=$(this).attr("exhibition_num");
                $.ajax({
                    url:"/exhibition/deleteLike",
                    data:{"exhibition_num":exhibition_num},
                    type:"get",
                    success:function() {
                         alert("찜하기 삭제");
                         location.reload();
                    }
                });

            }else{
                $(this).addClass('active')
                $(this).find('img').attr({
                    'src': '../../image/redheart.png',
                    // alt:'찜하기 완료'
                })
                var exhibition_num=$(this).attr("exhibition_num");
                $.ajax({
                    url:"/exhibition/insertLike",
                    data:{"exhibition_num":exhibition_num},
                    type:"get",
                    success:function() {
                         alert("찜하기 완료");
                         location.reload();
                    }
                });
			
		}

        

        
    })
});

$(function() {
	 
	var review_num =  document.getElementById("review_num").value;
	
	console.log("review_num:"+review_num);
$("#detailreviewdel").click(function() {
		if (confirm("삭제 하시겠습니까?")) {
			
		

	//삭제 ajax
	$.ajax({

		type : "get",
		url : "/review/reviewdelete",
		dataType : "html",
		data : {
			"review_num" : review_num
		},
		success : function() {
				alert("작성한 후기 삭제되었습니다");
				location.reload();
			
			
		}
	});
		}else {
			
	    	location.reload();

		}
});

}); 

 $(function () {
 $("#btnupdate").click(function(){
		 
		 updatenum=$(this).attr("num");
		//alert(updatenum); 
		  
		
		$.ajax({
			type:"get",
			dataType:"json",
			url:"/review/updateform",
			data:{"review_num": updatenum},
			success:function(res){
				
				console.dir(res);
				
				$("#updatecontent").val(res.review_content);
				$("#updatescore").val(res.review_score);
					

			}
			
		});
		  
	  });
//수정
 $("#updatewrite").click(function(){
	  
	  
	
	  var updatecontent=$("#updatecontent").val()
	  
	  
	  
	var updatescores= document.querySelector('input[name="review_score"]:checked').value; 
 

	  
	 
	 
	 
	
	  console.log("updatecontent:"+updatecontent);
	  console.log("updatescores:"+updatescores);
	  
	  var data="review_num="+updatenum+"&review_content="+updatecontent+"&review_score="+updatescores;
	  console.log(data);
	  
	  
	  $.ajax({
		  
		  type:"post",
		  dataType:"text",
		  data:data,
		  url:"/review/update",
		  success:function(){
			   location.reload(); 
		  }
	  });
 });
	
})
	$(function () {
		
	
	$("#wirtereview").click(function () {
					
					var exhibition_num = $("#exhibition_nums").val();
					var member_num = $("#member_nums").val();
					 console.log("exhibition_num:"+exhibition_num);
					 console.log("member_num:"+member_num);
					$.ajax({
						type:"get",
						dataType:"json",
						url:"/review/memberreviewcheck",
						data:{"exhibition_num": exhibition_num,
							  "member_num": member_num},
						success:function(res){
							if(res.reviewcount==0){
								 location.href="/exhibition/reviewform?exhibition_num="+exhibition_num; 
							}else{
								alert("작성하신 후기가 존재 합니다.")
								
							}
							
							
							

							
						}
						
					});
				})
	})




 
    </script>



</head>
<body>
	<input type="hidden" id="member_nums" value="${member_num }">
	<input type="hidden" id="exhibition_nums" value="${exhibition_num }">
	<c:set var="loginok" value="${sessionScope.loginok}"></c:set>
	<div class="exhibition_info">

		<b>${Edto.exhibition_subject }</b>
		<hr>
		<br>

		<div class="exhibition_detailimg">
			<img alt="exhibition_img" src="${Edto.exhibition_image}"
				style="width: 300px; height: 400px;">
		</div>
		<br>

		<div class="exhibition_detailcontent">
			${Edto.exhibition_content}<br>
		</div>

		<b>전시 정보</b>
		<hr>


		<br>
		<div class="exhibition_data">

			<div class="like_exhibition">
				<c:if test="${not empty loginok}">
					<c:if test="${like_check eq 1}">
						<a class="icon heart active"
							exhibition_num="${Edto.exhibition_num}"> <img
							src="../../image/redheart.png" alt="좋아요" style="width: 20px;">
						</a>
						<span class="Likecount">${Like}</span>


					</c:if>


					<c:if test="${like_check ne 1}">
						<a class="icon heart" exhibition_num="${Edto.exhibition_num}">
							<img src="../../image/heart.png" alt="좋아요" style="width: 20px;">
						</a>
						<span class="Likecount">${Like}</span>

					</c:if>


				</c:if>

				<c:if test="${empty loginok}">
					<a class="icon" id="nologin"> <img src="../../image/heart.png"
						alt="좋아요" style="width: 20px;">
					</a>

					<span class="Likecount">${Like}</span>

				</c:if>

			</div>
			<br>
			<ul>
				<li><b>제목:</b> ${Edto.exhibition_subject }</li>
				<li><b>작가:</b> ${Edto.exhibition_artist}</li>
				<li><b>기간:</b> ${Edto.exhibition_term }</li>
				<li><b>가격:</b> ${Edto.exhibition_price}</li>
				<li><b>장소:</b> ${Edto.exhibition_location}</li>
				<li><b>출처:</b> <a style="color: gray;"
					href="https://www.opengallery.co.kr${Edto.exhibition_link}">
						사이트 바로가기</a></li>

			</ul>

		</div>



		<b>위치 정보</b>
		<hr>
		<br>
		<div id="map"
			style="width: 50%; height: 250px; margin: 0 auto; border: 1px solid #BDBDBD;"></div>
		<div
			style="width: 50%; height: 60px; margin: 0 auto; border: 1px solid #BDBDBD; text-align: left;">
			<a
				style="color: black; font-size: 13px; position: absolute; margin-top: 5px;"
				href="https://map.kakao.com/link/to/${Edto.exhibition_location},${Edto.exhibition_latitude},${Edto.exhibition_longitude}"><strong>길찾기</strong></a>
			<br> <small style="font-size: 10px; color: gray;">${Edto.exhibition_detaillocation}</small>
		</div>
		<script type="text/javascript"
			src="//dapi.kakao.com/v2/maps/sdk.js?appkey=fbd4f48b50743a44e8ec0c2610e22f3e"></script>
		<script>

var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
mapOption = { 
    center: new kakao.maps.LatLng(${Edto.exhibition_latitude},${Edto.exhibition_longitude}), // 지도의 중심좌표
    level: 3 // 지도의 확대 레벨 129.1270384	35.1542175
};

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

//마커가 표시될 위치입니다 
var markerPosition  = new kakao.maps.LatLng(${Edto.exhibition_latitude},${Edto.exhibition_longitude}); 

//마커를 생성합니다
var marker = new kakao.maps.Marker({
position: markerPosition
});

//마커가 지도 위에 표시되도록 설정합니다
marker.setMap(map);
		    

var mapTypeControl = new kakao.maps.MapTypeControl();

//지도에 컨트롤을 추가해야 지도위에 표시됩니다
//kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

//지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
var zoomControl = new kakao.maps.ZoomControl();
map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

</script>
		<br> <br> <br> <br> <b>후기(${reviewcount})</b> <b
			style="font-size: 14px;"> ★${avgscore} ${noreview} </b>

		<hr>
		<div class="lists">
			<c:if test="${noreview==0}">
				<a id="nototalreviewlist">전체보기</a>
			</c:if>
			<c:if test="${noreview!=0}">
				<a href="/review/reviewlist?exhibition_num=${Edto.exhibition_num}"
					class="totalreviewlist">전체보기</a>
			</c:if>
		</div>


		<div id="reveiw-list">

			<c:if test="${noreview==0}">
				<div style="width: 100px; margin: 0 auto;">
					<b style="font-size: 14px; color: #5d6361;">후기가 없습니다.</b>
				</div>
			</c:if>
			<br>
			<c:forEach var="e" items="${list}" varStatus="i">
				<input type="hidden" id="exhibition_num" value="${e.exhibition_num }">
				<input type="hidden" id="review_num" value="${e.review_num }">
				<input type="hidden" id="member_num" value="${e.member_num }">
				<c:if test="${noreview!=0}">
				
					<div class="reviewbox">
					
						<div class="reviewmeberinfo">
		
							<div class="reviewtop">
							
							<c:if test="${member_num eq e.member_num}">
							 <div class="rmenu">
							 
							 <img alt="" class="rmenubtn" src="../../image/menuimage2.png" style="width: 25px; height: 15px;">
								
							<div  class="rmenucontent" style="width: 40px;">
							<ul>
							<li><a id="detailreviewdel">삭 제</a></li>
							<li><a type="button" data-toggle="modal" data-target="#myModal" num=${e.review_num }  id="btnupdate">수 정</a></li>
							</ul>
							
							
							
							</div>
							</div>
							
							
									
							</c:if>
								
								<c:if test="${e.member_photo==null }">
									<img src="../../image/logoimage.png" id="profile-img">
								</c:if>
								<c:if test="${e.member_photo!=null }">
									<img alt="" src="../../photo/${e.member_photo}"
										id="profile-img">
								</c:if>
								<c:if test="${e.member_nickname!=null}">
								<b>${e.member_nickname}</b>
								</c:if>
								<c:if test="${e.member_nickname==null}">
								<b>${e.member_name}</b>
								</c:if>
								
								<c:choose>
									<c:when test="${e.review_score==1}">
										<label>★</label>
									</c:when>
									<c:when test="${e.review_score==2}">
										<label>★★</label>
									</c:when>
									<c:when test="${e.review_score==3}">
										<label>★★★</label>
									</c:when>
									<c:when test="${e.review_score==4}">
										<label>★★★★</label>
									</c:when>
									<c:when test="${e.review_score==5}">
										<label>★★★★★</label>
									</c:when>
								</c:choose>
								<b>${e.review_score}</b> 
								<br>	 
								<b style="float: left; margin-top: 10px; margin-right: 2px; font-size: 7px;">${e.review_writeday}</b>
							</div>
							<br>	
							<div class="reviewinfo">

								<b style="word-break: break-all; 	margin-left: 10px;
								">${e.review_content}</b> <br>

							
								

							</div>

						</div>


					</div>
				</c:if>


			</c:forEach>


		</div>
		<div class="writebtn">
			<c:if test="${not empty loginok}">
				<button id="wirtereview"
					<%-- onclick="location.href='/exhibition/reviewform?exhibition_num=${Edto.exhibition_num}'" --%>>
					<b>후기 작성</b>
				</button>
			</c:if>

			<c:if test="${empty loginok}">
				<button id="noreview">
					<b>후기 작성</b>
				</button>

			</c:if>
		</div>
	</div>


<!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog modal-sm">
    
      <!-- Modal content-->
      <div class="modal-content">
      
      <!--  header-->
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h5 class="modal-title">후기 수정</h5>
        </div>
        
        
        
        <!-- body -->
        <div class="modal-body">
        
        
        			<div class="form-group">
        			<label for="updatescore" style="font-size: 13px; color: black;">현재 평점</label>
        				
        				<br>
						<input type="number" id="updatescore"  style="border: none; width: 15px; height: 20px;
						text-align: center; font-size: 11px; background-color: white;"  disabled><small style="font-size: 11px;">점</small>
						
					</div>
        			
        
        			<div class="form-group1" >
        			
						
		
						<fieldset>
					<span class="text-bold"><b style="font-size: 13px; text-align: center;">수정할 별점을
							선택해주세요</b></span><br> 
							<input type="radio" name="review_score"
						value="5" id="rate1" class="form-control"> <label
						for="rate1">★</label> <input type="radio"
						name="review_score" value="4" id="rate2"
						class="form-control"> <label for="rate2">★</label> <input
						type="radio" name="review_score" value="3" id="rate3"
						class="form-control"><label for="rate3">★</label> <input
						type="radio" name="review_score" value="2" id="rate4"
						class="form-control"><label for="rate4">★</label> <input
						type="radio" name="review_score" value="1" id="rate5"
						class="form-control"><label for="rate5">★</label>

				</fieldset>

        			</div>
        
        			
					<div class="form-group" >
						<label for="updatecontent" style="font-size: 13px; ">후기 내용</label>
						<textarea  class="form-control" id="updatecontent"
							name="review_content" maxlength="100"></textarea>
					</div>
					
					
		</div>
        
        
        
        
       <!-- footer -->
        
        <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal" id="updatewrite">수정하기</button>
          <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
        </div>
      </div>
      
    </div>
  </div>
</body>
 

<script type="text/javascript">
   document.getElementById("nologin").addEventListener("click", function() {
      alert("로그인 후 이용 가능합니다");
      window.location.href = "/member/loginform";
      
     
      


   });
  document.getElementById("noreview").addEventListener("click", function() {
	      alert("로그인 후 이용 가능합니다");
	      window.location.href = "/member/loginform";
	      
	     
	      


	   });
  document.getElementById("nototalreviewlist").addEventListener("click", function() {
      alert("후기가 없습니다.");
     
      
     
      


   });   
  
 
  
   
  </script>

</html>