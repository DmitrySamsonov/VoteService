app.controller("GetVotingLinkController", function ($scope, $http) {

    $scope.link = "";

    $scope.getLinkByVotingId = function () {
        // alert("getLinkByVotingId()");
        $http({
            method: 'GET',
            url: 'http://localhost:8090/rest/voting/' + votingId + '/link',
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(
            function (res) { // success
                console.log("success: " + res.status + " : " + res.data);
                $scope.link = res.data;
            },
            function (res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    }

});
