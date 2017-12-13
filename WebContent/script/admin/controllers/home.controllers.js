app.controller('HomeCtrl', function($rootScope, $scope, $location, $http) {
	console.log("Home controller");
	$scope.products = [];

	$http.get("home/index.php").success(function(data) {
		$scope.products = data;
	});
	
	$scope.search = function(keywords) {
		var temp = "product/search.php?keywords=/" + keywords;
		$http.get(temp).success(function(data) {
			$scope.products = data;
		});
	};
	

//	$scope.detail = function(id) {
//		var temp = "product/detail/" + id + ".php";
//		$http.get(temp).success(function(data) {
//			$scope.products = data;
//		});
//		productDetailService.loadProducts(id);
//	};

//app.service('productDetailService', function() {
//	var products = []
//	var loadProducts = function(id) {
//		var temp = "product/detail/" + id + ".php";
//		$http.get(temp).success(function(data) {
//			products = data;
//		});
//	};
//	var getProducts = function() {
//		return products;
//	}
//
});