<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: hanz
  Date: 18-2-12
  Time: 上午11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>
    Today is ${LocalDate.now()}
</h2>

<div>
    ${["Aster", "Carnation", "Rose"].stream().toList()}
    <li>${list[0]}</li>
    <%--<c:out value="value" [escapeXml="{true|false}] [default="defaultValue"]/>--%>
</div>

<div id="global">
    <form:form commandName="product" action="seven-save-product" method="post" enctype="multipart/form-data">
        <fieldset>
            <legend>Add a product</legend>
            <p>
                <label for="name">Product Name: </label>
                <form:input id="name" path="name" cssErrorClass="error"/>
                <form:errors path="name" cssClass="error"/>
            </p>
            <p>
                <label for="description">Description: </label>
                <form:input path="description" id="description"/>
            </p>
            <p>
                <label for="price"> Price: </label>
                <form:input path="price" id="price" cssErrorClass="error"/>
            </p>
            <p id="buttons">
                <input id="reset" type="reset" tabindex="4">
                <input id="submit" type="submit" tabindex="5" value="Add Product">
            </p>
        </fieldset>
    </form:form>
</div>


<h2>----------</h2>
<div>
    <h2>html file upload</h2>
    <form action="action" enctype="multipart/form-data" method="post">
        Select a file <input type="file" name="fieldName" multiple="multiple" />
        <input type="submit" value="Upload" />
    </form>
</div>

<div>
    <h2>html5 file upload</h2>
    <input type="file" name="fileName" multiple />
    <input type="submit" value="Upload">
</div>
<form method="post" action="/seven-save-product">
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

<p>
    ${pageContext.request}
</p>
<p>${pageContext.request.method}</p>
<p>${initParam.product}</p>
<p>${param.get("product")}</p>
</body>
</html>
