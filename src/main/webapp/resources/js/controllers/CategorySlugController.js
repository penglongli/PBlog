
var CategorySlugController = function ($scope, $interval, $http, $timeout, $routeParams) {
    var categorySlug = $routeParams.categorySlug;

    $scope.fetchCategorySlugList = function () {
        $http.get('/category/' + categorySlug + '.json').
            success(function (data) {
                initializeCategorySlug();
                $scope.categoryList = data.categoryInfoVOList;
                $scope.articleList = data.articleInfoVOList;
                initializeLoad($scope, $timeout);
            }).
            error(function (err) {
                console.log(err);
            });
    };
    $scope.fetchCategorySlugList();
};

function initializeCategorySlug () {
    $(".menu_bar ul li").each(function (index) {
        if(index == 2) {
            $(this).addClass("active");
        }else {
            $(this).removeClass("active");
        }
    });
}