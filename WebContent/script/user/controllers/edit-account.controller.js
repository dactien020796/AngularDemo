app.controller('EditAccountCtrl', function($rootScope, $scope, $location, $http) {
	console.log("Edit Account controller");
	
	$scope.ma = "";
	$scope.hoTen = "";
	$scope.email = "";
	
	$http.get("account/edit.php").success(function(data) {
		$scope.ma = data.ma;
		$scope.hoTen = data.hoTen;
		$scope.email = data.email;
	});
	
	$scope.change = function(hoTen, email) {
		var temp = "account/edit.php?hoTen=" +hoTen+ "&email=" +email; 
		$http.post(temp).success(function(data) {
			alert(data);
			location.reload();
		});
	};
});