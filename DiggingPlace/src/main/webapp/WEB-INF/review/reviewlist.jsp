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
	 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
<!-- Plugin -->
<link rel="stylesheet" href="https://rawgit.com/enyo/dropzone/master/dist/dropzone.css" />
<script src="https://rawgit.com/enyo/dropzone/master/dist/dropzone.js"></script>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans&family=Noto+Sans+KR&display=swap" rel="stylesheet">


<style type="text/css">
#review-warpper{
margin: 0 auto;
text-align: center;
}

.writebtn {
	
	font-size: 13px;
	margin-bottom: 3px;
	
}
.writebtn b:hover{
color: #BDBDBD;
}

#profile-img {
	width: 60px;
	height: 50px;
	border-radius: 50%;
	border: 1px solid gray;
	margin-left: 2px;
}
.reviewbox {
	margin-bottom: 10px;
	width: 250px;
	height: 250px;
	display: inline-flex;
	margin-left: 10px;
	border: 1px solid #BDBDBD;
	box-shadow: 0px 0px 5px #BDBDBD;
	
	
	
}
.reviewbox b{
font-size: 10px;
}
.reviewmeberinfo{
width: 100%;
}
.reviewinfo{

}
.reviewtop{

height: 50px;
width: 120px;
margin: 0 auto; 

}
.reviewbottom{
margin: 0 auto; 
}

.writebtn button {
	background-color: #BDBDBD;
	width: 500px;
	border-radius: 5px;
	border: none;
	height: 40px;
	font-size: 10px;
	color: white;
	
}

.writebtn button:hover {
	background-color: white;
	color: #BDBDBD;
	border: 1px solid #BDBDBD;
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
  width: 30px;
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
.form-group{
	text-align: center;
}



</style>
<script type="text/javascript">
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
</script>
</head>
<body>
<br>

<div id="review-warpper">
<b class="reviewsubject">후기(${listsize })</b><b style="font-size: 14px;"> ★${avgscore}</b>  	
		
		<br>
		<br>
		<br>
		<div id="reveiw-list">
			
			
			
			<c:forEach var="e" items="${list}" varStatus="i">
				<input type="hidden" id="exhibition_num" value="${e.exhibition_num }">
				<input type="hidden" id="review_num" value="${e.review_num }">
				<input type="hidden" id="member_num" value="${e.member_num }">
				<div class="reviewbox">
					<div class="reviewmeberinfo">
					<b style="float: left; margin-right: 2px; ">${e.review_writeday}</b>
					
					<c:if test="${member_num eq e.member_num}">
							 
							 <div class="rmenu">
							 
							 <img alt="" class="rmenubtn" src="../../image/menuimage2.png" style="width: 15px; height: 15px;">
								
							<div  class="rmenucontent" style="width: 30px;">
							<ul>
							<li><a id="detailreviewdel">삭 제</a></li>
							<li><a type="button" data-toggle="modal" data-target="#myModal" num=${e.review_num }  id="btnupdate">수 정</a></li>
							</ul>
							
							
							
							</div>
							</div>
							
						
							</c:if>
					<br>
					<div class="reviewtop">
					
					
						<c:if test="${e.member_photo==null }">
							<img src="../../image/logoimage.png" id="profile-img">
						</c:if>
						<c:if test="${e.member_photo!=null }">
							<img alt="" src="../../photo/${e.member_photo}"
								id="profile-img">
						</c:if>
						<b style="margin-left: 5px; font-size: 13px;">${e.member_nickname}</b> 
						
						</div>
						<br>
						<div class="reviewbottom">
						<c:choose >
						<c:when test="${e.review_score==1}">
						<label >★</label>
						</c:when>
						<c:when test="${e.review_score==2}">
						<label >★★</label>
						</c:when>
						<c:when test="${e.review_score==3}">
						<label >★★★</label>
						</c:when>
						<c:when test="${e.review_score==4}">
						<label >★★★★</label>
						</c:when>
						<c:when test="${e.review_score==5}">
						<label >★★★★★</label>
						</c:when>
						</c:choose>
						</div>
						
						<b >별점:${e.review_score}</b> 
						<br>
						<div class="reviewinfo">
						
						<b style="word-break:break-all;">${e.review_content}</b>
						</div>
						
					
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
							<a href = "reviewlist?currentPage=${startPage-1 }">이전</a>
						</li>
					</c:if>
					
					<c:forEach var = "pp" begin = "${startPage }" end = "${endPage }" >
						<c:if test="${currentPage==pp }">
							<li class="active" >
         						<a href="reviewlist?exhibition_num=${exhibition_num}&currentPage=${pp }" style="cursor: pointer; background-color: #BDBDBD; border-color: #BDBDBD;">${pp }</a>
      						</li>
						</c:if>
						
						
						<c:if test="${currentPage!=pp }">
							<li>
         						<a href="reviewlist?exhibition_num=${exhibition_num}&currentPage=${pp }" style="color: black;">${pp }</a>
         						
      						</li>
						</c:if>
						
						
					</c:forEach>
					
					
					<!-- 다음 -->
					<c:if test="${endPage<totalPage }">
						<li>
							<a href = "reviewlist?currentPage=${endPage+1 }">다음</a>
						</li>
					</c:if>
				</ul>
			</div>
		</c:if>
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
					<span class="text-bold"><b style="font-size: 13px;">수정할 별점을
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
        
        			
					<div class="form-group">
						<label for="updatecontent" style="font-size: 13px;">후기 내용</label>
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
</html>