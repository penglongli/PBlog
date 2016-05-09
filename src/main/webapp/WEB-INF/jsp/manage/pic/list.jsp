<%@ include file="../include/namespace.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <title>书评管理</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link href="${cssDomain}/manage/pic_list.css" rel="stylesheet"  />
    <link rel="stylesheet" href="${cssPlugins}/font-awesome.min.css" />
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

        <a href="" class="click-btn">图片上传</a>

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

                <tr>
                    <td>1</td>
                    <td>var/dfsdfsdf</td>
                    <td>2016-05-08 00:32:09</td>
                    <td><img src="https://img3.doubanio.com/lpic/s28576995.jpg"></td>
                    <td>
                        <a href="/manage/book/edit/1" class="click-btn">编辑</a>
                        <a href="#" class="click-btn">查看</a>
                        <a href="#" class="click-btn">隐藏</a>
                    </td>
                </tr>

                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>
