app.controller('HoaDonCtrl', function ($rootScope, $scope, $location, $http) {
    console.log("Hoa Don controller");
    $scope.hoadon = [];
    $scope.cthoadon=[];
    $scope.ma = "";
    $scope.khachHang = "";
    $scope.ngayDat = "";
    $scope.ngayGiao = "";
    $scope.nguoiNhan = "";
    $scope.diaChi = "";
    $scope.tongTien = "";
    $scope.ghiChu = "";
    
   // Xem hóa đơn
    $http.get("admin/order/items.php").success(function(data) {
		$scope.hoadon = data;
	});
    
    // Xem chi tiết
    $scope.xemChiTiet = function(ma) {
    	var temp = "admin/order/get-order-detail.php?ma=" + ma;
    	$http.get(temp).success(function(data) {
    		$scope.cthoadon = data;
    		$scope.ma = data[0].ma;
    	    $scope.khachHang = data[0].hoaDon.khachHang.hoTen;
    	    $scope.ngayDat = data[0].hoaDon.ngayDat;
    	    $scope.ngayGiao = data[0].hoaDon.ngayGiao;
    	    $scope.nguoiNhan = data[0].hoaDon.nguoiNhan;
    	    $scope.diaChi = data[0].hoaDon.nguoiNhan;
    	    $scope.tongTien = data[0].hoaDon.tongTien;
    	    $scope.ghiChu = data[0].hoaDon.ghiChu;
    	});
	};
    
});