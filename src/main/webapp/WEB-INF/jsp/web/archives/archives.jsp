<%@ page import="java.util.Date" %>
<%@ include file="../include/namespace.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Archives | Pelin的个人博客</title>
    <link rel="icon" href="${imageDomain}/pblog_icon.ico"/>
    <link href="${cssPlugin}/font-awesome.min.css" rel="stylesheet"/>
    <link href="${styleDomain}/archives/archives.less" type="text/less" rel="stylesheet/less"  />
    <script src="${jsPlugin}/less.min.js"></script>
</head>
<body>
    <c:set var="active_line" value="2"/>
    <div id="wrapper">
      <%@ include file="../include/index_header.jsp"%>
      <div class="content">
          <div class="archive-panel">
              <div class="archive-head">文章存档</div>
              <div class="archive-list">
                <ul>
                    <c:forEach var="archivesVO" items="${archivesVOList}" varStatus="status">
                        <li>
                            <a href="${staticDomain}/archives/<fmt:formatDate value="${archivesVO.timeStamp}" pattern="yyyy-MM" />" <c:if test="${archivesVO.timeStamp eq timeStamp}">class="active"</c:if> >
                                <fmt:formatDate value="${archivesVO.timeStamp}" pattern="yyyy年MM月" />
                            </a>
                            <span>(${fn:length(archivesVO.articleInfoVOList)})</span>
                        </li>
                    </c:forEach>
                </ul>
              </div>
          </div>
          <div class="article-list">
              <c:forEach var="articleInfoVO" items="${articleInfoVOList}" varStatus="status">
                  <div class="article-item">
                      <div class="article-head">
                          <span class="article-title"><a href="${staticDomain}/article/${articleInfoVO.articleSlug}">${articleInfoVO.title}</a></span>
                      </div>
                      <div class="article-metadata">
                          <span class="article-time"><fmt:formatDate value="${articleInfoVO.createTime}" pattern="yyyy-MM-dd HH:mm:ss" /></span>
                          <span class="article-category"><a href="${staticDomain}/category/${articleInfoVO.categorySlug}">${articleInfoVO.categoryName}</a></span>
                          <span class="article-view"><i class="icon-eye-open"></i>阅读<span>(425)</span></span>
                      </div>
                      <div class="article-description">${articleInfoVO.description}</div>
                      <div class="article-footer">
                          <div class="article-tags">
                              <c:forEach var="tag" items="${articleInfoVO.tags}" varStatus="status">
                                    <span class="tag">${tag}</span>
                              </c:forEach>
                          </div>
                          <div class="read-more"><a href="">继续阅读<i class=" icon-double-angle-right"></i></a></div>
                          <div class="clear-fix"></div>
                      </div>
                  </div>
              </c:forEach>
          </div>
          <div class="clear-fix"></div>
      </div>
    </div>
</body>
</html>
