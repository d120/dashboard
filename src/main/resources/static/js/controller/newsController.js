'use strict';

var app = angular.module('dashboardApp');

app.controller('newsController', ['$scope', '$http', '$interval', function ($scope, $http, $interval) {
    $scope.news = [ ];
    var loadNews = function () {
        $http.get('/api/news').then(function (response) {
            $scope.news = response.data.news;
        }, function () {
            // Error.
        });
    };
    var next = function () {
        $scope.shownNews = $scope.news.shift();
        if ($scope.news.length < 2) {
            loadNews();
        }
    };

    loadNews();

    $interval(next, DASHBOARD.news.interval * 1000);
}]);
