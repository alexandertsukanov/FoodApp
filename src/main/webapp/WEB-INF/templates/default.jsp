<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/static/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/static/css/bootstrap-theme.min.css">
    <link rel="stylesheet" type="text/css" href="/static/css/app.css">
    <title>FoodApp</title>
</head>
<body>
<header>
    <nav class="navbar navbar-default navbar-static-top">
        <a class="navbar-brand" href="/main">FoodApp</a>
        <ul class="nav navbar-nav">
            <li><a href="/main">Main</a></li>
            <li><a href="/food">Food</a></li>
            <li><a href="/category">Categories</a></li>
            <li><a href="/#">Users</a></li>
            <li><a href="/#">Orders</a></li>
            <li><a href="/#">History</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="/login">Log out <span class="glyphicon glyphicon-log-in"></span></a></li>
        </ul>
    </nav>
</header>
<sitemesh:write property="body" />
</body>
<script src="/static/js/jquery-2.2.4.min.js"></script>
<script src="/static/js/bootstrap.min.js"></script>
<script src="/static/js/app.js"></script>
</html>
