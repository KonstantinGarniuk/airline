<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<html lang="en">
    <head>
        <jsp:include page="common/head.jsp"/>
        <link rel="stylesheet" href="css/slider.css">
        <script src="js/slider.js" defer></script>
    </head>
    <body class="page">
        <jsp:include page="common/header.jsp"/>
        <div>
            <div>Почему выбирают нас?</div>
            <div class="slider">
                <img src="images/1.jpg" alt="Image1" class="slide">
                <img src="images/2.jpg" alt="Image2" class="slide">
                <img src="images/3.jpg" alt="Image3" class="slide">
                <img src="images/4.jpg" alt="Image4" class="slide">
                <div id="slideText">Мы всегда рады Вас видеть</div>
            </div>
            <div class="sliderCtrls">
                <input class="sliderCtrl" name="selectedSlide" onclick="selectSlide()" type="radio" checked>
                <input class="sliderCtrl" name="selectedSlide" onclick="selectSlide()" type="radio" >
                <input class="sliderCtrl" name="selectedSlide" onclick="selectSlide()" type="radio" >
                <input class="sliderCtrl" name="selectedSlide" onclick="selectSlide()" type="radio" >
            </div>
        </div>
    </body>
</html>