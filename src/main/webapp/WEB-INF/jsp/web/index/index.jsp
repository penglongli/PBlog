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
    <script type="text/javascript" src="${jsDomain}/less.min.js"></script>
    <script type="text/javascript" src="${jsDomain}/jquery.min.js"></script>
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
                           <a href="" class="article-category">[${articleInfo.categoryName}]</a>
                           <a href="" class="article-title">${articleInfo.title}</a>
                       </div>
                       <div class="article-description">${articleInfo.description}</div>
                       <div class="article-metadata">
                           <span class="create-time"><i class="icon-calendar"></i><fmt:formatDate value="${articleInfo.createTime}" pattern="yyyy-MM-dd" /></span>
                           <div class="meta-tags">
                               <span><i class="icon-tag"></i>Java</span>
                               <span><i class="icon-tag"></i>设计模式</span>
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
        <div class="article-content">${content}</div>
     </div>
  </div>
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

      $$(function(){
          loadSlider()
      })

      function loadSlider(){
         var $container = $(".scroll-area");
         var $content = $(".article-list");
         var $slideArea = $(".scroll-vertical");
         var $bar = $(".scroll-bar");

          console.log($container.height());
          console.log($content.height())

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
