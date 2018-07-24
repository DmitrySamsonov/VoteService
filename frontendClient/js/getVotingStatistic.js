app.controller("GetVotingStatisticController", function ($scope, $http) {


    $scope.votingDto = {
        votingTheme: "",
        question: "",
        voteList: { }
    };

    // $scope.voting = {};


    $scope.getStatisticVoting = function () {
        alert("sending http GET request to url: " + votingLink + "for get voting statistic...");

        $http({
            method: 'GET',
            url: votingLink,
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(
            function (res) { // success
                console.log($scope.voting);
                $scope.voting = res.data;
            },
            function (res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );

    };

});
