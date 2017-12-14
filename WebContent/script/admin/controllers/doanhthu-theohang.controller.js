app.controller('DoanhThuHangCtrl', function ($rootScope, $scope, $location, $http) {
    console.log("Doanh Thu Hang controller");
    $scope.doanhthusp = [];
    
	$http.get("admin/revenue/bysanpham.php").success(function(data) {
		$scope.doanhthusp = data;
	});
});