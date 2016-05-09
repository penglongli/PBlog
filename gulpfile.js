var gulp = require('gulp');
var jshint = require('gulp-jshint');
var less = require('gulp-less');
var concat = require('gulp-concat');
var uglify = require('gulp-uglify');
var rename = require('gulp-rename');
var minifycss = require('gulp-minify-css');

//var rev = require('gulp-rev');

var resourceDir = 'src/main/webapp/resources';

var src = {
    js: resourceDir + '/js/*.js',
    jsController: resourceDir + '/js/controllers/*.js',
    less: resourceDir + '/less/**/*.less',
};

var dist = {
    js: resourceDir + '/assets/js/',
    css: resourceDir + '/assets/css/'
};

/**
 * 打包AngularJs工具
*/
gulp.task('combinePluginJs', function () {
    gulp.src([
        resourceDir + '/js/plugins/angular.min.js',
        resourceDir + '/js/plugins/angular-animate.min.js',
        resourceDir + '/js/plugins/angular-route.min.js',
        resourceDir + '/js/plugins/angular-sanitize.min.js'
    ])
    .pipe(jshint.reporter('default'))
    .pipe(concat('angular-plugins.min.js'))
    .pipe(gulp.dest(dist.js));
});

/**
 * 打包个人工具组件
**/
gulp.task('combineOwnJs', function () {
    gulp.src([
        resourceDir + '/js/plugins/jquery.min.js',
        resourceDir + '/js/plugins/marked.js',
        resourceDir + '/js/plugins/SliderBar.js'])
            .pipe(jshint.reporter('default'))
            .pipe(concat('lib.min.js'))
            .pipe(gulp.dest(dist.js));
});

/**
 * 打包Angular编写的客户端JS
**/
gulp.task('combineJs', function () {
    gulp.src([src.js, src.jsController])
        .pipe(uglify({mangle: false}))
        .pipe(concat('client-js.min.js'))
        .pipe(gulp.dest(dist.js));
});

gulp.task('less', function () {
    gulp.src(src.less)
        .pipe(less())
        .pipe(gulp.dest(dist.css));
});

//合并压缩PC端css文件
gulp.task('combinePcCss', function () {
    gulp.src([
        resourceDir + '/assets/css/plugins/loading-bar.css',   //进度条样式
        resourceDir + '/assets/css/include/index_global.css',
        resourceDir + '/assets/css/about/*.css',
        resourceDir + '/assets/css/archives/*.css',
        resourceDir + '/assets/css/article/*.css',
        resourceDir + '/assets/css/book/*.css',
        resourceDir + '/assets/css/category/*.css',
        resourceDir + '/assets/css/index/*.css',
        resourceDir + '/assets/css/index/*.css'
    ])
    .pipe(concat('dacular-pc-main.css'))
    .pipe(gulp.dest(dist.css))
    .pipe(rename({ suffix: '.min' }))
    .pipe(minifycss())
    .pipe(gulp.dest(dist.css));
});





gulp.task('default', function () {

});