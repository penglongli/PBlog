<%@ include file="../include/namespace.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <title>文章管理</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link href="${styleDomain}/index_man.less" type="text/less" rel="stylesheet/less"  />
    <link href="${cssDomain}/font-awesome.min.css" rel="stylesheet"/>
    <script src="${jsDomain}/less.min.js"></script>
    <script src="${jsPlugin}/jquery.min.js"></script>
</head>
<body>
    <c:set var="active_line" value="1" />
    <div id="progress"><span></span></div>
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
                    <a href="">添加文章</a>
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
                        <tr>
                            <td class="slug">93478371</td>
                            <td class="title">【MyBatis】MyBatis+SpringMVC+EasyUI整合分页整合分页整合分整合分整合分整合分页<span>(2015-08-05 10:30)<span></td>
                            <td class="viewNum">120</td>
                            <td class="thumbNum">0</td>
                            <td class="status">是</td>
                            <td class="operate">
                                <a href="">编辑</a>
                                <a href="">查看</a>
                                <a href="">隐藏</a>
                            </td>
                        </tr>
                        <tr>
                            <td class="slug">93478371</td>
                            <td class="title">【MyBatis】MyBatis+SpringMVC+EasyUI整合分页<span>(2015-08-05 10:30)<span></td>
                            <td class="viewNum">120</td>
                            <td class="thumbNum">0</td>
                            <td class="status">是</td>
                            <td class="operate">
                                <a href="">编辑</a>
                                <a href="">查看</a>
                                <a href="">隐藏</a>
                            </td>
                        </tr>
                    </tbody>
                </table>
<%--
                <div class="article-head">
                    <span class="slug">编号</span>
                    <span class="title">标题</span>
                    <span class="createTime">创建时间</span>
                    <span class="viewNum">浏览量</span>
                    <span class="thumbNum">点赞数</span>
                    <span class="status">状态</span>
                </div>
--%>
                <%--<div class="article-body">
                    <span class="slug">93478371</span>
                    <span class="title">【MyBatis】MyBatis+SpringMVC+EasyUI整合分页</span>
                    <span class="createTime">2015-08-05 10:30</span>
                    <span class="viewNum">120</span>
                    <span class="thumbNum">0</span>
                    <span class="status">是</span>
                </div>--%>
            </div>
        </div>
    </div>
</body>

</html>