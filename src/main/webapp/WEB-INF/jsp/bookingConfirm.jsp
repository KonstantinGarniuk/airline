<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <jsp:include page="common/head.jsp"/>
        <c:url var="bookingStyleUrl" value="/css/booking.css" context="/"/>
        <c:url var="bookingJsUrl"    value="/js/booking.js"   context="/"/>

        <link rel="stylesheet" href="${bookingStyleUrl}">
        <script src="${bookingJsUrl}" defer></script>
    </head>
    <body>
        <jsp:include page="common/header.jsp"/>
        <sf:form action="/booking/confirm" method="POST" modelAttribute="bookingInfo">
            <sf:input type="hidden" path="directFlightId" value="${bookingInfo.directFlightId}"/>
            <sf:input type="hidden" path="returnFlightId" value="${bookingInfo.returnFlightId}"/>
            <sf:input type="hidden" path="seatsRequared" value="${bookingInfo.seatsRequared}"/>
            <h2>Забронировать по ${bookingInfo.seatsRequared} билета на рейсы:</h2>
            <table class="fligthList">
                <thead>
                    <th>Аэропорт отравления</th>
                    <th>Время вылета</th>
                    <th>Аэропорт прибытия</th>
                    <th>Время прибытия</th>
                    <th>Доступно мест</th>
                    <th>Цена</th>
                </thead>
                <tr class="flightInfo">
                    <th>
                        ${directFlight.departureAirport}
                    </th>
                    <th>
                        ${directFlight.departureTime}
                    </th>
                    <th>
                        ${directFlight.destinationAirport}
                    </th>
                    <th>
                        ${directFlight.arrivalTime}
                    </th>
                    <th>
                        ${directFlight.seatsAvailable}
                    </th>
                    <th>
                        ${directFlight.price}
                    </th>
                </tr>
                <tr class="flightInfo">
                    <th>
                        ${returnFlight.departureAirport}
                    </th>
                    <th>
                        ${returnFlight.departureTime}
                    </th>
                    <th>
                        ${returnFlight.destinationAirport}
                    </th>
                    <th>
                        ${returnFlight.arrivalTime}
                    </th>
                    <th>
                        ${returnFlight.seatsAvailable}
                    </th>
                    <th>
                        ${returnFlight.price}
                    </th>
                </tr>
            </table>
            <input type="submit" value="Забронировать"/>
            <input type="button" value="Отмена" onclick="cancelBooking()"/>
        </sf:form>
    </body>
</html>