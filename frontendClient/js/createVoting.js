app.controller("VotingController", function ($scope, $http) {


    $scope.answers = [{answerName: 'home', count: '0'},
        {answerName: 'bar', count: '0'},
        {answerName: 'restaurant', count: '0'},
        {answerName: 'cottage', count: '0'},
    ];


    $scope.addNewAnswer = function () {
        $scope.answers.push({'answerName': '', 'count': '0'});
    };

    $scope.removeLastAnswer = function () {
        var newItemNo = $scope.answers.length - 1;
        if (newItemNo !== 0) {
            $scope.answers.pop();
        }
    };

    $scope.showAddAnswer = function (answer) {
        return answer.id === $scope.answers[$scope.answers.length - 1].id;
    };



    $scope.votingCreateDto = {
        votingTheme: "celebration",
        question: "where we will celebrate the holiday ?",
        answerList: $scope.answers
    };


    $scope.createVoting = function () {
        // alert("ey man!");

        $http({
            method: "POST",
            url: "http://localhost:8090/rest/voting/create",
            data: $scope.votingCreateDto,
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(
            function (res) { // success
                console.log("success: " + res.status + " : " + res.data);
                $scope.votingId = res.data;
                votingId = res.data;
            },
            function (res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    };

});
