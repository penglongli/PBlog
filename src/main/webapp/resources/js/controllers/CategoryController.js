
var CategoryController = function ($scope, $interval, $http, $timeout) {

    $scope.fetchCategoryList = function () {
        $http.get('/categoryList.json').
            success(function (data) {
                $scope.categoryList = data.categoryInfoVOList;
                $scope.articleList = data.articleInfoVOList;
            }).
            error(function (err) {
                console.log(err);
            });
    };

    initializeCategory();
    initializeLoad($scope, $timeout);
    $scope.fetchCategoryList();
};

function initializeCategory() {
    $(".menu_bar ul li").each(function (index) {
        if(index == 2) {
            $(this).addClass("active");
        }else {
            $(this).removeClass("active");
        }
    });

    $(document).attr("title","分类 | Pelin的个人博客");
}