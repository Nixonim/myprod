<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<body>
<%@ include file="header.jsp" %>
<br>
<form action="/login" method = "post" enctype="multipart/form-data">
    <label for="email"><fmt:message key="page.login.email"/>:
    <input type="text" name="email" id="email" required>
</label>
<br>
    <label for="password"><fmt:message key="page.login.password"/>:
    <input type="password" name="password" id="password" required>
    </label>
    <br>
     <button type="submit"> <fmt:message key="page.login.submit.button"/></button>
</form>
</body>
</html>