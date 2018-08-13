angular.module('demo', [])
  .controller('Hello', ['$scope', '$http', function ($scope, $http) {
      $scope.greeting = [];

      $scope.search = function () {
          /* the $http service allows you to make arbitrary ajax requests.
           * in this case you might also consider using angular-resource and setting up a
           * User $resource. */
          $http.get('http://localhost:8080/Chatbot/greeting?input1=Adrian&input2=Praveen',
            function (response) { $scope.greeting = response.data; },
            function (failure) { console.log("failed :(", failure); });
      }
  }]);