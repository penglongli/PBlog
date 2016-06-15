<%@ include file="include/namespace.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <base href="/">
    <link rel="icon" href="${imageDomain}/pblog_icon.ico"/>
    <c:choose>
        <c:when test="${mo == 1}">
            <link rel="stylesheet" href="${cssDomain}/night-pc-main-4e6b1e8763.css" />
        </c:when>
        <c:otherwise>
            <link rel="stylesheet" href="${cssDomain}/day-pc-main-4b3b2e648a.css" />
        </c:otherwise>
    </c:choose>
    <link rel="stylesheet" href="${cssPlugins}/font-awesome.min.css" />
    <link rel="stylesheet" href="${cssPlugins}/highlight.min.css" />
    <script src="${jsAssets}/lib.min.js"></script>
    <script src="${jsAssets}/angular-plugins.min.js"></script>
    <script src="${jsAssets}/loading-bar.js"></script>
    <script src="${jsAssets}/client-js.min.js"></script>
    <script src="${jsAssets}/highlight.min.js" type="text/javascript"></script>
</head>
<body ng-app="pBlogApp" ng-controller="loadingBar">

<div id="wrapper">
    <div class="content" ng-view></div>

    <%@ include file="include/header.jsp" %>
</div>

</body>
</html>
