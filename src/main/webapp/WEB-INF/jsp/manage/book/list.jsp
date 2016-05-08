<%@ include file="../include/namespace.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <title>书评管理</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link href="${cssDomain}/manage/book_list.css" rel="stylesheet"  />
    <link rel="stylesheet" href="${cssPlugins}/font-awesome.min.css" />
    <script src="${jsPlugins}/jquery.min.js"></script>
</head>
<body>

<c:set var="active_line" value="2" />
<c:set var="first_nav" value="书评信息" />
<c:set var="first_url" value="${staticDomain}/manage/book/list" />

<div id="wrapper">
    <%@ include file="../include/index_man_header.jsp"%>
    <div class="content">
        <c:set var="second_nav" value="在读列表" />
        <%@ include file="../include/index_second_header.jsp" %>
        <a href="javascript:void(0)" class="add-read-book click-btn" onclick="addBookTable()">添加在读书籍</a>
        <div class="reading-list">
            <c:forEach var="bookTable" items="${bookTableList}" varStatus="status">
                <div class="banner-item">
                    <img src="${bookTable.bookBanner}" alt="${bookTable.bookName}" />
                    <div class="operate">
                        <div class="edit" onclick="editBookTable('${bookTable.id}', '${bookTable.bookName}', '${bookTable.bookUrl}', '${bookTable.bookBanner}')"><i class="icon-edit"></i></div>
                        <div class="del" onclick="delMask('${bookTable.id}')"><i class="icon-trash"></i></div>
                    </div>
                </div>
            </c:forEach>

            <div class="clear-fix"></div>
        </div>

        <c:set var="second_nav" value="书评列表" />
        <%@ include file="../include/index_second_header.jsp" %>
        <div class="add-read-book click-btn"><a href="${staticDomain}/manage/book/add">添加书评</a></div>
        <div class="book-list">
            <table>
                <thead>
                    <tr>
                        <th>编号</th>
                        <th>标题</th>
                        <th>创建时间</th>
                        <th>Banner</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="bookInfo" items="${bookInfoList}" varStatus="status">
                        <tr>
                            <td>${bookInfo.slug}</td>
                            <td>${bookInfo.title}</td>
                            <td><fmt:formatDate value="${bookInfo.createTime}" pattern="YYYY-MM-dd HH:mm:ss" /></td>
                            <td><img src="${bookInfo.banner}" /></a></td>
                            <td>
                                <a href="${staticDomain}/manage/book/edit/${bookInfo.id}" class="click-btn">编辑</a>
                                <a href="#" class="click-btn">查看</a>
                                <a href="#" class="click-btn">隐藏</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <!-- 在读书籍编辑遮罩层 -->
    <div class="mask" id="mask-edit">
        <form action="" method="post" id="book-table-form">
            <div class="modal-dialog">
                <div class="modal-title">更新 - 在读书籍</div>
                <div class="modal-body">
                    <input type="hidden" name="id" />
                    <div class="title">
                        <span>名称: </span>
                        <input type="text" placeholder="请输入书籍名称" name="bookName" />
                    </div>
                    <div class="banner-url">
                        <span>Banner链接: </span>
                        <input type="text" placeholder="书籍Banner外链可以在豆瓣读书找到" name="bookBanner" onchange="listenBanner(this)" />
                    </div>
                    <div class="book-url">
                        <span>书籍链接: </span>
                        <input type="text" placeholder="书籍外链可以外链到豆瓣读书某个书籍链接" name="bookUrl" />
                    </div>
                    <div class="view">
                        <span>图片显示</span>
                        <img src="" class="banner-view" />
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

    <!-- 在读书籍删除遮罩层 -->
    <div class="mask" id="mask-del">
        <div class="modal-dialog">
            <div class="modal-title">删除 - 设计模式</div>
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

<input type="hidden" value="${staticDomain}/manage/read/add" class="bt-add-action" />
<input type="hidden" value="${staticDomain}/manage/read/update" class="bt-update-action" />
<input type="hidden" value="${staticDomain}/manage/read/delete" class="bt-del-action" />
<script type="text/javascript" src="${jsDomain}/manage/book_list.js"></script>
</body>
</html>



