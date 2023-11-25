<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <jsp:include page="common/head.jsp"/>
        <link rel="stylesheet" href="css/schedule.css">
        <script src="js/schedule.js" defer></script>
    </head>
    <body>
        <jsp:include page="common/header.jsp"/>
        <form action="/schedule">
            <table class="scheduleForm">
                <tr>
                    <th>
                        <label for="from">Расписание с: </label>
                        <input type="datetime-local" name="from">
                    </th>
                    <th>
                        <label for="to">до: </label>
                        <input type="datetime-local" id="to" name="to">
                    </th>
                    <th>
                        <input type="submit" value="Принять">
                    </th>
                </tr>
            </table>
        </form>
        <table class="schedule">
            <thead>
                <th>Departure airport</th>
                <th>Departure time</th>
                <th>Departure gate</th>
                <th>Arrival airport</th>
                <th>Arrival time</th>
                <th>Arrival gate</th>
                <th>Status</th>
            </thead>
            <c:forEach items="${flights}" var="flight">
                <tr class="flightInfo">
                    <th>
                        ${flight.departureAirport}
                    </th>
                    <th>
                        ${flight.departureTime}
                    </th>
                    <th>
                        <sec:authorize access="hasRole('DISPATCHER')">
                            <select class="gateInput" onchange="setDepartureGate('${flight.id}', '${_csrf.token}')">
                                <c:if test="${flight.departureGate == ''}">
                                    <option value="null"></option>
                                </c:if>
                                <c:forEach items="${flight.availableDepartureGates}" var="departureGate">
                                    <c:choose>
                                        <c:when test="${flight.departureGate == departureGate}">
                                            <option value="${departureGate}" selected>${departureGate}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${departureGate}">${departureGate}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </sec:authorize>
                        <sec:authorize access="!hasRole('DISPATCHER')">
                            ${flight.departureGate}
                        </sec:authorize>
                    </th>
                    <th>
                        ${flight.arrivalAirport}
                    </th>
                    <th>
                        ${flight.arrivalTime}
                    </th>
                    <th>
                        <sec:authorize access="hasRole('DISPATCHER')">
                            <select class="gateInput" onchange="setArrivalGate('${flight.id}', '${_csrf.token}')">
                                <c:if test="${flight.arrivalGate == ''}">
                                    <option value="null"></option>
                                </c:if>
                                <c:forEach items="${flight.availableArrivalGates}" var="arrivalGate">
                                    <c:choose>
                                        <c:when test="${flight.arrivalGate == arrivalGate}">
                                            <option value="${arrivalGate}" selected>${arrivalGate}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${arrivalGate}">${arrivalGate}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>     
                        </sec:authorize>
                        <sec:authorize access="!hasRole('DISPATCHER')">
                            ${flight.arrivalGate}
                        </sec:authorize>
                    </th>
                    <th>
                        <sec:authorize access="hasRole('DISPATCHER')">
                            <select class="statusInput" onchange="setFlightStatus('${flight.id}', '${_csrf.token}')">
                                <c:forEach items="${statuses}" var="status">
                                    <c:choose>
                                        <c:when test="${flight.status == status.status}">
                                            <option value="${flight.status}" selected>${flight.status}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${status.status}">${status.status}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select> 
                        </sec:authorize>
                        <sec:authorize access="!hasRole('DISPATCHER')">
                            ${flight.status}
                        </sec:authorize>
                    </th>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>