app.controller('DoanhThuSPCtrl', function ($rootScope, $scope, $location, $http) {
    console.log("Doanh Thu San Pham controller");
    $scope.doanhthuhang = [];
    
	$http.get("admin/revenue/byhang.php").success(function(data) {
		$scope.doanhthuhang = data;
	});
});