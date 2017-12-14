<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<c:set var="cart" value="${sessionScope['scopedTarget.cart']}" />

<div class="header">
	<div class="header_top">
		<div class="logo">
			<a ui-sref="home"><img src="images/logo.png" alt="" /></a>
		</div>
		<div class="header_top_right">
			<div class="search_box" ng-controller="HomeCtrl">
				<form>
					<input ng-model="keywords" type="text" value="Search for Products"
						onfocus="this.value = '';"
						onblur="if (this.value == '') {this.value = 'Search for Products';}">
					<input ui-sref="search({ keywords: keywords })" type="submit" value="SEARCH">
				</form>
			</div>
			<div class="shopping_cart">
				<div class="cart">
					<a ui-sref="shopping-cart" title="Xem giỏ hàng"
						rel="nofollow"> <strong class="opencart"> </strong> <!-- 				<span class="cart_title">Giỏ hàng</span> -->
						<span id="count">(${cart.count}</span> sản phẩm)
					</a>
				</div>
			</div>

			<div class="currency" title="currency">
				<div id="currency" class="wrapper-dropdown" tabindex="1">
					<span class="glyphicon glyphicon-user"></span> <strong class="opencart">
					</strong>
					<ul class="dropdown">
						<c:choose>
							<c:when test="${empty sessionScope.user}">
								<li><a ui-sref="login">Đăng nhập</a></li>
								<li><a ui-sref="login">Đăng ký</a></li>
								<li><a ui-sref="forgot-password">Quên mật khẩu</a></li>
							</c:when>
							<c:otherwise>
								<li><a ng-controller="LoginCtrl" ng-click="logoff();">Đăng xuất</a></li>
								<li><a ui-sref="change-password">Đổi mật khẩu</a></li>
								<li><a ui-sref="edit-account">Chỉnh sửa hồ sơ</a></li>
								<li class="divider"></li>
								<li><a ui-sref="order-history">Đơn hàng</a></li>
							</c:otherwise>
						</c:choose>
					</ul>
				</div>
				<script type="text/javascript">
					function DropDown(el) {
						this.dd = el;
						this.initEvents();
					}
					DropDown.prototype = {
						initEvents : function() {
							var obj = this;

							obj.dd.on('click', function(event) {
								$(this).toggleClass('active');
								event.stopPropagation();
							});
						}
					}

					$(function() {

						var dd = new DropDown($('#currency'));

						$(document).click(function() {
							// all dropdowns
							$('.wrapper-dropdown').removeClass('active');
						});

					});
				</script>
			</div>
			<!--             <div class="login"> -->
			<!--                 <span><a href="login.html"><img src="images/login.png" alt="" title="login"/></a></span> -->
			<!--             </div> -->
			<div class="clear"></div>
		</div>
		<div class="clear"></div>
	</div>
	<div class="h_menu" ng-controller="HomeCtrl">
		<a id="touch-menu" class="mobile-menu" href="#">Menu</a>
		<nav>
			<ul class="menu list-unstyled">
				<li><a ui-sref="home">TRANG CHỦ</a></li>

				<li class="activate"><a href="#">HÃNG</a>
					<ul class="sub-menu list-unstyled sub-menu2">
						<div class="navg-drop-main">
							<div class="nav-drop">
								<li ng-repeat="h in hangs">
									<a ui-sref="search-hang({ hang: h.ma })" ">{{h.ten}} </a>
								</li>
							</div>
						</div>
					</ul>
				</li>

				<li><a ui-sref="about">GIỚI THIỆU</a></li>


				<li><a href="home/contact.php">LIÊN HỆ</a></li>
				<li><a href="home/faq.php">HỎI ĐÁP</a></li>
				<div class="clear"></div>
			</ul>
		</nav>
		<script src="js/menu.js" type="text/javascript"></script>
	</div>

	<div class="header_bottom">
		<div class="header_bottom_left">
			<div class="section group">
				<div class="listview_1_of_2 images_1_of_2">
					<div class="listimg listimg_2_of_1">
						<a href="preview.html"> <img src="images/pic4.png" alt="" /></a>
					</div>
					<div class="text list_2_of_1">
						<h2>Iphone</h2>
						<p>Lorem ipsum dolor sit amet sed do eiusmod.</p>
						<div class="button">
							<span><a href="preview.html">Add to cart</a></span>
						</div>
					</div>
				</div>
				<div class="listview_1_of_2 images_1_of_2">
					<div class="listimg listimg_2_of_1">
						<a href="preview-5.html"><img src="images/pic3.png" alt=""/ ></a>
					</div>
					<div class="text list_2_of_1">
						<h2>Samsung</h2>
						<p>Lorem ipsum dolor sit amet, sed do eiusmod.</p>
						<div class="button">
							<span><a href="preview-5.html">Add to cart</a></span>
						</div>
					</div>
				</div>
			</div>
			<div class="section group">
				<div class="listview_1_of_2 images_1_of_2">
					<div class="listimg listimg_2_of_1">
						<a href="preview-3.html"> <img src="images/pic3.jpg" alt="" /></a>
					</div>
					<div class="text list_2_of_1">
						<h2>Acer</h2>
						<p>Lorem ipsum dolor sit amet, sed do eiusmod.</p>
						<div class="button">
							<span><a href="preview-3.html">Add to cart</a></span>
						</div>
					</div>
				</div>
				<div class="listview_1_of_2 images_1_of_2">
					<div class="listimg listimg_2_of_1">
						<a href="preview-6.html"><img src="images/pic1.png" alt="" /></a>
					</div>
					<div class="text list_2_of_1">
						<h2>Canon</h2>
						<p>Lorem ipsum dolor sit amet, sed do eiusmod.</p>
						<div class="button">
							<span><a href="preview-6.html">Add to cart</a></span>
						</div>
					</div>
				</div>
			</div>
			<div class="clear"></div>
		</div>
		<div class="header_bottom_right_images">
			<!-- FlexSlider -->
			<section class="slider">
				<div class="flexslider">
					<ul class="slides">
						<li><img src="images/1.jpg" alt="" /></li>
						<li><img src="images/2.jpg" alt="" /></li>
						<li><img src="images/3.jpg" alt="" /></li>
						<li><img src="images/4.jpg" alt="" /></li>
					</ul>
				</div>
			</section>
			<!-- FlexSlider -->
		</div>
		<div class="clear"></div>
	</div>
</div>

