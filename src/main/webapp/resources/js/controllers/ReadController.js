
var ReadController = function ($scope, $interval, $http, $timeout) {
    
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

    $scope.fetchBooksList();
};

function initializeRead() {
    $(".menu_bar ul li").each(function (index) {
        if(index == 3) {
            $(this).addClass("active");
        }else {
            $(this).removeClass("active");
        }
    });
}