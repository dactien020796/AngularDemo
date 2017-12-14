<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>DIGIWORLD WEB MASTER</title>
        <base href="${pageContext.request.contextPath}/">

        <!-- Bootstrap Core CSS -->
        <link href="admin/css/bootstrap.min.css" rel="stylesheet">

        <!-- MetisMenu CSS -->
        <link href="admin/css/metisMenu.min.css" rel="stylesheet">

        <!-- Timeline CSS -->
        <link href="admin/css/timeline.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="admin/css/startmin.css" rel="stylesheet">

        <!-- Morris Charts CSS -->
        <link href="admin/css/morris.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="admin/css/font-awesome.min.css" rel="stylesheet" type="text/css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body ng-app="app">
		<!-- Vendor: Angular, followed by our custom Javascripts -->
				<script src="/DemoAngular/js/angular.min.js"></script>
				<script src="/DemoAngular/js/angular-ui-router.min.js"></script>
				<script src="/DemoAngular/js/angular-jwt.min.js"></script>
				<script src="/DemoAngular/js/angular-storage.min.js"></script>
				<!-- Our Website Javascripts -->
				<script src="/DemoAngular/script/admin/app-admin.js"></script>
				<!-- Controllers -->
				<script src="/DemoAngular/script/admin/controllers/hangsx.controller.js"></script>
				<script src="/DemoAngular/script/admin/controllers/sanpham.controller.js"></script>
					<script src="/DemoAngular/script/admin/controllers/hoadon.controller.js"></script>
				
        <div id="wrapper" style="height: 725px;">
        
        <!-- Service -->
	<script src="/DemoAngular/script/admin/services/authentication.service.js"></script>
	<script src="/DemoAngular/script/admin/services/product-detail.service.js"></script>

            <!-- Navigation -->
            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                <div class="navbar-header">
                    <a class="navbar-brand" >Startmin</a>
                </div>

                <ul class="nav navbar-right navbar-top-links">
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                            <i class="fa fa-user fa-fw"></i> ${sessionScope.admin.hoTen} <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu dropdown-user">
                            <li><a href="admin/home/login.php?out=true"><i class="fa fa-sign-out fa-fw"></i> Đăng xuất</a>
                            </li>
                        </ul>
                    </li>
                </ul>
                <!-- /.navbar-top-links -->

                <div class="navbar-default sidebar" role="navigation">
                    <div class="sidebar-nav navbar-collapse">
                        <ul class="nav in" id="side-menu">
                            <li class="sidebar-search">
                                <div class="input-group custom-search-form">
                                    <input class="form-control" placeholder="Search..." type="text">
                                    <span class="input-group-btn">
                                        <button class="btn btn-primary" type="button">
                                            <i class="fa fa-search"></i>
                                        </button>
                                </span>
                                </div>
                                <!-- /input-group -->
                            </li>
                            <li>
                                <a ui-sref="hangsx" class="active"><i class="fa fa-dashboard fa-fw"></i> Quản lý hãng sản xuất</a>
                            </li>
                            <li class="">
                                <a ui-sref="sanpham" ><i class="fa fa-bar-chart-o fa-fw"></i> Quản lý sản phẩm</a>
                            </li>
                            <li>
                                <a ui-sref="hoadon"><i class="fa fa-table fa-fw"></i> Quản lý hóa đơn</a>
                            </li>
                            <li>
                                <a href="admin/inventory/byhang.php"><i class="fa fa-edit fa-fw"></i> Thống kê sản phẩm</a>
                            </li>
                            <li>
                                <a href="admin/revenue/bysanpham.php"><i class="fa fa-wrench fa-fw"></i> Doanh thu theo sản phẩm</a>
                            </li>
                            <li>
                                <a href="admin/revenue/byhang.php"><i class="fa fa-sitemap fa-fw"></i> Doanh thu theo hãng</a>
                            </li>
                            <li>
                                <a href="admin/revenue/bykhachhang.php"><i class="fa fa-files-o fa-fw"></i> Doanh thu theo khách hàng</a>
                            </li>
                            <li>
                                <a href="admin/revenue/byyear.php"><i class="fa fa-files-o fa-fw"></i> Doanh thu theo năm</a>
                            </li>
                            <li>
                                <a href="admin/revenue/bymonth.php"><i class="fa fa-files-o fa-fw"></i> Doanh thu theo tháng</a>
                            </li>
                            <li>
                                <a href="admin/revenue/byquarter.php"><i class="fa fa-files-o fa-fw"></i> Doanh thu theo quý</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>

            <div id="page-wrapper" ui-view>
<%--                 <jsp:include page="${param.view}"></jsp:include> --%>
            </div>
            <!-- /#page-wrapper -->
		
        </div>
        <!-- /#wrapper -->

        <!-- jQuery -->
        <script src="admin/js/jquery.min.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="admin/js/bootstrap.min.js"></script>

        <!-- Metis Menu Plugin JavaScript -->
        <script src="admin/js/metisMenu.min.js"></script>

        <!-- Morris Charts JavaScript -->
<!--         <script src="admin/js/raphael.min.js"></script> -->
<!--         <script src="admin/js/morris.min.js"></script> -->
<!--         <script src="admin/js/morris-data.js"></script> -->

        <!-- Custom Theme JavaScript -->
        <script src="admin/js/startmin.js"></script>

    </body>
</html>