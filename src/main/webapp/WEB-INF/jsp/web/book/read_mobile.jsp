<%@ include file="../include/namespace.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=EDGE">
    <meta name="renderer" content="webkit">
    <meta name="format-detection" content="telephone=no">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <title>Books | Pelin的个人博客</title>
    <link rel="icon" href="${imageDomain}/pblog_icon.ico"/>
    <link href="${cssDomain}/mobile/read_mobile.css" rel="stylesheet"/>
    <link href="${staticDomain}/resources/assets/plugins/font-awesome.min.css" rel="stylesheet"/>
    <script src="${jsPlugins}/jquery.min.js" type="text/javascript"></script>
</head>
<body>
<div id="Wrapper">
    <%@ include file="../include/index_mobile_header.jsp"%>
    <div id="Content">
        <div class="read-header"><i class="fa fa-check-circle" aria-hidden="true"></i>书评统计：<span>1篇</span></div>
        <div class="read-title">书评列表</div>
        <div class="books-list">
            <c:forEach var="bookInfoVO" items="${bookInfoVOList}" varStatus="status" >
                <div class="book">
                    <div class="cover">
                        <img src="${bookInfoVO.banner}" />
                    </div>
                    <div class="info">
                        <h3 class="title"><a href="${staticDomain}/read/${bookInfoVO.slug}/detail">${bookInfoVO.title}</a></h3>
                        <div class="detail"><a href="${staticDomain}/about">李鹏龙</a><span>03-10 17:20</span></div>
                        <div class="intro">${bookInfoVO.introduction}</div>
                        <div class="actions">
                            <a href="${staticDomain}/read/${bookInfoVO.slug}/detail">阅读</a>
                            <span>8344阅读</span>
                        </div>
                    </div>
                    <div style="clear: both"></div>
                </div>
            </c:forEach>
        </div>

    </div>
</div>

<script type="text/javascript" src="${staticDomain}/resources/js/mobile/global_mobile.js"></script>
</body>
</html>