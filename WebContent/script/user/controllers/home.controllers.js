app.controller('HomeCtrl', function($rootScope, $scope, $location, $http) {
	console.log("Home controller");
	$scope.products = [];

	$http.get("home/index.php").success(function(data) {
		$scope.products = data;
	});
//	$scope.addCart = function(id) {
//		$.ajax({
//			url: "shopping-cart/add.php",
//			data: {ma:id},
//			success: function(response){
//				$("#count").html( '(' + response[0] );
//			},
//			dataType: "json"
//		});
////		var img = $($(this).parent(".button")).parent(".nn-box").find("img");
//		var img = $(this).parents(".grid_1_of_4").find(".nn-box img");
//		img.effect("bounce");
//	};
});