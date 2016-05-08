var $bookTableForm = $("#book-table-form");
var $modalTitle = $("#book-table-form .modal-title");
var $id = $("input[name='id']");
var $bookName = $("input[name='bookName']");
var $bookUrl = $("input[name='bookUrl']");
var $bookBanner = $("input[name='bookBanner']");
var $bannerView = $(".banner-view");
var $delIdInput = $(".del-id-input");

//添加
function addBookTable() {
    $bookTableForm.attr("action", $(".bt-add-action").val());
    $modalTitle.html("添加 - 在读书籍");
    $id.val("");
    $bookName.val("");
    $bookUrl.val("");
    $bookBanner.val("");
    $bannerView.attr("src", "");

    $("#mask-edit").css("display", "block");
}

//编辑
function editBookTable(id, bookName, bookUrl, bookBanner) {
    $bookTableForm.attr("action", $(".bt-update-action").val());
    $modalTitle.html("更新 - 在读书籍");
    $id.val(id);
    $bookName.val(bookName);
    $bookUrl.val(bookUrl);
    $bookBanner.val(bookBanner);
    $bannerView.attr("src", bookBanner);
    $("#mask-edit").css("display", "block");
}

//删除操作的遮罩层
function delMask(bookTableId) {
    $("#mask-del").css("display", "block");
    $delIdInput.val(bookTableId);
}

//关闭遮罩层
function closeMask(str) {
    $(".mask").css("display", "none");
    if(str == "reload") {
        location.reload();
    }
}

//提交BookTable表单
function submitBt() {
    var id = $id.val();
    var bookName = $bookName.val();
    var bookUrl = $bookUrl.val();
    var bookBanner = $bookBanner.val();

    if((null == bookName) || ("" == $.trim(bookName))) {
        alert("书名不能为空");
        return false;
    }
    if((null == bookUrl) || ("" == $.trim(bookUrl))) {
        alert("书籍链接不能为空");
        return false;
    }
    if((null == bookBanner) || ("" == $.trim(bookBanner))) {
        alert("书籍封面图不能为空");
        return false;
    }

    $bookTableForm.submit();
}

//删除BookTable
function deleteBt() {
    var btId = $delIdInput.val();

    $.ajax({
        async: false,
        type: "POST",
        url: $(".bt-del-action").val(),
        data: {
            'bookTableId': btId
        },
        success: function (data) {
            if(data.status == 1) {
                $("#mask-tip .modal-body").html("删除成功")
                $("#mask-tip").css("display", "block");
            }
        },
        error: function (err) {
            console.log(err);
            $("#mask-tip .modal-body").html("系统出现错误，请稍后再试！")
            $("#mask-tip").css("display", "block");
        }
    });
}

function listenBanner(obj) {
    $bannerView.attr("src", $(obj).val());
}