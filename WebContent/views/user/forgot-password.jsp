<%@ page pageEncoding="utf-8"%>
<div class="content" ng-controller="ForgotPasswordCtrl">
	<h2>Quên mật khẩu</h2>
	<form>
		<div class="form-group">
			<label>Tên tài khoản</label> 
			<input ng-model="ma" class="form-control">
		</div>
		<div class="form-group">
			<label>Email</label> 
			<input ng-model="email" class="form-control">
		</div>
		<div class="form-group">
			<button ng-click="forgot(ma, email)" class="btn btn-default">
				<span class="glyphicon glyphicon-search"></span> Lấy lại mật khẩu
			</button>
		</div>
	</form>
</div>