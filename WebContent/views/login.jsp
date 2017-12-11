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
<div class="content" ng-controler="LoginCtrl">
	<div class="login_panel col-sm-4">
		<h3>Đăng nhập</h3>
		<form ng-controller="LoginCtrl" ng-submit="submit(_id, _password)" >
			<input name="id" type="text" value="Tên đăng nhập" class="field" ng-model="_id"
				onfocus="this.value = '';"
				onblur="if (this.value == '') {this.value = 'Username';}"> 
			<input
				name="password" type="password" value="Mật khẩu" class="field" ng-model="_password"
				onfocus="this.value = '';"
				onblur="if (this.value == '') {this.value = 'Password';}"> 
<!-- 			<span style="color: red; padding: 0" class="col-sm-12"">{{result}}</span> -->
			<!-- 		<p class="note"> -->
			<!-- 			If you forgot your passoword just enter your email and click <a -->
			<!-- 				href="#">here</a> -->
			<!-- 		</p> -->
			<div class="buttons">
				<div>
					<button type="submit" class="grey">Đăng nhập</button>
				</div>
			</div>
		</form>
		
	</div>
<!-- 	<div class="register_account" style="width:64.5%"> -->
<!-- 		<h3>Đăng ký</h3> -->
<%-- 		<form:form action="account/register.php" modelAttribute="user" enctype="multipart/form-data"> --%>
<!-- 			<table> -->
<!-- 				<tbody> -->
<!-- 					<tr> -->
<!-- 						<td> -->
<%-- 							<form:input path="ma" type="text" placeholder="Tên tài khoản"></form:input> --%>
<!-- 						</td> -->
<!-- 						<td> -->
<%-- 							<form:input path="hoTen" type="text" placeholder="Họ tên"></form:input> --%>
<!-- 						</td> -->
<!-- 					</tr> -->
<!-- 					<tr> -->
<!-- 						<td> -->
<%-- 							<form:input path="matKhau" id="password" type="password" placeholder="Mật khẩu"></form:input> --%>
<!-- 						</td> -->
<!-- 						<td> -->
<%-- 							<form:input path="email" type="email" placeholder="Email"></form:input> --%>
<!-- 						</td> -->
<!-- 					</tr> -->
<!-- 					<tr> -->
<!-- 						<td> -->
<!-- 							<input id="confirm-password" type="password" placeholder="Nhập lại mật khẩu" /> -->
<!-- 						</td> -->
<!-- 						<td> -->
<!-- 							<input type="file" name="uphinhAnh" placeholder="Hình ảnh"> -->
<%-- 							<form:hidden path="trangThai"/> --%>
<!-- 						</td> -->
<!-- 					</tr> -->
<!-- 				</tbody> -->
<!-- 			</table> -->
<%-- 			<span style="color: red; padding: 0" class="col-sm-12" id="error_dangKy">${message}</span> --%>
			
<!-- 			<div class="search"> -->
<!-- 				<div> -->
<!-- 					<button type="submit" class="grey">Tạo tài khoản</button> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<p class="terms"> -->
<!-- 				By clicking 'Create Account' you agree to the <a href="#">Terms -->
<!-- 					&amp; Conditions</a>. -->
<!-- 			</p> -->
<!-- 			<div class="clear"></div> -->
<%-- 		</form:form> --%>
<!-- 	</div> -->
	<div class="clear"></div>
</div>


