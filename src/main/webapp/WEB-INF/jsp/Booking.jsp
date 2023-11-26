<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <jsp:include page="common/head.jsp"/>
        <link rel="stylesheet" href="css/booking.css">
        <script src="js/booking.js" defer></script>
    </head>
    <body>
        <jsp:include page="common/header.jsp"/>
        <sf:form action="/booking" method="GET" modelAttribute="routeRequest">
            <h2>Подбор рейса</h2>
            <table class="routeReqest">
                <tr>
                    <th>
                        <sf:label path="departureAirport">Окуда: </sf:label>
                    </th>
                    <th>
                        <sf:select id="departureAirportInput" path="departureAirport" multiple="single" onchange="setRoute()">
                            <sf:option selected="true" value="${routeRequest.departureAirport}" />
                            <sf:options items="${departureAirports}"/>
                        </sf:select>
                    </th>
                    <th>
                        <sf:label path="destinationAirport">Куда: </sf:label>
                    </th>
                    <th>
                        <sf:select id="destinationAirportInput" path="destinationAirport" multiple="single" onchange="setRoute()">
                            <sf:option selected="true" value="${routeRequest.destinationAirport}" />
                            <sf:options items="${destinationAirports}"/>
                        </sf:select>
                    </th>
                </tr>
                <tr>
                    <th>
                        <sf:label path="departureDate">Туда: </sf:label>
                    </th>
                    <th>
                        <sf:input path="departureDate" type="date" value="${routeRequest.departureDate}"/>
                    </th>
                    <th>
                        <sf:label path="returningDate">Обратно: </sf:label>
                    </th>
                    <th>
                        <sf:input path="returningDate" type="date" value="${routeRequest.returningDate}"/>
                    </th>
                </tr>
                <tr>
                    <th>
                        <input class="checkable" id="thwoDirrections" type="checkbox" onchange="updateReturnFlightsVisibility()" checked="true"/>
                        <label>Туда и обратно</label>
                    </th>
                    <th>
                        <sf:label path="seatsRequared">Мест: </sf:label>
                        <sf:input path="seatsRequared" type="number" min="1" max="10" value="${routeRequest.seatsRequared}"/>
                    </th>
                    <th>
                        
                    </th>
                    <th>
                        <input type="submit" value="Поиск"/> 
                    </th>
                </tr>
            </table>
        </sf:form>
        
        <sf:form action="/booking/confirm" method="GET" modelAttribute="bookingInfo">
            <sf:input type="hidden" path="seatsRequared" value="${routeRequest.seatsRequared}"/>
            <div id="directFligthChoose">
            <c:choose>
                <c:when test="${directFlights.isEmpty()}">
                    <h4>К сожалению прямых рейсов не найдено</h4>
                </c:when>
                <c:when test="${!directFlights.isEmpty()}">
                    <h4>Туда</h4>
                    <table class="fligthList" title="Туда">
                        <thead>
                            <th>Аэропорт отравления</th>
                            <th>Время вылета</th>
                            <th>Аэропорт прибытия</th>
                            <th>Время прибытия</th>
                            <th>Доступно мест</th>
                            <th>Цена</th>
                            <th>Статус рейса</th>
                            <th>Выбор рейса</th>
                        </thead>
                        <c:forEach items="${directFlights}" var="directFlight">
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
                                <th>
                                    ${directFlight.status}
                                </th>
                                <th>
                                    <sf:radiobutton class="checkable" path="directFlightId" value="${directFlight.id}"/>
                                </th>
                            </tr>
                        </c:forEach>
                    </table>
                </c:when>
            </c:choose>
            </div>
            <div id="returnFligthChoose">
            <c:choose>
                <c:when test="${returnFlights.isEmpty()}">
                    <h4>К сожалению обратных рейсов не найдено</h4>
                </c:when>
                <c:when test="${!returnFlights.isEmpty()}">
                    <h4>Обратно</h4>
                    <table class="fligthList" title="Обратно">
                        <thead>
                            <th>Аэропорт отравления</th>
                            <th>Время вылета</th>
                            <th>Аэропорт прибытия</th>
                            <th>Время прибытия</th>
                            <th>Доступно мест</th>
                            <th>Цена</th>
                            <th>Статус рейса</th>
                            <th>Выбор рейса</th>
                        </thead>
                        <c:forEach items="${returnFlights}" var="returnFlight">
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
                                <th>
                                    ${returnFlight.status}
                                </th>
                                <th>
                                    <sf:radiobutton class="checkable" path="returnFlightId" value="${returnFlight.id}"/>
                                </th>
                            </tr>
                        </c:forEach>
                    </table>
                </c:when>
            </c:choose>
            </div>
            <input type="submit" value="Бронировать">
        </sf:form>
    </body>
</html>