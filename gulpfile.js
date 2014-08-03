var gulp = require('gulp');
var bowerSrc = require('gulp-bower-src');

gulp.task('default', function () {
    bowerSrc()
        .pipe(gulp.dest('src/main/webapp/resources/vendor'));
});