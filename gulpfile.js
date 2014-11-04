var gulp = require('gulp'),
    bowerSrc = require('gulp-bower-src'),
    concat = require('gulp-concat'),
    uglify = require('gulp-uglify'),
    sourcemaps = require('gulp-sourcemaps'),
    jshint = require('gulp-jshint'),
    rename = require('gulp-rename'),
    notify = require('gulp-notify');

gulp.task('move', function() {
    bowerSrc().pipe(gulp.dest('src/main/webapp/resources/vendor'));
});

gulp.task('default', function () {
    gulp.start('move'); // scripts
});
