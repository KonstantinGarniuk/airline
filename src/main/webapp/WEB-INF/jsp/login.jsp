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
  <div>
    <sf:form action="/login" method='POST'>
      <h2>Вход в систему</h2>
      <c:if test="${param.error!=null}">
        <h4 class="error">Неверный логин или пароль!</h4>
      </c:if>
      <div>
        <input name="username" type="text" placeholder="Логин" autofocus="true"/> <br>
        <input name="password" type="password" placeholder="Пароль"/> <br>
        <input type="submit" value="Войти"/>
        <h6><a href="/registration">Зарегистрироваться</a></h6>
      </div>
    </sf:form>
  </div>

</body>
</html>
