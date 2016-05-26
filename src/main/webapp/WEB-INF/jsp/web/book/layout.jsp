<%@ include file="../include/namespace.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="book">
    <div class="book-wrapper">
        <span class="cate-name">读书</span>
        <div class="book" ng-repeat="bookInfo in bookInfoList">
            <div class="book-banner">
                <img ng-src="{{ bookInfo.banner }}" />
            </div>
            <div class="book-detail">
                <div class="book-title"><a href="${staticDomain}/#/read/{{ bookInfo.slug }}">{{ bookInfo.title }}</a></div>
                <div class="book-operate">
                    <span><a href="/#/about">Pelin</a></span> / <span>{{ bookInfo.createTime | date:'MM-dd HH:mm' }}</span> / <span>阅读: {{ bookInfo.reviewNum }}</span>
                </div>
                <div class="book-intro">{{ bookInfo.introduction }}</div>
            </div>
            <div class="clear-fix"></div>
            <div class="book-read"><a href="">继续阅读 »</a></div>
        </div>
    </div>

    <div class="reading-book">
        <span class="cate-name">在读</span>
        <div class="book-list">
            <a href="{{ bookTable.bookUrl }}" ng-repeat="bookTable in bookTableList"><img ng-src="{{ bookTable.bookBanner }}" alt="{{ bookTable.bookName }}" /></a>
            <div class="clear-fix"></div>
        </div>
    </div>
</div>

<%@ include file="../include/footer.jsp"%>