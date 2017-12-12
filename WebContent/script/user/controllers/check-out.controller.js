
app.controller('CheckOutCtrl', function($rootScope, $scope, $location, $http, $stateParams) {
	console.log("Check-out controller");

	$scope.nguoiDat = "";
	$scope.nguoiNhan = "";
	$scope.ngayDat = "";
	$scope.ngayGiao = "";
	$scope.diaChi = "";
	$scope.tongTien = "";
	$scope.ghiChu = "";
	$http.get("order/checkout.php").success(function(data) {
		$scope.nguoiDat = data.khachHang.hoTen;
		$scope.nguoiNhan = data.khachHang.hoTen;
//		var myNgayDat = $.parseJSON('{"ngayDat":"'+ data.ngayDat +'"}'),
//	    	myDate = new Date(1000*myNgayDat.ngayDat);
//		$scope.ngayDat = myDate.toLocaleString();
//		
//		var myNgayGiao = $.parseJSON('{"ngayGiao":"'+ data.ngayGiao +'"}'),
//    		myDate2 = new Date(1000*myNgayGiao.ngayGiao);
//		$scope.ngayGiao = myDate2.toLocaleString();
		$scope.ngayDat = moment("/Date("+ data.ngayDat +")/").format('DD/MM/YYYY');
		$scope.ngayGiao = moment("/Date("+ data.ngayGiao +")/").format('DD/MM/YYYY')
		$scope.diaChi = "";
		$scope.tongTien = data.tongTien;
		$scope.ghiChu = "";
	});
	
	$scope.check_out = function(nguoiNhan, ngayDat, ngayGiao, diaChi, tongTien, ghiChu) {
		var temp = "order/checkout.php?nguoiNhan=" +nguoiNhan+ "&ngayDat=" +ngayDat+ 
			"&ngayGiao=" +ngayGiao+ "&diaChi=" +diaChi+ "&tongTien=" +tongTien+ 
			"&ghiChu=" + ghiChu;
		$http.post(temp).success(function(data) {
//			if (data == "Dat hang thanh cong") {
//				window.location = "http://localhost:9999/DemoAngular";
//			}
			alert(data);
			window.location = "http://localhost:9999/DemoAngular";
		});
	};
});