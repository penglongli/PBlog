;(function ($) {
    var maxTop, maxMarginTop;

    function SliderBar(context, options){
        this.context = context;
        this.option = options;
    }

    SliderBar.prototype.init = function () {
        var $container = this.option.container;
        var $content = this.option.content;
        var $bar = this.option.bar;

        //初始化文章和导航高度
        $content.css({"top": 0});
        $bar.css({"margin-top": 0});

        if($container.height() < $content.height()){
            this.bindScrollEvent();
            this.bindDragEvent();
        }
    }

    //绑定滚动事件
    SliderBar.prototype.bindScrollEvent = function (){
        var _this = this;
        var $container = _this.option.container;

        $container.bind("mousewheel", function(event){
            event.preventDefault();
            _this.calcDistance(-event.originalEvent.wheelDelta/120);
        })
    }

    //监测拖动
    SliderBar.prototype.bindDragEvent = function () {
        var _this = this;
        var $bar = this.option.bar;
        var lastY = 0, currentY, isDraging = false;

        $bar.mousedown(function (event){
            lastY = event.clientY;
            isDraging = true;
        })
        $(document).mousemove(function (event) {
            if(isDraging){
                currentY = event.clientY;

                _this.calcLimit();

                var barMarginTop = currentY - lastY;
                var contentTop = (barMarginTop * maxTop) / maxMarginTop;

                _this.modifyStyle(-contentTop, barMarginTop, maxTop, maxMarginTop);
                lastY = event.clientY;
            }
        })
        $(document).mouseup(function (){
            isDraging = false;
        })

    }

    //计算位移
    SliderBar.prototype.calcDistance = function (value) {
        //滑轮滚动一次位移距离
        var speed = this.option.speed;
        var contentTop = -(speed * value);
        var barMarginTop = -(maxMarginTop * (contentTop / maxTop));

        this.calcLimit();

        this.modifyStyle(contentTop, barMarginTop, maxTop, maxMarginTop);
    }

    //计算临界值
    SliderBar.prototype.calcLimit = function (){
        //滚动内容高度
        var conHeight = this.option.content.height();
        //浏览器高度
        var deviceHeight = this.option.container.height();
        //滚动条高度
        var barHeight = this.option.bar.height();

        maxTop = conHeight - deviceHeight;
        maxMarginTop = deviceHeight - barHeight;
    }

    SliderBar.prototype.modifyStyle = function (top, marginTop, maxTop, maxMarginTop) {
        var $content = this.option.content;
        var $bar = this.option.bar;
        var currentTop = parseFloat(($content.css("top")).replace("px", ""));
        var currentMarginTop = parseFloat(($bar.css("margin-top")).replace("px", ""));
        var actualTop = currentTop + top, actualMarginTop = currentMarginTop + marginTop;

        if(actualTop > 0){
            actualTop = 0;
        }else if(-actualTop > maxTop){
            actualTop = -maxTop;
        }
        if(actualMarginTop < 0){
            actualMarginTop = 0;
        }else if(actualMarginTop > maxMarginTop){
            actualMarginTop = maxMarginTop;
        }

        $content.css("top", actualTop + "px");
        $bar.css("margin-top", actualMarginTop + "px");
    }


    $.fn.slider = function(options){
        var defaults = {
            speed: 5,
            container: null,
            content: null,
            slideArea: null,
            bar: null
        };
        var opt = $.extend({}, defaults, options);
        return this.each(function () {
            var sliderBar = new SliderBar($(this), opt);
            sliderBar.init();
        });
    }

})(jQuery);