app.controller("SetVotingController", function ($scope, $http) {

    //
    // $scope.votingCreateDto = {
    //     votingTheme: "celebration",
    //     question: "where we will celebrate the holiday ?",
    //     voteList: {
    //         "at home": 0,
    //         "in bar": 0,
    //         "in restaurant": 0
    //     }
    // };

    $scope.selectedItems = {
        voteText: "at home"
    };

    $scope.setVotes = function () {
        alert("set votes!");


        $http({
            method: 'POST',
            url: 'http://localhost:8090/voting/votingId2',
            params:  $scope.selectedItems,
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(
            function (res) { // success
                $scope.voting = res.data;
            },
            function (res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );

    };

});
