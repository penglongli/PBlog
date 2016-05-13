<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- header and navigation -->
<header>
    <nav>
        <div class="navbar-header">Pblog Admin</div>
        <div class="navbar-right">李鹏龙</div>
        <div class="navbar-left">
            <ul>
                <a href="${staticDomain}/manage/article/list"><li <c:if test="${active_line == 1}">class="active"</c:if>><i class="fa fa-pencil-square-o" aria-hidden="true"></i>文章管理</li></a>
                <a href="${staticDomain}/manage/book/list"><li <c:if test="${active_line == 2}">class="active"</c:if>><i class="fa fa-book" aria-hidden="true"></i>书评信息</li></a>
                <a href="${staticDomain}/manage/record/list"><li <c:if test="${active_line == 3}">class="active"</c:if>><i class="fa fa-text-height" aria-hidden="true"></i>个人日志</li></a>
                <a href="${staticDomain}/manage/pic/list"><li <c:if test="${active_line == 4}">class="active"</c:if>><i class="fa fa-cloud-upload" aria-hidden="true"></i>图片管理</li></a>
                <a href="${staticDomain}/manage/category/list"><li <c:if test="${active_line == 5}">class="active"</c:if>><i class="fa fa-bars" aria-hidden="true"></i>分类管理</li></a>
            </ul>
        </div>
    </nav>
</header>