app.controller('Product-Detail-Controller', function($rootScope, $scope, $location, $http, $stateParams) {
	console.log("Product detail controller");

	var id = $stateParams.id;
	$scope.products = [];
	var temp = "product/detail/" + id + ".php";
	$http.get(temp).success(function(data) {
		$scope.products = data;
	});
});