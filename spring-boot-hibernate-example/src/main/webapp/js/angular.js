var app = angular.module('app', []);

app.controller('postController', function ($scope, $http, $location) {
    $scope.submitForm = function () {
        var url = $location.absUrl() + "postcustomer";

        var config = {
            headers: {
                'Content-Type': 'application/json;charset=utf-8;'
            }
        }

        var data = {
            id: $scope.id,
            name: $scope.name,
            height: $scope.height,
            weight: $scope.height
        };


        $http.post(url, data, config).then(function () {
            $scope.postResultMessage = "Sucessful!";
        }, function () {
            $scope.postResultMessage = "Fail!";
        });

        $scope.id = "";
        $scope.name = "";
        $scope.height = "";
        $scope.weight = "";
    }
});
