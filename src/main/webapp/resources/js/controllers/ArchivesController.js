
var ArchivesController = function ($scope, $interval, $http, $timeout) {
    
    $scope.fetchArchivesList = function () {
        $http.get('/archivesList.json').
            success(function (data) {
                initializeArchives();
                $scope.archivesList = data.archivesVOList;
                $scope.articleList = data.archivesVOList[0].articleInfoVOList;

                initializeLoad($scope, $timeout);
            }).
            error(function (err) {
                console.log(err);
            });
    };

    $scope.fetchArchivesList();
};

/**
 * 初始化
 */
function initializeArchives() {
    $(".menu_bar ul li").each(function (index) {
        if(index == 1) {
            $(this).addClass("active");
        }else {
            $(this).removeClass("active");
        }
    });
}