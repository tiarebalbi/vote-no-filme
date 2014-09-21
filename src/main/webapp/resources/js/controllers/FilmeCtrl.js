define(['angular'], function (angular) {
    'use strict';

    /**
     * @ngdoc function
     * @name votacao.controller:FilmeCtrl
     * @description
     * # FilmeCtrl
     * Controller of the votacao
     */
    angular.module('votacao.controllers.FilmeCtrl', [])
        .controller('FilmeCtrl', ['$scope', "$http", "$location",function ($scope, $http, $location) {
            $scope.filmes = new Array();
            $scope.total = 0;

            $http({
                method: 'GET',
                dataType: 'json',
                url: 'api/filme',
                data : '',
                headers: {
                    "Content-Type": "application/json"
                }
            }).success(function(data, status, headers, config) {
                    $scope.filmes = data;

            }).error(function(data, status, headers, config) {
                    $scope.mensagem = "Não foi possível carregar os filmes, por favor tente novamente";

            });

            $http({
                method: 'GET',
                dataType: 'json',
                url: 'api/voto/total',
                data : '',
                headers: {
                    "Content-Type": "application/json"
                }
            }).success(function(data, status, headers, config) {
                $scope.total = data.total;
            });
        }]
    );
});