<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Input Product Form</title>
    <meta charset="UTF-8">
    <link href="<c:url value="/css/main.css"/>" rel="stylesheet">
</head>
<body>
<h1>Enter Product Details</h1>
<form action="/product_save" method="post">
    <fieldset>
        <legend>Product Form</legend>
        <p>
            <label for="name">Name:</label>
            <input type="text" name="name" id="name" tabindex="1">
        </p>
        <p>
            <label for="description">Description:</label>
            <input type="text" name="description" id="description" tabindex="2">
        </p>
        <p>
            <label for="price">Price:</label>
            <input type="text" name="price" id="price" tabindex="3">
        </p>
        <p id="buttons">
            <input type="reset" name="reset" tabindex="4">
            <input type="submit" name="submit" id="submit" value="Add Product" tabindex="5">
        </p>
    </fieldset>
</form>
</body>
</html>
