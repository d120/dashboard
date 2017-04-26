'use strict';

var app = angular.module('dashboardApp');

app.controller('carouselController', ['$scope', '$timeout', function ($scope, $timeout) {
    $scope.infos = DASHBOARD.infos;

    $scope.current = 0;
    var next = function () {
        var current = $scope.current;
        do {
            current = (current + 1) % $scope.infos.length;
        } while (!($scope.infos[current].isActive ? $scope.infos[current].isActive() : true));
        $scope.current = current;
    }

    $scope.$watch('current', function () {
        $scope.shownInfo = $scope.infos[$scope.current];

        $timeout(next, $scope.shownInfo.interval * 1000);
    });
}]);
