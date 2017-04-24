'use strict';

var infos = DASHBOARD.infos;

var app = angular.module('dashboardApp', ['ngRoute', 'ui.bootstrap']);

app.config(['$routeProvider', function ($routeProvider) {
    for (var i = 0; i < infos.length; i++) {
        var name = infos[i].name;
        $routeProvider.when('/info/' + name, {
            templateUrl: '/static/view/info/' + name + '.html',
            controller: name + 'Controller'
        });
    }
    $routeProvider.otherwise({
        templateUrl: '/static/view/main.html',
        controller: 'mainController'
    });
}]);

app.run(['$location', '$interval', function ($location, $interval) {
    var current = 0;

    var InfoService = {
        switchToService: function (name) {
            $location.path('/info/' + name);
        },
        next: function () {
            do {
                current = (current + 1) % infos.length;
            } while (!(infos[current].isActive ? infos[current].isActive() : true));
            InfoService.switchToService(infos[current].name);
        }
    };

    $interval(function () {
        InfoService.next();
    }, DASHBOARD.interval);

    return InfoService;
}]);
