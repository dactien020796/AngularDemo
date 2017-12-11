app.controller('ShoppingCartCtrl', function($rootScope, $scope, $location, $http) {
	console.log("Shopping Cart controller");
	$scope.items = [];
	$http.get("shopping-cart/view.php").success(function(data) {
		$scope.items = data;
	});
	
	$scope.addCart = function(id) {
		$.ajax({
			url: "shopping-cart/add.php",
			data: {ma:id},
			success: function(response){
				$("#count").html( '(' + response[0] );
			},
			dataType: "json"
		});
//		var img = $($(this).parent(".button")).parent(".nn-box").find("img");
//		var img = $(this).parents(".grid_1_of_4").find(".nn-box img");
//		img.effect("bounce");
	};
});