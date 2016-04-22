<%@ include file="include/namespace.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home | Pelin的个人博客</title>
    <link rel="icon" href="${imageDomain}/pblog_icon.ico"/>
    <link rel="stylesheet" href="${cssDomain}/index.css" />
    <link rel="stylesheet" href="${cssPlugin}/font-awesome.min.css" />
    <script src="${jsPlugin}/jquery.min.js"></script>
    <script src="${jsPlugin}/marked.js"></script>
</head>
<body ng-app="pBlogApp">

<div id="wrapper">
    <%@ include file="include/index_header.jsp" %>

    <div class="content" ng-view></div>
</div>

<script src="${jsPlugin}/angular.min.js"></script>
<script src="${jsPlugin}/angular-animate.min.js"></script>
<script src="${jsPlugin}/angular-sanitize.min.js"></script>
<script src="${jsPlugin}/angular-route.min.js"></script>
<script src="${jsDomain}/app.js"></script>
<script src="${jsDomain}/services.js"></script>
<script src="${jsDomain}/controllers/IndexController.js"></script>
<script src="${jsDomain}/filters.js"></script>
<script src="${jsDomain}/directives.js"></script>


</body>
</html>
