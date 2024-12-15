<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<body>
<c:if test="${not empty sessionScope.user}">
<form action="/logout" method = "post" enctype="multipart/form-data">
    <h1 style ="color :red">
    <span><button type="submit"> logout </button></span>
   </h1>
   </c:if>
</form>
</body>
</html>