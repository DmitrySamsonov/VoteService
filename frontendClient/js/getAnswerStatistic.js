app.controller("GetAnswerStatisticController", function ($scope, $http) {

    $scope.answerId = 0;

    $scope.getAnswerStatisticByAnswerId = function () {
        $http({
            method: 'GET',
            url: 'http://localhost:8090/rest/voting/' + votingId + '/' + $scope.answerId,
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(
            function (res) { // success
                console.log("success: " + res.status + " : " + res.data);
                $scope.count = res.data;
            },
            function (res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    }

});
