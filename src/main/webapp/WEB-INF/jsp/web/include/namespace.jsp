<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<%@ page trimDirectiveWhitespaces="true" %>

<c:set var="staticDomain" value="${pageContext.request.contextPath}" />
<c:set var="staticResources" value="${pageContext.request.contextPath}/resources" />
<c:set var="jsAssets" value="${staticResources}/assets/js" />
<c:set var="jsPlugins" value="${staticResources}/js/plugins" />
<c:set var="jsDomain" value="${staticResources}/js" />
<c:set var="cssDomain" value="${staticResources}/assets/css" />
<c:set var="cssPlugins" value="${staticResources}/assets/plugins" />
<c:set var="imageDomain" value="${staticResources}/image" />