<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="wrapper-header">
  <%--<ul class="navbar">
    <a href="${staticDomain}/"><li <c:if test="${active_line == 1}">class="active"</c:if>>首页</li></a>
    <a href="${staticDomain}/archives"><li <c:if test="${active_line == 2}">class="active"</c:if>>归档</li></a>
    <a href="${staticDomain}/category"><li <c:if test="${active_line == 3}">class="active"</c:if>>分类</li></a>
    <a href=""><li <c:if test="${active_line == 4}">class="active"</c:if>>书评</li></a>
    <a href=""><li <c:if test="${active_line == 5}">class="active"</c:if>>日记</li></a>
    <a href=""><li <c:if test="${active_line == 6}">class="active"</c:if>>关于</li></a>
    <div style="clear: both;"></div>
  </ul>--%>
</div>
<div id="fix-left">
  <div class="author_info">
    <img src="${imageDomain}/author_header.png"/>
    <p>Pelin</p>
    <p class="motto"><i class="icon-heart"></i>&nbsp;&nbsp;我们在同一个时区，却有一辈子的时差。</p>
  </div>
  <div class="menu_bar">
    <ul>
      <a href=""><li <c:if test="${active_line == 1}">class="active"</c:if>><i class="icon-home"></i> 首页</li></a>
      <a href=""><li <c:if test="${active_line == 2}">class="active"</c:if>><i class="icon-calendar"></i> 归档</li></a>
      <a href=""><li <c:if test="${active_line == 3}">class="active"</c:if>><i class="icon-reorder"></i> 分类</li></a>
      <a href=""><li><i class="icon-book"></i> 读书</li></a>
      <a href=""><li><i class="icon-text-width"></i> 日记</li></a>
      <a href=""><li><i class="icon-info-sign"></i> 关于</li></a>
    </ul>
  </div>

  <%--<div class="f1" style="display:<c:if test="${active_line == 1}">block</c:if>;">
    <div class="site-state">
      <div class="site-state-blog">
        <a href="">
          <span class="site-state-item-count">8</span>
          <span class="site-state-item-name">博客</span>
        </a>
      </div>
      <div class="site-state-category">
        <a href="">
          <span class="site-state-item-count">8</span>
          <span class="site-state-item-name">分类</span>
        </a>
      </div>
      <div class="site-state-book">
        <a href="">
          <span class="site-state-item-count">8</span>
          <span class="site-state-item-name">书评</span>
        </a>
      </div>
      <div class="site-state-record">
        <a href="">
          <span class="site-state-item-count">8</span>
          <span class="site-state-item-name">日志</span>
        </a>
      </div>
      <div style="clear: both;"></div>
    </div>
    <div class="btn-link">
      <div class="btn-link-title">Links</div>
      <div class="btn-link-list">
        <ul>
          <li><a href=""><img src="${imageDomain}/zhihu.png"/><span>知乎</span></a></li>
          <li><a href=""><img src="${imageDomain}/csdn.png"/><span>CSDN</span></a></li>
          <li>
            <a href="">
              <svg aria-hidden="true" class="octicon octicon-mark-github" height="28" role="img" version="1.1" viewBox="0 0 16 16" width="28"><path d="M8 0C3.58 0 0 3.58 0 8c0 3.54 2.29 6.53 5.47 7.59 0.4 0.07 0.55-0.17 0.55-0.38 0-0.19-0.01-0.82-0.01-1.49-2.01 0.37-2.53-0.49-2.69-0.94-0.09-0.23-0.48-0.94-0.82-1.13-0.28-0.15-0.68-0.52-0.01-0.53 0.63-0.01 1.08 0.58 1.23 0.82 0.72 1.21 1.87 0.87 2.33 0.66 0.07-0.52 0.28-0.87 0.51-1.07-1.78-0.2-3.64-0.89-3.64-3.95 0-0.87 0.31-1.59 0.82-2.15-0.08-0.2-0.36-1.02 0.08-2.12 0 0 0.67-0.21 2.2 0.82 0.64-0.18 1.32-0.27 2-0.27 0.68 0 1.36 0.09 2 0.27 1.53-1.04 2.2-0.82 2.2-0.82 0.44 1.1 0.16 1.92 0.08 2.12 0.51 0.56 0.82 1.27 0.82 2.15 0 3.07-1.87 3.75-3.65 3.95 0.29 0.25 0.54 0.73 0.54 1.48 0 1.07-0.01 1.93-0.01 2.2 0 0.21 0.15 0.46 0.55 0.38C13.71 14.53 16 11.53 16 8 16 3.58 12.42 0 8 0z"></path></svg>
              <span>GitHub</span>
            </a>
          </li>
          <div style="clear: both;"></div>
        </ul>
      </div>
    </div>
    <div class="contact-me">
      <div class="contact-me-title">Contact Me</div>
      <div class="contact-me-info">
        <ul>
          <li>
            <i class="icon-envelope"></i>&nbsp;&nbsp;&nbsp;&nbsp;Email: <a href="mailto:penglong95.li@gmail.com" title="penglong95.li@gmail.com">Pelin</a>
          </li>
          <li>
            <i class="icon-road"></i>&nbsp;&nbsp;&nbsp;&nbsp;Address: <a href="#">北京市海淀区</a>
          </li>
          <li>
            <i class="icon-hand-right"></i>&nbsp;&nbsp;&nbsp;&nbsp;About: <a href="#">关于</a>
          </li>
        </ul>
      </div>
    </div>
    <div class="website-info">
      <div class="website-info-title">Website Info</div>
      <div class="website-info-list">
        <ul>
          <li>访问量：<span>123123次</span></li>
          <li>访问IP：<span>8000个</span></li>
        </ul>
      </div>
    </div>
  </div>--%>
</div>
