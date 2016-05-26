
var AboutController = function ($scope, $interval, $http, $timeout) {
    initializeAbout();
    initializeLoad($scope, $timeout);
};

function initializeAbout() {
    $(".menu_bar ul li").each(function (index) {
        if(index == 5) {
            $(this).addClass("active");
        }else {
            $(this).removeClass("active");
        }
    });

    $(document).attr("title","关于 | Pelin的个人博客");
}