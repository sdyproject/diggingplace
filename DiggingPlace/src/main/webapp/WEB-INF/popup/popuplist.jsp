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
.allpopup {
	width: 100%;
	height: 1300px;
	text-align: center;
	margin-top: 30px;
}

.popupbox {
	margin-bottom: 50px;
	width: 330px;
	height: 320px;
	display: inline-flex;
	margin-right: 10px; /*아이템별 간격  */
	margin-left: 10px;
	border: 1px solid #BDBDBD;
	box-shadow: 0px 0px 5px #BDBDBD;
	
}



.popupbox img:hover {
	filter: opacity(0.4);
}

.popupbox b {
	color: black;
}

.pho {
	width: 320px;
	height: 200px;
	position: relative;
}

.p {
	width: 320px;
	height: 60px;
	position: absolute;
	font-size: 9px;
	text-align: left;
	margin-left: 3px;
	margin-top: 3px;
	
}
.p b{
color: black;
}

.p .popup_Subject {
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
	width: 220px;
	height: 20px;
	display: inline-block;
	font-size: 14px;
	cursor: pointer;
}

.p img {
	text-align: center;
	border-radius: 5px;
}

.popupsort a {
	color: black;
	text-decoration: none;
}

.popupsort {
	font-size: 12px;
	
	
}

.v-line {
	border-left: 2px solid #BDBDBD;
	height: 12px;
	width: 20px;
	margin-left: 3px;
}
.v-line2 {
	border-left: 2px solid #BDBDBD;
	width: 5px;

}

.popupsort b {
	margin-left: 2.5px
}

#submitBtn {
	background-color: #BDBDBD;
	width: 40px;
	border-radius: 5px;
	border: none;
	height: 25px;
	font-size: 10px;
	color: white;
	box-shadow: 0px 0px 5px #BDBDBD; 
}

#submitBtn:hover {
	background-color: white;
	color: #BDBDBD;
	border: 1px solid #BDBDBD;
}

.locationreset {
	float: left;
	margin-right: 2px;
	background-color: #6e6e6e;
	border-radius: 5px;
	border: none;
	box-shadow: 0px 0px 5px #BDBDBD; 
	width: 65px;
	height: 25px;
	font-size: 10px;
}
.locationreset span{
color:white;
}
.locationreset span:hover{
	color:#BDBDBD;
}
.locationreset:hover{
background-color: white;
	border: 1px solid #BDBDBD;
}

.totalsort{

color: black;
font-size: 12px;
float: right;
margin-top: 3.5px; 
margin-left: 10px;
}
.totalsort b:hover{
color: #BDBDBD;
}
.totalsort b{
color: #5d6361;
}


/*좋아요 css  */

.like_popup{
float:right;
width: 30px;
text-align: right;
font-size: 9.5px;
height: 50px;
margin-right: 3px;



}

.like_popup a{
 text-decoration:none; color:inherit; cursor: pointer; float: left; 
}
.like_popup .icon{
 display: flex;
    align-items: center;
    justify-content: center;
    width: calc(100vw * (50 / 1920));
    height: calc(100vw * (50 / 1920));
   border-radius: 50%;
    border: solid 1.5px #eaeaea;
    background-color: #fff;
}
.icon.heart img{
    width: calc(100vw * (24 / 1920));
    height: calc(100vw * (24 / 1920));
}
.icon.heart.fas{
  color:red
}
.heart{
    transform-origin: center;
}
.heart.active img{
    animation: animateHeart .3s linear forwards;
}
@keyframes animateHeart{
    0%{transform:scale(.2);}
    40%{transform:scale(1.2);}
    100%{transform:scale(1);}
 }
.icons{
 display: flex;
    align-items: center;
    justify-content: center;
    width: calc(100vw * (50 / 1920));
    height: calc(100vw * (50 / 1920));
   border-radius: 50%;
    border: solid 1.5px #eaeaea;
    background-color: #fff;
}  
  .Likecount{

font-size: 10px;
color: black;
margin-right: 11px;
}

