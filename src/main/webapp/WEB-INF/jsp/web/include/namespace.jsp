<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>

<c:set var="ENV" value="local" />

<c:choose>
    <c:when test="${ENV == 'local'}">
        <c:set var="staticDomain" value="${pageContext.request.contextPath}"/>
        <c:set var="styleDomain" value="${staticDomain}/resources/less"/>
    </c:when>
    <c:when test="${ENV == 'portal'}">

    </c:when>
</c:choose>

<c:set var="jsDomain" value="${staticDomain}/resources/js"/>
<c:set var="jsPlugin" value="${staticDomain}/resources/js/plugins"/>
<c:set var="imageDomain" value="${staticDomain}/resources/image"/>
<c:set var="cssDomain" value="${staticDomain}/resources/css"/>
<c:set var="cssPlugin" value="${staticDomain}/resources/css/plugins" />
<c:set var="fontDomain" value="${staticDomain}/resources/font-awesome" />
<c:set var="imageDomain" value="${staticDomain}/resources/image" />