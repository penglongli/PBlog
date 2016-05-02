
var AboutController = function ($scope, $interval, $http, $timeout) {
    $scope.fetchAboutMessage = function () {
        initializeAbout();
        initializeLoad($scope, $timeout);
    };

    $scope.fetchAboutMessage();
};

function initializeAbout() {
    $(".menu_bar ul li").each(function (index) {
        if(index == 5) {
            $(this).addClass("active");
        }else {
            $(this).removeClass("active");
        }
    });
}