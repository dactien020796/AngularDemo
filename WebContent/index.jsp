<!DOCTYPE html>
<!--[if lt IE 7]>
<html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>
<html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>
<html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->
<head>
	<title>Free Smart Store Website Template | Home :: w3layouts</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport"
		content="width=device-width, initial-scale=1, maximum-scale=1">
	<script src="/DemoAngular/js/jquery.min.js"></script>
	<script src="/DemoAngular/js/bootstrap.min.js"></script>
	<link href="/DemoAngular/css/bootstrap.min.css" rel="stylesheet" />
	<link href="/DemoAngular/css/style.css" rel="stylesheet" type="text/css" media="all" />
	<link href="/DemoAngular/css/menu.css" rel="stylesheet" type="text/css" media="all" />
	<script src="/DemoAngular/js/script.js" type="text/javascript"></script>
	<script type="/DemoAngular/text/javascript" src="js/move-top.js"></script>
	<script type="/DemoAngular/text/javascript" src="js/easing.js"></script>
<!-- 	<link href='//fonts.googleapis.com/css?family=Monda' rel='stylesheet' type='text/css'> -->
<!-- 	<link href='//fonts.googleapis.com/css?family=Doppio+One' rel='stylesheet' type='text/css'> -->
	<link href="/DemoAngular/css/flexslider.css" rel='stylesheet' type='text/css' />
	<script src="https://cdn.jsdelivr.net/npm/moment@2.19.4/moment.js" type="text/javascript"></script>
	<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
	<script src="/DemoAngular/js/bootstrap.min.2.js"></script>
</head>
<body ng-app="app">
	<div class="wrap">
		<div ng-include='"/DemoAngular/templates/header.jsp"'></div>
		<div ui-view></div>
	</div>
	<div ng-include='"/DemoAngular/templates/footer.jsp"'></div>

	<!-- Vendor: Angular, followed by our custom Javascripts -->
	<script src="/DemoAngular/js/angular.min.js"></script>
	<script src="/DemoAngular/js/angular-ui-router.min.js"></script>
	<script src="/DemoAngular/js/angular-jwt.min.js"></script>
	<script src="/DemoAngular/js/angular-storage.min.js"></script>
	<!-- Our Website Javascripts -->
	<script src="/DemoAngular/script/user/main.js"></script>
	<!-- Controllers -->
	<script src="/DemoAngular/script/user/controllers/home.controllers.js"></script>
	<script src="/DemoAngular/script/user/controllers/about.controller.js"></script>
	<script src="/DemoAngular/script/user/controllers/login.controller.js"></script>
	<script src="/DemoAngular/script/user/controllers/product-detail.controller.js"></script>
	<script src="/DemoAngular/script/user/controllers/register.controller.js"></script>
	<script src="/DemoAngular/script/user/controllers/shopping-cart.controller.js"></script>
	<script src="/DemoAngular/script/user/controllers/check-out.controller.js"></script>
	<script src="/DemoAngular/script/user/controllers/change-password.controller.js"></script>
	<script src="/DemoAngular/script/user/controllers/edit-account.controller.js"></script>
	<script src="/DemoAngular/script/user/controllers/forgot-password.controller.js"></script>
	<script src="/DemoAngular/script/user/controllers/order-history.controller.js"></script>
	<script src="/DemoAngular/script/user/controllers/order-detail.controller.js"></script>
	
	<!-- Service -->
	<script src="/DemoAngular/script/user/services/authentication.service.js"></script>
	<script src="/DemoAngular/script/user/services/product-detail.service.js"></script>

	<script type="text/javascript">
		$(document).ready(function() {

			// 			var defaults = {
			// 				containerID: 'toTop', // fading element id
			// 				containerHoverID: 'toTopHover', // fading element hover id
			// 				scrollSpeed: 1200,
			// 				easingType: 'linear' 
			// 			};

// 			$().UItoTop({
// 				easingType : 'easeOutQuart'
// 			});

		});
	</script>
	<a href="#" id="toTop" style="display: block;"><span
		id="toTopHover" style="opacity: 1;"></span></a>

	<script defer src="js/jquery.flexslider.js"></script>
	<script type="text/javascript">
// 		$(function() {
// 			SyntaxHighlighter.all();
// 		});
		$(window).load(function() {
			$('.flexslider').flexslider({
				animation : "slide",
				start : function(slider) {
					$('body').removeClass('loading');
				}
			});
		});
	</script>
</body>
</html>