/*jshint unused: vars */
require.config({
    paths: {
        angular: '../vendor/angular/angular',
        'angular-animate': '../vendor/angular-animate/angular-animate.min',
        'angular-cookies': '../vendor/angular-cookies/angular-cookies.min',
        'angular-mocks': '../vendor/angular-mocks/angular-mocks.min',
        'angular-resource': '../vendor/angular-resource/angular-resource.min',
        'angular-route': '../vendor/angular-route/angular-route.min',
        'angular-sanitize': '../vendor/angular-sanitize/angular-sanitize.min',
        'angular-scenario': '../vendor/angular-scenario/angular-scenario.min',
        'angular-touch': '../vendor/angular-touch/angular-touch.min',
        bootstrap: '../vendor/bootstrap/dist/js/bootstrap.min',
        'pubnub-angular' : "//pubnub.github.io/angular-js/scripts/pubnub-angular",
        'pubnub' : '//cdn.pubnub.com/pubnub.min',
        'pubnub-crypto' : '//cdn.pubnub.com/pubnub-crypto.min'
    },
    shim: {
        angular: {
            exports: 'angular'
        },
        'angular-route': [
            'angular'
        ],
        'angular-cookies': [
            'angular'
        ],
        'angular-sanitize': [
            'angular'
        ],
        'angular-resource': [
            'angular'
        ],
        'angular-animate': [
            'angular'
        ],
        'angular-touch': [
            'angular'
        ],
        'angular-mocks': {
            deps: [
                'angular'
            ],
            exports: 'angular.mock'
        },
        'pubnub': {
            exports: 'PUBNUB'
        },
        'pubnub-angular': {
            deps: [
                'pubnub'
            ]
        },
        'pubnub-crypto': {
            deps: [
                'pubnub'
            ]
        }

    },
    priority: [
        'angular'
    ],
    packages: [

    ]
});

//http://code.angularjs.org/1.2.1/docs/guide/bootstrap#overview_deferred-bootstrap
window.name = 'NG_DEFER_BOOTSTRAP!';

require([
    'angular',
    'app',
    'angular-route',
    'angular-cookies',
    'angular-sanitize',
    'angular-resource',
    'angular-animate',
    'angular-touch'
], function(angular, app, ngRoutes, ngCookies, ngSanitize, ngResource, ngAnimate, ngTouch) {
    'use strict';
    /* jshint ignore:start */
    var $html = angular.element(document.getElementsByTagName('html')[0]);
    /* jshint ignore:end */
    angular.element().ready(function() {
        angular.resumeBootstrap([app.name]);
    });
});
