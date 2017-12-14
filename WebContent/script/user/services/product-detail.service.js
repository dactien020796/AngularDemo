app.service('productDetailService', function() {
	var products = []
	var loadProducts = function(id) {
		var temp = "product/detail/" + id + ".php";
		$http.get(temp).success(function(data) {
			products = data;
		});
	};
	var getProducts = function() {
		return products;
	}

});
angular.module('app.services', [])
.factory('ProductsService', function ($q, $http, store) {
    var service = {
		search: function(keywords) {
            return $http.get("product/search.php?keywords=" + keywords)
            .success(function(response) {
                return response.data;
            });
        }
    };
    return service;
})
.factory('safeApply', [function($rootScope) {
    return function($scope, fn) {
        var phase = $scope.$root.$$phase;
        if(phase == '$apply' || phase == '$digest') {
            if (fn) {
                $scope.$eval(fn);
            }
        } else {
            if (fn) {
                $scope.$apply(fn);
            } else {
                $scope.$apply();
            }
        }
    }
}]);