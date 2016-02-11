<%@ include file="../include/namespace.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Category | Pelin的个人博客</title>
    <link rel="icon" href="${imageDomain}/pblog_icon.ico"/>
    <link href="${cssDomain}/font-awesome.min.css" rel="stylesheet"/>
    <link href="${styleDomain}/category/category.less" type="text/less" rel="stylesheet/less"  />
    <script src="${jsDomain}/less.min.js"></script>
</head>
<body>
    <c:set var="active_line" value="3"/>
    <div id="wrapper">
        <%@ include file="../include/index_header.jsp"%>
        <div class="content">
            <div class="category-list">
                <div class="category-title"><i class="icon-th"></i> 类别</div>
                <div class="category-item">
                    <div class="category-item-name">生活</div>
                    <div class="category-item-list">
                        <ul>
                            <li>2014年12月28日 : 我第一篇博客</li>
                        </ul>
                    </div>
                </div>

                <div class="category-item">
                    <div class="category-item-name">程序人生</div>
                    <div class="category-item-list">
                        <ul>
                            <li>2014年12月30日 : 程序员如何留住健康</li>
                            <li>2014年12月29日 : 请不要做浮躁的人</li>
                        </ul>
                    </div>
                </div>

                <div class="category-item">
                    <div class="category-item-name">git</div>
                    <div class="category-item-list">
                        <ul>
                            <li>2015年01月30日 :  Git五分钟教程</li>
                            <li>2015年01月29日 :  让git push命令不再每次都输入密码</li>
                            <li>2015年01月21日 :  Eclipse上GIT插件EGIT使用</li>
                            <li>2015年01月21日 :  Eclipse上GIT插件EGIT使用</li>
                            <li>2015年01月20日 :  MyEclipse8.5整合Git</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
