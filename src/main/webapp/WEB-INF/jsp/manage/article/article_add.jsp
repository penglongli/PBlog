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
        <form action="${staticDomain}/manage/article/add" method="post" id="article-form">
         <div class="article-title">
            <div class="article-title-theme">文章标题</div>
            <div class="article-title-content">
              <textarea rows="1" maxlength="120" id="topic_title" name="title" autofocus="autofocus" placeholder="请输入文章标题，标题字数在120字以内"></textarea>
            </div>
         </div>
         <div class="article-body">
            <div class="article-body-theme">文章正文</div>
            <textarea class="editor" name="content"></textarea>
         </div>
         <div class="article-category">
            <div class="category" name="categorySlug">
                文章分类：
                <select name="categorySlug">
                    <c:forEach  var="category" items="${categoryList}" varStatus="status">
                        <option value="${category.categoryId}">${category.title}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="tag">
                标签:<input type="text" name="tag" />
            </div>
            <div style="clear: both;"></div>
         </div>
         <div class="article-operate">
             <i class="icon-eye-open" id="pre"></i>
             <button type="button" class="preview-article">预览文章</button>
             <div style="clear: both;"></div>
         </div>
         <div class="view"></div>
         <div class="description">
            <div class="description-title">添加描述</div>
            <textarea class="editor" name="description"></textarea>
         </div>
         <div class="description-operate">
              <i class="icon-eye-open"></i>
              <button type="button" class="preview-description">预览描述</button>
         </div>
         <div class="description-view"></div>
         <div class="publish">
             <button type="button" class="publish-article"><i class="icon-fighter-jet"></i>发布文章</button>
         </div>
        </form>
      </div>
    </div>
  </div>
</body>

<script type="text/javascript">
    $(function(){
        $(".publish-article").click(function(){
            $("#article-form").submit();
        })

        $(".preview-article").click(function(){
            alert(2);
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
