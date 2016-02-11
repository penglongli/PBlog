<%@ include file="../include/namespace.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Archives | Pelin的个人博客</title>
    <link rel="icon" href="${imageDomain}/pblog_icon.ico"/>
    <link href="${cssDomain}/font-awesome.min.css" rel="stylesheet"/>
    <link href="${styleDomain}/archives/archives.less" type="text/less" rel="stylesheet/less"  />
    <script src="${jsDomain}/less.min.js"></script>
</head>
<body>
    <c:set var="active_line" value="2"/>
    <div id="wrapper">
      <%@ include file="../include/index_header.jsp"%>
      <div class="content">
        <div class="archive-list">
            <div class="archive-title"><i class="icon-calendar"></i> Archives</div>
            <div class="archive-item"><span class="year">2016</span><span class="month">02</span></div>
            <ul>
                <li>
                    <div class="the-article">
                        <span class="day">08</span> : 解码转换QQ微信的SILK v3编码音频为MP3或其他格式
                    </div>
                </li>
                <li>
                    <div class="the-article">
                        <span class="day">08</span> : 解码转换QQ微信的SILK v3编码音频为MP3或其他格式
                    </div>
                </li>
            </ul>
            <div class="archive-item"><span class="year">2016</span><span class="month">01</span></div>
            <ul>

            </ul>
            <div class="archive-item"><span class="year">2015</span><span class="month">12</span></div>
            <ul>

            </ul>
        </div>
      </div>
    </div>
</body>
</html>
