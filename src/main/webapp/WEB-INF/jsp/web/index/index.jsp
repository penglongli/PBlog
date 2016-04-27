<%@ include file="../include/namespace.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link rel="stylesheet" href="${cssDomain}/index.css" />
<link rel="stylesheet" href="${cssPlugins}/highlight.min.css" />
<script type="text/javascript" src="${jsDomain}/highlight.min.js" ></script>

<div class="scroll-area">
    <div class="index-article-list">
        <div class="article-item" ng-repeat="article in articleList">
            <div class="article-header">
                <a href="${staticDomain}/#/category/{{ article.categorySlug }}" class="article-category">[{{ article.categoryName }}]</a>
                <a href="${staticDomain}/#/article/{{ article.articleSlug }}" class="article-title">{{ article.title }}</a>
            </div>
            <div class="article-description" ng-bind-html="article.description"></div>
            <div class="article-metadata">
                <span class="create-time"><i class="icon-calendar"></i>{{ article.createTime | date:'yyyy-MM-dd' }}</span>
                <div class="meta-tags" ng-repeat="tag in article.tags">
                    <span><i class="icon-tag"></i>{{ tag }}</span>
                    <div class="clear-fix"></div>
                </div>
                <div class="clear-fix"></div>
            </div>
        </div>
    </div>
    <div class="scroll-vertical">
        <div class="scroll-bar"></div>
    </div>
</div>

<div class="article-content">
    <div class="content-head">
        <h1><i class="icon-flag"></i> {{ f_article.title }}</h1>
        <div class="content-head-detail">
                    <span class="c_time">
                        <i class="icon-time"></i>
                        {{ f_article.createTime | date:'MMM d, EEEE' }}
                    </span>
            <span class="c_eye"><i class="icon-eye-open"></i> 427人阅读</span>
            <span class="c_name"><a href=""><i class="icon-list"></i> {{ f_article.categoryName }}</a></span>
            <span class="c_like"><a href=""><i class="icon-heart-empty"></i> 喜欢</a></span>
        </div>
    </div>
    <div class="content-body"></div>
</div>
