<%@ include file="../include/namespace.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link rel="stylesheet" href="${cssPlugins}/highlight.min.css" />

<div id="article">
    <div class="article-content">
        <div class="content-head">
            <h1><i class="icon-flag"></i> {{ articleVO.title }}</h1>
            <div class="content-head-detail">
                        <span class="c_time">
                            <i class="icon-time"></i>
                            {{ articleVO.createTime | date:'MMM d, EEEE' }}
                        </span>
                <span class="c_eye"><i class="fa fa-eye" aria-hidden="true"></i> {{articleVO.reviewNum}}次点击</span>
                <span class="c_name"><a href=""><i class="fa fa-align-justify" aria-hidden="true"></i> {{ articleVO.categoryName }}</a></span>
                <span class="c_like"><a href=""><i class="fa fa-heart-o" aria-hidden="true"></i> 喜欢</a></span>
            </div>
        </div>
        <div class="content-body"></div>
        <div class="content-nav">
            <div class="nav-heading">文章目录</div>
            <div class="nav-list"></div>
        </div>
        <div class="clear-fix"></div>
    </div>

    <%@ include file="../include/footer.jsp"%>
</div>