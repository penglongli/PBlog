<%@ include file="../include/namespace.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="bookDetail">
    <div class="book-content">
        <div class="content-head">
            <h1><i class="icon-flag"></i> {{ bookInfoVO.title }}</h1>
            <div class="content-head-detail">
                        <span class="c_time">
                            <i class="icon-time"></i>
                            {{ bookInfoVO.createTime | date:'MMM d, EEEE' }}
                        </span>
                <span class="c_eye"><i class="icon-eye-open"></i> {{ bookInfoVO.reviewNum }}次点击</span>
                <span class="c_like"><a href=""><i class="icon-heart-empty"></i> 喜欢</a></span>
            </div>
        </div>
        <div class="content-body"></div>
        <div class="content-nav">
            <span>> <a href="#">星野道夫的北地之梦</a></span>
            <img src="https://img3.doubanio.com/mpic/s28481841.jpg" />
        </div>
        <div class="clear-fix"></div>
    </div>
</div>