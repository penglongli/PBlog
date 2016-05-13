<%@ include file="../include/namespace.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <title>书评管理</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link href="${cssDomain}/manage/category_list.css" rel="stylesheet"  />
    <link rel="stylesheet" href="${staticDomain}/resources/assets/plugins/font-awesome.min.css" />
    <script src="${jsPlugins}/jquery.min.js"></script>
</head>
<body>

<c:set var="active_line" value="5" />
<c:set var="first_nav" value="分类管理" />
<c:set var="second_nav" value="分类列表" />
<c:set var="first_url" value="${staticDomain}/manage/category/list" />

<div id="wrapper">
    <%@ include file="../include/index_man_header.jsp"%>
    <div class="content">
        <%@ include file="../include/index_second_header.jsp" %>
        <a href="javascript:void(0)" class="click-btn" onclick="addMask()">添加分类</a>
        <div class="cat-list">
            <table>
                <thead>
                    <tr>
                        <th class="slug">编号</th>
                        <th class="category">类别</th>
                        <th class="num">文章</th>
                        <th class="operate">操作</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="simpleCategory" items="${simpleCategoryList}" varStatus="status">
                        <tr>
                            <td>${simpleCategory.categorySlug}</td>
                            <td>${simpleCategory.title}</td>
                            <td>${simpleCategory.num}</td>
                            <td>
                                <span class="click-btn" onclick="editMask('${simpleCategory.categorySlug}', '${simpleCategory.title}')">编辑</span>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <!-- 分类添加遮罩层 -->
    <div class="mask" id="mask-edit">
        <form action="" method="POST" class="mask-edit-form">
            <div class="modal-dialog">
                <div class="modal-title">添加 - 分类</div>
                <div class="modal-body">
                    <input type="hidden" name="slug" class="category-slug" />
                    <span>类别名称: </span>
                    <input name="title" class="category-title" />
                </div>
                <div class="modal-operate">
                    <span class="sub" onclick="submitBt()">提交</span>
                    <span class="close" onclick="closeMask('reload')">关闭</span>
                    <div class="clear-fix"></div>
                </div>
            </div>
        </form>
    </div>
</div>

<input type="hidden" value="${staticDomain}/manage/category/add" class="cate-add-action" />
<input type="hidden" value="${staticDomain}/manage/category/update" class="cate-update-action" />

<script type="text/javascript" >
    var $maskEdit = $("#mask-edit");
    var $maskForm = $(".mask-edit-form");
    var $categoryInput = $(".category-title");
    var $categorySlug = $(".category-slug");
    var specialCharReg = /^[^/!@#$%^&*()-+=]*$/;
    var blankSpaceReg = /^[^/ ]*$/;

    function addMask() {
        $categoryInput.val(null);
        $categorySlug.val(null);
        $maskForm.attr("action", $(".cate-add-action").val());
        $maskEdit.css("display", "block");
    }

    function editMask(categorySlug, categoryTitle) {
        $categorySlug.val(categorySlug);
        $categoryInput.val(categoryTitle);
        $maskForm.attr("action", $(".cate-update-action").val());
        $maskEdit.css("display", "block");
    }

    function submitBt() {
        var categoryTitle = $.trim($categoryInput.val());

        if(!specialCharReg.test(categoryTitle)) {
            alert("添加的分类名称不允许包含特殊字符!");
        } else if(!blankSpaceReg.test(categoryTitle)) {
            alert("分类名称不能包含空格");
        } else if (null == categoryTitle || $.trim(categoryTitle) == "") {
            alert("分类名称不能为空!");
        } else {
            $maskForm.submit();
        }
    }

    //关闭遮罩层
    function closeMask(str) {
        $(".mask").css("display", "none");
        if(str == "reload") {
            location.reload();
        }
    }
</script>

</body>
</html>