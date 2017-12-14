<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Quản lý hãng sản xuất</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<ul class="nav nav-tabs">
	<li class="active"><a data-toggle="tab" href="#form"> <span
			class="glyphicon glyphicon-edit"></span> Chỉnh sửa
	</a></li>
	<li><a data-toggle="tab" href="#gridview"> <span
			class="glyphicon glyphicon-list"></span> Danh sách hãng sản xuất
	</a></li>
</ul>

<div class="tab-content" ng-controller="HangSXCtrl">
	<div id="form" class="tab-pane fade in active">
		<!-- FORM -->
		
		<form>
			<div class="form-group">
				<label>Mã</label>
				<input ng-model="ma" class="form-control" />
			</div>
			<div class="form-group">
				<label>Tên Hãng</label>
				<input ng-model="tenHang" class="form-control" />
			</div>

			<div class="form-group">
				<button class="btn btn-primary"
					ng-click="insert(ma, tenHang)">
					<span class="glyphicon glyphicon-plus"></span> Thêm
				</button>
				<button class="btn btn-warning" 
					ng-click="edit(ma, tenHang)">
					<span class="glyphicon glyphicon-save"></span> Cập nhật
				</button>
				<button class="btn btn-danger" formaction="admin/manufacturer/delete.php">
					<span class="glyphicon glyphicon-trash"></span> Xóa
				</button>
				<button class="btn btn-default" formaction="admin/manufacturer/index.php">
					<span class="glyphicon glyphicon-refresh"></span> Reset
				</button>
			</div>
		</form>
	</div>
	<div id="gridview" class="tab-pane fade">
		<!-- TABLE -->
		<table class="table">
			<thead>
				<tr>
					<th>Mã</th>
					<th>Tên Hãng</th>
					<th></th>
				</tr>
			</thead>

			<tbody>
				
					<tr ng-repeat="hang in hangsx" >
						<td>{{hang.ma}}</td>
						<td>{{hang.ten}}</td>
						<td><a ng-click="getHang(hang.ma)"
							class="btn btn-sm btn-info"> <span
								class="glyphicon glyphicon-edit"></span> Sửa
						</a></td>
					</tr>

			</tbody>
		</table>
	</div>
</div>
