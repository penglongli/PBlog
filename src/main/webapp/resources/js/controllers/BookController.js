
var BookController = function ($scope, $interval, $http, $timeout, $routeParams) {
    var bookSlug = $routeParams.bookSlug;

    $scope.fetchBooksDetail = function () {
        $http.get('/book/' + bookSlug + '.json').
        success(function(data) {
            initializeBook(data.bookInfoVO.title);
            initializeBookContent(data.bookInfoVO.content);

            $scope.bookInfoVO = data.bookInfoVO;
        }).
        error(function(err) {
            console.log(err);
        });
    };

    initializeLoad($scope, $timeout);
    $scope.fetchBooksDetail();
};


function initializeBook(book_title) {
    $(".menu_bar ul li").each(function (index) {
        if(index == 3) {
            $(this).addClass("active");
        }else {
            $(this).removeClass("active");
        }
    });

    $(document).attr("title", book_title + " | Pelin的个人博客");
}

function initializeBookContent(content_md) {
    var $contentBody = $(".content-body");

    //初始化书评内容
    console.log(marked(content_md));
    $contentBody.html(marked(content_md));

    //监测窗口滚动并更新文章导航条active
    $(window).scroll(function () {
        //45为搜索栏高度
        var scrollDistance = $("body").scrollTop() + 30;

        if (scrollDistance > 165) {
            $(".content-nav").addClass("fixed");
        } else if (scrollDistance <= 165) {
            $(".content-nav").removeClass("fixed");
        }
    });
}