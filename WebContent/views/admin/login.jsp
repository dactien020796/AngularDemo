<!-- <div> -->
<%--     <form ng-submit="LoginCtrl.submit(_email, _password)"> --%>
<!--         <input type="email" ng-model="_email" /> -->
<!--         <input type="password" ng-model="_password" /> -->
<!--         <button>Submit</button> -->
<%--     </form> --%>
<!--     <button ng-click="LoginCtrl.cancel()">Cancel</button> -->
<!-- </div> -->

<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"  %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<div class="content" ng-controller="LoginCtrl">
	<div class="login_panel col-sm-4">
		<h3>Đăng nhập</h3>
		<div >
			<input name="id" type="text" value="Tên đăng nhập" placeholder="Tên đăng nhập" class="field" ng-model="_id"
				onfocus="this.value = '';"
				onblur="if (this.value == '') {this.value = 'Username';}"> 
			<input
				name="password" type="password" value="Mật khẩu" placeholder="Mật khẩu" class="field" ng-model="_password"
				onfocus="this.value = '';"
				onblur="if (this.value == '') {this.value = 'Password';}"> 
<!-- 			<span style="color: red; padding: 0" class="col-sm-12"">{{result}}</span> -->
			<!-- 		<p class="note"> -->
			<!-- 			If you forgot your passoword just enter your email and click <a -->
			<!-- 				href="#">here</a> -->
			<!-- 		</p> -->
			<div class="buttons">
				<div>
					<button  ng-click="login(_id, _password)" type="submit" class="grey">Đăng nhập</button>
				</div>
			</div>
		</div>
		
	</div>
	<div class="register_account" style="width:64.5%" >
		<h3>Đăng ký</h3>
		<div>
			<table>
				<tbody>
					<tr>
						<td>
							<input type="text" placeholder="Tên tài khoản" ng-model="_username">
						</td>
						<td>
							<input type="text" placeholder="Họ tên" ng-model="_hoTen">
						</td>
					</tr>
					<tr>
						<td>
							<input ng-model="_matKhau" id="password" type="password" placeholder="Mật khẩu">
						</td>
						<td>
							<input ng-model="_email" type="email" placeholder="Email"></input>
						</td>
					</tr>
					<tr>
						<td>
							<input id="confirm-password"  type="password" placeholder="Nhập lại mật khẩu" />
						</td>
						
					</tr>
				</tbody>
			</table>
			<span style="color: red; padding: 0" class="col-sm-12" id="error_dangKy">${message}</span>
			
			<div class="search">
				<div>
					<button ng-click="register(_username,_hoTen,_matKhau,_email)"  type="submit" class="grey">Tạo tài khoản</button>
				</div>
			</div>
			<p class="terms">
				By clicking 'Create Account' you agree to the <a href="#">Terms
					&amp; Conditions</a>.
			</p>
			<div class="clear"></div>
		</div>
	</div>
	<div class="clear"></div>
</div>


