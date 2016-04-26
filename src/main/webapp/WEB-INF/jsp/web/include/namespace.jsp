<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<%@ page trimDirectiveWhitespaces="true" %>

<c:set var="staticDomain" value="${pageContext.request.contextPath}" />
<c:set var="jsDomain" value="${staticDomain}/resources/assets/js" />
<c:set var="cssDomain" value="${staticDomain}/resources/assets/css" />
<c:set var="cssPlugins" value="${staticDomain}/resources/assets/css/plugins" />
<c:set var="fontDomain" value="${staticDomain}/resources/font" />
<c:set var="imageDomain" value="${staticDomain}/resources/image" />