
var ArchivesTimeStampController = function ($scope, $interval, $http, $timeout, $routeParams) {
    var timeStamp = $routeParams.timeStamp;

    $scope.fetchArchivesTimeStampList = function () {
        $http.get('/archives/' + timeStamp + '.json').
            success(function (data) {
                initializeArchivesTimeStamp();
                initializeLoad($scope, $timeout);

                $scope.archivesList = data.archivesVOList;
                $scope.articleList = data.articleInfoVOList;
                $scope.timeStamp = timeStamp;
            }).
            error(function (err) {
                console.log(err);
            });
    };

    $scope.fetchArchivesTimeStampList();
};

function initializeArchivesTimeStamp() {
    $(".menu_bar ul li").each(function (index) {
        if(index == 1) {
            $(this).addClass("active");
        }else {
            $(this).removeClass("active");
        }
    });
}