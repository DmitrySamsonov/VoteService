app.controller("GetOptionsController", function ($scope, $http) {


    $scope.init = function () {
        // alert("init()");
        $http({
            method: 'OPTIONS',
            url: 'http://localhost:8090/',
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(
            function (res) { // success
                console.log("success: " + res.status + " : " + res.data);
                $scope.options = res.data;
            },
            function (res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    }

});
