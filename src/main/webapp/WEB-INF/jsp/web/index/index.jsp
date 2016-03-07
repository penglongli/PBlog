<%@ include file="../include/namespace.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Home | Pelin的个人博客</title>
    <link rel="icon" href="${imageDomain}/pblog_icon.ico"/>
    <link href="${styleDomain}/index.less" type="text/less" rel="stylesheet/less"  />
    <link href="${cssPlugin}/font-awesome.min.css" rel="stylesheet"/>
    <script src="${jsDomain}/less.min.js"></script>
</head>
<body>
  <c:set var="active_line" value="1"/>
  <div id="wrapper">
     <%@ include file="../include/index_header.jsp"%>
     <div class="content">
        <div class="article-list">
            <%--<div class="article-item">
                <div class="article-header">
                    <a href="" class="article-category">[设计模式]</a>
                    <a href="" class="article-title">netty学习记录-3-socket浅析</a>
                </div>
                <div class="article-description">java的并发编程有几个概念原子性：即一个操作或者多个操作，要么全部执行并且执行的过程不会被任何因素...</div>
                <div class="article-metadata">
                    <span class="create-time"><i class="icon-calendar"></i>2016-03-10</span>
                    <div class="meta-tags">
                        <span><i class="icon-tag"></i>Java</span>
                        <span><i class="icon-tag"></i>设计模式</span>
                        <div class="clear-fix"></div>
                    </div>
                    <div class="clear-fix"></div>
                </div>
            </div>--%>
            <c:forEach var="articleInfo" items="${pagination.items}" varStatus="status">
                <div class="article-item">
                    <div class="article-header">
                        <a href="" class="article-category">[${articleInfo.categoryName}]</a>
                        <a href="" class="article-title">${articleInfo.title}</a>
                    </div>
                    <div class="article-description">${articleInfo.description}</div>
                    <div class="article-metadata">
                        <span class="create-time"><i class="icon-calendar"></i><fmt:formatDate value="${articleInfo.createTime}" pattern="yyyy-MM-dd" /></span>
                        <div class="meta-tags">
                            <span><i class="icon-tag"></i>Java</span>
                            <span><i class="icon-tag"></i>设计模式</span>
                            <div class="clear-fix"></div>
                        </div>
                        <div class="clear-fix"></div>
                    </div>
                </div>
            </c:forEach>
        </div>
        <div class="article-content">
            <%--<c:forEach var="articleInfo" items="${pagination.items}" varStatus="status">
                <div class="article-item">
                    <div class="article-item-title">
                        <span class="article-item-category"><a href="">[${articleInfo.categoryName}]</a></span>
                        <h1><a href="">${articleInfo.title}</a></h1>
                        <div style="clear: both;"></div>
                    </div>
                    <div class="article-item-content">${articleInfo.description}</div>
                    <div class="article-item-footer">
                        <div class="article-tag-list">
                            <c:forEach var="tag" items="${articleInfo.tags}" varStatus="status">
                                <span>${tag}</span>
                            </c:forEach>
                        </div>
                        <div class="article-info">
                            <div class="create-time">${articleInfo.createTime}</div>
                            <div class="read-num"><i class="icon-eye-open"></i><span class="icon-title">阅读</span><span>(${articleInfo.reviewNum})</span></div>
                            <div class="like-num"><i class="icon-heart-empty"></i><!-- icon-heart --><span class="icon-title">喜欢</span><span>(${articleInfo.likeNum})</span></div>
                            <div style="clear: both;"></div>
                        </div>
                        <div style="clear: both;"></div>
                    </div>
                </div>
            </c:forEach>--%>
        </div>
     </div>
  </div>
</body>
</html>
