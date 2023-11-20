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
    <sf:form action="/registration" method='POST'>
      <!-- <c:if test="${params.error}">
        <div>ERROR</div>
      </c:if>
      <c:if test="${params.logout}">
        <div>LOGOUT SUCSSESFULL</div>
      </c:if> -->
      
        <h2>Регистрация пользователя</h2>
        <table class="registration">
            <tr>
                <th>
                    <label>Логин: </label>
                </th>
                <th>
                    <input name="username" type="text" placeholder="Логин" autofocus="true"/>
                </th>
            </tr>
            <tr>
                <th>
                    <label>Имя: </label>
                </th>
                <th>
                    <input name="firstName" type="text" placeholder="Имя"/>
                </th>
            </tr>
            <tr>
                <th>
                    <label>Фамилия: </label>
                </th>
                <th>
                    <input name="lastName" type="text" placeholder="Фамилия"/>
                </th>
            </tr>
            <tr>
                <th>
                    <label>Дата рождения</label>
                </th>
                <th>
                    <input name="dob" type="date"/>
                </th>
            </tr>
            <tr>
                <th>
                    <label>Идентификационный номер: </label>
                </th>
                <th>
                    <input name="pid" type="text" placeholder="Идентификационный номер"/>
                </th>
            </tr>
            <tr>
                <th>
                    <label>Пароль: </label>
                </th>
                <th>
                    <input name="password" type="password" placeholder="Пароль"/>
                </th>
            </tr>
            <tr>
                <th>
                    <label>Повторите пароль: </label>
                </th>
                <th>
                    <input class="registrationInput" name="password" type="password" placeholder="Повторите пароль"/>
                </th>
            </tr>
        </table>
        <input type="submit" value="Зарегистрироваться"/>
    </sf:form>
    <h6><a href="/login">Уже есть аккаунт</a></h6>
  </div>

</body>
</html>