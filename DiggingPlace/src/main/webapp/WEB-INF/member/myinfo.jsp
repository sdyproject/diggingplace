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
.myinfo-wrapper {
	width: 650px;
	height: 800px;
	margin: 0 auto;
	text-align: center;
}
.profile-info {
	width: 600px;
	height: 150px;
	margin: 0 auto;
	
}

#allmyinfo {
	width: 600px;
	margin: 0 auto;
}

.image-wrapper {
	width: 150px;
	height: 150px;
	float: left;
	margin-left: 150px;
	/*  border:  1px solid red;  */
}

#profile-img {
	width: 120px;
	height: 110px;
	border-radius: 50%;
	margin-top: 20px;
	border:  1px solid #BDBDBD;
	margin-left: 10px;
	box-shadow: 0px 0px 5px #BDBDBD; 
}

.info-wrapper {
	width: 200px;
	height: 110px;
	float: right;
	text-align: left;
	margin-top: 40px;
	margin-right: 60px;

	/*  border:  1px solid blue; */
}

.info-wrapper li a {
	color: #6E6E6E;

}


ul, li {
	margin: 0;
	padding: 0;
	list-style-type: none;
	font-size: 13px;
	line-height: 30px;
}

#profile-management {
	background-color: #6E6E6E;
	width: 80px;
	border-radius: 10px;
	border: none;
	height: 25px;
	font-size: 10px;
	color: white;
	box-shadow: 0px 0px 5px #BDBDBD; border-radius: 10px;
}

.like-exhibition {
	margin-top: 3px;
	width: 201px;
	height: 260px;
	display: inline-flex;
	margin-right: 1px; /*아이템별 간격  */
	margin-left: 10px;
	/* border: 1px solid #BDBDBD;
	box-shadow: 0px 0px 5px #BDBDBD; */
}

.like-exhibition img {
	filter: opacity(1);
}

.like-exhibition img:hover {
	filter: opacity(0.4);
}

.pho {
	width: 200px;
	height: 180px;
	position: relative;
}

.p {
	width: 200px;
	height: 60px;
	position: absolute;
	font-size: 8px;
	text-align: left;
	border: 1px solid #BDBDBD;
	box-shadow: 0px 0px 5px #BDBDBD;
}

.p .exhibition_Subject {
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
	width: 190px;
	height: 20px;
	display: inline-block;
	font-size: 10px;
	cursor: pointer;
}

.p img {
	text-align: center;
	border-radius: 5px;
}

.v-line {
	border-left: 2px solid #BDBDBD;
	height: 12px;
	width: 20px;
	margin-left: 3px;
}
/*삭제버튼 css  */
.deletemyexhibition {
	float: right;
}

/*삭제버튼 css  */
#btnlikeexhitiondelete {
	background-color: #BDBDBD;
	border-radius: 10px;
	border: none;
	color: white;
	width: 60px;
	height: 25px;
	font-size: 10px;
	box-shadow: 0px 0px 5px #BDBDBD; border-radius: 10px;
}

#btnlikeexhitiondelete:hover {
	background-color: white;
	color: #BDBDBD;
	border: 1px solid #BDBDBD;
}

input[type=checkbox] {
	accent-color: #6E6E6E;
}

#like-content {
	box-shadow: 0px 0px 5px #BDBDBD;
	border-radius: 10px;
	width: 710px;
	margin-top: 60px;
	height: 380px;
}

#profile-management:hover {
	background-color: white;
	color: #BDBDBD;
	border: 1px solid #BDBDBD;
}
/*팝업 좋아요 리스트 css  */
.like-popup {
	margin-top: 3px;
	width: 201px;
	height: 250px;
	display: inline-flex;
	margin-right: 1px; /*아이템별 간격  */
	margin-left: 10px;
}

.like-popup img {
	filter: opacity(1);
}

.like-popup img:hover {
	filter: opacity(0.4);
}

