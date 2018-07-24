app.controller("StartStopController", function ($scope, $http) {

    // url: link,

    $scope.getVotingIdByLink = function (link) {
        var link = votingLink + '/id';
        $http({
            method: 'GET',
            url: link,
            params: {"link": votingLink},
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(
            function (res) { // success
                console.log("success: " + res.status + " : " + res.data);
                votingId = res.data;
                alert("Voting Id = " + votingId);
            },
            function (res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    }


    $scope.startVoting = function () {
        if (votingId == "???") {
            alert("For start or stop voting you need a Voting ID. Click button 'Get Voting Id'");
            return;
        }
        alert("sending http GET request to url: http://localhost:8090/rest/voting/" + votingId + "/start for start voting...");
        sendRequest('/start');
    };


    $scope.stopVoting = function () {
        if (votingId == "???") {
            alert("For start or stop voting you need a Voting ID. Click button 'Get Voting Id'");
            return;
        }
        alert("sending http GET request to url: http://localhost:8090/rest/voting/" + votingId + "/stop for start voting...");
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
                alert("success");
            },
            function (res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    }


});
