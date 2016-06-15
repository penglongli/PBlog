var gulp = require('gulp');
var jshint = require('gulp-jshint');
var less = require('gulp-less');
var concat = require('gulp-concat');
var uglify = require('gulp-uglify');
var rename = require('gulp-rename');
var clean = require('gulp-clean');
var minifycss = require('gulp-minify-css');
var rev = require('gulp-rev');
var revCollector = require('gulp-rev-collector');

var resourceDir = 'src/main/webapp/resources';
var viewDir = 'src/main/webapp/WEB-INF/jsp/';
var src = {
    js: resourceDir + '/js/*.js',
    jsController: resourceDir + '/js/controllers/*.js',
    less: resourceDir + '/less/**/*.less',
};

var dist = {
    js: resourceDir + '/assets/js/',
    css: resourceDir + '/assets/css/',
    rev: resourceDir + '/assets/rev/'
};

//编译less文件
gulp.task('less', function () {
    return gulp.src(src.less)
        .pipe(less())
        .pipe(gulp.dest(dist.css));
});

gulp.task('cleanCss', function () {
    return gulp.src(dist.css + '*-pc-main-*.css')
        .pipe(clean());
});

//合并压缩PC端夜间模式css文件
gulp.task('combinePcNightCss', ['less', 'cleanCss'], function () {
    return gulp.src([
            resourceDir + 'assets/plugins/loading-bar.css',   //进度条样式
            dist.css + '*/night_*.css'
        ])
        .pipe(concat('night-pc-main.css'))
        .pipe(minifycss())
        .pipe(rev())
        .pipe(gulp.dest(dist.css))
        .pipe(rev.manifest())
        .pipe(gulp.dest(dist.rev))
});

//合并压缩PC端日间模式css文件
gulp.task('combinePcDayCss',['less', 'combinePcNightCss'], function () {
    return gulp.src([
            resourceDir + 'assets/plugins/loading-bar.css',   //进度条样式
            dist.css + '*/day_*.css'
        ])
        .pipe(concat('day-pc-main.css'))
        .pipe(minifycss())
        .pipe(rev())
        .pipe(gulp.dest(dist.css))
        .pipe(rev.manifest(dist.rev + 'rev-manifest.json', {
            merge: true,
            base: dist.rev
        }))
        .pipe(gulp.dest(dist.rev));
});

//重写视图，执行css替换
gulp.task('revTask', ['combinePcDayCss'], function () {
    gulp.src([dist.rev + '*.json', viewDir + 'web/home.jsp'])
        .pipe(revCollector())
        .pipe(gulp.dest(viewDir + 'web'));
});

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


gulp.task('default', ['revTask', 'combinePluginJs', 'combineOwnJs', 'combineJs']);