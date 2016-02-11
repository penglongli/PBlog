<%@ include file="../include/namespace.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <title>Home | Pelin的个人博客</title>
    <link rel="icon" href="${imageDomain}/pblog_icon.ico"/>
    <link href="${styleDomain}/index.less" type="text/less" rel="stylesheet/less"  />
    <link href="${cssDomain}/font-awesome.min.css" rel="stylesheet"/>
    <script src="${jsDomain}/less.min.js"></script>
</head>
<body>
  <c:set var="active_line" value="1"/>
  <div id="wrapper">
     <%@ include file="../include/index_header.jsp"%>
     <div class="content">
        <div class="article-list">
            <div class="article-item">
                <div class="article-item-title">
                    <span class="article-item-category"><a href="">[Sql Server学习]</a></span>
                    <h1><a href="">Sql Server数据查询、数据更新、视图、权限管理</a></h1>
                    <div style="clear: both;"></div>
                </div>
                <div class="article-item-content">
                    <p>最近忙著佈署新的測試伺服器，而 Google Cloud Platform 剛好有提供 $300 兩個月的免費試用，且在台灣又有設點，所以我就決定拿 Google Compute Engine 來建置測試伺服器了。</p>
                    <h3>Dynamic inventory</h3>
                    <p>在開始之前，先稍微解釋一下何謂 Ansible 的 inventory，inventory 即代表伺服器，在 Ansible 中，可把伺服器列在 inventory file 中，藉此來分類伺服器，例如：</p>
                    <p>Ansible 官方提供了各種主流主機商的 dynamic inventory，可以直接取用，而 GCE 當然也沒有缺席：<a href="">http://docs.ansible.com/ansible/guide_gce.html。</a></p>
                    <a href="" class="read-more">Read More</a>
                </div>
                <div class="article-item-footer">
                    <div class="article-tag-list">
                        <span>Java</span>
                        <span>设计模式</span>
                        <span>SpringMVC</span>
                    </div>
                    <div class="article-info">
                        <div class="create-time">2015-08-05 10:30</div>
                        <div class="read-num"><i class="icon-eye-open"></i><span class="icon-title">阅读</span><span>(322)</span></div>
                        <div class="like-num"><i class="icon-heart-empty"></i><!-- icon-heart --><span class="icon-title">喜欢</span><span>(0)</span></div>
                        <div style="clear: both;"></div>
                    </div>
                    <div style="clear: both;"></div>
                </div>
            </div>
        </div>
     </div>
  </div>
</body>
</html>
