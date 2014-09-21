define(['angular', 'pubnub'], function (angular, PUBNUB) {
    'use strict';

    /**
     * @ngdoc function
     * @name votacao.controller:VotoCtrl
     * @description
     * # VotoCtrl
     * Controller of the votacao
     */
    angular.module('votacao.controllers.VotoCtrl', [])
        .controller('VotoCtrl', ["$scope", "$http", "$routeParams", "$location",function ($scope, $http, $routeParams, $location) {

            $http({
                method: 'POST',
                dataType: 'json',
                url: 'api/voto',
                data : {
                    filme : {
                        id : $routeParams.idFilme
                    }
                },
                headers: {
                    "Content-Type": "application/json"
                }
            }).success (function () {
                var pubnub = PUBNUB.init({
                    publish_key: 'pub-c-a3d09656-7d8e-4a75-8568-56be4934dd22',
                    subscribe_key: 'sub-c-c1379f54-41cd-11e4-aed8-02ee2ddab7fe'
                });

                pubnub.publish({
                    channel: 'votos',
                    message: 'add'
                });

                $location.path("/");
            });
        }]
    );
});