<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%--
  Created by IntelliJ IDEA.
  User: hanz
  Date: 18-2-13
  Time: 上午10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Book Form</title>
</head>
<body>
<div id="global">
    <c:url var="formAction" value="/update-book" />
    <form:form modelAttribute="book" action="${formAction}" method="post">
        <fieldset>
            <legend>Edit a book</legend>
            <form:hidden path="id"/>
            <p>
                <label for="category"> Category: </label>
                <form:select id="category" path="category.id" items="${categories}"
                 itemLabel="name" itemValue="id"/>
            </p>
            <p>
                <label for="title"> Title: </label>
                <form:input id="title" path="title"/>
            </p>
            <p>
                <label for="author"> Author: </label>
                <form:input path="author" id="author"/>
            </p>
            <p>
                <label for="isbn"> ISBN: </label>
                <form:input path="isbn" id="isbn"/>
            </p>

            <p id="buttons">
                <input id="reset" type="reset" tabindex="4"/>
                <input id="submit" type="submit" tabindex="5" value="Update Book"/>
            </p>
        </fieldset>
    </form:form>
</div>
</body>
</html>
