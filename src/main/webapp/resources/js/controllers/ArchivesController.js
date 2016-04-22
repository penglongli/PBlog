
var ArchivesController = function ($scope, $interval, $http) {
    
    $scope.fetchArchivesList = function () {
        $http.get('/archivesList.json').
            success(function (data) {
                $scope.archivesList = data.archivesList;
            }).
            error(function (err) {
                console.log(err);
            });
    }

    $scope.fetchArchivesList();
};