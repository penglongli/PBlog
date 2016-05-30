<%@ include file="include/namespace.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <base href="/">
    <link rel="icon" href="${imageDomain}/pblog_icon.ico"/>
    <link rel="stylesheet" href="${cssDomain}/${mo}-pc-main.min.css" />
    <link rel="stylesheet" href="${cssPlugins}/font-awesome.min.css" />
    <link rel="stylesheet" href="${cssPlugins}/highlight.min.css" />
    <script src="${jsAssets}/lib.min.js"></script>
    <script src="${jsAssets}/angular-plugins.min.js"></script>
    <script src="${jsAssets}/loading-bar.js"></script>
    <script src="${jsAssets}/client-js.min.js"></script>
    <script src="${jsAssets}/highlight.min.js" type="text/javascript"></script>
    <script>
        var _hmt = _hmt || [];
        (function() {
            var hm = document.createElement("script");
            hm.src = "//hm.baidu.com/hm.js?03296f04a7ca2b9ee9d16adfbd1e2c17";
            var s = document.getElementsByTagName("script")[0];
            s.parentNode.insertBefore(hm, s);
        })();
    </script>
</head>
<body ng-app="pBlogApp" ng-controller="loadingBar">

<div id="wrapper">
    <div class="content" ng-view></div>

    <%@ include file="include/header.jsp" %>
</div>


</body>
</html>
