
var RecordController = function ($scope, $interval, $http, $timeout, $routeParams) {

    $scope.fetchRecordList = function () {
        $http.get('/record.json').
            success(function (data) {
                $scope.recordInfoList = data.recordInfoList;

                for(var i = 0; i < data.recordInfoList.length; i++) {
                    $scope.recordInfoList[i].content = marked(data.recordInfoList[i].content);
                }
            })
    };

    initializeRecord();
    initializeLoad($scope, $timeout);
    $scope.fetchRecordList();
};

function initializeRecord () {
    $(".menu_bar ul li").each(function (index) {
        if(index == 4) {
            $(this).addClass("active");
        }else {
            $(this).removeClass("active");
        }
    });

    $(document).attr("title","记录 | Pelin的个人博客");
}

