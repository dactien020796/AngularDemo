app.controller('OrderHistoryCtrl', function($rootScope, $scope, $location, $http) {
	console.log("Order history controller");
	$scope.orders = [];

	$http.get("order/list.php").success(function(data) {
		$scope.orders = data;
	});
});