app.controller('Product-Detail-Controller', function($rootScope, $scope, $location, $http, $stateParams) {
	console.log("Product detail controller");
	//$scope.products = productDetailService.getProducts();
	//
	//    $http.get("home/index.php")
	//        .success(function (data) {
	//        	$scope.products = data;
	//        });
	var id = $stateParams.id;
	$scope.products = [];
//	$scope.detail = function() {
//		var temp = "product/detail/" + id + ".php";
//		$http.get(temp).success(function(data) {
//			$scope.products = data;
//		});
//	};
	var temp = "product/detail/" + id + ".php";
	$http.get(temp).success(function(data) {
		$scope.products = data;
	});
});