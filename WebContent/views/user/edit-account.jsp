<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<div class="content">
	<h2>Cập nhật tài khoản</h2>
	<form>
		<div class="form-group">
			<label>Tên tài khoản</label>
			<input ng-model="ma" class="form-control" readonly="true"/>
		</div>
		
		<div class="form-group">
			<label>Họ tên</label>
			<input ng-model="hoTen" class="form-control"/>
		</div>
		
		<div class="form-group">
			<label>Email</label>
			<input ng-model="email" type="email" class="form-control"/>
		</div>
		
		<div class="form-group">
			<button ng-click="change(hoTen, email)" class="btn btn-default btn-info">
				Lưu cập nhật
			</button>
		</div>
	</form>
</div>