<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<div class="header">
	<div class="header_top">
		<div class="logo">
			<a href="index.html"><img src="images/logo.png" alt="" /></a>
		</div>
		<div class="header_top_right">
			<div class="search_box">
				<form>
					<input type="text" value="Search for Products"
						onfocus="this.value = '';"
						onblur="if (this.value == '') {this.value = 'Search for Products';}"><input
						type="submit" value="SEARCH">
				</form>
			</div>
			<div class="shopping_cart">
				<div class="cart">
					<a href="#" title="View my shopping cart" rel="nofollow"> <strong
						class="opencart"> </strong> <span class="cart_title">Cart</span> <span
						class="no_product">(empty)</span>
					</a>
				</div>
			</div>

			<div class="currency" title="currency">
				<div id="currency" class="wrapper-dropdown" tabindex="1">
					<span class="glyphicon glyphicon-user" /> <strong class="opencart">
					</strong>
					<ul class="dropdown">
						<c:choose>
							<c:when test="${empty sessionScope.user}">
								<li><a ui-sref="login">Đăng nhập</a></li>
								<li><a href="account/register.php">Đăng ký</a></li>
								<li><a href="account/forgot.php">Quên mật khẩu</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="" ng-click="LoginCtrl.logoff();">Đăng xuất</a></li>
								<li><a href="account/change.php">Đổi mật khẩu</a></li>
								<li><a href="account/edit.php">Chỉnh sửa hồ sơ</a></li>
								<li class="divider"></li>
								<li><a href="order/list.php">Đơn hàng</a></li>
								<li><a href="order/items.php">Hàng đã mua</a></li>
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
	<div class="h_menu">
		<a id="touch-menu" class="mobile-menu" href="#">Menu</a>
		<nav>
			<ul class="menu list-unstyled">
				<li><a href="home/index.php">TRANG CHỦ</a></li>

				<li class="activate"><a href="#">HÃNG</a>
					<ul class="sub-menu list-unstyled sub-menu2">
						<div class="navg-drop-main">
							<div class="nav-drop">
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
