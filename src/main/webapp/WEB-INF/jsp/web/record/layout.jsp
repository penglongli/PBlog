<%@ include file="../include/namespace.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="record">
    <div class="record-content">
        <div class="record-title">个人工作生活日志</div>
        <div class="main">
            <div class="year">
                <div class="time-line"></div>
                <div class="year-title">2016年 <i class="fa fa-caret-down" aria-hidden="true"></i></div>
                <div class="daily" ng-repeat="recordInfo in recordInfoList">
                    <div class="daily-title">
                        <div class="time">{{ recordInfo.createTime | date:'MM月dd日' }}</div>
                        <div class="title">{{ recordInfo.title }}</div>
                        <div class="clear-fix"></div>
                    </div>
                    <div class="daily-content" ng-bind-html="recordInfo.content"></div>
                </div>
            </div>

        </div>
    </div>
</div>
