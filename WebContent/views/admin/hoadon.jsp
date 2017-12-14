<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Quản lý hóa đơn</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<ul class="nav nav-tabs">
	<li class="active"><a data-toggle="tab" href="#form"> <span
			class="glyphicon glyphicon-edit"></span> Chỉnh sửa
	</a></li>
	<li><a data-toggle="tab" href="#gridview"> <span
			class="glyphicon glyphicon-list"></span> Danh sách hóa đơn
	</a></li>
</ul>

<div class="tab-content" ng-controller="HoaDonCtrl">
	<div id="form" class="tab-pane fade in active">
		<!-- FORM -->

		<form>
			<div class="form-group">
				<label>Mã hóa đơn</label> <input ng-model="ma" class="form-control"
					readonly="true" />
			</div>
			<div class="form-group">
				<label>Khách hàng</label> <input ng-model="khachHang"
					class="form-control" readonly="true" />
				<%-- 				<form:hidden ng-model="khachHang.ma"/> --%>
			</div>
			<div class="form-group">
				<label>Ngày đặt</label> <input ng-model="ngayDat"
					class="form-control" />
			</div>
			<div class="form-group">
				<label>Ngày giao</label> <input ng-model="ngayGiao"
					class="form-control" />
			</div>
			<div class="form-group">
				<label>Người nhận</label> <input ng-model="nguoiNhan"
					class="form-control" />
			</div>
			<div class="form-group">
				<label>Địa chỉ</label> <input ng-model="diaChi" class="form-control" />
			</div>
			<div class="form-group">
				<label>Tổng tiền</label> <input ng-model="tongTien"
					class="form-control" readonly="true" />
			</div>
			<div class="form-group">
				<label>Ghi chú</label> <input ng-model="ghiChu" class="form-control" />
			</div>

			<div class="row">
				<fieldset>
					<legend>Chi tiết hóa đơn</legend>
					<table class="table">
						<thead>
							<tr>
								<th>Tên SP</th>
								<th>Đơn giá</th>
								<th>Giảm giá</th>
								<th>Số lượng</th>
								<th>Thành tiền</th>
							</tr>
						</thead>
						<tbody>

							<tr ng-repeat="cthd in cthoadon">
								<td>{{cthd.sanPham.ten}}</td>
								<td>{{cthd.sanPham.donGia | number:0}} VND</td>
								<td>{{cthd.sanPham.khuyenMai}}</td>
								<td>{{cthd.sanPham.soLuong}}</td>
								<td>{{cthd.sanPham.donGia * cthd.sanPham.soLuong *
									(1-cthd.sanPham.khuyenMai) | number:0}} VND</td>
							</tr>

						</tbody>
					</table>
				</fieldset>
			</div>
		</form>
	</div>
	<div id="gridview" class="tab-pane fade">
		<!-- TABLE -->
		<table class="table">
			<thead>
				<tr>
					<th>Mã</th>
					<th>Khách hàng</th>
					<th>Ngày đặt</th>
					<th>Tổng cộng</th>
					<th></th>
				</tr>
			</thead>

			<tbody>

				<tr ng-repeat="hd in hoadon">
					<td>{{hd.ma}}</td>
					<td>{{hd.khachHang.hoTen}}</td>
					<td>{{hd.ngayDat}}</td>
					<td>{{hd.tongTien | number:0}} VND</td>
					<td><a ng-click="xemChiTiet(hd.ma)">Xem chi tiết </a></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>