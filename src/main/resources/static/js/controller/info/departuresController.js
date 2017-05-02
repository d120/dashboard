'use strict';

var app = angular.module('dashboardApp');

app.controller('departuresController', ['$scope', '$http', '$interval', function ($scope, $http, $interval) {
    $scope.DASHBOARD = DASHBOARD;

    $scope.index = 0;

    var loadDepartures = function () {
        $http.get('/api/departures/' + encodeURIComponent(DASHBOARD.station.id), {
            params: {
                limit: 50
            }
        }).then(function (response) {
            $scope.departures = response.data.departures;
        }, function () {
            // Error.
        });
    };

    $scope.getSeverity = function (dep) {
        var millisToDeparture = dep.plannedTime - Date.now();
        if (millisToDeparture < 0) {
            return 'default';
        } else if (millisToDeparture < DASHBOARD.station.time.critical * 1000 * 60) {
            return 'danger';
        } else if (millisToDeparture < DASHBOARD.station.time.warning * 1000 * 60) {
            return 'warning';
        } else {
            return 'success';
        }
    };

    // 30 seconds
    $interval(loadDepartures, 30 * 1000);
    loadDepartures();
}]);
