
var IndexController = function ($scope, $interval, $http, $timeout) {

    $scope.fetchArticlesList = function () {
        $http.get('/topTenArticle.json').
            success(function(data) {
                $scope.detail = data.detail;
                $scope.articleList = data.pagination.items;
                $scope.f_article = data.firstArticle;

                initializeIndex($scope.f_article.content);
            }).
            error(function (err) {
                console.log(err);
            });
    };

    initializeIndexLoad($scope, $timeout);
    $scope.fetchArticlesList();
};
/**
 * 初始化文章内容
 * @param content_md 文章内容MD
 */
function initializeIndex(content_md){
    var $contentBody = $(".content-body");

    $(".menu_bar ul li").each(function (index) {
        if(index == 0) {
            $(this).addClass("active");
        }else {
            $(this).removeClass("active");
        }
    });

    $(document).attr("title","首页 | Pelin的个人博客");

    $contentBody.html(marked(content_md));
}

/**
 * 加载首页进度条(因为首页有滚动条，为了让 **滚动条** 能够加载，必须等到数据已经动态加载结束后加载 **滚动条**)
 * @param $scope
 * @param $timeout
 */

function initializeIndexLoad($scope, $timeout) {
    $scope.start();
    $scope.fakeIntro = true;
    $timeout(function() {
        $scope.complete();
        $scope.fakeIntro = false;

        initializeHighLight();
        loadSlider();
    }, 750);
}

/**
 * 加载滚动条
 */
function loadSlider(){
    var $container = $(".scroll-area");
    var $content = $(".index-article-list");
    var $slideArea = $(".scroll-vertical");
    var $bar = $(".scroll-bar");

    $container.slider({
        container: $container,
        content: $content,
        slideArea: $slideArea,
        bar: $bar
    });
}