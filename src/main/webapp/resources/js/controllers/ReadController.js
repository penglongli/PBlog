
var ReadController = function ($scope, $interval, $http, $timeout) {
    
    $scope.fetchBooksList = function () {
        initializeRead();
        initializeLoad($scope, $timeout);
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