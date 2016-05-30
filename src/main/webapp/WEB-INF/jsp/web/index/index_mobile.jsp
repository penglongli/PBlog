<%@ include file="../include/namespace.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=EDGE">
    <meta name="renderer" content="webkit">
    <meta name="format-detection" content="telephone=no">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <title>Home | Pelin的个人博客</title>
    <link rel="icon" href="${imageDomain}/pblog_icon.ico"/>
    <link href="${cssDomain}/mobile/article_mobile_list.css" rel="stylesheet"/>
    <link rel="stylesheet" href="${cssPlugins}/font-awesome.min.css" />
    <script src="${jsPlugins}/jquery.min.js" type="text/javascript"></script>
    <script src="${staticDomain}/resources/js/mobile/analytics.js" type="text/javascript"></script>
</head>
<body>
<div id="Wrapper">
    <%@ include file="../include/index_mobile_header.jsp"%>
    <div id="Content">
        <c:forEach var="articleInfo" items="${pagination.items}" varStatus="status">
            <div class="article">
                <h1><a href="${staticDomain}/article/${articleInfo.articleSlug}/detail">${articleInfo.title}</a></h1>
                <div class="article-detail">
                    <span class="time">
                        <fmt:setLocale value="en"/>
                        <fmt:formatDate type="date" value="${articleInfo.createTime}"/>
                    </span>
                    <span class="category"><a href="${staticDomain}/category/${articleInfo.categorySlug}/list">${articleInfo.categoryName}</a></span>
                </div>
                <div class="article-description">${articleInfo.description}</div>
                <span class="continue-read"><a href="${staticDomain}/article/${articleInfo.articleSlug}/detail">Read More</a></span>
            </div>
        </c:forEach>
    </div>
</div>
<script type="text/javascript" src="${jsDomain}/mobile/global_mobile.js"></script>
</body>
</html>
