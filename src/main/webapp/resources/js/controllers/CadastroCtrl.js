define(['angular'], function (angular) {
    'use strict';

    /**
     * @ngdoc function
     * @name votacao.controller:CadastroCtrl
     * @description
     * # CadastroCtrl
     * Controller of the votacao
     */
    angular.module('votacao.controllers.CadastroCtrl', ["pubnub.angular.service"])
        .controller('CadastroCtrl', function ($rootScope, $scope, $location, $http, PubNub) {
            $scope.usuario = {status : true};

            $scope.salvar = function (form) {
                if(form.$valid == true) {

                    $http({
                        method: 'POST',
                        dataType: 'json',
                        url: 'api/usuario',
                        data : $scope.usuario,
                        headers: {
                            "Content-Type": "application/json"
                        }
                    }).success(function(data, status, headers, config) {
                        window.location = "#/ranking";
                    }).error(function(data, status, headers, config) {
                        console.log(data);
                    });
                }
            };

        }
    );
});