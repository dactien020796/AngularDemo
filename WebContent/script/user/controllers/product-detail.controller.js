app.controller('Product-Detail-Controller', function($rootScope, $scope, $location, $http) {
	console.log("Product detail controller");
	//$scope.products = productDetailService.getProducts();
	//
	//    $http.get("home/index.php")
	//        .success(function (data) {
	//        	$scope.products = data;
	//        });
	$scope.products = [];
	$scope.detail = function(id) {
		var temp = "product/detail/" + id + ".php";
		$http.get(temp).success(function(data) {
			$scope.products = data;
		});
	};
});
$scope.detail();