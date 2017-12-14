app.controller('HomeCtrl', function($rootScope, $scope, $location, $http, ProductsService, $q) {
	console.log("Home controller");
	$scope.products = [];
	$scope.hangs = [];

	$http.get("home/index.php").success(function(data) {
		$scope.products = data;
	});
	
	$http.get("home/get-hangs.php").success(function(data) {
		$scope.hangs = data;
	});
	
//	$scope.search = function(keywords) {
//		/*
//		 * ProductsService.search(keywords).then(function(response) {
//		 * $scope.products = response.data; $scope.$apply(); });
//		 */
//		var temp = "product/search.php?keywords=" + keywords;
//		$http.get(temp).then(function(data) {
//			
//			$scope.products = data;
//		});    
//	};
	
	$scope.search = function(keywords) {
		loadData(keywords).then(function(data) {
			$scope.products = data;
		});
	};
	
	function loadData(keywords){
    	var deferred = $q.defer();
    	
        setTimeout(function(){
        	var data = [];
        	var temp = "product/search.php?keywords=" + keywords;
        	$http.get(temp).then(function(response) {
    			data = response.data;
    		});
            deferred.resolve(data);
        }, 3000);
        return deferred.promise;
    };
});
