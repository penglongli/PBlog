<%@ include file="../include/namespace.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>个人信息管理</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link href="${cssDomain}/manage/about_edit.css" rel="stylesheet"/>
    <script src="${jsPlugins}/jquery.min.js"></script>
    <script src="${jsPlugins}/marked.js"></script>
</head>
<body>
<c:set var="active_line" value="1" />
<c:set var="first_nav" value="个人信息管理" />


<div id="wrapper">
    <%@ include file="../include/index_man_header.jsp" %>
    <div class="content">
        <%@ include file="../include/index_second_header.jsp" %>

    </div>
</div>

</body>
</html>
