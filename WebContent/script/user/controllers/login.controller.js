app.controller('LoginCtrl', function($rootScope, $scope, $location, $http) {
	console.log("Login controller");
	this.cancel = $scope.$dismiss;

	var result = "";
	$scope.login = function(id, password) {
		//    $http.post
		var temp = "account/login.php?id=" + id + "&password=" + password;
		$http.post(temp).success(function(data) {
//			if (data == "Dang nhap thanh cong") {
//				window.location = "http://localhost:9999/DemoAngular";
//			} else
			alert(data);
			window.location = "http://localhost:9999/DemoAngular";
		});
	};

	$scope.logoff = function(id, password) {
		//    $http.post
		$http.get("account/logoff.php").success(function(data) {
			window.location = "http://localhost:9999/DemoAngular";
		});
	};

	 // dang ki
	$scope.register = function(username,hoten,matkhau,email) {
    	//    $http.post
    	var temp = "account/register.php?username=" + username + "&hoten=" + hoten + "&matkhau=" + matkhau + "&email=" + email;
    	$http.post(temp).success(function(data) {
    		if (data == "Dang ki thanh cong") {
    			alert(data);
    		} else
    			alert(data);
    	});
    };
});