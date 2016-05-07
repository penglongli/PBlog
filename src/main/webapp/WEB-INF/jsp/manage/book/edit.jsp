<%@ include file="../include/namespace.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <title>文章管理</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link href="${cssDomain}/manage/book_edit.css" rel="stylesheet"/>
    <link rel="stylesheet" href="${cssPlugins}/font-awesome.min.css" />
    <script src="${jsPlugins}/jquery.min.js"></script>
    <script src="${jsPlugins}/marked.js"></script>
</head>
<body>
<c:set var="active_line" value="2"/>
<c:set var="first_nav" value="书评信息" />
<c:set var="first_url" value="${staticDomain}/manage/book/list" />


<c:set var="second_nav" value="书评添加" />
<c:set var="url" value="${staticDomain}/manage/article/add" />
<c:set var="submit_btn" value="发布书评" />
<%--<c:choose>
    <c:when test="${type == 1}">
        <c:set var="second_nav" value="书评添加" />
        <c:set var="url" value="${staticDomain}/manage/article/add" />
        <c:set var="submit_btn" value="发布书评" />
    </c:when>
    <c:when test="${type == 2}">
        <c:set var="second_nav" value="书评更新" />
        <c:set var="url" value="${staticDomain}/manage/article/update" />
        <c:set var="submit_btn" value="更新书评 />
    </c:when>
</c:choose>--%>

<div id="wrapper">
    <%@ include file="../include/index_man_header.jsp"%>
    <div class="content">
        <%@ include file="../include/index_second_header.jsp" %>
        <form action="#" method="post" id="evaluation-add-form">
            <div class="evaluation">
                <div class="evaluation-title">
                    <div class="evaluation-title-theme">书评标题</div>
                    <div class="evaluation-title-content">
                        <textarea rows="1" maxlength="120" name="title" autofocus="autofocus" placeholder="请输入文章标题，标题字数在120字以内"></textarea>
                    </div>
                </div>
                <div class="evaluation-body">
                    <div class="evaluation-body-theme">书评正文</div>
                    <textarea class="editor" name="content" title="文章正文"></textarea>
                </div>
                <div class="evaluation-operate">
                    <i class="icon-eye-open" id="pre"></i>
                    <button type="button" class="preview-evaluation">预览书评</button>
                    <div style="clear: both;"></div>
                </div>
                <div class="view"></div>
                <div class="description">
                    <div class="description-title">添加介绍</div>
                    <textarea class="editor" title="文章描述" name="introduction"></textarea>
                </div>
            </div>
        </form>
</body>

</html>