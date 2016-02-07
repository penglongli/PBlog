<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="wrapper-header">
  <ul class="navbar">
    <li <c:if test="${active_line == 1}">class="active"</c:if>><a href="">Home</a></li>
    <li <c:if test="${active_line == 2}">class="active"</c:if>><a href="">Archives</a></li>
    <li <c:if test="${active_line == 3}">class="active"</c:if>><a href="">Category</a></li>
    <li <c:if test="${active_line == 4}">class="active"</c:if>><a href="">Book Review</a></li>
    <li <c:if test="${active_line == 5}">class="active"</c:if>><a href="">Record</a></li>
    <li <c:if test="${active_line == 6}">class="active"</c:if>><a href="">Contact Me</a></li>
    <div style="clear: both;"></div>
  </ul>
</div>
<div id="fix-left"></div>
