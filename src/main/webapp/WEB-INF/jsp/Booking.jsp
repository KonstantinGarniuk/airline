<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <jsp:include page="common/head.jsp"/>
        <link rel="stylesheet" href="css/booking.css">
    </head>
    <body>
        <jsp:include page="common/header.jsp"/>
        <sf:form action="/" method='GET' modelAttribute="routeRequest">
            <h2>Подбор рейса</h2>
            <table class="routeReqest">
                <tr>
                    <th>
                        <sf:label path="departureAirport">Окуда: </sf:label>
                    </th>
                    <th>
                        <sf:input path="departureAirport"/>
                    </th>
                    <th>
                        <sf:label path="arrivalAirport">Куда: </sf:label>
                    </th>
                    <th>
                        <sf:input path="arrivalAirport"/>
                    </th>
                </tr>
                <tr>
                    <th>
                        <sf:label path="departureDate">Туда: </sf:label>
                    </th>
                    <th>
                        <sf:input path="departureDate" type="date"/>
                    </th>
                    <th>
                        <sf:label path="returningDate">Обратно: </sf:label>
                    </th>
                    <th>
                        <sf:input path="returningDate" type="date"/>
                    </th>
                </tr>
                <tr>
                    <th>
                        <input id="thwoDirrections" type="checkbox"/>
                        <label>Туда и обратно</label>
                    </th>
                    <th></th>
                    <th></th>
                    <th>
                        <input type="submit" value="Поиск"/> 
                    </th>
                </tr>
            </table>
        </sf:form>
        
    </body>
</html>