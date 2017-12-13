app.controller('HangSXCtrl', function ($rootScope, $scope, $location, $http) {
    console.log("HangSX controller");
    $scope.hangsx = [];
    $scope.tenHang = "";
    $scope.ma = "";
    
	$http.get("admin/manufacturer/items.php").success(function(data) {
		$scope.hangsx = data;
	});
    $scope.insert = function(ma, tenHang){
    	var temp = "admin/manufacturer/insert.php?ma=" + ma + "&tenHang=" + tenHang;
    	$http.post(temp).success(function(data) {
    		if (data = "Them thanh cong") {
				alert(data);
				location.reload();
			}
    		else alert(data);
    	});
    	
    };
    
    $scope.getHang = function(ma) {
    	var temp = "admin/manufacturer/edit.php?ma=" + ma;
    	$http.get(temp).success(function(data) {
    		$scope.ma = data.ma;
    		$scope.tenHang = data.ten;
    	});
    };
    
    $scope.edit = function(ma, tenHang){
    	ma = $scope.ma;
    	var temp = "admin/manufacturer/update.php?ma=" + ma + "&tenHang=" + tenHang;
    	$http.post(temp).success(function(data) {
    		if (data = "Sua thanh cong") {
				alert(data);
				location.reload();
			}
    		else alert(data);
    	});
    };
    
    
});