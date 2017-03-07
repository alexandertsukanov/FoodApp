<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="col-md-6 col-md-offset-3">
    <form:form method="post" modelAttribute="FoodForm" action="/edit/food/">
        <form:hidden path="id"></form:hidden>
        <label for="categoryId">Category</label>
        <form:select class="custom-select mb-2 mr-sm-2 mb-sm-0" id="categoryId" path="categoryId">
            <c:forEach var="categories" items="${categories}">
                <option value="${categories.id}" ${categories.id == FoodForm.categoryId ? 'selected="selected"' : ''}>${categories.name}</option>
            </c:forEach>
        </form:select>
        <div class="form-group">
            <label for="title">Title</label>
            <form:input class="form-control" id="title" path="title" type="text" required="true"/>
        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <form:input class="form-control" id="description" path="description" type="text" required="true"/>
        </div>
        <div class="form-group">
            <label for="ingredients">Ingredients</label>
            <form:input class="form-control" id="ingredients" path="ingredients" type="text" required="true"/>
        </div>
        <div class="form-group">
            <label for="calories">Calories</label>
            <form:input class="form-control" id="calories" path="calories" type="number" required="true"/>
        </div>
        <div class="form-group">
            <label for="weight">Weight</label>
            <form:input class="form-control" id="weight" path="weight" type="number" required="true"/>
        </div>
        <div class="form-group">
            <label for="price">Price</label>
            <form:input class="form-control" id="price" path="price" type="number" required="true"/>
        </div>
        <div class="form-group">
            <label for="imageLink">Image Link</label>
            <form:input class="form-control" id="imageLink" path="imageLink" type="text" required="true"/>
        </div>
        <form:button type="submit" class="btn btn-info btn-md">Save</form:button>
        <a href="/food" class="btn btn-info btn-md">Cancel</a>
    </form:form>
</div>