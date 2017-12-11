<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>


<div class="content" ng-controler="Product-Detail-Controller">
	<div class="content_top">
		<div class="back-links">
			<p style="font-size: 25px">Chi tiết sản phẩm</p>
		</div>
		<div class="clear"></div>
	</div>

	<div class="section group">
		<div class="cont-desc span_1_of_2" style="width: 100%">
			<div class="grid images_3_of_2">
				<img src="images/products/{{products.hinhAnh}}" alt="" style="width: 300px; height: 350px"/>
			</div>
			<div class="desc span_3_of_2">
				<h2>{{products.ten}}</h2>
				<div class="price">
					<p>
						Giá: 
						<span> 
<%-- 							<fmt:formatNumber type="number"	value="{{products.donGia}}" pattern="###,###,###" />  --%>
							{{products.donGia}} VND
						</span>
					</p>
					<p>
						Khuyến mãi: <span>{{products.khuyenMai}}</span>
					</p>
				</div>


				<div class="add-cart">

					<div class="button rating">
						<span><a href="#">Add to Cart</a></span>
					</div>
					<div class="clear"></div>
				</div>
			</div>
			<div class="product-desc">
				<h2>Cấu hình chi tiết :</h2>
				<table class="table">
					<tr>
						<td><strong>Màn hình</strong></td>
						<td>{{products.manHinh}}</td>
					</tr>
					<tr>
						<td><strong>Hệ điều hành</strong></td>
						<td>{{products.hDH}}</td>
					</tr>
					<tr>
						<td><strong>RAM</strong></td>
						<td>{{products.rAM}}</td>
					</tr>
					<tr>
						<td><strong>ROM</strong></td>
						<td>{{products.rOM}}</td>
					</tr>
					<tr>
						<td><strong>Camera</strong></td>
						<td>{{products.camera}}</td>
					</tr>
					<tr>
						<td><strong>Selfie</strong></td>
						<td>{{products.selfie}}</td>
					</tr>
					<tr>
						<td><strong>Pin</strong></td>
						<td>{{products.pin}}</td>
					</tr>
					<tr>
						<td><strong>Bảo hành</strong></td>
						<td>{{products.baoHanh}}</td>
					</tr>
<!-- 					<tr> -->
<!-- 						<td><strong>Ghi chú</strong></td> -->
<!-- 						<td>{{products.ghi}}</td> -->
<!-- 					</tr> -->
				</table>
			</div>

		</div>
		<div class="rightsidebar span_3_of_1">
<!-- 			<h2>Sản phẩm liên quan</h2> -->
<!-- 			<ul> -->
<%-- 				<c:forEach var="hang" items="${sameHangItems}"> --%>
<%-- 					<li><a href="product/detail/${sanpham.ma}.php">${hang.ten}</a></li> --%>
<%-- 				</c:forEach> --%>

<!-- 			</ul> -->


		</div>

	</div>
</div>