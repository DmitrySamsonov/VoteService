app.controller("TestController", function ($scope, $http) {


    $scope.testController = function () {

        $http({
            method: "POST",
            url: 'http://localhost:8090/test/inputblockdto',
            data:
                {
                 "questionName" : "name1",
                 "type": "radiobuttons",
                 "elements": [
                     {"hui":"moi"},
                     {"pizda":"tvoja"},
                 ]
                },
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
    }

});
