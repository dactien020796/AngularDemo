app.controller('HomeCtrl', function($rootScope, $scope, $location, $http) {
	console.log("Home controller");
	$scope.products = [];

	$http.get("home/index.php").success(function(data) {
		$scope.products = data;
	});
	
	$scope.search = function(keywords) {
		var temp = "product/search.php?keywords=" + keywords;
		$http.get(temp).success(function(data) {
			$scope.products = data;
			location.href = "http://localhost:9999/DemoAngular/#/";
		});
	};
});