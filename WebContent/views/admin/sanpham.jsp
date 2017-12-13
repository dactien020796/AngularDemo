yy<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<script src="admin/js/jquery.min.js"></script>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Quản lý sản phẩm</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<ul class="nav nav-tabs">
	<li class="active"><a data-toggle="tab" href="#form"> <span
			class="glyphicon glyphicon-edit"></span> Chỉnh sửa
	</a></li>
	<li><a data-toggle="tab" href="#gridview"> <span
			class="glyphicon glyphicon-list"></span> Danh sách sản phẩm
	</a></li>
</ul>

<div class="tab-content">
	<div id="form" class="tab-pane fade in active">
		<!-- FORM -->
		<form>
			<div class="form-group">
				<label>Mã</label> <input ng-model="ma" class="form-control"
					readonly="true" />
			</div>
			<div class="form-group">
				<label>Tên</label> <input ng-model="ten" class="form-control" />
			</div>
			<div class="form-group">
				<label>Đơn giá</label> <input ng-model="donGia" class="form-control" />
			</div>
			<div class="form-group">
				<label>Số lượng</label> <input ng-model="soLuong"
					class="form-control" />
			</div>
			<div class="form-group">
				<label>Hãng</label>
				<%-- 				<form:select ng-model="hang.ma" class="form-control" --%>
				<%-- 					items="${sitems}" itemValue="ma" itemLabel="ten" /> --%>
				<select ng-model="" class="form-control">

					<option>1</option>
					<option>2</option>
					<option>3</option>

				</select>
			</div>
			<div class="form-group">
				<label>Kích thước màn hình</label> <input ng-model="manHinh"
					class="form-control" />
			</div>
			<div class="form-group">
				<label>Hệ điều hành</label> <input ng-model="hDH"
					class="form-control" />
			</div>
			<div class="form-group">
				<label>Dung lượng RAM</label> <input ng-model="rAM"
					class="form-control" />
			</div>
			<div class="form-group">
				<label>Dung lượng ROM</label> <input ng-model="rOM"
					class="form-control" />
			</div>
			<div class="form-group">
				<label>Camera sau</label> <input ng-model="camera"
					class="form-control" />
			</div>
			<div class="form-group">
				<label>Camera trước</label> <input ng-model="selfie"
					class="form-control" />
			</div>
			<div class="form-group">
				<label>Dung lượng pin</label> <input ng-model="pin"
					class="form-control" />
			</div>
			<div class="form-group">
				<label>Bảo hành</label> <input ng-model="baoHanh"
					class="form-control" />
			</div>
			<div class="form-group">
				<label>Khuyến mãi</label> <input ng-model="khuyenMai"
					class="form-control" />
			</div>
			<div class="form-group">
				<label>Số lượng xem</label> <input ng-model="luotXem"
					class="form-control" />
			</div>
			<div class="form-group">
				<label>Ghi chú</label>
				<%-- 				<form:textarea ng-model="ghiChu" class="form-control" rows="3" /> --%>

			</div>
			<div class="form-group">
				<label>Đặc biệt?</label>
				<div class="form-control">
					<%-- 					<form:radiobutton ng-model="dacBiet" value="true" label="Yes" /> --%>
					<%-- 					<form:radiobutton ng-model="dacBiet" value="false" label="No" /> --%>

					<input type="radio" ng-model="dacBiet" value="true" label="Yes">
					<input type="radio" ng-model="dacBiet" value="false" label="No">
				</div>
			</div>
			<div class="form-group">
				<label>Mới nhất?</label>
				<div class="form-control">
					<%-- 					<form:radiobutton ng-model="moiNhat" value="true" label="Yes" /> --%>
					<%-- 					<form:radiobutton ng-model="moiNhat" value="false" label="No" /> --%>
					<input type="radio" ng-model="moiNhat" value="true" label="Yes">
					<input type="radio" ng-model="moiNhat" value="false" label="No">
				</div>
			</div>
			<div class="form-group">
				<label>Hình ảnh</label> <input type="file" name="uphinhAnh"
					class="form-control">
				<%-- 				<form:hidden ng-model="hinhAnh" /> --%>
				<input type="hidden" ng-model="hinhAnh">
			</div>

			<div class="form-group">
				<button class="btn btn-primary"
					formaction="admin/product/insert.php">
					<span class="glyphicon glyphicon-plus"></span> Thêm
				</button>
				<button class="btn btn-warning"
					formaction="admin/product/update.php">
					<span class="glyphicon glyphicon-save"></span> Cập nhật
				</button>
				<button class="btn btn-danger" formaction="admin/product/delete.php">
					<span class="glyphicon glyphicon-trash"></span> Xóa
				</button>
				<button class="btn btn-default" formaction="admin/product/index.php">
					<span class="glyphicon glyphicon-refresh"></span> Reset
				</button>
			</div>
		</form>
	</div>
	<div id="gridview" class="tab-pane fade" ng-controller="SanPhamCtrl">
		<!-- TABLE -->
		<!-- 		<tr ng-repeat="hang in hangsx" > -->
		<!-- 						<td>{{hang.ma}}</td> -->
		<!-- 						<td>{{hang.ten}}</td> -->
		<!-- 						<td><a ng-click="getHang(hang.ma)" -->
		<!-- 							class="btn btn-sm btn-info"> <span -->
		<!-- 								class="glyphicon glyphicon-edit"></span> Sửa -->
		<!-- 						</a></td> -->
		<!-- 					</tr> -->
		<table class="table">
			<thead>
				<tr>
					<th>Mã</th>
					<th>Tên</th>
					<th>Hãng</th>
					<th>Đơn giá</th>
					<th>Số lượng</th>
					<th>Giảm giá</th>
					<th></th>
				</tr>
			</thead>

			<tbody>

				<tr ng-repeat="sp in sanpham">
					<td>{{sp.ma}}</td>
					<td>{{sp.ten}}</td>
					<td>{{sp.hang.ten}}</td>
					<td>{{sp.gia | number:0}} VND</td>

					<td>{{sp.soLuong}}</td>
					<td>{{sp.khuyenMai}}</td>
					<td><a class="btn btn-sm btn-info"> <span
							class="glyphicon glyphicon-edit"></span> Sửa
					</a></td>
				</tr>

			</tbody>
		</table>
		<ul class="pager">
			<li><a href=""><span class="glyphicon glyphicon-hand-up"></span></a></li>
			<li><a href=""><span class="glyphicon glyphicon-hand-left"></span></a></li>
			<li><a>1</a></li>
			<li><a href=""><span class="glyphicon glyphicon-hand-right"></span></a></li>
			<li><a href=""><span class="glyphicon glyphicon-hand-down"></span></a></li>
		</ul>
		<div id="page"></div>
	</div>
	<script type="text/javascript">
		$(function() {
			pageNo = 0;
			pageSize = 6;
			pageCount = 10;

			//Tải tổng số trang
			$.ajax({
				url : "admin/product/pagecount.php",
				data : {
					pageSize : pageSize
				},
				success : function(response) {
					pageCount = parseInt(response);
				}
			});

			function gotoPage() {
				$.ajax({
					url : "admin/product/loadpage.php",
					data : {
						pageNo : pageNo,
						pageSize : pageSize
					},
					success : function(response) {
						$("#page").html(response);
						$(".pager a:eq(2)").html(
								(1 + pageNo) + " of " + pageCount);
					}
				});
			}

			gotoPage(); //hiển thị trang đầu tiên

			$(".pager a:eq(0)").click(function() {
				pageNo = 0;
				gotoPage();
				return false;
			});

			$(".pager a:eq(1)").click(function() {
				if (pageNo > 0) {
					pageNo -= 1;
					gotoPage();
				}
				return false;
			});

			$(".pager a:eq(3)").click(function() {
				if (pageNo < pageCount - 1) {
					pageNo += 1;
					gotoPage();
				}
				return false;
			});

			$(".pager a:eq(4)").click(function() {
				pageNo = pageCount - 1;
				gotoPage();
				return false;
			});

		});
	</script>
</div>

