var $Wrapper = $("#Wrapper");
var $SlideBar = $("#SlideBar");
var startX, endX, status = 0;

function loadFontSize() {
    var templateWidth = 320;
    var actualWidth = $(window).width();

    $("html").css("font-size", (actualWidth * 1.0) / templateWidth * 10.5 + "px");
}


function slide() {
    if (status == 1) {
        //向左滑动
        $Wrapper.css('position', '');
        $SlideBar.animate({'right': '100%'}, 250);
        $Wrapper.animate({'margin-left': '0'}, 250);
        status = 0;
    } else if (status == 0) {
        //向右滑动
        $Wrapper.css('position', 'fixed');
        $SlideBar.animate({'right': '24%'}, 500);
        $Wrapper.animate({'margin-left': '76%'}, 500);
        status = 1;
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
                $("#Wrapper").css('position', '');
                $("#SlideBar").animate({'right': '100%'}, 250);
                $("#Wrapper").animate({'margin-left': '0'}, 250);
                status = 0;
            }
        }
    }
});