.p .popup_Subject {
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
	width: 190px;
	height: 20px;
	display: inline-block;
	font-size: 10px;
	cursor: pointer;
}

/*삭제버튼 css  */
.deletemyexhibition {
	float: right;
}

/*삭제버튼 css  */
#btnlikepopupdelete {
	background-color: #BDBDBD;
	border-radius: 10px;
	border: none;
	color: white;
	width: 60px;
	height: 25px;
	font-size: 10px;
}

#btnlikepopupdelete:hover {
	background-color: white;
	color: #BDBDBD;
	border: 1px solid #BDBDBD;
}

input[type=checkbox] {
	accent-color: #6E6E6E;
}

#profile-management:hover {
	background-color: white;
	color: #BDBDBD;
	border: 1px solid #BDBDBD;
}
/*후기 css  */
#btnreviewdelete {
	background-color: #BDBDBD;
	border-radius: 10px;
	border: none;
	color: white;
	width: 60px;
	height: 25px;
	font-size: 10px;
}

#btnlikepopupdelete:hover {
	background-color: white;
	color: #BDBDBD;
	border: 1px solid #BDBDBD;
}

.wirte-review {
	margin-top: 30px;
	width: 201px;
	height: 200px;
	display: inline-flex;
	margin-right: 1px; /*아이템별 간격  */
	margin-left: 10px;
	border: 1px solid #BDBDBD;
	box-shadow: 0px 0px 5px #BDBDBD;
}

#review-content {
	box-shadow: 0px 0px 5px #BDBDBD;
	border-radius: 10px;
	width: 700px;
	margin-top: 10px;
	height: 320px;
}

.reviews {
	width: 200px;
	height: 180px;
	position: relative;
	font-size: 11px;
	border-radius: 10px;
	text-align: center;
	color: black;
}

.movedetailpage a {
	color: black;
	font-size: 10px;
	outline: none;
	text-decoration: underline;
}

.movedetailpage a:hover {
	color: #5d6361;
	font-size: 10px;
	outline: none;
	text-decoration: underline;
}

#membermenu {
	width: 720px;

	

	
}

#membermenu ul li {
	list-style: none;
	color: white;
	 background-color: white;
	float: left;
	line-height: 45px;
	vertical-align: middle;


	
	
}





#membermenu .menus {
	 text-decoration:none;  
	 color:#bdbdbd;
	 display:block; 
 	width: 235px; 
 	 font-size:12px; 
	 font-weight: bold;        
	
	
}


</style>
<script type="text/javascript">









	$(function() {
		//전체 선택하면 체크 박스 전체 선택 
		$("#allcheck").click(function() {

			//체크겂 얻기
			var chk = $(this).is(":checked");
			console.log(chk);

			//전체체크값을 아래의 체크에 일괄전달
			//prop :전달

			$(".del").prop("checked", chk)

		});

		$("#btnlikeexhitiondelete").click(function() {

			var cnt = $(".del:checked").length;
			//alert(cnt);

			if (cnt == 0) {
				alert("삭제하실 전시회를 선택해 주세요.");
				return;
			}

			$(".del:checked").each(function(i, elt) {
				//선택한 멤버의 num만 나오는지 확인 
				var num = $(this).attr("num");
				console.log(num);
				if (num>1) {
					
				} else {

				}

				//삭제 ajax
				$.ajax({

					type : "get",
					url : "/exhibition/mylikedelete",
					dataType : "html",
					data : {
						"exhibition_num" : num
					},
					success : function() {
						alert("'좋아요' 취소 되었습니다");
						location.reload();
					}
				});
			});
		});

	});


	
	
	
	
</script>


