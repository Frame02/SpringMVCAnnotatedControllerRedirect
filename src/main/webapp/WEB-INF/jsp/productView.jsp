<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Saved Product Details</title>
    <meta charset="UTF-8">
    <link href="<c:url value="/css/main.css"/>" rel="stylesheet">
</head>
<body>
<h1>Saved Product Details</h1>
<table>
    <thead>
        <tr>
            <th>Field</th>
            <th>Value</th>
        </tr>
    </thead>
    <tbody>
    <tr>
        <td>Name</td>
        <td>${product.name}</td>
    </tr>
    <tr>
        <td>Description</td>
        <td>${product.description}</td>
    </tr>
    <tr>
        <td>Price</td>
        <td>$${product.price}</td>
    </tr>
    </tbody>
</table>

</body>
</html>
