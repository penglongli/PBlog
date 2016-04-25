<%@ include file="../include/namespace.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link rel="stylesheet" href="${staticDomain}/resources/assets/css/archives/archives.css" />

<div class="archive-panel">
    <div class="archive-head">文章存档</div>
    <div class="archive-list">
        <ul>
            <li ng-repeat="archivesVO in archivesList">
                <a href="${staticDomain}/#/archives/{{ archivesVO.timeStamp | date:'yyyy-MM' }}" time="{{ archivesVO.timeStamp | date:'yyyy-MM' }}">
                   {{ archivesVO.timeStamp | date:'yyyy年MM月' }}
                </a>
                <span>({{ archivesVO.articleInfoVOList.length + 1 }})</span>
            </li>
        </ul>
    </div>
</div>
<div class="archive-article-list">
    <div class="article-item" ng-repeat="articleInfoVO in articleList">
        <div class="article-head">
                    <span class="article-title">
                        <a href="${staticDomain}/article/{{ articleInfoVO.articleSlug }}">{{ articleInfoVO.title }}</a>
                    </span>
        </div>
        <div class="article-metadata">
                    <span class="article-time">{{articleInfoVO.createTime | date:'yyyy-MM-dd HH:mm:ss' }}</span>
                    <span class="article-category">
                        <a href="${staticDomain}/category/{{ articleInfoVO.categorySlug }}">{{ articleInfoVO.categoryName }}</a>
                    </span>
            <span class="article-view"><i class="icon-eye-open"></i>阅读<span>(425)</span></span>
        </div>
        <div class="article-description" ng-bind-html="articleInfoVO.description"></div>
        <div class="article-footer">
            <div class="article-tags">
                <span class="tag" ng-repeat="tag in articleInfoVO.tags">{{ tag }}</span>
            </div>
            <div class="read-more">
                <a href="">继续阅读<i class=" icon-double-angle-right"></i></a>
            </div>
            <div class="clear-fix"></div>
        </div>
    </div>
</div>
<div class="clear-fix"></div>
