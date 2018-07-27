app.controller("GetVotingStatisticController", function ($scope, $http) {

    // url: 'http://localhost:8090/rest/voting/' + votingId,

    $scope.generatedVotingLink = votingLink;

        $scope.getVotingStatistic = function () {
        // alert("init()");
        $http({
            method: 'GET',
            url: votingLink,
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(
            function (res) { // success
                console.log("success: " + res.status + " : " + res.data);
                $scope.voting = res.data;
            },
            function (res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    }

});
