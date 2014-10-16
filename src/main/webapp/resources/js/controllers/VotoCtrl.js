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
                    publish_key: 'pub-c-b47c13fa-4851-4345-bef8-83fc9b6b4038',
                    subscribe_key: 'sub-c-b9ca96fa-5338-11e4-a551-02ee2ddab7fe'
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