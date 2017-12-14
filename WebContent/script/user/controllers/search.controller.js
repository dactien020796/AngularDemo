app.controller('SearchCtrl', function($rootScope, $scope, $location,
		$http, $stateParams) {
	console.log("Search controller");
	$scope.products = [];
	
	var keywords = $stateParams.keywords;
	var temp = "product/search.php?keywords=" + keywords;
	$http.get(temp).success(function(data) {
		$scope.products = data;
	});
	
});