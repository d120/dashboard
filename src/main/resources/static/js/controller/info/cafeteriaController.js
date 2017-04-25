'use strict';

var app = angular.module('dashboardApp');

app.controller('cafeteriaController', ['$scope', '$http', '$interval', function ($scope, $http, $interval) {
    var loadCafeteria = function () {
        $http.get('/api/cafeteria/grouped').then(function (response) {
            $scope.categories = response.data.categories;
        }, function () {
            // Error.
        });
    };

    // 30 minutes
    $interval(loadCafeteria, 30 * 60 * 60 * 1000);
    loadCafeteria();
}]);
