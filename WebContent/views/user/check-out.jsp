<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class="content" ng-controller="CheckOutCtrl">
	<div class="content_top">
		<div class="heading">
			<h3>Xác nhận đơn hàng</h3>
		</div>
		<div class="clear"></div>
	</div>
	<div class="section group">
		<form >
			<br>
			<div class="row">
				
				<div class="form-group col-sm-4">
					<label>Khách hàng</label>
					<input class="form-control" readonly="true" ng-model="nguoiDat" />
				</div>

				<div class="form-group col-sm-4">
					<label>Người nhận</label>
					<input class="form-control" ng-model="nguoiNhan" />
				</div>

				<div class="form-group col-sm-4">
					<label>Ngày đặt</label>
					<input class="form-control" readonly="true" ng-model="ngayDat" />
				</div>
			</div>
			<div class="row">
				<div class="form-group col-sm-4">
					<label>Ngày giao</label>
					<input class="form-control" readonly="true"  ng-model="ngayGiao" />
				</div>

				<div class="form-group col-sm-4">
					<label>Địa chỉ</label>
					<input class="form-control" ng-model="diaChi"/>
				</div>

				<div class="form-group col-sm-4">
					<label>Tổng tiền</label>
					<input class="form-control" readonly="true" ng-model="tongTien"/>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-sm-12">
					<label>Ghi chú</label>
					<textarea rows="5" class="form-control" ng-model="ghiChu" ></textarea>
				</div>

				<div class="form-group">
					<button ng-click="check_out(nguoiNhan, ngayDat, ngayGiao, diaChi, tongTien, ghiChu)" class="btn btn-info" style="margin-left:20px">Xác nhận</button>
				</div>
			</div>
		</form>
	</div>
</div>