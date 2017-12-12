<%@ page pageEncoding="utf-8"%>
<div class="content" ng-controller="ChangePasswordCtrl">
	<h2>Đổi mật khẩu</h2>
	<form>
		<div class="form-group">
			<label>Mật khẩu hiện tại</label> 
			<input ng-model="password" class="form-control" type="password">
		</div>

		<div class="form-group">
			<label>Mật khẩu mới</label> 
			<input ng-model="password1" class="form-control" type="password">
		</div>

		<div class="form-group">
			<label>Xác nhận mật khẩu mới</label> 
			<input ng-model="password2" class="form-control" type="password">
		</div>

		<div class="form-group">
			<button class="btn btn-default btn-info" ng-click="change(password, password1, password2)">
				<span class="glyphicon glyphicon-save"></span> Đổi mật khẩu
			</button>
		</div>
	</form>
</div>