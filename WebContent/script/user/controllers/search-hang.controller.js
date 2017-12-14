app.controller('SearchHangCtrl', function($rootScope, $scope, $location,
		$http, $stateParams) {
	console.log("Search hang controller");
	$scope.products = [];
	
	var ma = $stateParams.hang;
	var temp = "product/list-by-hang.php?ma=" + ma;
	$http.get(temp).success(function(data) {
		$scope.products = data;
	});
	
});