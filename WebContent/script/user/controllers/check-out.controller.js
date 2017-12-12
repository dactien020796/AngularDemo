app.controller('CheckOutCtrl', function($rootScope, $scope, $location, $http, $stateParams) {
	console.log("Check-out controller");

//	var id = $stateParams.id;
//	$scope.products = [];
//	var temp = "product/detail/" + id + ".php";
//	$http.get(temp).success(function(data) {
//		$scope.products = data;
//	});
	$scope.customer = [];
	$http.get("order/checkout.php").success(function(data) {
		$scope.customer = data;
	});
});