<%@ include file="../include/namespace.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=EDGE">
    <meta name="renderer" content="webkit">
    <meta name="format-detection" content="telephone=no">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <title>Home | Pelin的个人博客</title>
    <link href="${styleDomain}/index_mobile.less" type="text/less" rel="stylesheet" />
    <link href="${cssPlugin}/font-awesome.min.css" rel="stylesheet"/>
    <script type="text/javascript" src="${jsPlugin}/less.min.js"></script>
    <script type="text/javascript" src="${jsPlugin}/jquery.min.js"></script>
    <script type="text/javascript" src="${jsPlugin}/marked.js"></script>
</head>
<body onload="loadFontSize()">
    <div id="Wrapper">
        <div id="Top">
            <span class="top-list"><i class="icon-align-justify" onclick="slide()"></i></span>
            <span>Pelin's Blog</span>
            <span class="top-github"><a href=""><i class="icon-github"></i></a></span>
            <div class="clear-fix"></div>
    </div>
        <div id="Content">
            <c:forEach var="articleInfo" items="${pagination.items}" varStatus="status">
            <div class="article">
                <h1>${articleInfo.title}</h1>
                <div class="article-detail">
                    <span class="time">
                        <fmt:setLocale value="en" />
                        <fmt:formatDate type="date" value="${articleInfo.createTime}" />
                    </span>
                    <span class="category"><a href="">${articleInfo.categoryName}</a></span>
                </div>
                <div class="article-description">${articleInfo.description}</div>
                <span class="continue-read"><a href="">Continue reading</a></span>
            </div>
        </c:forEach>
    </div>
</div>
    <nav id="SlideBar">
    <div class="author_info">
        <img src="${imageDomain}/author_header.png"/>
        <p>Pelin</p>
    </div>
    <div class="menu_bar">
        <ul>
            <li><i class="icon-home"></i> Home</li>
            <li><i class="icon-calendar"></i> Archives</li>
            <li><i class="icon-reorder"></i> Categories</li>
            <li><i class="icon-book"></i> Books</li>
            <li><i class="icon-text-width"></i> Recorder</li>
        </ul>
        <ul>
            <li><span class="csdn"></span> BLOG</li>
            <li><span class="zhihu"></span> 知乎</li>
        </ul>
    </div>
</nav>
</body>


<script type="text/javascript">
    $(function () {

    })


    $Wrapper = $("#Wrapper");
    $SlideBar = $("#SlideBar");
    var startX, startY, endX, endY, status = 0;

    function loadFontSize(){
        var templateWidth = 320;
        var actualWidth = $(window).width();

        $("html").css("font-size", (actualWidth * 1.0) / templateWidth * 10.5  + "px");
    }


    function slide(){
        if(status == 1){
             //向左滑动
             $Wrapper.css('position', '');
             $SlideBar.animate({'right': '100%'}, 250);
             $Wrapper.animate({'margin-left': '0'}, 250);
             status = 0;
         }else if(status == 0){
             //向右滑动
             $Wrapper.css('position', 'fixed');
             $SlideBar.animate({'right': '24%'}, 500);
             $Wrapper.animate({'margin-left': '76%'}, 500);
             status = 1;
         }
    }

    $Wrapper.on({
        touchstart: function(e){
            var touch = e.originalEvent.touches[0] || e.originalEvent.changedTouches[0];
            startX = touch.pageX;
        },
        touchend: function(e){
            var touch = e.originalEvent.touches[0] || e.originalEvent.changedTouches[0];
            endX = touch.pageX;

            var distanceX = endX - startX;

            if(status == 1){
                if(distanceX < 0){
                    //向左滑动
                    $("#Wrapper").css('position', '');
                    $("#SlideBar").animate({'right': '100%'}, 250);
                    $("#Wrapper").animate({'margin-left': '0'}, 250);
                    status = 0;
                }
            }
        }
    });
</script>

</html>
