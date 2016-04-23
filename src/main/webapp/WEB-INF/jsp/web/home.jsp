<%@ include file="include/namespace.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home | Pelin的个人博客</title>
    <link rel="icon" href="${imageDomain}/pblog_icon.ico"/>
    <%--<link rel="stylesheet" href="${staticDomain}/resources/assets/css/index.css" />--%>
    <link rel="stylesheet" href="${staticDomain}/resources/assets/css/include/index_global.css" />
    <link rel="stylesheet" href="${cssPlugin}/font-awesome.min.css" />
    <script src="${staticDomain}/resources/assets/js/lib.min.js"></script>
</head>
<body ng-app="pBlogApp">

<div id="wrapper">
    <div class="content" ng-view></div>

    <%@ include file="include/index_header.jsp" %>
</div>

<script src="${staticDomain}/resources/assets/js/angular-plugins.min.js"></script>
<script src="${staticDomain}/resources/assets/js/client-js.min.js"></script>
</body>
</html>
