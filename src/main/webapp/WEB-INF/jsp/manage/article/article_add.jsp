<%@ include file="../include/namespace.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">
<head>
  <title>文章管理</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <link href="${styleDomain}/article_add.less" type="text/less" rel="stylesheet/less"  />
  <link href="${cssDomain}/font-awesome.min.css" rel="stylesheet"/>
  <script src="${jsDomain}/less.min.js"></script>
</head>
<body>
  <c:set var="active_line" value="2" />
  <div id="wrapper">
    <%@ include file="../include/index_man_header.jsp"%>
    <div class="content">
      <%@ include file="../include/index_second_header.jsp"%>

      <div class="article">
         <div class="article-title">
            <div class="article-title-theme">文章标题</div>
            <div class="article-title-content">
              <textarea rows="1" maxlength="120" id="topic_title" name="title" autofocus="autofocus" placeholder="请输入文章标题，标题字数在120字以内"></textarea>
            </div>
         </div>
         <div class="article-body">
            <div class="article-body-theme">文章正文</div>
            <div class="editor" contenteditable>

            </div>
         </div>
         <div class="article-category">

         </div>
         <div class="article-operate">

         </div>
      </div>
    </div>
  </div>
</body>
</html>
