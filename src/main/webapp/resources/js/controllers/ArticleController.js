
var ArticleController = function ($scope, $interval, $http, $timeout, $routeParams) {
    var articleSlug = $routeParams.articleSlug;

    $scope.fetchArticle = function () {
        $http.get('/article/' + articleSlug + '.json').
            success(function (data) {
                initializeArticleSlug();
                console.log("测试结果");
                console.log(data);
            })
    }
};


function initializeArticleSlug () {
    $(".menu_bar ul li").each(function () {
        $(this).removeClass("active");
    });
}