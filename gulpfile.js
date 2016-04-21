var gulp = require('gulp');
var jshint = require('gulp-jshint');
var less = require('gulp-less');
var concat = require('gulp-concat');
var uglify = require('gulp-uglify');
var rename = require('gulp-rename');

var src = {
    js: 'src/main/webapp/resources/js/**/*.js',
    less: 'src/main/webapp/resources/less/**/*.less',
    mainjs: [
        'assests/'
    ]
}

var dist = {
    js: 'assets/dist/js/',
    css: 'assets/dist/css'
}

gulp.task('minifyjs', function() {
    gulp.src(src.js)
        .pipe(rename({suffix: '.min'}))
        .pipe(uglify({preserveComments : 'some'}))
        .pipe(gulp.dest(dist.js));
})

gulp.task('combinejs', function() {
    gulp.src(src)
})

gulp.task('less', function () {
    gulp.src('src/main/webapp/resources/less/**/*.less')
        .pipe(less())
        .pipe(gulp.dest('src/main/webapp/resources/css'));
})


gulp.task('default', function () {
    gulp.run('lint', 'less');
})