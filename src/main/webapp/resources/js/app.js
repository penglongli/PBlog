var pBlogApp = {};

var app = angular.module('pBlogApp', ['chieffancypants.loadingBar', 'ngAnimate', 'ngRoute', 'ngSanitize', 'pBlogApp.filters', 'pBlogApp.services', 'pBlogApp.directives']).
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

        $routeProvider.when('/archives/:timeStamp', {
            templateUrl: '/archives/layout',
            controller: ArchivesTimeStampController
        });

        $routeProvider.when('/category/:categorySlug', {
            templateUrl: '/category/layout',
            controller: CategorySlugController
        });

        $routeProvider.when('/article/:articleSlug', {
            templateUrl: '/article/slug/layout',
            controller: ArticleController
        });

        $routeProvider.otherwise({redirectTo: '/index'});
    }).
    config(function(cfpLoadingBarProvider) {
        //配置angular-loading-bar
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

        initializeHighLight();
    }, 750);
}

/**
 * 加载代码高亮插件
 */
function initializeHighLight() {
    console.log("加载代码高亮");
    $('pre code').each(function(i, block) {
        hljs.highlightBlock(block);
    });
}
