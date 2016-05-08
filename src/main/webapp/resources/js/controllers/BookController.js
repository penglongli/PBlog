
var BookController = function ($scope, $interval, $http, $timeout, $routeParams) {
    var bookSlug = $routeParams.bookSlug

    $scope.fetchBooksList = function () {
        $http.get('/book/list.json').
        success(function(data) {
            initializeRead();
            initializeLoad($scope, $timeout);

            $scope.bookInfoList = data.bookInfoVOList;
            $scope.bookTableList = data.bookTableVOList;
        }).
        error(function(err) {
            console.log(err);
        });
    };

};


function initializeBook() {
    $(".menu_bar ul li").each(function (index) {
        if(index == 3) {
            $(this).addClass("active");
        }else {
            $(this).removeClass("active");
        }
    });
}