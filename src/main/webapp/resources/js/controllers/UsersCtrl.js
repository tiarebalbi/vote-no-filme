define(['angular','pubnub', 'pubnub-angular','pubnub-crypto'], function (angular, pubnubD) {
    'use strict';

    /**
     * @ngdoc function
     * @name votacao.controller:UsersCtrl
     * @description
     * # UsersCtrl
     * Controller of the votacao
     */
    angular.module('votacao.controllers.UsersCtrl', ["pubnub.angular.service"])
        .controller('UsersCtrl', function ($rootScope, $scope, $location, $http, PubNub) {

            $scope.channel  = 'votacao-channel-users';

            var inicializarSocket = function (data, status, headers, config) {

                $scope.userId   = data.session;

                if (!$rootScope.initialized) {
                    // Initialize the PubNub service
                    PubNub.init({
                        publish_key: 'pub-c-a3d09656-7d8e-4a75-8568-56be4934dd22',
                        subscribe_key: 'sub-c-c1379f54-41cd-11e4-aed8-02ee2ddab7fe',
                        uuid:$scope.userId
                    });
                    $rootScope.initialized = true;
                }

                if($scope.userId !== undefined) PubNub.ngSubscribe({ channel: $scope.channel });

                $rootScope.$on(PubNub.ngPrsEv($scope.channel), function(ngEvent, payload) {
                    $scope.$apply(function() {
                        $scope.users = PubNub.ngListPresence($scope.channel);
                    });
                });

                PubNub.ngHereNow({
                    channel: $scope.channel
                });

                PubNub.ngHistory({
                    channel: $scope.channel,
                    count: 10
                });
            };

            $http({
                method: 'GET',
                dataType: 'json',
                url: 'api/usuario',
                data : '',
                headers: {
                    "Content-Type": "application/json"
                }
            }).success(inicializarSocket);

        }
    );
});