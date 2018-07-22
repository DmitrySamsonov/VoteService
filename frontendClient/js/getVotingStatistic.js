app.controller("GetVotingStatisticController", function ($scope, $http) {


    $scope.votingDto = {
        votingTheme: "",
        question: "",
        voteList: { }
    };

    // $scope.voting = {};
    $scope.b = 3;

    $scope.getStatisticVoting = function () {
        alert("get statistic!");


        $http({
            method: 'GET',
            url: 'http://localhost:8090/voting/votingId',
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(
            function (res) { // success
                $scope.voting = res.data;
                console.log($scope.voting);
                $scope.b = 12;
            },
            function (res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );

    };

});
