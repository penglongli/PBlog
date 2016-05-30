<%@ include file="../include/namespace.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=EDGE">
    <meta name="renderer" content="webkit">
    <meta name="format-detection" content="telephone=no">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <title>Read | Pelin的个人博客</title>
    <link rel="icon" href="${imageDomain}/pblog_icon.ico"/>
    <link href="${cssDomain}/mobile/read_mobile_detail.css" rel="stylesheet"/>
    <link href="${staticDomain}/resources/assets/plugins/font-awesome.min.css" rel="stylesheet"/>
    <script src="${jsPlugins}/jquery.min.js" type="text/javascript"></script>
    <script src="${staticDomain}/resources/js/mobile/analytics.js" type="text/javascript"></script>
</head>
<body>
<div id="Wrapper">
    <%@ include file="../include/index_mobile_header.jsp"%>
    <div id="Content">
        <div class="read-head">
            <h1><i class="icon-flag"></i> ${bookInfoVO.title}</h1>
        </div>
        <div class="read-content">${bookInfoVO.content}</div>
    </div>

</div>

<script type="text/javascript" src="${staticDomain}/resources/js/mobile/global_mobile.js"></script>
</body>
</html>