<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>
<html>
    <head>
        <title>error</title>
    </head>
    <body>
        Message:${exception.getMessage()}<br/>
        Status code:${pageContext.errorData.statusCode}<br/>  
        <!--
        <c:forEach var="trace" items="${pageContext.exception.stackTrace}">
            ${trace}
        </c:forEach>
        -->
    </body>
</html>