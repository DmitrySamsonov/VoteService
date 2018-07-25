app.controller("StartStopController", function ($scope, $http) {

    $scope.isOpen = "CLOSED";

    $scope.startVoting = function () {
        if (votingId == "???") {
            alert("For start or stop voting you need a Voting ID. Please, create Voting");
            return;
        }
        // alert("sending http GET request to url: http://localhost:8090/rest/voting/" + votingId + "/start for start voting...");
        sendRequest('/start');
    };


    $scope.stopVoting = function () {
        if (votingId == "???") {
            alert("For start or stop voting you need a Voting ID. Please, create Voting");
            return;
        }
        // alert("sending http GET request to url: http://localhost:8090/rest/voting/" + votingId + "/stop for start voting...");
        sendRequest('/stop');
    };

    var sendRequest = function (action) {
        $http({
            method: 'GET',
            url: 'http://localhost:8090/rest/voting/' + votingId + action,
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(
            function (res) { // success
                console.log("success: " + res.status + " : " + res.data);
                // alert("success");
                if(action == "/start"){
                    $scope.isOpen = "OPEN";
                }
                if(action == "/stop"){
                    $scope.isOpen = "CLOSED";
                }
            },
            function (res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    }


});
