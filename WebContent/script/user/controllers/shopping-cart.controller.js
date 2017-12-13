app.controller('ShoppingCartCtrl', function($rootScope, $scope, $location, $http) {
	console.log("Shopping Cart controller");
	$scope.items = [];
	$scope.amount = 0;
	
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
	
//	$scope.getAmount = function() {
//		$.ajax({
//			url: "shopping-cart/get-amount.php",
//			success: function(response){
//				$scope.amount = response;
//			}
//		});
//	};
	
	$http.get("shopping-cart/view.php").success(function(data) {
		$scope.items = data;
		$.ajax({
			url: "shopping-cart/get-amount.php",
			success: function(response){
				var value = response;
				var num = value.toFixed(0).replace(/(\d)(?=(\d\d\d)+(?!\d))/g, "$1,");
				$("#tongtien").html(num + ' VND');
			}
		});
	});
	
	$scope.remove = function(id) {
		$.ajax({
			url: "shopping-cart/remove.php",
			data: {ma:id},
			success: function(response){
				$("#count").html('('+response[0]);
				var value = response[1];
				var num = value.toFixed(0).replace(/(\d)(?=(\d\d\d)+(?!\d))/g, "$1,");
				$("#tongtien").html(num + ' VND');

				$http.get("shopping-cart/view.php").success(function(data) {
					$scope.items = data;
				});
			},
			dataType: "json"
		});
	};
	
	$scope.update = function(ma) {
		var qty = this.qty;
		//td_amt = $(this).parents("tr").find(".amt");
		$.ajax({
			url: "shopping-cart/update.php",
			data: {ma:ma, qty: qty},
			success: function(response){
				$("#count").html(response[0]);
				
				$http.get("shopping-cart/view.php").success(function(data) {
					$scope.items = data;
					$.ajax({
						url: "shopping-cart/get-amount.php",
						success: function(response){
							var value = response;
							var num = value.toFixed(0).replace(/(\d)(?=(\d\d\d)+(?!\d))/g, "$1,");
							$("#tongtien").html(num + ' VND');
						}
					});
				});
			},
			dataType: "json"
		});
	};
});