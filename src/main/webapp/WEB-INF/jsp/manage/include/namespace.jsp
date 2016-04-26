<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>

<c:set var="staticDomain" value="${pageContext.request.contextPath}" />
<c:set var="jsDomain" value="${staticDomain}/resources/js" />
<c:set var="jsPlugins" value="${jsDomain}/plugins" />
<c:set var="cssDomain" value="${staticDomain}/resources/assets/css" />
<c:set var="cssPlugins" value="${cssDomain}/plugins" />