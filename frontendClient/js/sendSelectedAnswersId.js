app.controller("SendSelectedAnswersIdController", function ($scope, $http) {


    $scope.selectedAnswersId = [];


    $scope.addNewAnswer = function (answerId) {
        var access = true;
        for(var i =0 ; i< $scope.selectedAnswersId.length; i++){
            if($scope.selectedAnswersId[i] == answerId){
                access = false;
            }
        }
        if(access == true){
            $scope.selectedAnswersId.push(answerId);
        }
    };

    $scope.removeLastAnswer = function () {
        var newItemNo = $scope.selectedAnswersId.length;
        if (newItemNo !== 0) {
            $scope.selectedAnswersId.pop();
        }
    };


    $scope.sendSelectedAnswersId = function () {
        // alert("ey man!");

        $http({
            method: "POST",
            url: "http://localhost:8090/rest/voting/" + votingId + "/answers",
            params: {"selectedAnswersId" : $scope.selectedAnswersId},
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
