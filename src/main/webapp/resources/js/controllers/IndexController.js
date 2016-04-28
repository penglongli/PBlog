
var IndexController = function ($scope, $interval, $http, $timeout) {

    $scope.fetchArticlesList = function () {
        $http.get('/topTenArticle.json').
            success(function(data) {
                $scope.detail = data.detail;
                $scope.articleList = data.pagination.items;
                $scope.f_article = data.firstArticle;

                initializeIndex($scope.f_article.content);
                initializeLoad($scope, $timeout);
            }).
            error(function (err) {
                console.log(err);
            });
    }

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
    })

    $contentBody.html(marked(content_md));
    loadSlider();
}
/**
 * 加载滚动条
 */
function loadSlider(){
    var $container = $(".scroll-area");
    var $content = $(".article-list");
    var $slideArea = $(".scroll-vertical");
    var $bar = $(".scroll-bar");

    $container.slider({
        container: $container,
        content: $content,
        slideArea: $slideArea,
        bar: $bar
    });
}