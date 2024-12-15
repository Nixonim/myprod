<%@page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<body>
<%@ include file="logout.jsp" %>
<div id="locale">
    <form action="/locale" method="post">
        <button type="submit" name="lang" value="ru_RU">RU</button>
        <button type="submit" name="lang" value="en_US">EN</button>
    </form>
</div>
<fmt:setLocale value="${sessionScope.lang != null ? sessionScope.lang: 'en_US'}"/>
<fmt:setBundle basename="translation"/>
</body>
</html>
