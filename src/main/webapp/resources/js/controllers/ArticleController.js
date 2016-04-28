
var ArticleController = function ($scope, $interval, $http, $timeout, $routeParams) {
    var articleSlug = $routeParams.articleSlug;

    $scope.fetchArticle = function () {
        $http.get('/article/' + articleSlug + '.json').
            success(function (data) {
                $scope.articleVO = data.articleVO;

                initializeArticleSlug();
                initializeLoad($scope, $timeout);
                initializeArticleContent(data.articleVO.content);
            })
    };

    $scope.fetchArticle();
};

/**
 * 更新左侧导航样式
 */
function initializeArticleSlug () {
    $(".menu_bar ul li").each(function () {
        $(this).removeClass("active");
    });
}

function initializeArticleContent (content_md) {
    var $contentBody = $(".content-body");
    var contentHTML = marked(content_md);

    //初始化文章内容
    var $tempHTML = $("<div></div>").append(contentHTML);
    var counter = 0;
    $tempHTML.find("h2").each(function () {
        $(this).attr("id", "section-" + counter++);
    });
    $contentBody.html($tempHTML);

    //初始化文章导航条
    var $navList = $(".nav-list");
    var topArray = [];

    var navHTML = "<ul>";
    $(".content-body h2").each(function (index) {
        var distance = document.getElementById("section-" + index).offsetTop;
        topArray[index] = distance;

        if(index == 0) {
            navHTML += ("<li onclick='scrollArticle(" + distance + ")' id='nav-section-" + index + "'  class='active'>" + $(this).text() + "</li>");
        } else {
            navHTML += ("<li onclick='scrollArticle(" + distance + ")' id='nav-section-"+ index +"'>" + $(this).text() + "</li>");
        }
    });
    navHTML += "</ul>";
    $navList.html(navHTML);

    //监测窗口滚动并更新文章导航条active
    $(window).scroll(function () {
        //45为搜索栏高度
        var scrollDistance = $("body").scrollTop() + 30;

        if (scrollDistance > 165) {
            $(".content-nav").addClass("fixed");
        } else if(scrollDistance <= 165) {
            $(".content-nav").removeClass("fixed");
        }

        for(var i = 0; i < topArray.length; i++) {
            if (i == 0) {
                if(scrollDistance <= topArray[i + 1]) {
                    removeActiveClass(topArray);
                    $("#nav-section-0").addClass("active");
                    break;
                }
            } else {
                if(scrollDistance >= topArray[i] && scrollDistance <= topArray[i + 1]) {
                    removeActiveClass(topArray);
                    $("#nav-section-" + i).addClass("active");
                    break;
                }
            }
        }
    });
}

function scrollArticle (distance) {
    $('body').animate({scrollTop: distance}, 300);
}

function removeActiveClass (topArray) {
    for(var i = 0; i < topArray.length; i++) {
        $("#nav-section-" + i).removeClass("active");
    }
}

