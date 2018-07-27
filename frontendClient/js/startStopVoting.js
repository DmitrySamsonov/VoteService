app.controller("StartStopController", function ($scope, $http) {

    $scope.isOpen = "CLOSED";
    $scope.link = "";
    $scope.userLink = "";

    $scope.startVoting = function () {
        if (votingId == "???") {
            alert("For start or stop voting you need a Voting ID. Please, create Voting");
            return;
        }
        // alert("sending http GET request to url: http://localhost:8090/rest/voting/" + votingId + "/start for start voting...");
        $http({
            method: 'GET',
            url: 'http://localhost:8090/rest/voting/' + votingId + '/start',
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(
            function (res) { // success
                console.log("success: " + res.status + " : " + res.data);
                // alert("success");
                $scope.link = res.data;
                votingLink = res.data;
                $scope.userLink = res.data + "/ui";
                $scope.isOpen = "OPEN";

            },
            function (res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );

    };


    $scope.stopVoting = function () {
        if (votingId == "???") {
            alert("For start or stop voting you need a Voting ID. Please, create Voting");
            return;
        }
        // alert("sending http GET request to url: http://localhost:8090/rest/voting/" + votingId + "/stop for start voting...");
        $http({
            method: 'GET',
            url: 'http://localhost:8090/rest/voting/' + votingId + '/stop',
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(
            function (res) { // success
                console.log("success: " + res.status + " : " + res.data);
                // alert("success");
                $scope.isOpen = "CLOSED";

            },
            function (res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    };



});
