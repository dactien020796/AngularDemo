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