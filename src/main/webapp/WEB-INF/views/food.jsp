<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="btn-group">
    <a href="/edit/food/" class="btn btn-info">Add Food</a>

    <div class="btn-group">
        <button class="btn btn-info dropdown-toggle" type="button" data-toggle="dropdown">Select category
            <span class="caret"></span></button>
        <ul class="dropdown-menu">
            <li><a href="/food">All</a></li>
            <c:forEach var="categories" items="${categories}">
                <li><a href="/food/${categories.id}">${categories.name}</a></li>
            </c:forEach>
        </ul>
    </div>
</div>
<br>
<br>
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
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="food" items="${food}">
        <tr>
            <td>${food.id}</td>
            <td>${food.foodCategoryByCategoryId.name}</td>
            <td>${food.title}</td>
            <td>${food.description}</td>
            <td>${food.ingredients}</td>
            <td>${food.weight} g</td>
            <td>${food.price} $</td>
            <td><a href="${food.imageLink}"><img class="thumbnail" style="height: 50px; width: 60px"
                                                 src="${food.imageLink}"/></a></td>
            <td><a href="/edit/food/${food.id}" class="btn btn-info btn-md">Edit</a></td>
            <td><a href="/delete/food/${food.id}${cat}" class="btn btn-danger btn-md">X</a></td>


        </tr>
    </c:forEach>
</table>