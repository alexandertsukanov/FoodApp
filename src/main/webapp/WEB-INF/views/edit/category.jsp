<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="col-md-6 col-md-offset-3">
    <form:form method="post" modelAttribute="CategoryForm" action="/edit/category/">
        <form:hidden path="id"></form:hidden>
        <div class="form-group">
            <label for="name">Name</label>
            <form:input class="form-control" id="name" path="name" type="text" required="true"/>
        </div>
        <div class="form-group">
            <label for="link">Small Image</label>
            <form:input class="form-control" id="link" path="link" type="text" required="true"/>
        </div>
        <div class="form-group">
            <label for="linkBig">Big Image</label>
            <form:input class="form-control" id="linkBig" path="linkBig" type="text" required="true"/>
        </div>
        <form:button type="submit" class="btn btn-info btn-md">Save</form:button>
        <a href="${pageContext.request.contextPath}/category" class="btn btn-info btn-md">Cancel</a>
    </form:form>
</div>