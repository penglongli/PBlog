<%@ include file="../include/namespace.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <title>书评管理</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link href="${cssDomain}/manage/pic_list.css" rel="stylesheet"  />
    <link rel="stylesheet" href="${staticDomain}/resources/assets/plugins/font-awesome.min.css" />
    <script src="${jsPlugins}/jquery.min.js"></script>
</head>
<body>

<c:set var="active_line" value="4" />
<c:set var="first_nav" value="图片管理" />
<c:set var="second_nav" value="图片列表" />
<c:set var="first_url" value="${staticDomain}/manage/pic/list" />

<div id="wrapper">
    <%@ include file="../include/index_man_header.jsp"%>
    <div class="content">
        <%@ include file="../include/index_second_header.jsp" %>
        <a href="javascript:void(0)" class="click-btn" onclick="uploadImage()">图片上传</a>

        <div class="pic-list">
            <table>
                <thead>
                    <tr>
                        <th>编号</th>
                        <th>图片路径</th>
                        <th>创建时间</th>
                        <th>预览</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="picInfo" items="${picInfoList}" varStatus="status" >
                        <tr>
                            <td>${picInfo.id}</td>
                            <td>${picInfo.relativePath}</td>
                            <td><fmt:formatDate value="${picInfo.createTime}" pattern="yyyy-MM-dd mm:hh:ss" /></td>
                            <td><img src="${picInfo.relativePath}"></td>
                            <td>
                                <a href="${picInfo.relativePath}" target="_blank" class="click-btn">查看</a>
                                <a href="javascript:void(0)" class="click-btn" onclick="deleteImage('${picInfo.id}')">删除</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <!-- 图片上传遮罩层 -->
    <div class="mask" id="mask-upload">
        <form action="${staticDomain}/manage/pic/upload" method="post" id="img-upload-form" enctype="multipart/form-data">
            <div class="modal-dialog">
                <div class="modal-title">图片上传</div>
                <div class="modal-body">
                    <div class="upload-wrapper"><input type="file" name="file" class="file-input"/><span class="file-name">点击上传</span></div>
                </div>
                <div class="modal-operate">
                    <span class="sub" onclick="submitBt()">提交</span>
                    <span class="close" onclick="closeMask()">关闭</span>
                    <div class="clear-fix"></div>
                </div>
            </div>
        </form>
    </div>

    <!-- 图片删除遮罩层 -->
    <div class="mask" id="mask-del">
        <div class="modal-dialog">
            <div class="modal-title">图片删除</div>
            <div class="modal-body">确定要删除这张图片么？</div>
            <div class="modal-operate">
                <input type="hidden" class="del-id-input" />
                <span class="confirm" onclick="deleteBt()">删除</span>
                <span class="close" onclick="closeMask()">关闭</span>
                <div class="clear-fix"></div>
            </div>
        </div>
    </div>

    <!-- 提示 -->
    <div class="mask" id="mask-tip">
        <div class="modal-dialog">
            <div class="modal-title">提示</div>
            <div class="modal-body"></div>
            <div class="modal-operate">
                <span class="close" onclick="closeMask('reload')">关闭</span>
                <div class="clear-fix"></div>
            </div>
        </div>
    </div>
</div>

<input type="hidden" value="${staticDomain}/manage/pic/delete" class="del-url-input" />

<script type="text/javascript">
    var $maskUpload = $("#mask-upload");
    var $maskDelete = $("#mask-del");
    var $maskTip = $("#mask-tip");
    var $fileInput = $("input[name='file']");
    var $imgUploadForm = $("#img-upload-form");
    var $delIdInput = $(".del-id-input");
    var $delUrlInput = $(".del-url-input");

    function uploadImage() {
        $maskUpload.css("display", "block");
    }

    function submitBt() {
        var file = $fileInput.val();
        if(file == null || $.trim(file) == "") {
            alert("请选择上传文件!");
            return false;
        }else {
            var filePath = $(".file-input").val();
            if(filePath.indexOf("jpg")!=-1 || filePath.indexOf("png")!=-1) {
                $imgUploadForm.submit();
            } else {
                alert("您未上传文件，或者您上传文件类型有误！");
            }
        }
    }

    function deleteImage(picId) {
        $delIdInput.val(picId);
        $maskDelete.css("display", "block");
    }

    function deleteBt() {

        $.ajax({
            type: "POST",
            url: $delUrlInput.val(),
            data: {
                picId: $delIdInput.val()
            },
            success: function (data) {
                if(data.status == 1) {
                    tip("删除成功！")
                } else {
                    tip("删除失败，请刷新重试或查看服务器日志！")
                }
            },
            error: function (err) {
                console.log(err);
                alert("系统出现错误!")
            }
        })
    }

    $(".upload-wrapper").on("change","input[type='file']",function(){
        var filePath=$(this).val();
        if(filePath.indexOf("jpg")!=-1 || filePath.indexOf("png")!=-1){
            var arr=filePath.split('\\');
            var fileName=arr[arr.length-1];
            $(".file-name").html(fileName);
        }else{
            $(".file-name").html("点击上传");
            alert("您未上传文件，或者您上传文件类型有误！");
            return false
        }
    });

    //关闭遮罩层
    function closeMask(str) {
        $(".mask").css("display", "none");
        if(str == "reload") {
            location.reload();
        }
    }

    function tip (content) {
        $maskTip.css("display", "block");
        $("#mask-tip .modal-body").html(content);
    }
</script>

</body>
</html>
