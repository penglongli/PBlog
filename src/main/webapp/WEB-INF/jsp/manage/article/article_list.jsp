<%@ include file="../include/namespace.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <title>文章管理</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link href="${styleDomain}/article_list.less" type="text/less" rel="stylesheet/less"  />
    <link href="${cssPlugin}/font-awesome.min.css" rel="stylesheet"/>
    <script src="${jsDomain}/less.min.js"></script>
</head>
<body>
    <c:set var="active_line" value="2" />
    <div id="wrapper">
        <%@ include file="../include/index_man_header.jsp"%>
        <div class="content">
            <div class="content-second-nav">
                <ol>
                    <li><i class="icon-edit"></i>文章管理</li>
                    <li class="active"><i class="icon-list"></i>文章列表</li>
                </ol>
                <div style="clear: both;"></div>
            </div>
            <div class="content-find">
                <div class="find-by-type">
                    类别: <select>
                        <option>全部</option>
                        <option>测试11111</option>
                        <option>测试222222</option>
                        <option>测试121</option>
                    </select>
                </div>
                <div class="add-article">
                    <a href="${staticDomain}/manage/article/edit">添加文章</a>
                </div>
                <div style="clear: both;"></div>
            </div>
            <div class="content-article-list">
                <table>
                    <thead>
                        <tr>
                            <th class="slug">编号</th>
                            <th class="title">标题</th>
                            <th class="viewNum">浏览量</th>
                            <th class="thumbNum">点赞数</th>
                            <th class="status">状态</th>
                            <th class="operate">操作</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="articleInfo" items="${articleInfoList}" varStatus="status">
                            <tr>
                                <td class="slug">${articleInfo.slug}</td>
                                <td class="title">${articleInfo.title}<span>(${articleInfo.createTime})<span></td>
                                <td class="viewNum">120</td>
                                <td class="thumbNum">${articleInfo.thumb}</td>
                                <td class="status">
                                    <c:choose>
                                        <c:when test="${articleInfo.enabled}">是</c:when>
                                        <c:otherwise>否</c:otherwise>
                                    </c:choose>
                                </td>
                                <td class="operate">
                                    <a href="">编辑</a>
                                    <a href="">查看</a>
                                    <a href="">隐藏</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>

        </div>
    </div>
</body>

</html>