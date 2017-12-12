<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class="content">
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
					<input class="form-control" readonly="true" value="{{customer.khachHang.hoTen}}" />
				</div>

				<div class="form-group col-sm-4">
					<label>Người nhận</label>
					<input class="form-control" value="{{customer.khachHang.hoTen}}" />
				</div>

				<div class="form-group col-sm-4">
					<label>Ngày đặt</label>
					<input class="form-control" readonly="true" value="{{customer.ngayDat}}" />
				</div>
			</div>
			<div class="row">
				<div class="form-group col-sm-4">
					<label>Ngày giao</label>
					<input class="form-control" readonly="true"  value="{{customer.ngayGiao}}"/>
				</div>

				<div class="form-group col-sm-4">
					<label>Địa chỉ</label>
					<input class="form-control"/>
				</div>

				<div class="form-group col-sm-4">
					<label>Tổng tiền</label>
					<input class="form-control" readonly="true"  value="{{customer.tongTien}}"/>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-sm-12">
					<label>Ghi chú</label>
					<textarea rows="5" class="form-control" ></textarea>
				</div>

				<div class="form-group">
					<button class="btn btn-info" style="margin-left:20px">Xác nhận</button>
				</div>
			</div>
		</form>
	</div>
</div>