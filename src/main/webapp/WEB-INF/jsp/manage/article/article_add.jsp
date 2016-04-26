<%@ include file="../include/namespace.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <title>文章管理</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link href="${cssDomain}/article_add.css" rel="stylesheet"/>
    <link href="${cssPlugins}/font-awesome.min.css" rel="stylesheet"/>
    <script src="${jsPlugins}/jquery.min.js"></script>
    <script src="${jsPlugins}/marked.js"></script>
</head>
<body>
<c:set var="active_line" value="2"/>
<c:set var="first_nav" value="文章管理" />
<c:choose>
    <c:when test="${type == 1}">
        <c:set var="second_nav" value="文章添加" />
        <c:set var="url" value="${staticDomain}/manage/article/add" />
        <c:set var="submit_btn" value="发布文章" />
    </c:when>
    <c:when test="${type == 2}">
        <c:set var="second_nav" value="文章更新" />
        <c:set var="url" value="${staticDomain}/manage/article/update" />
        <c:set var="submit_btn" value="更新文章" />
    </c:when>
</c:choose>


<div id="wrapper">
    <%@ include file="../include/index_man_header.jsp" %>
    <div class="content">
        <%@ include file="../include/index_second_header.jsp" %>
        <form action="${url}" method="post" id="article-add-form">
            <input type="hidden" name="id" value="${articleInfo.id}" />
            <div class="article">
                <div class="article-title">
                    <div class="article-title-theme">文章标题</div>
                    <div class="article-title-content">
                        <textarea rows="1" maxlength="120" name="title" autofocus="autofocus"
                                  placeholder="请输入文章标题，标题字数在120字以内">${articleInfo.title}</textarea>
                    </div>
                </div>
                <div class="article-body">
                    <div class="article-body-theme">文章正文</div>
                    <textarea class="editor" name="content" title="文章正文">${articleInfo.content}</textarea>
                </div>
                <div class="article-operate">
                    <i class="icon-eye-open" id="pre"></i>
                    <button type="button" class="preview-article">预览文章</button>
                    <div style="clear: both;"></div>
                </div>
                <div class="view"></div>
                <div class="description">
                    <div class="description-title">添加描述</div>
                    <textarea class="editor" title="文章描述"></textarea>
                </div>
                <div class="description-operate">
                    <i class="icon-eye-open"></i>
                    <button type="button" class="preview-description">预览描述</button>
                    <textarea name="description" style="display: none;" title="描述隐藏域"></textarea>
                </div>
                <div class="description-view">${articleInfo.description}</div>
            </div>
            <div class="operate">
                <div class="publish">
                    <button type="button" class="publish-article"><i class="icon-fighter-jet"></i>${submit_btn}</button>
                </div>
                <div class="article-category">
                    <div class="title">文章分类</div>
                    <c:forEach  var="category" items="${categoryList}" varStatus="status">
                        <span><input type="radio" name="categorySlug" value="${category.categorySlug}" <c:if test="${category.categorySlug eq articleInfo.categorySlug}">checked="checked"</c:if> />${category.title}</span>
                    </c:forEach>
                </div>
                <div class="tag">
                    <div class="title">文章标签</div>
                    <input type="text" name="tag" value="${articleInfo.tag}" />
                </div>
            </div>
        </form>
    </div>
</div>

</body>

<script type="text/javascript">
    $(".publish-article").click(function () {
        var title = $("textarea[name='title']").val();
        var content = $("textarea[name='content']").val();
        var description = $("textarea[name='description']").val();
        var categorySlug = $("input[name='categorySlug']:checked").val();
        var tag = $("input[name='tag']").val();

        $("#article-add-form").submit();
    })

    $(".preview-article").click(function () {
        previewArticle();
    });

    $(".preview-description").click(function () {
        previewDescription();
    });

    function previewArticle() {
        var htmlValue = markedToHTML($(".editor:eq(0)"), $(".view"))
        //$("textarea[name='content']").html(htmlValue);
    }

    function previewDescription() {
        var htmlValue = markedToHTML($(".editor:eq(1)"), $(".description-view"));
        $("textarea[name='description']").html(htmlValue);
    }

    function markedToHTML($input, $preview) {
        var htmlValue = marked($input.val());
        $preview.html(htmlValue);
        return htmlValue;
    }
</script>
</html>
