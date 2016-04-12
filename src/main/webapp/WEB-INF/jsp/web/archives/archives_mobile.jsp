<%@ include file="../include/namespace.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=EDGE">
    <meta name="renderer" content="webkit">
    <meta name="format-detection" content="telephone=no">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <title>Archives | Pelin的个人博客</title>
    <link href="${styleDomain}/archives/archives_mobile.less" type="text/less" rel="stylesheet"/>
    <link href="${cssPlugin}/font-awesome.min.css" rel="stylesheet"/>
    <script type="text/javascript" src="${jsPlugin}/less.min.js"></script>
    <script type="text/javascript" src="${jsPlugin}/jquery.min.js"></script>
</head>
<body onload="loadFontSize()">
<div id="Wrapper">
    <%@ include file="../include/index_mobile_header.jsp"%>
    <div id="Content">
        <div class="archive-header"><i class="icon-ok-sign"></i>文章统计：<span>82篇</span></div>
        <div class="archive-title">文章存档</div>
        <div class="archive-timeline">
            <div class="timeline-left">
                <c:forEach var="archivesVO" items="${archivesVOList}" varStatus="status">
                    <div class="left-item">
                        <span>
                            <a href="${staticDomain}/archives/<fmt:formatDate value="${archivesVO.timeStamp}" pattern="yyyy-MM" />"
                               <c:if test="${archivesVO.timeStamp eq timeStamp}">class="active"</c:if> >
                                <fmt:formatDate value="${archivesVO.timeStamp}" pattern="yyyy年MM月"/>
                            </a>
                            (${fn:length(archivesVO.articleInfoVOList)})
                        </span>
                        <div class="time-point"></div>
                    </div>
                </c:forEach>
            </div>
            <div class="timeline-right">
                <%--<div class="right-item">顺丰速运 已收取快件</div>--%>
                <c:forEach var="archivesVO" items="${archivesVOList}" varStatus="status">
                    <div class="right-item">
                        <c:forEach var="articleVO" items="${archivesVO.articleInfoVOList}" varStatus="articleStatus">
                            <div class="article-item">
                                <span>04-11</span>
                                <a href="">${articleVO.title}</a>
                            </div>
                        </c:forEach>
                    </div>
                </c:forEach>
            </div>
            <div class="clear-fix"></div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="${jsPlugin}/global_mobile.js"></script>
</html>
