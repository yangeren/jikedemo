<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: hanz
  Date: 18-2-13
  Time: 上午10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book Add Form</title>
</head>
<body>

<div id="globle">
    <form:form modelAttribute="book" action="save-book" method="post">
        <fieldset>
            <legend> Add a book </legend>
            <p>
                <label for="category">Category: </label>
                <form:select path="category.id" id="category" items="${categories}" itemLabel="name" itemValue="id" />
            </p>

            <p>
                <label for="title">Title:</label>
                <form:input path="title" id="title"/>
            </p>
            <p>
                <label for="author">Author:</label>
                <form:input path="author" id="author"/>
            </p>
            <p>
                <label for="isbn">ISBN:</label>
                <form:input path="isbn" id="isbn"/>
            </p>
            <p id="buttons">
                <input id="reset" type="reset" tabindex="4">
                <input id="submit" type="submit" tabindex="5" value="Add Book">
            </p>
        </fieldset>
    </form:form>
</div>
</body>
</html>
