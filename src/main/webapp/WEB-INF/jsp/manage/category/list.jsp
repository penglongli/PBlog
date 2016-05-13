<%@ include file="../include/namespace.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <title>书评管理</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link href="${cssDomain}/manage/pic_list.css" rel="stylesheet"  />
    <link rel="stylesheet" href="${staticDomain}/resources/assets/plugins/font-awesome.min.css" />
    <script src="${jsPlugins}/jquery.min.js"></script>
</head>
<body>

<c:set var="active_line" value="5" />
<c:set var="first_nav" value="分类管理" />
<c:set var="second_nav" value="分类列表" />
<c:set var="first_url" value="${staticDomain}/manage/category/list" />

<div id="wrapper">
    <%@ include file="../include/index_man_header.jsp"%>
    <div class="content">
        <%@ include file="../include/index_second_header.jsp" %>

    </div>
</div>

</body>
</html>