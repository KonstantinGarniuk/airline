<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
  <jsp:include page="common/head.jsp"/>
</head>

<body class="page">
    <jsp:include page="common/header.jsp"/>
    <c:url var="employeeStyleUrl"    value="/css/employee.css"   context="/"/>

    <link rel="stylesheet" href="${employeeStyleUrl}">
  <div>
        <sf:form action="/employee/hire" method='POST' modelAttribute="employeeInfo">

            <h2>Регистрация работника</h2>
            <table class="registration">
                <tr>
                    <th>
                        <sf:label path="firstName">Имя: </sf:label>
                    </th>
                    <th>
                        <sf:input path="firstName" type="text" placeholder="Имя"/>
                    </th>
                </tr>
                <tr>
                    <th>
                        <sf:label path="lastName">Фамилия: </sf:label>
                    </th>
                    <th>
                        <sf:input path="lastName" type="text" placeholder="Фамилия"/>
                    </th>
                </tr>
                <tr>
                    <th>
                        <sf:label path="dob">Дата рождения</sf:label>
                    </th>
                    <th>
                        <sf:input path="dob" type="date"/>
                    </th>
                </tr>
                <tr>
                    <th>
                        <sf:label path="pid">Идентификационный номер: </sf:label>
                    </th>
                    <th>
                        <sf:input path="pid" type="text" placeholder="ИД"/>
                    </th>
                </tr>
                <tr>
                    <th>
                        <sf:label path="userName">Логин: </sf:label>
                    </th>
                    <th>
                        <sf:input path="userName" type="text" placeholder="Логин" autofocus="true"/>
                    </th>
                </tr>
                <tr>
                    <th>
                        <sf:label path="password">Временный пароль: </sf:label>
                    </th>
                    <th>
                        <sf:input path="password" type="password" placeholder="Пароль"/>
                    </th>
                </tr>
                <tr>
                    <th>
                        <sf:label path="job">Должность: </sf:label>
                    </th>
                    <th>
                        <sf:select path="job" multiple="single">
                            <sf:options items="${jobs}"/>
                        </sf:select>
                    </th>
                </tr>
                <tr>
                    <th>
                        <sf:label path="salary">Зарплата: </sf:label>
                    </th>
                    <th>
                        <sf:input path="salary" type="number" min="0"/>
                    </th>
                    
                </tr>
                <tr>
                    <th>
                        <sf:label path="role">Роль: </sf:label>
                    </th>
                    <th>
                        <sf:select path="role" multiple="single">
                            <sf:options items="${roles}"/>
                        </sf:select>
                    </th>
                </tr>
            </table>
            <input type="submit" value="Зарегистрировать"/>
            <button type="button" onclick="cancelHiring()">Отмена</button>
        </sf:form>
  </div>

</body>
</html>