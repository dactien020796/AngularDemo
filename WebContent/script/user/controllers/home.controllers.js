app.controller('HomeCtrl', function($rootScope, $scope, $location, $http) {
	console.log("Home controller");
	$scope.products = [];

	$http.get("home/index.php").success(function(data) {
		$scope.products = data;
	});
});
