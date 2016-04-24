<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="wrapper-header">
    <div class="search">
        <input type="text" class="search_input"/>
    </div>
</div>
<div id="fix-left">
    <div class="author_info">
        <img src="${imageDomain}/author_header.png"/>
        <p>Pelin</p>
        <p class="motto"><i class="icon-heart"></i>&nbsp;&nbsp;我们在同一个时区，却有一辈子的时差。</p>
    </div>
    <div class="menu_bar">
        <ul>
            <a href="${staticDomain}/#/index">
                <li <c:if test="${active_line == 1}">class="active"</c:if>><i class="icon-home"></i>首页</li>
            </a>
            <a href="${staticDomain}/#/archives">
                <li <c:if test="${active_line == 2}">class="active"</c:if>><i class="icon-calendar"></i>归档</li>
            </a>
            <a href="${staticDomain}/#/category">
                <li <c:if test="${active_line == 3}">class="active"</c:if>><i class="icon-reorder"></i>分类</li>
            </a>
            <a href="">
                <li><i class="icon-book"></i>读书</li>
            </a>
            <a href="">
                <li><i class="icon-text-width"></i>日记</li>
            </a>
            <a href="">
                <li><i class="icon-info-sign"></i>关于</li>
            </a>
        </ul>
    </div>
</div>
