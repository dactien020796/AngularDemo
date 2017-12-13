<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f"%>

<div class="content" ng-controller="OrderHistoryCtrl">
	<div class="content_top">
		<div class="heading">
			<h3>Danh sách đặt hàng</h3>
		</div>
		<div class="clear"></div>
	</div>
	<div class="section group">
		<br>
		<table class="table">
		<thead>
			<tr>
				<th>Mã</th>
				<th>Ngày đặt</th>
				<th>Người nhận</th>
				<th>Tổng tiền</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			
				<tr ng-repeat="o in orders">
					<td># {{o.ma}}</td>
					<td>{{o.ngayDat}}</td>
					<td>{{o.nguoiNhan}}</td>
					<td>
						{{o.tongTien | number:0}} VND
					</td>
					<td>
						<a ui-sref="order-detail({ id: o.ma })">Chi tiết</a>
					</td>
				</tr>
		</tbody>
	</table>
	</div>
</div>