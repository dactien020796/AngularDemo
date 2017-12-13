<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>

<div class="content" ng-controller="OrderDetailCtrl">
	<div class="content_top">
		<div class="heading">
			<h3>Chi tiết hóa đơn</h3>
		</div>
		<div class="clear"></div>
	</div>
	<div class="section group">
		<br>
		<form readonly="true">
			<div class="row">
				<div class="form-group col-sm-4">
					<label>Khách hàng</label>
					<input ng-model="khachHang" class="form-control"
						readonly="true" />
				</div>

				<div class="form-group col-sm-4">
					<label>Nguoi nhan</label>
					<input ng-model="nguoiNhan" class="form-control" readonly="true" />
				</div>

				<div class="form-group col-sm-4">
					<label>Ngày đặt</label>
					<input ng-model="ngayDat" class="form-control"
						readonly="true" />
				</div>
			</div>
			<div class="row">
				<div class="form-group col-sm-4">
					<label>Ngày giao</label>
					<input ng-model="ngayGiao" class="form-control"
						readonly="true" />
				</div>

				<div class="form-group col-sm-4">
					<label>Địa chỉ</label>
					<input ng-model="diaChi" class="form-control" readonly="true" />
				</div>

				<div class="form-group col-sm-4">
					<label>Tổng tiền</label>
					<input ng-model="tongTien" class="form-control" readonly="true" />
				</div>
			</div>
			<div class="row">
				<div class="form-group col-sm-12">
					<label>Ghi chú</label>
					<textarea ng-model="ghiChu" rows="5" class="form-control"
						readonly="true" ></textarea>
				</div>

			</div>
		</form>

		<fieldset>
			<legend>Chi tiết đơn hàng</legend>
			<table class="table">
				<thead>
					<tr>
						<th>Mã</th>
						<th>Tên</th>
						<th>Đơn giá</th>
						<th>Khuyến mãi</th>
						<th>Số lượng</th>
						<th>Thành tiền</th>
					</tr>
				</thead>
				<tbody>
					
						<tr ng-repeat="d in details">
							<td>{{d.ma}}</td>
							<td>{{d.sanPham.ten}}</td>
							<td>
								{{d.donGia | number:0}} VND
							</td>
							<td>{{d.khuyenMai*100}} %</td>
							<td>{{d.soLuong}}</td>
							<td>
								{{d.donGia * d.soLuong * (1-d.khuyenMai) | number:0}} VND
							</td>
						</tr>
				</tbody>
			</table>
		</fieldset>
	</div>
</div>