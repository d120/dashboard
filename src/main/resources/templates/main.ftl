<!DOCTYPE html>
<html>
<head>
    <!-- Meta information. -->
    <meta charset="UTF-8">
    <meta name="robots" content="noindes, follow">
    <meta name="viewport" content="width = device-width, initial-scale = 10, maximum-scale = 10">

    <title>D120 Dashboard</title>

    <!-- CSS. -->
    <link rel="stylesheet" href="/static/bootstrap/dist/css/bootstrap.min.css">
    <!-- Custom CSS. -->
    <link rel="stylesheet" href="/static/css/news.css">
    <link rel="stylesheet" href="/static/css/style.css">
    <link rel="stylesheet" href="/static/css/info-cafeteria.css">
    <link rel="stylesheet" href="/static/css/info-departures.css">
    <link rel="stylesheet" href="/static/css/info-pizzaPad.css">
    <!-- JavaScript. -->
    <script src="/static/jquery/dist/jquery.min.js"></script>
    <script src="/static/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="/static/angular/angular.min.js"></script>
    <script src="/static/angular-i18n/angular-locale_de-de.js"></script>
    <script src="/static/angular-bootstrap/ui-bootstrap.min.js"></script>
    <script src="/static/angular-route/angular-route.min.js"></script>
    <!-- Custom JavaScript. -->
    <#include "config.ftl">
    <script src="/static/js/app.js"></script>
    <script src="/static/js/controller/carouselController.js"></script>
    <script src="/static/js/controller/newsController.js"></script>
    <script src="/static/js/controller/info/cafeteriaController.js"></script>
    <script src="/static/js/controller/info/departuresController.js"></script>
    <script src="/static/js/controller/info/pizzaPadController.js"></script>
</head>
<body ng-app="dashboardApp" ng-cloak>
    <div class="container-fluid">
        <div id="d120-alert">
            <!-- Content -->
        </div>
        <div ng-controller="carouselController">
            <div ng-show="shownInfo.name === 'departures'">
                <div ng-controller="departuresController" ng-include="'/static/view/info/departures.html'"></div>
            </div>
            <div ng-show="shownInfo.name === 'pizzaPad'">
                <div ng-controller="pizzaPadController" ng-include="'/static/view/info/pizzaPad.html'"></div>
            </div>
            <div ng-show="shownInfo.name === 'cafeteria'">
                <div ng-controller="cafeteriaController" ng-include="'/static/view/info/cafeteria.html'"></div>
            </div>
        </div>
        <div id="d120-news" ng-controller="newsController" class="animation-container">
            <span>+++ {{ shownNews }} +++</span>
            <span id="d120-news-copyright">Powered by <a href="http://www.der-postillon.com">http://www.der-postillon.com</a></span>
        </div>
    </div>
</body>
</html>
