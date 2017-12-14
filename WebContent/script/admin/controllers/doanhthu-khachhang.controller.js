app.controller('DoanhThuKhachHangCtrl', function ($rootScope, $scope, $location, $http) {
    console.log("Doanh Thu KhachHang controller");
    $scope.doanhthukh = [];
    
	$http.get("admin/revenue/bykhachhang.php").success(function(data) {
		$scope.doanhthukh = data;
	});
});