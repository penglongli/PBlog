<%@ include file="../include/namespace.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <title>书评管理</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link href="${cssDomain}/manage/record_list.css" rel="stylesheet"  />
    <link rel="stylesheet" href="${cssPlugins}/font-awesome.min.css" />
    <script src="${jsPlugins}/jquery.min.js"></script>
</head>
<body>

<c:set var="active_line" value="3" />
<c:set var="first_nav" value="日志管理" />
<c:set var="second_nav" value="日志列表" />
<c:set var="first_url" value="${staticDomain}/manage/record/list" />

<div id="wrapper">
    <%@ include file="../include/index_man_header.jsp"%>
    <div class="content">
        <%@ include file="../include/index_second_header.jsp" %>

        <a href="javascript:void(0)" class="click-btn" onclick="addRecord()">添加日志</a>

        <div class="pic-list">
            <table>
                <thead>
                    <tr>
                        <th>编号</th>
                        <th>名称</th>
                        <th>创建时间</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="recordInfo" items="${recordInfoList}" varStatus="status">
                        <tr>
                            <td>${recordInfo.id}</td>
                            <td>${recordInfo.title}</td>
                            <td><fmt:formatDate value="${recordInfo.createTime}" pattern="YYYY-MM-dd HH:mm:ss" /></td>
                            <td>
                                <a href="javascript:void(0)" class="click-btn" onclick="editRecord('${recordInfo.id}')">编辑</a>
                                <a href="${staticDomain}/#/record" class="click-btn">查看</a>
                                <a href="javascript:void(0)" class="click-btn" onclick="deleteRecord('${recordInfo.id}')">删除</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <!-- 日志编辑遮罩层 -->
    <div class="mask" id="mask-edit">
        <form action="" method="post" id="record-table-form">
            <div class="modal-dialog">
                <div class="modal-title">添加 - 个人日志</div>
                <div class="modal-body">
                    <input type="hidden" name="id" />
                    <div class="title">
                        <span>标题: </span>
                        <input type="text" placeholder="输入日志标题" name="title" />
                    </div>
                    <div class="record-content">
                        <span>内容: </span>
                        <textarea name="content"></textarea>
                        <div style="clear: both"></div>
                    </div>
                </div>
                <div class="modal-operate">
                    <span class="sub" onclick="submitBt()">提交</span>
                    <span class="close" onclick="closeMask()">关闭</span>
                    <div class="clear-fix"></div>
                </div>
            </div>
        </form>
    </div>

    <!-- 日志删除遮罩层 -->
    <div class="mask" id="mask-del">
        <div class="modal-dialog">
            <div class="modal-title">删除 - 个人日志</div>
            <div class="modal-body">你确认要删除么？</div>
            <div class="modal-operate">
                <input type="hidden" class="del-id-input" />
                <span class="confirm" onclick="deleteBt()">删除</span>
                <span class="close" onclick="closeMask()">取消</span>
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

<input type="hidden" value="${staticDomain}/manage/record/add" class="bt-add-action" />
<input type="hidden" value="${staticDomain}/manage/record/update" class="bt-update-action" />
<input type="hidden" value="${staticDomain}/manage/record/delete" class="bt-delete-action" />

<script type="text/javascript">
    var $modalTitle = $(".modal-title");
    var $recordForm = $("#record-table-form");
    var $recordId = $("input[name='id']");
    var $recordTitle = $("input[name='title']");
    var $recordContent = $("textarea[name='content']");
    var $delIdInput = $(".del-id-input");

    //添加
    function addRecord() {
        $recordForm.attr("action", $(".bt-add-action").val());
        $recordId.val("");
        $recordTitle.val("");
        $recordContent.val("");

        $("#mask-edit").css("display", "block");
    }

    //编辑
    function editRecord(id) {
        $recordForm.attr("action", $(".bt-update-action").val());
        $recordId.val(id);

        $.ajax({
            url: "/manage/record/edit/" + id,
            type: "get",
            success: function (data) {
                var  recordInfo = data.recordInfo;

                console.log(recordInfo);

                if(recordInfo == null) {
                    alert("Id为空或者没有相应记录，不能更新!");
                    return false;
                } else {
                    $recordId.val(id);
                    $recordTitle.val(recordInfo.title);
                    $recordContent.val(recordInfo.content);

                    $modalTitle.html("更新 - 个人日志");
                    $("#mask-edit").css("display", "block");
                }
            },
            error: function (err) {
                console.log(err);
            }
        });
    }

    //删除
    function deleteRecord(recordId) {
        $("#mask-del").css("display", "block");

        $delIdInput.val(recordId);
    }

    //删除提交
    function deleteBt() {
        var recordId = $delIdInput.val();

        $.ajax({
            url: "/manage/record/delete",
            type: "POST",
            data: {
                id: recordId
            },
            success: function (data) {
                if(data.status == 1) {
                    $("#mask-tip .modal-body").html("删除成功")
                    $("#mask-tip").css("display", "block");
                } else{
                    $("#mask-tip .modal-body").html("删除失败，请刷新后重试！")
                    $("#mask-tip").css("display", "block");
                }
            },
            error: function (err) {
                console.log(err);
                alert("系统出错")
            }
        })
    }

    //提交表单
    function submitBt() {
        var title = $recordTitle.val();
        var content = $recordContent.val();

        if((null == title) || ("" == $.trim(title))) {
            alert("日志名称不能为空！");
            return false;
        }

        if((null == content) || ("" == $.trim(content))) {
            alert("日志内容不能为空！");
            return false;
        }

        $recordForm.submit();
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
