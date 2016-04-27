
var ArticleController = function ($scope, $interval, $http, $timeout, $routeParams) {
    var articleSlug = $routeParams.articleSlug;

    $scope.fetchArticle = function () {
        $http.get('/article/' + articleSlug + '.json').
            success(function (data) {
                initializeArticleSlug();

                $scope.articleVO = data.articleVO;
            })
    };

    $scope.fetchArticle();
};


function initializeArticleSlug () {
    $(".menu_bar ul li").each(function () {
        $(this).removeClass("active");
    });
}