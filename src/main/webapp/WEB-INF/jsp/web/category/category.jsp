<%@ include file="../include/namespace.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Category | Pelin的个人博客</title>
    <link rel="icon" href="${imageDomain}/pblog_icon.ico"/>
    <link href="${cssPlugin}/font-awesome.min.css" rel="stylesheet"/>
    <link href="${styleDomain}/category/category.less" type="text/less" rel="stylesheet/less"  />
    <script src="${jsPlugin}/less.min.js"></script>
</head>
<body>
    <c:set var="active_line" value="3"/>
    <div id="wrapper">
        <%@ include file="../include/index_header.jsp"%>
        <div class="content">
            <div class="archive-panel">
                <div class="archive-head">文章分类</div>
                <div class="archive-list">
                    <ul>
                        <c:forEach var="categoryInfoVO" items="${categoryInfoVOList}" varStatus="status">
                            <li>
                                <a href="${staticDomain}/category/${categoryInfoVO.slug}" <c:if test="${categoryInfoVO.slug eq slug}">class="active"</c:if>>${categoryInfoVO.categoryTitle}</a>
                                <span>(${fn:length(categoryInfoVO.articleInfoVOList)})</span>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
            <div class="article-list">
                <c:forEach var="articleInfoVO" items="${articleInfoVOList}" varStatus="status">
                    <div class="article-item">
                        <div class="article-head">
                            <span class="article-title"><a href="${staticDomain}/article/${articleInfoVO.articleSlug}">${articleInfoVO.title}</a></span>
                        </div>
                        <div class="article-metadata">
                            <span class="article-time"><fmt:formatDate value="${articleInfoVO.createTime}" pattern="yyyy-MM-dd HH:mm:ss" /></span>
                            <span class="article-category"><a href="${staticDomain}/category/${articleInfoVO.categorySlug}">${articleInfoVO.categoryName}</a></span>
                            <span class="article-view"><i class="icon-eye-open"></i>阅读<span>(425)</span></span>
                        </div>
                        <div class="article-description">转载地址：http://blog.csdn.net/lh3325251325/article/details/4767700 今天在网上下载了Aptana RadRails, build: 2.0.0.1256768894学习网页技术，但是在用其生成的HTML页面用IE打开时乱码（原来输入的是中文），于是在网上搜寻解决方法，虽然有很多关于Aptana乱码的帖子，但是大部分都是在aptana中编辑...</div>
                        <div class="article-footer">
                            <div class="article-tags">
                                <%--<span class="tag">Java</span>
                                <span class="tag">数据结构</span>--%>
                                <c:forEach var="tag" items="${articleInfoVO.tags}" varStatus="status">
                                    <span class="tag">${tag}</span>
                                </c:forEach>
                            </div>
                            <div class="read-more"><a href="${staticDomain}/article/${articleInfoVO.articleSlug}">继续阅读<i class=" icon-double-angle-right"></i></a></div>
                            <div class="clear-fix"></div>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <div class="clear-fix"></div>
        </div>
    </div>
</body>
</html>
