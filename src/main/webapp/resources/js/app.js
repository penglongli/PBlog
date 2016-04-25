var pBlogApp = {};

var APP = angular.module('pBlogApp', ['chieffancypants.loadingBar', 'ngAnimate', 'ngRoute', 'ngSanitize', 'pBlogApp.filters', 'pBlogApp.services', 'pBlogApp.directives']).
    config(function ($routeProvider) {
        $routeProvider.when('/index', {
            templateUrl: '/index/layout',
            controller: IndexController
        });

        $routeProvider.when('/archives', {
            templateUrl: '/archives/layout',
            controller: ArchivesController
        });

        $routeProvider.when('/category', {
            templateUrl: '/category/layout',
            controller: CategoryController
        });

        $routeProvider.otherwise({redirectTo: '/index'});
    }).
    config(function(cfpLoadingBarProvider) {
        cfpLoadingBarProvider.includeSpinner = true;
    }).
    controller('loadingBar', function ($scope, $http, $timeout, cfpLoadingBar) {
        $scope.start = function() {
            cfpLoadingBar.start();
        };

        $scope.complete = function () {
            cfpLoadingBar.complete();
        };
    });

/**
 * 加载进度条
 * @param $scope
 * @param $timeout
 */
function initializeLoad($scope, $timeout) {
    $scope.start();
    $scope.fakeIntro = true;
    $timeout(function() {
        $scope.complete();
        $scope.fakeIntro = false;
    }, 750);
}
