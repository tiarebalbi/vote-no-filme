define(['angular', 'pubnub'], function (angular, PUBNUB) {
    'use strict';

    /**
     * @ngdoc function
     * @name votacao.controller:RankingCtrl
     * @description
     * # RankingCtrl
     * Controller of the votacao
     */
    angular.module('votacao.controllers.RankingCtrl', [])
        .controller('RankingCtrl', ['$scope', "$http", "$location",function ($scope, $http, $location) {
            $scope.usuario = {};

            $scope.votosGerais = new Array();
            $scope.votosUsuario = new Array();

            $http({
                method: 'GET',
                dataType: 'json',
                url: 'api/usuario',
                data : '',
                headers: {
                    "Content-Type": "application/json"
                }
            }).success(function(data, status, headers, config) {

                if(data.usuario === null) {
                    $location.path("/cadastro");
                    return;
                }

                $scope.usuario = data.usuario;

                // Consultando Ranking do Usuário
                $http({
                    method: 'GET',
                    dataType: 'json',
                    url: 'api/voto/ranking/' + $scope.usuario.id,
                    data : '',
                    headers: {
                        "Content-Type": "application/json"
                    }
                }).success(function(data, status, headers, config) {
                    $scope.votosUsuario = data.data;

                }).error(function(data, status, headers, config) {
                    $location.path("/");

                });

            }).error(function(data, status, headers, config) {
                $location.path("/cadastro");

            });

            // Consultando Ranking geral
            var refreshRankingGeral = function () {
                $http({
                    method: 'GET',
                    dataType: 'json',
                    url: 'api/voto/ranking',
                    data : '',
                    headers: {
                        "Content-Type": "application/json"
                    }
                }).success(function(data, status, headers, config) {
                    $scope.votosGerais = data.data;

                }).error(function(data, status, headers, config) {
                    $location.path("/");

                });
            };
            refreshRankingGeral();

            var pubnub = PUBNUB.init({
                publish_key: 'pub-c-a3d09656-7d8e-4a75-8568-56be4934dd22',
                subscribe_key: 'sub-c-c1379f54-41cd-11e4-aed8-02ee2ddab7fe'
            });

            pubnub.subscribe({
                channel: 'votos',
                message: function(m){
                    if(m == "add") {
                        refreshRankingGeral();
                    }
                }
            });



        }]
    );
});
