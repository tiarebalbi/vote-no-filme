/*jshint unused: vars */
define([
    'angular',
    'controllers/FilmeCtrl',
    'controllers/SobreCtrl',
    'controllers/VotoCtrl',
    'controllers/RankingCtrl',
    'controllers/CadastroCtrl',
    'controllers/UsersCtrl'
    ]/*deps*/,
    function (angular, FilmeCtrl, SobreCtrl, VotoCtrl, RankingCtrl, CadastroCtrl, UsersCtrl)/*invoke*/ {
    'use strict';

    /**
     * @ngdoc overview
     * @name votacao
     * @description
     * # votacao
     *
     * Main module of the application.
     */
    return angular
        .module('votacao', [
            'votacao.controllers.FilmeCtrl',
            'votacao.controllers.SobreCtrl',
            'votacao.controllers.VotoCtrl',
            'votacao.controllers.RankingCtrl',
            'votacao.controllers.CadastroCtrl',
            'votacao.controllers.UsersCtrl',
            /*angJSDeps*/
            'ngCookies',
            'ngResource',
            'ngSanitize',
            'ngRoute',
            'ngAnimate',
            'ngTouch'
        ])
        .config(function ($routeProvider) {
            $routeProvider
                .when('/', {
                    templateUrl: 'resources/js/template/filmes.html',
                    controller: 'FilmeCtrl'
                })
                .when('/voto/:idFilme', {
                    templateUrl: 'resources/js/template/voto.html',
                    controller: 'VotoCtrl'
                })
                .when('/sobre', {
                    templateUrl: 'resources/js/template/sobre.html',
                    controller: 'SobreCtrl'
                })
                .when('/ranking', {
                    templateUrl: 'resources/js/template/ranking.html',
                    controller: 'RankingCtrl'
                })
                .when('/cadastro', {
                    templateUrl: 'resources/js/template/cadastro.html',
                    controller: 'CadastroCtrl'
                })
                .otherwise({
                    redirectTo: '/'
                });
        });
});
