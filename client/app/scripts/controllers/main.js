'use strict';

angular.module('corsPlayAngularApp')
    .controller('MainCtrl', function ($scope, $http, $q) {
        $scope.awesomeThings = [
            'HTML5 Boilerplate',
            'AngularJS',
            'Karma'
        ];

        $scope.response = {};

        $scope.getData = function () {
            $http
                .get('http://localhost:19000/sayHello ').
                success(function (data) {
                    console.log(data);
                    $scope.response = data;
                });
        };

    });
