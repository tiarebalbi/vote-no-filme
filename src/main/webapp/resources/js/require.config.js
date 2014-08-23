require.config({
	baseUrl : 'resources/js/',
    paths: {
        'angular': '../vendor/angular/angular',
        'angular-route': '../vendor/angular-route/angular-route',
        'domReady': '../vendor/requirejs-domready/domReady'
    },

    shim: {
        'angular': {
            exports: 'angular'
        },
        'angular-route': {
            deps: ['angular']
        }
    },

    deps: [
        './init-bootstrap'
    ]
});