<!DOCTYPE html>
<html>
<head>
    <!-- Meta information. -->
    <meta charset="UTF-8">
    <meta name="robots" content="noindes, follow">
    <meta name="viewport" content="width = device-width, initial-scale = 1, maximum-scale = 1, user-scalable = no">

    <title>D120 Dashboard</title>

    <!-- CSS. -->
    <link rel="stylesheet" href="/static/bootstrap/dist/css/bootstrap.min.css">
    <!-- Custom CSS. -->
    <!-- JavaScript. -->
    <script src="/static/jquery/dist/jquery.min.js"></script>
    <script src="/static/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="/static/angular/angular.min.js"></script>
    <script src="/static/angular-bootstrap/ui-bootstrap.min.js"></script>
    <script src="/static/angular-route/angular-route.min.js"></script>
    <!-- Custom JavaScript. -->
    <script src="/static/js/config.js"></script>
    <script src="/static/js/app.js"></script>
    <script src="/static/js/controller/mainController.js"></script>
    <script src="/static/js/controller/info/departuresController.js"></script>
    <script src="/static/js/controller/info/pizzaPadController.js"></script>
</head>
<body ng-app="dashboardApp" ng-cloak>
    <div class="container-fluid">
        <div id="d120-alert">
            <!-- Content -->
        </div>
        <div ng-view></div>
    </div>
</body>
</html>
