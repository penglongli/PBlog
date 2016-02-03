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
  <script src="${jsDomain}/jquery.min.js"></script>
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
            <%--<div class="editor" contenteditable></div>--%>
             <textarea class="editor"></textarea>
         </div>
         <div class="article-category">
            文章分类：<select>
                        <option>全部</option>
                        <option>测试1</option>
                        <option>测试1123123</option>
                        <option>测试1打发斯蒂芬</option>
                        <option>测试1123</option>
                        <option>测试1</option>
                    </select>
         </div>
         <div class="article-operate">
             <button class="preview-article">预览文章</button>
             <button class="publish-article">发布文章</button>
             <div style="clear: both;"></div>
         </div>

         <div class="view"></div>
      </div>
    </div>
  </div>
</body>

<script type="text/javascript">
    $(function(){
        $(".preview-article").click(function(){
            alert($(".editor").val());
            $.ajax({
                async: false,
                url: '${pageContext.request.contextPath}/preview/markdown',
                type: "POST",
                dataType: "json",
                context: $(this),
                beforeSend: function(xhr){
                    xhr.setRequestHeader("X-Requested-With","XMLHttpRequest");
                },
                data: {
                    content: $(".editor").val()
                },
                success: function(obj){
                    $(".view").html(obj.html);
                },
                error: function(status){
                    alert("请求失败");
                }

            });
        });
    })
</script>
</html>
