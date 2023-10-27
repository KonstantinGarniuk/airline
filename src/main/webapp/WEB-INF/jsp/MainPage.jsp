<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Gremlin Air Lines</title>
        <link rel="shortcut icon" href="images/logo.ico">

        <link rel="stylesheet"    href="css/mainStyle.css">
        <link rel="stylesheet"    href="css/pages.css">
        <link rel="stylesheet"    href="css/slider.css">

        <script src="js/pageCtrl.js" defer></script>
        <script src="js/slider.js"   defer></script>
    </head>
    <body>
        <div class="mainContainer">
            <jsp:include page="header.jsp"/>
            <div class="orderInfo">
                <div class="page" id="mainPage">
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
            </div>
        </div>
    </body>
</html>