var app = angular.module("VotingService", []);
app.controller("VotingController", function ($scope, $http) {


    $scope.votingCreateDto = {
        themeName: "celebration",
        question: "where we will celebrate the holiday ?",
        voteList: {
            "a": 0,
            "b": 0,
            "c": 0
        }
    };


    $scope.createVoting = function () {
        alert("ey man!");

        $http({
            method: "POST",
            url: "http://localhost:8090/voting/create",
            data: $scope.votingCreateDto,
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(
            function (res) { // success
                console.log("success: " + res.status + " : " + res.data);
            },
            function (res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    };

});
