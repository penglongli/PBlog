
var AboutController = function ($scope, $interval, $http, $timeout) {
    $scope.fetchAboutMessage = function () {

        $http.get('/about.json').
            success(function (data) {
                initializeAbout();
                initializeLoad($scope, $timeout);


            }).
            error(function (err) {
                console.log(err);
            });
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