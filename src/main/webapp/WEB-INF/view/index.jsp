<%@ page import="by.grouptopprogers.entity.Category" %>
<%@ page import="by.grouptopprogers.entity.Product" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="ISO-8859-5" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional //EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Store </title>
</head>
<body>
<table border="1">
    <%for (Category category : (ArrayList<Category>) request.getAttribute("categoryList")) {%>
    <tr>
        <td><%=category.getNameCategory()%>
        </td>
    </tr>
    <p>
        <tr>
            <td>ID</td>
            <td>Type</td>
            <td>Company</td>
            <td>Country</td>
            <td>Purpose</td>
            <td>Value</td>
            <td>Currency</td>
        </tr>
    </p>
    <%for (Product product : category.getListProducts()) {%>
    <p>

        <tr>
            <td><%=product.getId()%>
            </td>
            <td><%=product.getType()%>
            </td>
            <td><%=product.getCompany()%>
            </td>
            <td><%=product.getCountry()%>
            </td>
            <td><%=product.getPurpose()%>
            </td>
            <td><%=product.getCost().getValue()%>
            </td>
            <td><%=product.getCost().getCurrency()%>
            </td>
        </tr>
    </p>
    <%--<br>--%>
    <%}%>
    <%}%>
</table>

</body>
</html>
