<%@ include file="../include/namespace.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <title>Home | Pelin的个人博客</title>
    <link rel="icon" href="${imageDomain}/pblog_icon.ico"/>
    <link href="${styleDomain}/index.less" type="text/less" rel="stylesheet/less"  />
    <link href="${cssDomain}/font-awesome.min.css" rel="stylesheet"/>
    <script src="${jsDomain}/less.min.js"></script>
</head>
<body>
  <c:set var="active_line" value="1"/>
  <div id="wrapper">
     <%@ include file="../include/index_header.jsp"%>
     <div class="content">
        <div class="article-list">
            <c:forEach var="articleInfo" items="${pagination.items}" varStatus="status">
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
            </c:forEach>
        </div>
     </div>
  </div>
</body>
</html>
