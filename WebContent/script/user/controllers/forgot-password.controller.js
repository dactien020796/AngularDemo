app.controller('ForgotPasswordCtrl', function($rootScope, $scope, $location, $http) {
	console.log("Forgot Password controller");
	$scope.ma = "";
	$scope.email = "";

	// $http.get("account/forgot.php").success(function(data) {
	// $scope.ma = data.ma;
	// $scope.email = data.email;
	// });

	$scope.forgot = function(ma, email) {
		var temp = "account/forgot.php?ma=" + ma + "&email=" + email;
		$http.post(temp).success(function(data) {
			alert(data);
		});
	};
});