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
    <link rel="stylesheet" href="/static/css/style.css">
    <link rel="stylesheet" href="/static/css/info-departures.css">
    <link rel="stylesheet" href="/static/css/info-pizzaPad.css">
    <!-- JavaScript. -->
    <script src="/static/jquery/dist/jquery.min.js"></script>
    <script src="/static/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="/static/angular/angular.min.js"></script>
    <script src="/static/angular-bootstrap/ui-bootstrap.min.js"></script>
    <script src="/static/angular-route/angular-route.min.js"></script>
    <!-- Custom JavaScript. -->
    <script src="/static/js/config.js"></script>
    <script src="/static/js/app.js"></script>
    <script src="/static/js/controller/carouselController.js"></script>
    <script src="/static/js/controller/info/departuresController.js"></script>
    <script src="/static/js/controller/info/pizzaPadController.js"></script>
</head>
<body ng-app="dashboardApp" ng-cloak>
    <div class="container-fluid">
        <div id="d120-alert">
            <!-- Content -->
        </div>
        <div ng-controller="carouselController">
            <div ng-show="shownInfo.name === 'departures' && shownInfo.isActive()">
                <div ng-controller="departuresController" ng-include="'/static/view/info/departures.html'"></div>
            </div>
            <div ng-show="shownInfo.name === 'pizzaPad' && shownInfo.isActive()">
                <div ng-controller="pizzaPadController" ng-include="'/static/view/info/pizzaPad.html'"></div>
            </div>
        </div>
    </div>
</body>
</html>
