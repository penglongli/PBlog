<%@ include file="../include/namespace.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=EDGE">
    <meta name="renderer" content="webkit">
    <meta name="format-detection" content="telephone=no">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <title>Home | Pelin的个人博客</title>
    <link href="${cssDomain}/about/about_mobile.css" rel="stylesheet"/>
    <link href="${cssPlugins}/font-awesome.min.css" rel="stylesheet"/>
    <script src="${jsPlugins}/jquery.min.js" type="text/javascript"></script>
</head>

<body>
<div id="Wrapper">
    <%@ include file="../include/index_mobile_header.jsp"%>
    <div id="Content">
        <div class="banner">
            <div class="info">
                <h1>PELIN LI</h1>
                <h2>A Java Engineer(Web),&nbsp; wants to be a poet!</h2>
            </div>
        </div>

        <div class="about-detail">
            <div class="spot">
                <a href="https://github.com/penglongli" target="_blank"><i class="icon-github"></i> Follow me on GitHub</a>
            </div>
            <div class="contact">
                <h2>联系方式</h2>
                <ul>
                    <li>Email: <a href="mailto:penglong95.li@gmail.com" target="_blank">penglong95.li@gmail.com</a></li>
                </ul>
            </div>

            <div class="person">
                <h2>个人信息</h2>
                <ul>
                    <li>李鹏龙/男/1995</li>
                    <li>博客：<a href="http://www.pelinli.com" target="_blank">http://www.pelinli.com</a></li>
                    <li>城市: 北京</li>
                </ul>
            </div>

            <div class="social">
                <h2>社交账号</h2>
                <ul>
                    <li><a href="https://github.com/penglongli" target="_blank">GitHub</a></li>
                    <li><a href="https://www.zhihu.com/people/pelin.li" target="_blank">Zhihu</a></li>
                    <li><a href="http://blog.csdn.net/u010800530" target="_blank">CSDN</a></li>
                    <li><a href="javascript:void(0)">Sina Weibo</a></li>
                    <li><a href="http://v2ex.com/member/Lpl" target="_blank">V2EX</a></li>
                </ul>
            </div>

            <div class="open-source">
                <h2>开源项目</h2>
                <ul>
                    <li><a href="https://github.com/penglongli/PBlog" target="_blank">PBlog</a>: 基于Java + AngularJS开发的一款单页应用博客</li>
                </ul>
            </div>

            <div class="work-experience">
                <h2>工作经历</h2>
                <ul>
                    <li>2015-10 ~ 2016-04 多贝网(实习)</li>
                    <li>2015-07 ~ 2015-10 爱鲜蜂(实习)</li>
                    <li>2012-11 ~ 2015-07 校内多家企业(打杂)</li>
                </ul>
            </div>

            <div class="education">
                <h2>教育背景</h2>
                <ul>
                    <li>2012-09 ~ 2016-06 黄淮学院/学士学位 专业: 软件工程</li>
                </ul>
            </div>

            <div class="awards">
                <h2>获奖证书</h2>
                <ul>
                    <li>河南省第八届ACM铜牌</li>
                    <li>2015年国家励志奖学金</li>
                    <li>软件设计师(软考)</li>
                </ul>
            </div>

            <div class="technical">
                <h2>技能清单</h2>
                <ul>
                    <li>Web开发: Java(熟练)/Node(入门)</li>
                    <li>Web框架: SpringMVC/Spring/MyBatis/Struts2/Hibernate</li>
                    <li>前端: HTML(5)标准/CSS(3)标准/Javascript/Bootstrap/gulp/Less/AngularJS</li>
                    <li>数据库: MySql/MSSQL</li>
                    <li>版本管理工具: SVN/Git/Maven/Gradle</li>
                    <li>脚本: Python3(简单使用)/Bash</li>
                </ul>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="${jsPlugins}/global_mobile.js"></script>
</body>
</html>