</style>
<script type="text/javascript">


$(function(){
   var likeBtn =$('.icon.heart.active');
   
   likeBtn.click(function(){
	   var like_check = $(this).attr("clist")
	   console.log('like_check:'+like_check);
   		if(likeBtn.hasClass('active') && (like_check==1)){
               $(this).removeClass('active')
               $(this).find('img').attr({
                   'src': '../image/heart.png',
                    alt:"찜하기"
               });
               var popup_num=$(this).attr("popup_num");
               $.ajax({
                   url:"/popup/deleteLikelist",
                   data:{"popup_num":popup_num},
                   type:"get",
                   success:function() {
                        alert("찜하기 삭제");
                        location.reload();
                   }
               });

           }

       

       
   })
  
});


$(function(){
	   var likeBtn2 =$('.icon');
	   
	   likeBtn2.click(function(){
		   var like_check2 = $(this).attr("clist")
		   console.log('like_check2:'+like_check2);
	       if ((like_check2!=1)) {
	    	  
	           $(this).find('img').attr({
	               'src': '../image/redheart.png',
	               // alt:'찜하기 완료'
	           })
	           var popup_num=$(this).attr("popup_num");
	           $.ajax({
	               url:"/popup/insertLikelist",
	               data:{"popup_num":popup_num},
	               type:"get",
	               success:function() {
	                    alert("찜하기 완료");
	                    location.reload();
	               }
	           });
		       
		}
		 

	       
	   })
	  
	});

 
</script>
</head>
<body>

	<div class="allpopup">
		<div style="text-align: center;">
			<b>팝업 스토어 </b>
		</div>
		<br><br>

		<div>
			
			<b style="float: left; margin-left: 5px;  font-size: 13px; color: #5d6361;" >전체: ${listsize}  </b>
			<div class="popupsort" style="float: right;">
			
				<form action="locationsort" method="get"
					style="border-radius: 10px;">
					
					<a href="/popup/popuplist" class="locationreset"> 
					<span class="glyphicon glyphicon-repeat" style="margin-top: 6.8px; font-size: 9px; ">초기화</span>	
					</a>
					<select name="location" id="locations"
						style="width: 130px; height: 25px; border-radius: 5px; border-color: #BDBDBD; color: #5d6361;" >

						<option value="지역" title="지역">지역</option>
						<option value="서울" title="서울" <c:if test="${location eq '서울'}">selected='selected'</c:if>>서울</option>
						<option value="경기|인천" title="경기|인천" <c:if test="${location eq '경기|인천'}">selected='selected'</c:if>>경기</option>
						<option value="강원" title="강원" <c:if test="${location eq '강원'}">selected='selected'</c:if>>강원</option>
						<option value="충청" title="충청" <c:if test="${location eq '충청'}">selected='selected'</c:if>>충청</option>
						<option value="경상|울산|부산" title="경상|울산|부산" <c:if test="${location eq '경상|울산|부산'}">selected='selected'</c:if>>경상</option>
						<option value="전라" title="전라" <c:if test="${location eq '전라'}">selected='selected'</c:if>>전라</option>
					</select> 
					
					
					
					
					<button type="submit" id="submitBtn" title="검색">
						<span>검색</span>
					</button>
				</form>
				<div class="totalsort">
				
				<a href="likesort" class="likesort" style=" text-decoration: none;  font-size:9px;"><b>좋아요순</b></a>
				<span class='v-line2'></span>
				<a href="popupreviewsort" class="reviewsort" style=" text-decoration: none; font-size: 9px; "><b>평점순</b></a>
				
				
				
				</div>
			
				
				
			</div>
			<br><br>
			<c:if test="${listsize==0}">
				<div style="width: 200px; margin: 0 auto; margin-top: 50px;">
					<b style="font-size: 14px; color: #5d6361;">전시회가 없습니다.</b>
				</div>
			</c:if>
			<c:forEach var="e" items="${list}" varStatus="status">
				
				<div class="popupbox">
					<div class="pho">
						<c:if test="${e.popup_image!=null}">
						<img src="${e.popup_image}"
							onclick="location.href='popupdetail/${e.popup_num}'"
							style="width: 328px; height: 230px; cursor: pointer;">
						</c:if>
						<c:if test="${e.popup_image==null}">
							<img src="../image/logoimage.png"
							onclick="location.href='popupdetail/${e.popup_num}'"
							style="width: 298px; height: 230px; cursor: pointer;">
						</c:if>
							
							 <br>
				<div class="like_popup">
				
					<c:if test="${not empty loginok}">
						<c:if test="${clist[status.index] eq 1}">  
               			<a class="icon heart active"  popup_num="${elist[status.index]}" clist="${clist[status.index]}">
               			<img src="../image/redheart.png" alt="좋아요" style=" width: 20px; ">
               			</a>
               			
               			<span class="Likecount">${llist[status.index]}</span>
               			
               			
               			</c:if>
               			
               			
						<c:if test="${clist[status.index] ne 1}">
               			<a class="icon "  popup_num="${elist[status.index]}" clist="${clist[status.index]}">
               			<img src="../image/heart.png" alt="좋아요" style=" width: 20px; ">
               			</a>
               			
               			<span class="Likecount" >${llist[status.index]}</span>
						
               			</c:if>
               			
               			
               		</c:if>
               		
               		<c:if test="${empty loginok}">
               			<a class="icons" id="nologin">
               			<img src="../../image/heart.png" alt="좋아요" style=" width: 20px; ">
               			</a>
               			
               			<span class="Likecount">${llist[status.index]}</span>

               		</c:if>	 
               		
               			
