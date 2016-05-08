
var CategoryController = function ($scope, $interval, $http, $timeout) {

    $scope.fetchCategoryList = function () {
        $http.get('/categoryList.json').
            success(function (data) {
                initializeCategory();
                initializeLoad($scope, $timeout);

                $scope.categoryList = data.categoryInfoVOList;
                $scope.articleList = data.articleInfoVOList;
            }).
            error(function (err) {
                console.log(err);
            });
    };

    $scope.fetchCategoryList();
};

function initializeCategory() {
    $(".menu_bar ul li").each(function (index) {
        if(index == 2) {
            $(this).addClass("active");
        }else {
            $(this).removeClass("active");
        }
    })
}