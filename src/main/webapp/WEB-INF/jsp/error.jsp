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
    <h2 class="error">Something gone wrong!</h2>
    <!-- <p class="error">
        Failed URL: ${url} <br>
        Exception:  ${exception}
    </p> -->

</body>
</html>
