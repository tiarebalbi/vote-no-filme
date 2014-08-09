require.config({

	paths : {
		'domReady' : '../../vendor/bootstrap/dist/js/bootstrap.min',
		'bootstrap' : '../../vendor/bootstrap/dist/js/bootstrap.min',
		'angular' : '../../vendor/angular/angular.min'
	},

	shim : {
		'angular' : {
			exports : 'angular'
		}
	},

	deps : [ './init-bootstrap' ]
});