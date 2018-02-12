<%--
  Created by IntelliJ IDEA.
  User: hanz
  Date: 18-2-12
  Time: 上午11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/save-product">
    <h1> Add Product
        <span>Please use this form to enter product details</span>
    </h1>
    <label>
        <span>Product Name:</span>
        <input id="name" type="text" name="name" placeholder="The complete product name">
    </label>
    <label>
        <span>Description:</span>
        <input id="description" type="text" name="description" placeholder="Product description">
    </label>
    <label>
        <span>Price: </span>
        <input id="price" name="price" type="number" step="any" placeholder="Product price in #.## format">
    </label>
    <label>
        <span>&nbsp: </span>
        <input type="submit">
    </label>
</form>

</body>
</html>
