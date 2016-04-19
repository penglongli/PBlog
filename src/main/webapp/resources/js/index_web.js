var $$ = function (func) {
    if (document.addEventListener) {
        window.addEventListener("load", func, false);
    }
    else if (document.attachEvent) {
        window.attachEvent("onload", func);
    }
}

$(function () {
    loadSlider()
});

function loadSlider() {
    var $container = $(".scroll-area");
    var $content = $(".article-list");
    var $slideArea = $(".scroll-vertical");
    var $bar = $(".scroll-bar");
    var $markdown = $(".markdown-content");
    var $articleContent = $(".content-body");

    $articleContent.html(marked($markdown.val()));

    $container.slider({
        container: $container,
        content: $content,
        slideArea: $slideArea,
        bar: $bar
    });
}