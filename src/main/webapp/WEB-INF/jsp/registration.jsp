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
  <link rel="stylesheet" href="css/registration.css">
  <div>
    <sf:form action="/registration" method='POST' modelAttribute="createAccount">
      
        <h2>Регистрация пользователя</h2>
        <table class="registration">
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
                    <sf:input path="pid" type="text" placeholder="Идентификационный номер"/>
                </th>
            </tr>
            <tr>
                <th>
                    <sf:label path="password">Пароль: </sf:label>
                </th>
                <th>
                    <sf:input path="password" type="password" placeholder="Пароль"/>
                </th>
            </tr>
            <tr>
                <th>
                    <sf:label path="passwordConfirm">Повторите пароль: </sf:label>
                </th>
                <th>
                    <sf:input path="passwordConfirm" type="password" placeholder="Повторите пароль"/>
                </th>
            </tr>
        </table>
        <input type="submit" value="Зарегистрироваться"/>
    </sf:form>
    <h6><a href="/login">Уже есть аккаунт</a></h6>
  </div>

</body>
</html>