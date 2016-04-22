
var IndexController = function ($scope, $interval, $http) {

    $scope.fetchArticlesList = function () {
        $http.get('/topTenArticle.json').
            success(function(data) {
                $scope.detail = data.detail;
                $scope.articleList = data.pagination.items;
                $scope.f_article = data.firstArticle;
                initialize($scope.f_article.content);
            }).
            error(function (err) {
                console.log(err);
            });
    }

    $scope.fetchArticlesList();
};
/**
 * 初始化
 * @param content_md 文章内容MD
 */
function initialize(content_md){
    //loadCss();
    var $contentBody = $(".content-body");

    $(".menu_bar ul li:eq(0)").addClass("active");
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
/**
 * 加载css文件
 */
function loadCss(){
    console.log(1);
    $("<link>").
        attr({rel: "stylesheet",
            type: "text/css",
            href: "/resources/css/index.css"
        }).
        appendTo("head");
}
