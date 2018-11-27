<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="ISO-8859-5" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional //EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Info about Request </title>
</head>
<body>


    <p>
        <%if (request.getAttribute("categoryList") != null) {
            out.println("<p>" + request.getAttribute("my_class").toString() + "</p>");
        }%>
    </p>
    <%--<c:forEach var="item" items="${categoryList}">--%>
        <%--<tr>--%>
            <%--<c:forEach var="column" items="${item}">--%>
                <%--<td>${column}</td>--%>
            <%--</c:forEach>--%>
        <%--</tr>--%>
    <%--</c:forEach>--%>
</body>
</html>
