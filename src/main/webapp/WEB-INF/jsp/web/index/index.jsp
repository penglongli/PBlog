<%@ include file="../include/namespace.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Home | Pelin的个人博客</title>
    <link rel="icon" href="${imageDomain}/pblog_icon.ico"/>
    <link href="${styleDomain}/index.less" type="text/less" rel="stylesheet/css"  />
    <link href="${cssPlugin}/font-awesome.min.css" rel="stylesheet"/>
    <script type="text/javascript" src="${jsPlugin}/less.min.js"></script>
    <script type="text/javascript" src="${jsPlugin}/jquery.min.js"></script>
    <script type="text/javascript" src="${jsPlugin}/marked.js"></script>
</head>
<body>
  <c:set var="active_line" value="1"/>
  <div id="wrapper">
     <%@ include file="../include/index_header.jsp"%>
     <div class="content">
        <div class="scroll-area">
           <div class="article-list">
               <c:forEach var="articleInfo" items="${pagination.items}" varStatus="status">
                   <div class="article-item">
                       <div class="article-header">
                           <a href="${staticDomain}/category/${articleInfo.categorySlug}" class="article-category">[${articleInfo.categoryName}]</a>
                           <a href="${staticDomain}/article/${articleInfo.articleSlug}" class="article-title">${articleInfo.title}</a>
                       </div>
                       <div class="article-description">${articleInfo.description}</div>
                       <div class="article-metadata">
                           <span class="create-time"><i class="icon-calendar"></i><fmt:formatDate value="${articleInfo.createTime}" pattern="yyyy-MM-dd" /></span>
                           <div class="meta-tags">
                               <c:forEach var="tag" items="${articleInfo.tags}" varStatus="status">
                                    <span><i class="icon-tag"></i>${tag}</span>
                               </c:forEach>
                               <div class="clear-fix"></div>
                           </div>
                           <div class="clear-fix"></div>
                       </div>
                   </div>
               </c:forEach>
           </div>
           <div class="scroll-vertical">
               <div class="scroll-bar"></div>
           </div>
        </div>
        <div class="article-content">
            <div class="content-head">
                <h1><i class="icon-flag"></i> ${firstArticle.title}</h1>
                <div class="content-head-detail">
                    <span class="c_time"><i class="icon-time"></i> <fmt:formatDate value="${firstArticle.createTime}" pattern="MMMM d, EEEE" /> </span>
                    <span class="c_eye"><i class="icon-eye-open"></i> 427人阅读</span>
                    <span class="c_name"><a href=""><i class="icon-list"></i> ${firstArticle.categoryName}</a></span>
                    <span class="c_like"><a href=""><i class="icon-heart-empty"></i> 喜欢</a></span>
                </div>
            </div>
            <div class="content-body"></div>
        </div>
     </div>
  </div>

  <input type="hidden" value="${firstArticle.content}" class="markdown-content" />
  <script type="text/javascript" src="${jsPlugin}/SliderBar.js"></script>
  <script type="text/javascript">
      var $$ = function(func){
          if (document.addEventListener) {
              window.addEventListener("load", func, false);
          }
          else if (document.attachEvent) {
              window.attachEvent("onload", func);
          }
      }

      $(function(){
          loadSlider()
      });

      function loadSlider(){
          var $container = $(".scroll-area");
          var $content = $(".article-list");
          var $slideArea = $(".scroll-vertical");
          var $bar = $(".scroll-bar");
          var $markdown = $(".markdown-content");
          var $articleContent = $(".content-body");

          $articleContent.html(marked($markdown.val()));

          $container.slider({
                container: $container,
                content: $content,
                slideArea: $slideArea,
                bar: $bar
          });
     }
  </script>
</body>
</html>
