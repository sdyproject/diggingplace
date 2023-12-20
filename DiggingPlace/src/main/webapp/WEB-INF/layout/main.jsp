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
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans&family=Noto+Sans+KR&display=swap" rel="stylesheet">
<style type="text/css">
#main-content{
width: 800px;
height: 250px;

margin: 0 auto;
margin-top: 100px; 
}
.exhibition{
width: 48%;
height: 100%;
float: left;
color: #6E6E6E;
text-align: center;
border-radius: 10px; 
color: gray;
filter: opacity(0.5) drop-shadow(0 0 0 gray);
box-shadow:0px 0px 5px #BDBDBD;
}
.exhibition:hover{
border: 1px solid gray;
color:gray;
filter: opacity(0.5) drop-shadow(0 0 0 gray);
box-shadow:0px 0px 8px gray;
}
.exhibition img{

width: 200px;
height: 100px;
 filter: opacity(0.5) drop-shadow(0 0 0 #6E6E6E); 
 transition: all 0.2s linear;
 overflow: hidden;
}
.exhibition:hover img {
  transform: scale(1.1);
}
.popup{

width: 48%;
height: 100%;
float: right;
text-align: center;
border-radius: 10px; 
color: gray;
filter: opacity(0.5) drop-shadow(0 0 0 gray);
box-shadow:0px 0px 5px #BDBDBD;
}
.popup:hover{
border: 1px solid gray;
color:gray;
filter: opacity(0.5) drop-shadow(0 0 0 gray);
box-shadow:0px 0px 8px gray;

			

}
.popup img{
width: 200px;
height: 100px;
margin: 0 atuo;
 filter: opacity(0.5) drop-shadow(0 0 0 #6E6E6E); 
transition: all 0.2s linear;
 overflow: hidden;
}
.popup:hover img {
  transform: scale(1.1);
}
.container {
width: 100%;
margin: 17px 0px 0px 0px;


}

#slider {
            opacity: 1;
            width: 100%;
            height: 300px;
          
           
        }


</style>
<script type="text/javascript">
var currentPic = 0;
var opacity = 1;
var numOfPics = 2;
var maxOpacity = 1;
var minOpacity = 1;
var speed = 20;
var timer = 4000;
var pics = [];
"../image/banner1-1.png";
pics[0] = "../image/banner1-1.png";
pics[1] = "../image/banner2.jpg";

function fadeOut(element, speed) {

    opacity -= 0.1

    element.style.opacity = opacity;

    if (opacity <= minOpacity) {

        return true;
    }

    setTimeout(fadeOut.bind(null, element, speed), speed);
}

function fadeIn(element, speed) {

    opacity += 0.1

    element.style.opacity = opacity;

    if (opacity >= maxOpacity) {

        return true;
    }

    setTimeout(fadeIn.bind(null, element, speed), speed);
}

function imageSliderOut() {

    var slider = document.getElementById("slider");

    fadeOut(slider, speed);

    currentPic++;

    if (currentPic === numOfPics) {

        currentPic = 0;
    }

    setTimeout("imageSliderIn()", (timer / 3));
}

function imageSliderIn() {

    var slider = document.getElementById("slider");

    slider.src = pics[currentPic];

    fadeIn(slider, speed);

    setTimeout("imageSliderOut()", timer);
}

window.onload = imageSliderIn;
</script>
</head>

<body>

<div class="container">
    <img src="../image/banner1-1.png" id="slider" alt="Image">
</div>


<div id="main-content">

<div class="exhibition" >
<br>

<b>전시회</b>
<br><br>
<a href="/exhibition/exhibitionlist">
<img alt="" src="../image/exhibition.png" > 
</a>
</div>

<div  class="popup" >
<br>
<b>팝업 스토어</b>
<br><br>
<a href="/popup/popuplist">
<img alt="" src="../image/popup.png" > 
</a>
</div>

</div>
</body>
</html>