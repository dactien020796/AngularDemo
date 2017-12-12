app.controller('ChangePasswordCtrl', function($rootScope, $scope, $location, $http) {
	console.log("Change Password controller");
	
	$scope.change = function(password, password1, password2) {
		var temp = "account/change.php?password=" + password + "&password1=" + password1 +
			"&password2=" + password2;
		$http.post(temp).success(function(data) {
//			if (data == "Cap nhat mat khau thanh cong") {
//				location.reload();
//			} else
			alert(data);
			location.reload();
		});
	};
});