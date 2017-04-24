'use strict';

var app = angular.module('dashboardApp');

app.controller('carouselController', ['$scope', '$interval', function ($scope, $interval) {
    $scope.infos = DASHBOARD.infos;

    $scope.current = 0;
    $interval(function () {
        do {
            $scope.current = ($scope.current + 1) % $scope.infos.length;
        } while (!($scope.infos[$scope.current].isActive ? $scope.infos[$scope.current].isActive() : true));
    }, DASHBOARD.interval * 1000);

    $scope.$watch('current', function () {
        $scope.shownInfo = $scope.infos[$scope.current];
    });
}]);
