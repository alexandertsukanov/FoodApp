<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="dropdown">
    <button class="btn btn-info dropdown-toggle" type="button" data-toggle="dropdown">Select category
        <span class="caret"></span></button>
    <ul class="dropdown-menu">
        <c:forEach var="categories" items="${categories}">
            <li><a>${categories.name}</a></li>
        </c:forEach>
    </ul>
</div>
<table class="table">
    <tr>
        <th>Id</th>
        <th>Category</th>
        <th>Title</th>
        <th>Description</th>
        <th>Ingredients</th>
        <th>Weight</th>
        <th>Price</th>
        <th>Image</th>
    </tr>
    </br>
    <c:forEach var="food" items="${food}">
        <tr>
            <td>${food.id}</td>
            <td>${food.categoryId}</td>
            <td>${food.title}</td>
            <td>${food.description}</td>
            <td>${food.ingredients}</td>
            <td>${food.weight} g</td>
            <td>${food.price} $</td>
            <td><a href="${food.imageLink}"><img class="thumbnail" style="height: 50px; width: 60px"
                                                 src="${food.imageLink}"/></a></td>
        </tr>
    </c:forEach>
</table>