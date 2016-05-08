<%@ include file="../include/namespace.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <title>文章管理</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link href="${cssDomain}/manage/book_edit.css" rel="stylesheet"/>
    <link rel="stylesheet" href="${cssPlugins}/font-awesome.min.css" />
    <script src="${jsPlugins}/jquery.min.js"></script>
    <script src="${jsPlugins}/marked.js"></script>
</head>
<body>
<c:set var="active_line" value="2"/>
<c:set var="first_nav" value="书评信息" />
<c:set var="first_url" value="${staticDomain}/manage/book/list" />

<c:choose>
    <c:when test="${type == 1}">
        <c:set var="second_nav" value="书评添加" />
        <c:set var="url" value="${staticDomain}/manage/book/add" />
        <c:set var="submit_btn" value="发布书评" />
    </c:when>
    <c:when test="${type == 2}">
        <c:set var="second_nav" value="书评更新" />
        <c:set var="url" value="${staticDomain}/manage/book/update" />
        <c:set var="submit_btn" value="更新书评" />
    </c:when>
</c:choose>

<div id="wrapper">
    <%@ include file="../include/index_man_header.jsp"%>
    <div class="content">
        <%@ include file="../include/index_second_header.jsp" %>
        <form action="${url}" method="post" id="evaluation-add-form">
            <div class="evaluation">
                <input type="hidden" name="id" value="${bookInfo.id}" />
                <div class="evaluation-title">
                    <div class="evaluation-title-theme">书评标题</div>
                    <div class="evaluation-title-content">
                        <textarea rows="1" maxlength="120" name="title" autofocus="autofocus" placeholder="请输入文章标题，标题字数在120字以内">${bookInfo.title}</textarea>
                    </div>
                </div>
                <div class="evaluation-body">
                    <div class="evaluation-body-theme">书评正文</div>
                    <textarea class="editor" name="content" title="文章正文">${bookInfo.content}</textarea>
                </div>
                <div class="evaluation-operate">
                    <i class="icon-eye-open" id="pre"></i>
                    <button type="button" class="preview-evaluation">预览书评</button>
                    <div style="clear: both;"></div>
                </div>
                <div class="view"></div>
                <div class="description">
                    <div class="description-title">添加介绍</div>
                    <textarea class="editor" title="文章描述" name="introduction">${bookInfo.introduction}</textarea>
                </div>
            </div>

            <div class="banner">
                <span>Banner链接</span>
                <input name="banner" type="text" placeholder="书籍封面链接，可以从豆瓣读书获得" value="${bookInfo.banner}" />
            </div>

            <div class="publish">
                <button type="button" class="publish-evaluation"><i class="icon-fighter-jet"></i>${submit_btn}</button>
            </div>
        </form>
    </div>

    <!-- 提示 -->
    <div class="mask" id="mask-tip">
        <div class="modal-dialog">
            <div class="modal-title">提示</div>
            <div class="modal-body"></div>
            <div class="modal-operate">
                <span class="close" onclick="closeMask()">关闭</span>
                <div class="clear-fix"></div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    var $maskTip = $("#mask-tip");

    //关闭遮罩层
    function closeMask(str) {
        $maskTip.css("display", "none");
        if(str == "reload") {
            location.reload();
        }
    }

    //开启遮罩层
    function startMask(content) {
        $maskTip.find(".modal-body").html(content);
        $maskTip.css("display", "block");
    }

    $(".publish-evaluation").click(function () {
        var title = $("textarea[name='title']").val();
        var content = $("textarea[name='content']").val();
        var introduction = $("textarea[name='introduction']").val();
        var banner = $("input[name='banner']").val();

        if((null == title) || ("" == $.trim(title))) {
            startMask("书评名称不能为空!");
            return false;
        }
        if((null == content) || ("" == $.trim(content))) {
            startMask("书评内容不能为空!");
            return false;
        }
        if((null == introduction) || ("" == $.trim(introduction))) {
            startMask("书评介绍不能为空!");
            return false;
        }
        if((null == banner) || ("" == $.trim(banner))) {
            startMask("书籍Banner链接不能为空!");
            return false;
        }

        $("#evaluation-add-form").submit();
    });

    $(".preview-evaluation").click(function () {
        markedToHTML($(".editor"), $(".view"));
    });

    function markedToHTML($input, $preview) {
        var htmlValue = marked($input.val());
        $preview.html(htmlValue);
        return htmlValue;
    }
</script>
</body>
</html>