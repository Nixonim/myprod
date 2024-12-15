<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<body>
<%@ include file="header.jsp" %>
<h1> Список компаний </h1>
<ul>
<c:forEach var="company" items="${requestScope.companies}">
<li>
<a href= "/employees?companyId=${company.id}">${company.name}</a>
</li>
</c:forEach>
</ul>
<%@ include file="foot.jsp" %>
</body>
</html>