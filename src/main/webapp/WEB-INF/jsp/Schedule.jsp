<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Gremlin Air Lines</title>
        <link rel="shortcut icon" href="images/logo.ico">
        <link rel="stylesheet"    href="css/mainStyle.css">

        <script src="js/pageCtrl.js" defer></script>
    </head>
    <body>
        <div class="mainContainer">
            <jsp:include page="header.jsp"/>
            <form action="/schedule">
				<label for="from">Расписание с: </label>
				<input type="date" id="from" name="from">
				<label for="to">до: </label>
				<input type="date" id="to" name="to">
				<input type="submit" value="Принять">
			</form>
        </div>
        <div>
            <c:forEach items="${flights}" var="flight">
                ${flight.departureAirport} - ${flight.departureTime} - ${flight.departureGate} |
                ${flight.arrivalAirport} - ${flight.arrivalTime} - ${flight.arrivalGate} |
                ${flight.status} <br>
            </c:forEach>
        </div>
    </body>
</html>