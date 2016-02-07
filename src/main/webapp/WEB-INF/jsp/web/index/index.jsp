<%@ include file="../include/namespace.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <title>PBlog-Pelin的个人博客</title>
    <link href="${styleDomain}/index.less" type="text/less" rel="stylesheet/less"  />
    <link href="${cssDomain}/font-awesome.min.css" rel="stylesheet"/>
    <script src="${jsDomain}/less.min.js"></script>
</head>
<body>
  <c:set var="active_line" value="1"/>
  <div id="wrapper">
     <%@ include file="../include/index_header.jsp"%>
  </div>
</body>
</html>
