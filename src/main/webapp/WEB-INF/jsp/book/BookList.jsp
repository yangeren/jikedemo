<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>--%>
<%--
  Created by IntelliJ IDEA.
  User: hanz
  Date: 18-2-13
  Time: 上午10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BookList</title>
</head>
<body>

<div id="golbal">
    <h1>Book List</h1>
    <a href="<c:url value="/input-book"/>">Add Book</a>

    <table>
        <tr>
            <th>Category</th>
            <th>Title</th>
            <th>Author</th>
            <th>Price</th>
            <th>&nbsp:</th>
        </tr>
        <c:forEach items="${books}" var="book">
            <tr>
                <td>${book.category.name}</td>
                <td>${book.title}</td>
                <td>${book.isbn}</td>
                <td>${book.author}</td>
                <td>${book.price}</td>
                <td><a href="edit-book/${book.id}">Edit</a> </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
