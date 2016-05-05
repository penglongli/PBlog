
var ReadController = function ($scope, $interval, $http, $timeout) {
    
    $scope.fetchBooksList = function () {
        initializeRead();
        initializeLoad($scope, $timeout);
    };

    $scope.fetchBooksList();
};

function initializeRead() {

}