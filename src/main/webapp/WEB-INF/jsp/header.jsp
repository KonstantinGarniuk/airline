<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<div class="logo"               onclick="showMainPage()"    ><!--img src="/images/header.jpg"--></div>
<div class="greetings"          onclick="showMainPage()"    >Добро пожаловать в Gremlin Air Lines</div>
<div class="menuItems schedule" onclick="showSchedulePage()">Расписание рейсов</div>
<div class="menuItems booking"  onclick="showBookingPage()" >Бронирование билетов</div>
<div class="menuItems charter"  onclick="showCharterPage()" >Заказ чартерных рейсов</div>
<div class="menuItems account"  onclick="showAccountPage()" >Личный кабинет</div>