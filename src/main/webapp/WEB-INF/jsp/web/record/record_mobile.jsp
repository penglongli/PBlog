<%@ include file="../include/namespace.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=EDGE">
    <meta name="renderer" content="webkit">
    <meta name="format-detection" content="telephone=no">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <title>Archives | Pelin的个人博客</title>
    <link rel="icon" href="${imageDomain}/pblog_icon.ico"/>
    <link href="${staticDomain}/resources/assets/css/mobile/record_mobile.css" rel="stylesheet" />
    <link href="${staticDomain}/resources/assets/plugins/font-awesome.min.css" rel="stylesheet"/>
    <script src="${staticDomain}/resources/js/plugins/jquery.min.js" type="text/javascript"></script>
    <script src="${staticDomain}/resources/js/plugins/marked.js" type="text/javascript"></script>
</head>
<body>
<div id="Wrapper">
    <%@ include file="../include/index_mobile_header.jsp"%>
    <div id="Content">
        <div class="record-header"><i class="fa fa-check-circle" aria-hidden="true"></i>记录统计：<span>${fn:length(recordInfoList)}条</span></div>
        <div class="record-title">个人记录</div>
        <div class="record-list">
            <div class="clock"><img src="${imageDomain}/clock.png" /></div>
            <c:forEach var="recordInfo" items="${recordInfoList}" varStatus="status">
                <div class="daily">
                    <div class="detail-time">
                        <span><fmt:formatDate value="${recordInfo.createTime}" pattern="MM月dd日" /></span>
                        <span><fmt:formatDate value="${recordInfo.createTime}" pattern="HH:mm" /></span>
                    </div>
                    <div class="icon"><i class="fa fa-moon-o" aria-hidden="true"></i></div>
                    <div class="daily-record">${recordInfo.content}</div>
                    <div style="clear: both"></div>
                    <div class="time-line"></div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>

<script type="text/javascript" src="${staticDomain}/resources/js/mobile/global_mobile.js"></script>
<script type="text/javascript">
    $(".daily").each(function (index) {
        var recordHtml = marked($(this).find(".daily-record").html());
        $(this).delay(index * 1000).find(".daily-record").html(recordHtml);
        $(this).delay(index * 1000).fadeIn("slow");
    });
</script>
</body>
</html>