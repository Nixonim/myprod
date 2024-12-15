<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<body>
<iframe width="560" height="315" src="https://www.youtube.com/embed/wwia7N1kTv4?si=oDHpkFe5uzaIiOoX?&autoplay=1&mute=1" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
<img src="/images/users/43.jpeg" alt="user imageeee">
<form action="/registration" method = "post" enctype="multipart/form-data">
    <label for="name">Name:
    <input type="text" name="name" id="name" required>
</label><br>
    <label for="birthday">Birthday:
        <input type="date" name="birthday" id="birthday">
    </label><br>
    <label for="imageId">image:
            <input type="file" name="image" id="imageId">
        </label><br>
    <label for="email">E-mail:
        <input type="text" name="email" id="email">
    </label><br>
    <label for="password">Password:
        <input type="password" name="password" id="password">
    </label><br>
<select name="genders" id="genders">
             <option value="MAN">MAN</option>
             <option value="WOMAN">WOMAN</option>
         </select><br>
 <input type="radio" name="roles" value="ADMIN">ADMIN <br>
 <input type="radio" name="roles" value="USER">USER <br>
 <br>

 <c:if test="${not empty requestScope.errors}">
 <h1 style ="color :red"> <c:forEach var="error" items="${requestScope.errors}">
 <span>${error.massage}</span>
</c:forEach>
</h1>
</c:if>
     <button type="submit"> Нажимай </button>
</form>
</body>
</html>