</head>
<body>

	
		<div class="myinfo-wrapper">
			<input type="hidden" name="member_num" value="${member_num}">
			<c:set var="loginok" value="${sessionScope.loginok}"></c:set>
			<br> <b>마이 페이지</b> 
			<div class="allmyinfo">


				<div class="profile-info">

					<div class="info-wrapper">
						<ul>
							<li style="font-size: 15px;">${dto.member_name}</li>
							<li style="font-size: 10px;">마음에 드는 전시를 놓치지 마세요.</li>
						</ul>

						<button type="button" id="profile-management"
							onclick="location.href='/member/myprofile'">프로필 관리</button>



					</div>
					<div class="image-wrapper">
						<c:if test="${dto.member_photo==null }">
							<img src="../image/logoimage.png" id="profile-img">
						</c:if>
						<c:if test="${dto.member_photo!=null }">
							<img alt="" src="../../photo/${dto.member_photo}"
								id="profile-img">
						</c:if>
					</div>
				</div>
			

				<nav id="membermenu">
					<ul>
						<li><a href="myinfo" class="menus" style="background-color: #bdbdbd; color: white; 
						box-shadow: 0px 0px 5px #BDBDBD; border-radius: 10px;" >전 시(${totalCount})</a></li>
						<li><a href="memberpopup" class="menus">팝업 스토어(${totalCounts})</a></li>
						<li><a href="memberreview" class="menus">후 기(${rtotalCounts})</a></li>
					</ul>
				</nav>


				
			

				<div id="exhibitiondata">
					
					<div id="like-content">
						
						<div id="exhibition">
						
						<div style="width: 700px; text-align: right;">

							<b style="font-size: 10px;">전체 선택:</b> <input type="checkbox"
								id="allcheck" style="height: 10px;"><br>
							<button type="button" id="btnlikeexhitiondelete">삭 제</button>
						</div>
					</div>
						
						<c:if test="${totalCount==0}">
							<br>
							<br>
							<br>
							<br>
							<br>
							<div style="width: 200px; margin: 0 auto;">
								<b style="font-size: 14px; color: #5d6361;">선택한 전시회가 없습니다.</b>
							</div>
						</c:if>
						<c:forEach var="e" items="${list}" varStatus="i">

							<div class="like-exhibition">
								<div class="pho">

									<input type="checkbox" class="del" num=${e.exhibition_num }
										style="float: right; height: 15px; position: relative; z-index: 1; top: 15px;">



									<input type="hidden" name="exhibition_num"
										value="${e.exhibition_num}"> <img
										src="${e.exhibition_image}"
										onclick="location.href='exhibition/exhibitiondetail/${e.exhibition_num}'"
										style="width: 200px; height: 180px; cursor: pointer;"> <br>
									<div class="p">
										<b class="exhibition_Subject"
											onclick="location.href='exhibition/exhibitiondetail/${e.exhibition_num}'">
											${e.exhibition_subject }</b><br> <b>${e.exhibition_location }</b><span
											class='v-line'><b> ${e.exhibition_price }</b></span>







									</div>
									<br>
								</div>

							</div>
						</c:forEach>
						<c:if test="${totalCount>0 }">
							<div style="width: 700px; text-align: center;">
								<ul class="pagination">
									<!-- 이전 -->
									<c:if test="${startPage>1 }">
										<li><a href="myinfo?currentPage=${startPage-1 }">이전</a></li>
									</c:if>

									<c:forEach var="pp" begin="${startPage }" end="${endPage }">
										<c:if test="${currentPage==pp }">
											<li class="active"><a href="myinfo?currentPage=${pp }"
												style="cursor: pointer; background-color: #BDBDBD; border-color: #BDBDBD;">${pp }</a>
											</li>
										</c:if>

										<c:if test="${currentPage!=pp }">
											<li><a href="myinfo?currentPage=${pp }"
												style="color: black;">${pp }</a></li>
										</c:if>

									</c:forEach>

									<!-- 다음 -->
									<c:if test="${endPage<totalPage }">
										<li><a href="myinfo?currentPage=${endPage+1 }">다음</a></li>
									</c:if>
								</ul>
							</div>
						</c:if>
					</div>
				</div>





			</div>

		</div>







</body>
</html>