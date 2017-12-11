<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<head>
<!-- 	<script src="js/shopping-cart.js"></script> -->
	<style id = "nn-cart-fly">
			
	</style>
</head>

<div class="content">
	<div class="content_top">
		<div class="heading">
			<h3>Danh sách mặt hàng</h3>
		</div>
		<div class="clear"></div>
	</div>
	<div class="section group">
		<table border="1" style="width: 100%;" class="table">
			<thead>
				<tr>
					<th>Tên</th>
					<th>Đơn giá</th>
					<th>Khuyến mãi</th>
					<th>Số lượng</th>
					<th>Thành tiền</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="p" items="${cart.items}">
					<tr>
						<td>${p.ten}</td>
						<td>
							<fmt:formatNumber type="number" value="${p.donGia}" pattern="###,###,###"/>
							VND
						</td>
						<td>${p.khuyenMai}</td>
						<td>
							<input value="${p.soLuong}" type="number" style="width: 50px" data-cart-update="${p.ma}">
						</td>
						<td class="amt">
							<fmt:formatNumber type="number" value="${p.soLuong * p.donGia * (1 - p.khuyenMai)}" pattern="###,###,###"/>
							VND
						</td>
						<td>
							<button class="btn btn-sm btn-danger" data-cart-remove="${p.ma}">X
							</button>
						</td>
					</tr>
				</c:forEach>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td>Tổng tiền: </td>
					<td id="tongtien">
					<fmt:formatNumber type="number" value="${cart.amount}" pattern="###,###,###"/>
					</td>
				</tr>
			</tbody>
		</table>
		
		<div>
			<a class="btn btn-warning" href="shopping-cart/clear.php">Xóa hết</a>
			<a class="btn btn-info" href="#">Continue</a>
			<a class="btn btn-primary" href="order/checkout.php">Thanh toán</a>
		</div>
	</div>
</div>