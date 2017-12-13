app.controller('OrderDetailCtrl', function($rootScope, $scope, $location,
		$http, $stateParams) {
	console.log("Order detail controller");
	$scope.details = [];
	$scope.cthoadon = [];
	$scope.ma = "";
	$scope.khachHang = "";
	$scope.ngayDat = "";
	$scope.ngayGiao = "";
	$scope.nguoiNhan = "";
	$scope.diaChi = "";
	$scope.tongTien = "";
	$scope.ghiChu = "";

	var id = $stateParams.id;
	var temp = "order/detail.php?ma=" + id;
	$http.get(temp).success(function(data) {
		$scope.details = data;
	});
	var temp2 = "order/get-order.php?ma=" + id;
	$http.get(temp2).success(function(data) {
		$scope.ma = data.ma;
		$scope.khachHang = data.khachHang.hoTen;
		$scope.ngayDat = data.ngayDat;
		$scope.ngayGiao = data.ngayGiao;
		$scope.nguoiNhan = data.nguoiNhan;
		$scope.diaChi = data.diaChi;
		$scope.tongTien = data.tongTien;
		$scope.ghiChu = data.ghiChu;
	});
});