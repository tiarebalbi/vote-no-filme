var gulp = require('gulp'),
    bowerSrc = require('gulp-bower-src'),
    concat = require('gulp-concat'),
    uglify = require('gulp-uglify'),
    sourcemaps = require('gulp-sourcemaps'),
    jshint = require('gulp-jshint'),
    rename = require('gulp-rename'),
    notify = require('gulp-notify');

// Desativado devido ao uso do require.js

//gulp.task('scripts', function() {
//    return gulp.src('bower_components/**/*.js')
//        .pipe(concat('main.js'))
//        .pipe(gulp.dest('src/main/webapp/resources/vendor/dist'))
//        .pipe(rename({ suffix: '.min' }))
//        .pipe(uglify())
//        .pipe(gulp.dest('src/main/webapp/resources/vendor/dist'))
//        .pipe(notify({ message: 'Tarefa de script finalizada com sucesso.' }));
//});

gulp.task('move', function() {
    bowerSrc().pipe(gulp.dest('src/main/webapp/resources/vendor'));
});

gulp.task('default', function () {
    gulp.start('move'); // scripts
});
