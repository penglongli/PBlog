<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- header and navigation -->
<header>
    <nav>
        <div class="navbar-header">Pblog Admin</div>
        <div class="navbar-right">李鹏龙</div>
        <div class="navbar-left">
            <ul>
                <li <c:if test="${active_line == 1}">class="active"</c:if>><i class="icon-pencil"></i>个人信息</li>
                <li <c:if test="${active_line == 2}">class="active"</c:if>><i class="icon-edit"></i>文章管理</li>
                <li <c:if test="${active_line == 3}">class="active"</c:if>><i class="icon-book"></i>书评信息</li>
                <li <c:if test="${active_line == 4}">class="active"</c:if>><i class="icon-text-height"></i>个人日志</li>
            </ul>
        </div>
    </nav>
</header>