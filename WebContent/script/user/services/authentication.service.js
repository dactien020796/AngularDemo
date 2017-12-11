angular.module('app.services', [])
    .factory('AuthenticationService', function ($q, $http, store) {
        var service = {
            requestToken: function (username, password) {
                var route = $http.defaults.route + 'users/token';
                $http.defaults.headers.common['Authorization'] = 'Basic ' + btoa(username + ':' + password);
                return $http.get(route)
                    .success(function (response) {
                        delete $http.defaults.headers.common["Authorization"];
                        store.set(CONFIG.cookie.jwt_token, response.result.token);
                        return response.result.token;
                    }).error(function(response){
                        delete $http.defaults.headers.common["Authorization"];
                    });
            },
            checkToken: function (token) {
                var route = $http.defaults.route + 'checkToken';
                $http.defaults.headers.common['Authorization'] = 'Bearer ' + token;
                return $http.get(route)
                    .success(function (response) {
                        delete $http.defaults.headers.common["Authorization"];
                        return response;
                    }).error(function(response){
                        delete $http.defaults.headers.common["Authorization"];
                    });
            }
        };
        return service;
    });

//angular.module('app.services', []).service('productDetailService', function() {
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
//});