<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="wrapper-header">
  <ul class="navbar">
    <li <c:if test="${active_line == 1}">class="active"</c:if>><a href="${staticDomain}/">Home</a></li>
    <li <c:if test="${active_line == 2}">class="active"</c:if>><a href="${staticDomain}/archives">Archives</a></li>
    <li <c:if test="${active_line == 3}">class="active"</c:if>><a href="${staticDomain}/category">Category</a></li>
    <li <c:if test="${active_line == 4}">class="active"</c:if>><a href="">Book Review</a></li>
    <li <c:if test="${active_line == 5}">class="active"</c:if>><a href="">Record</a></li>
    <li <c:if test="${active_line == 6}">class="active"</c:if>><a href="">Contact Me</a></li>
    <div style="clear: both;"></div>
  </ul>
</div>
<div id="fix-left">
  <div class="author_info">
    <img src="${imageDomain}/author_header.png"/>
    <p>Pelin</p>
    <p class="motto"><i class="icon-heart"></i>&nbsp;&nbsp;我们在同一个时区，却有一辈子的时差。</p>
  </div>
  <div class="sidebar-nav">
    <div class="sidebar-nav-view <c:if test="${active_line == 1}">active</c:if>">站点概览</div>
    <div class="sidebar-nav-mes <c:if test="${active_line != 1}">active</c:if>">文章信息</div>
    <div style="clear: both;"></div>
  </div>

  <div class="f1" style="display:<c:if test="${active_line == 1}">block</c:if>;">
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
  </div>
  <div class="f2" style="display:<c:if test="${active_line != 1}">block</c:if>;">
    <div class="read-rank">
      <ol>
        <li><a href="">Android开发系列（十一）：对手机通讯录的读取、添加、删除、查找(2121)</a></li>
        <li><a href="">Android开发系列（十七）：读取assets目录下的数据库文件(2121)</a></li>
        <li><a href="">Android开发系列（二十二）：AdapterViewFlipper的功能和用法(2111)</a></li>
        <li><a href="">异常类型：Myeclipse10将web项目打成war包时出现security alert:integrity check error(2035)</a></li>
        <li><a href="">【数据库新手】关于创建数据库过程失败，“master”中拒绝了CREATE DATABASE权限问题(1572)</a></li>
        <li><a href="">Android开发系列（十五）：【Android小游戏成语连连看】第一篇(1264)</a></li>
        <li><a href="">计算机网络系列：在虚拟机上使用wireshark进行抓包(1176)</a></li>
        <li><a href="">Android开发系列（三）：消息模式的Toast.make Text(1163)</a></li>
      </ol>
    </div>
  </div>
</div>
