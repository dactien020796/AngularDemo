<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<head>
<!-- 	<script src="js/shopping-cart.js"></script> -->
<style id="nn-cart-fly">
</style>
</head>

<div class="content" ng-controler="ShoppingCartCtrl">
	<div class="content_top">
		<div class="heading">
			<h3>Danh sách mặt hàng</h3>
		</div>
		<div class="clear"></div>
	</div>
	<div class="section group">
		<table border="1" style="width: 100%;" class="table">
			<thead>
				<tr>
					<th>Tên</th>
					<th>Đơn giá</th>
					<th>Khuyến mãi</th>
					<th>Số lượng</th>
					<th>Thành tiền</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="p in items">
					<td>{{p.ten}}</td>
					<td>
						{{p.donGia | number:0 }} VND
					</td>
					<td>
						{{p.khuyenMai}}
					</td>
					<td>
						<input value="{{p.soLuong}}" type="number" ng-change = "update(p.ma)" ng-model="qty" 
							style="width: 50px" data-cart-update="{{p.ma}}">
					</td>
					<td class="amt">
						{{p.soLuong * p.donGia * (1 - p.khuyenMai) | number:0 }} VND
					</td>
					<td>
						<button class="btn btn-sm btn-danger" data-cart-remove="{{p.ma}}"
							ng-click="remove(p.ma)">X</button>
					</td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td>Tổng tiền:</td>
					<td id="tongtien" >
						{{amount}} VND
					</td>
				</tr>
			</tbody>
		</table>

		<div>
			<a class="btn btn-warning" ng-click="clear()">Xóa hết</a>
			<a class="btn btn-primary" ui-sref="check-out">Thanh toán</a>
		</div>
	</div>
</div>


