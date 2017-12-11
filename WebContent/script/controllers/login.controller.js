app.controller('LoginCtrl', function($rootScope, $scope, $location, $http) {
	console.log("Login controller");
	this.cancel = $scope.$dismiss;

	var result = "";
	$scope.submit = function(id, password) {
		//    $http.post
		var temp = "account/login.php?id=" + id + "&password=" + password;
		$http.post(temp).success(function(data) {
			if (data == "Dang nhap thanh cong") {
				window.location.replace("http://localhost:9999/DemoAngular/#/");
			} else
				alert(data);
		});
	};

	$scope.logoff = function(id, password) {
		//    $http.post
		$http.get("account/logoff.php").success(function(data) {
			
		});
	};
});