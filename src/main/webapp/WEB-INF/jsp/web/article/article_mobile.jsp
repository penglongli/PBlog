<%@ include file="../include/namespace.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=EDGE">
    <meta name="renderer" content="webkit">
    <meta name="format-detection" content="telephone=no">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <title>Article | Pelin的个人博客</title>
    <link rel="icon" href="${imageDomain}/pblog_icon.ico"/>
    <link href="${cssDomain}/mobile/article_mobile.css" rel="stylesheet"/>
    <link href="${staticDomain}/resources/assets/plugins/font-awesome.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="${staticDomain}/resources/assets/plugins/highlight.min.css" />
    <script src="${staticDomain}/resources/js/plugins/jquery.min.js" type="text/javascript"></script>
    <script src="${staticDomain}/resources/js/plugins/marked.js" type="text/javascript"></script>
    <script src="${staticDomain}/resources/assets/js/highlight.min.js" type="text/javascript"></script>
</head>
<body>
<div id="Wrapper">
    <%@ include file="../include/index_mobile_header.jsp"%>
    <div id="Content">
        <div class="article-head">
            <h1><i class="icon-flag"></i> ${articleInfo.title}</h1>
        </div>
        <div class="article-content"></div>
    </div>
</div>

<textarea style="display: none" class="md">${articleInfo.content}</textarea>
<script type="text/javascript" src="${staticDomain}/resources/js/mobile/global_mobile.js"></script>
<script type="text/javascript">
    var md = $(".md").val();
    $(".article-content").html(marked(md));

    $('pre code').each(function(i, block) {
        hljs.highlightBlock(block);
    });
</script>
</body>