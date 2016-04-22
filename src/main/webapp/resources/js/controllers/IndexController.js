'use strict'

var IndexController = function ($scope, $interval, $http) {

    $scope.fetchArticlesList = function () {
        $http.get('/topTenArticle.json').
            success(function(data) {
                $scope.detail = data.detail;
                $scope.articleList = data.pagination.items;
                $scope.f_article = data.firstArticle;
            }).
            error(function (err) {
                console.log(err);
            });
    }

    $scope.fetchArticlesList();
}