</div>
<br>
						<div class="p">
							<b class="popup_Subject"
								onclick="location.href='popupdetail/${e.popup_num}'">${e.popup_subject }</b><br><br>
							<b>${e.popup_location }</b><small style="float: right; margin-right: 10px;">후기:${rlist[status.index]}</small>
									
									<c:choose>
								<c:when test="${rslist[status.index]>0}">
								<small style="float: right; margin-right: 7px;">평점: ${rslist[status.index]}</small>
								</c:when>
								<c:when test="${rslist[status.index]==0}">
								<small style="float: right; margin-right: 7px;">평점: 0</small>
								</c:when>
								</c:choose>	
									
									
									


						</div>
						<br>
					</div>


				</div>



			</c:forEach>
			
			
			
			
			
			
			
				
		</div>
		<c:if test="${totalCount>0 }">
			<div style = "width:700px; text-align:center; margin: 0 auto;">
				<ul class = "pagination">
				<!-- 이전 -->
					<c:if test="${startPage>1 }">
						<li>
							<a href = "popuplist?currentPage=${startPage-1 }">이전</a>
						</li>
					</c:if>
					
					<c:forEach var = "pp" begin = "${startPage }" end = "${endPage }" >
						<c:if test="${currentPage==pp }">
							<li class="active" >
         						<a href="popuplist?currentPage=${pp }" style="cursor: pointer; background-color: #BDBDBD; border-color: #BDBDBD;">${pp }</a>
      						</li>
						</c:if>
						
						
						<c:if test="${currentPage!=pp }">
							<li>
         						<a href="popuplist?currentPage=${pp }" style="color: black;">${pp }</a>
         						
      						</li>
						</c:if>
						
						
					</c:forEach>
					
					
					<!-- 다음 -->
					<c:if test="${endPage<totalPage }">
						<li>
							<a href = "popuplist?currentPage=${endPage+1 }">다음</a>
						</li>
					</c:if>
				</ul>
			</div>
		</c:if>
		<!--지역순 페이징  -->
		<c:if test="${locationtotalCount>0 }">
			<div style = "width:700px; text-align:center; margin: 0 auto;">
				<ul class = "pagination">
				<!-- 이전 -->
					<c:if test="${startPage>1 }">
						<li>
							<a href = "locationsort?location=${location }??currentPage=${pp}">이전</a>
						</li>
					</c:if>
					
					<c:forEach var = "pp" begin = "${startPage }" end = "${endPage }" >
						<c:if test="${currentPage==pp }">
							<li class="active" >
         						<a href="locationsort?location=${location }&currentPage=${pp}" style="cursor: pointer; background-color: #BDBDBD; border-color: #BDBDBD;">${pp }</a>
      						</li>
						</c:if>
						
						<!--url 경로 변수 다중 추가  -->
						<c:if test="${currentPage!=pp }">
							<li>
         						<a href="locationsort?location=${location }&currentPage=${pp}" style="color: black;">${pp }</a>
         						
      						</li>
						</c:if>
						
						
					</c:forEach>
					
					
					<!-- 다음 -->
					<c:if test="${endPage<totalPage }">
						<li>
							<a href = "locationsort?currentPage=${endPage+1 }">다음</a>
						</li>
					</c:if>
				</ul>
			</div>
		</c:if>
		<!-- 좋아요 순 정렬 -->
		<c:if test="${likesortCount>0 }">
			<div style = "width:700px; text-align:center; margin: 0 auto;">
				<ul class = "pagination">
				<!-- 이전 -->
					<c:if test="${startPage>1 }">
						<li>
							<a href = "likesort?location=${location }??currentPage=${pp}">이전</a>
						</li>
					</c:if>
					
					<c:forEach var = "pp" begin = "${startPage }" end = "${endPage }" >
						<c:if test="${currentPage==pp }">
							<li class="active" >
         						<a href="likesort?currentPage=${pp}" style="cursor: pointer; background-color: #BDBDBD; border-color: #BDBDBD;">${pp }</a>
      						</li>
						</c:if>
						
						<!--url 경로 변수 다중 추가  -->
						<c:if test="${currentPage!=pp }">
							<li>
         						<a href="likesort?currentPage=${pp}" style="color: black;">${pp }</a>
         						
      						</li>
						</c:if>
						
						
					</c:forEach>
					
					
					<!-- 다음 -->
					<c:if test="${endPage<totalPage }">
						<li>
							<a href = "likesort?currentPage=${endPage+1 }">다음</a>
						</li>
					</c:if>
				</ul>
			</div>
		</c:if>
			<!-- 후기순 -->
		<c:if test="${popupreviewsortCount>0 }">
			<div style = "width:700px; text-align:center; margin: 0 auto;">
				<ul class = "pagination">
				<!-- 이전 -->
					<c:if test="${startPage>1 }">
						<li>
							<a href = "popupreviewsort?location=${location }??currentPage=${pp}">이전</a>
						</li>
					</c:if>
					
					<c:forEach var = "pp" begin = "${startPage }" end = "${endPage }" >
						<c:if test="${currentPage==pp }">
							<li class="active" >
         						<a href="popupreviewsort?currentPage=${pp}" style="cursor: pointer; background-color: #BDBDBD; border-color: #BDBDBD;">${pp }</a>
      						</li>
						</c:if>
						
						<!--url 경로 변수 다중 추가  -->
						<c:if test="${currentPage!=pp }">
							<li>
         						<a href="popupreviewsort?currentPage=${pp}" style="color: black;">${pp }</a>
         						
      						</li>
						</c:if>
						
						
					</c:forEach>
					
					
					<!-- 다음 -->
					<c:if test="${endPage<totalPage }">
						<li>
							<a href = "popupreviewsort?currentPage=${endPage+1 }">다음</a>
						</li>
					</c:if>
				</ul>
			</div>
		</c:if>
		
	</div>

</body>
<script type="text/javascript">
   document.getElementById("nologin").addEventListener("click", function() {
      alert("로그인 후 이용 가능합니다.");
      window.location.href = "/member/loginform";
      
     
      


   });
  </script>
</html>