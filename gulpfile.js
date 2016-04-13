var gulp = require('gulp');

var jshint = require('gulp-jshint');
var less = require('gulp-less');
var concat = require('gulp-concat');
var uglify = require('gulp-uglify');
var rename = require('gulp-rename');


gulp.task('lint', function () {
    gulp.src('src/main/webapp/resources/js/*.js')
        .pipe(jshint())
        .pipe(jshint.reporter('default'));
});

gulp.task('less', function () {
    gulp.src('src/main/webapp/resources/less/**/*.less')
        .pipe(less())
        .pipe(gulp.dest('src/main/webapp/resources/css'));
})


gulp.task('default', function () {
    gulp.run('lint', 'less');
})