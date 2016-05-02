var $Wrapper = $("#Wrapper");
var $SlideBar = $("#SlideBar");
var $Content = $("#Content");
var $Top = $("#Top");
var $body = $(document.body);
var startX, endX, status = 0;

$(document).ready(function(){
    loadFontSize();
});

function loadFontSize() {
    var templateWidth = 320;
    var actualWidth = $(window).width();

    $("html").css("font-size", (actualWidth * 1.0) / templateWidth * 10.5 + "px");
}


function slide() {
    if (status == 1) {
        //向左滑动
        $SlideBar.animate({'right': '100%'}, 500);
        $Top.animate({'left': '0'}, 500);
        $Content.animate({'left': '0'}, 500, function () {
            $body.removeClass("body-slide");
            $Content.removeClass("content-slide");
        });
        status = 0;
    } else if (status == 0) {
        //向右滑动
        $body.addClass("body-slide");
        $Content.addClass("content-slide");
        $SlideBar.animate({'right': '24%'}, 500);
        $Top.animate({'left': '76%'}, 500);
        $Content.animate({'left': '76%'}, 500);
        status = 1;
    }
}

function sleep(n){
    var start = new Date().getTime();
    while (true) if (new Date().getTime() - start > n){
        break;
    }
}

$Wrapper.on({
    touchstart: function (e) {
        var touch = e.originalEvent.touches[0] || e.originalEvent.changedTouches[0];
        startX = touch.pageX;
    },
    touchend: function (e) {
        var touch = e.originalEvent.touches[0] || e.originalEvent.changedTouches[0];
        endX = touch.pageX;

        var distanceX = endX - startX;

        if (status == 1) {
            if (distanceX < 0) {
                //向左滑动
                $SlideBar.animate({'right': '100%'}, 500);
                $Top.animate({'left': '0'}, 500);
                $Content.animate({'left': '0'}, 500, function () {
                    $body.removeClass("body-slide");
                    $Content.removeClass("content-slide");
                });
                status = 0;
            }
        }
    }
});

//初始化时间轴
function timeLineInitial(){
    var $leftItem = $(".left-item");
    var $rightItem = $(".right-item");
    var nodeSize = $leftItem.size();

    for(var i = 0; i < nodeSize; i++){
        var rightHeight = $($rightItem[i]).height();

        $($leftItem[i]).css({"height": rightHeight + 40});
        $($rightItem[i]).fadeIn("slow");
        $($leftItem[i]).fadeIn("slow");
    }
}
