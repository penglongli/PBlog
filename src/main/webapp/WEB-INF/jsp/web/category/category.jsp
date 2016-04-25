<%@ include file="../include/namespace.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link rel="stylesheet" href="${staticDomain}/resources/assets/css/category/category.css" />

<div class="archive-panel">
    <div class="archive-head">文章分类</div>
    <div class="archive-list">
        <ul>
            <li ng-repeat="categoryInfoVO in categoryList">
                <a href="${staticDomain}/#/category/{{ categoryInfoVO.slug }}">{{ categoryInfoVO.categoryTitle }}</a>
                <span>({{ categoryInfoVO.articleInfoVOList.length }})</span>
            </li>
        </ul>
    </div>
</div>
<div class="article-list">
    <div class="article-item" ng-repeat="articleInfoVO in articleList">
        <div class="article-head">
            <span class="article-title">
                <a href="${staticDomain}/article/{{ articleInfoVO.articleSlug }}">{{ articleInfoVO.title }}</a>
            </span>
        </div>
        <div class="article-metadata">
            <span class="article-time">{{ articleInfoVO.createTime | date:'yyyy-MM-dd HH:mm:ss' }}</span>
            <span class="article-category">
                <a href="${staticDomain}/category/{{ articleInfoVO.categorySlug }}">{{ articleInfoVO.categoryName }}</a>
            </span>
            <span class="article-view"><i class="icon-eye-open"></i>阅读<span>(425)</span></span>
        </div>
        <div class="article-description">转载地址：http://blog.csdn.net/lh3325251325/article/details/4767700
            今天在网上下载了Aptana RadRails, build:
            2.0.0.1256768894学习网页技术，但是在用其生成的HTML页面用IE打开时乱码（原来输入的是中文），于是在网上搜寻解决方法，虽然有很多关于Aptana乱码的帖子，但是大部分都是在aptana中编辑...
        </div>
        <div class="article-footer">
            <div class="article-tags">
                <span class="tag" ng-repeat="tag in articleInfoVO.tags">{{ tag }}</span>
            </div>
            <div class="read-more">
                <a href="${staticDomain}/article/{{ articleInfoVO.articleSlug }}">继续阅读<i class=" icon-double-angle-right"></i></a>
            </div>
            <div class="clear-fix"></div>
        </div>
    </div>
</div>
<div class="clear-fix"></div>