app.controller('SanPhamCtrl', function ($rootScope, $scope, $location, $http) {
    console.log("San Pham controller");
    $scope.sanpham = [];
   
    
	$http.get("admin/product/items.php").success(function(data) {
		$scope.sanpham = data;
	});
//    $scope.insert = function(ma, tenHang){
//    	var temp = "admin/manufacturer/insert.php?ma=" + ma + "&tenHang=" + tenHang;
//    	$http.post(temp).success(function(data) {
//    		if (data = "Them thanh cong") {
//				alert(data);
//				location.reload();
//			}
//    		else alert(data);
//    	});
//    	
//    };
//    
//    $scope.getHang = function(ma) {
//    	var temp = "admin/manufacturer/edit.php?ma=" + ma;
//    	$http.get(temp).success(function(data) {
//    		$scope.ma = data.ma;
//    		$scope.tenHang = data.ten;
//    	});
//    };
//    
//    $scope.edit = function(ma, tenHang){
//    	ma = $scope.ma;
//    	var temp = "admin/manufacturer/update.php?ma=" + ma + "&tenHang=" + tenHang;
//    	$http.post(temp).success(function(data) {
//    		if (data = "Sua thanh cong") {
//				alert(data);
//				location.reload();
//			}
//    		else alert(data);
//    	});
//    };
    
    
});