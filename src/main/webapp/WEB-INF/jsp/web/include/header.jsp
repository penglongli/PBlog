<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="wrapper-header">
    <div class="search">
        <i class="fa fa-search" aria-hidden="true"></i>
        <input type="text" class="search_input"/>
    </div>
</div>
<div id="fix-left">
    <div class="author_info">
        <img src="${imageDomain}/author_header.png"/>
        <p>Pelin</p>
    </div>
    <div class="menu_bar">
        <ul>
            <a href="${staticDomain}/#/index"><li class="menu_1">
                <i class="fa fa-home" aria-hidden="true"></i>
                <span style="top: 125px">首页</span>
            </li></a>
            <a href="${staticDomain}/#/archives"><li class="menu_2">
                <i class="fa fa-calendar" aria-hidden="true"></i>
                <span style="top: 165px">归档</span>
            </li></a>
            <a href="${staticDomain}/#/category"><li class="menu_3">
                <i class="fa fa-align-justify" aria-hidden="true"></i>
                <span style="top: 205px">分类</span>
            </li></a>
            <a href="${staticDomain}/#/read"><li class="menu_4">
                <i class="fa fa-book" aria-hidden="true"></i>
                <span style="top: 245px">阅读</span>
            </li></a>
            <a href="${staticDomain}/#/record"><li class="menu_5">
                <i class="fa fa-camera" aria-hidden="true"></i>
                <span style="top: 285px">日志</span>
            </li></a>
            <a href="${staticDomain}/#/about"><li class="menu_6">
                <i class="fa fa-info-circle" aria-hidden="true"></i>
                <span style="top: 325px">关于</span>
            </li></a>
            <a href="javascript:void(0)"><li class="menu_7">
                <a href="${staticDomain}/switch?mo=1"><i class="fa fa-moon-o" aria-hidden="true"></i></a>
                <a href="${staticDomain}/switch?mo=2"><span style="top: 405px">
                    <i class="fa fa-sun-o" aria-hidden="true"></i>
                </span></a>
            </li></a>
        </ul>
    </div>
</div>
