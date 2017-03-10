<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="btn-group">
    <a href="/edit/category/" class="btn btn-info">Add Category</a>
</div>
<br>
<br>
<table class="table">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Image</th>
        <th>Big Image</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="categories" items="${categories}">
        <tr>
            <td>${categories.id}</td>
            <td>${categories.name}</td>
            <td><a href="${categories.link}"><img style="height: 60px; width: 60px"
                                                  src="${categories.link}"/></a></td>
            <td><a href="${categories.linkBig}"><img class="thumbnail" style="height: 60px; width: 70px"
                                                     src="${categories.linkBig}"/></a></td>
            <td><a href="/edit/category/${categories.id}" class="btn btn-info btn-md">Edit</a></td>
            <td><a href="/delete/category/${categories.id}" class="btn btn-danger btn-md">X</a></td>
        </tr>
    </c:forEach>
</table>