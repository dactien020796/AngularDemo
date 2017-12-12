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
	<link href="css/bootstrap.min.css" rel="stylesheet" />
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
	<link href="css/menu.css" rel="stylesheet" type="text/css" media="all" />
	<script src="js/script.js" type="text/javascript"></script>
	<script type="text/javascript" src="js/move-top.js"></script>
	<script type="text/javascript" src="js/easing.js"></script>
	<link href='//fonts.googleapis.com/css?family=Monda' rel='stylesheet' type='text/css'>
	<link href='//fonts.googleapis.com/css?family=Doppio+One' rel='stylesheet' type='text/css'>
	<link href="css/flexslider.css" rel='stylesheet' type='text/css' />
</head>
<body ng-app="app">
	<div class="wrap">
		<div ng-include='"templates/header.jsp"'></div>
		<div ui-view></div>
	</div>
	<div ng-include='"templates/footer.jsp"'></div>

	<!-- Vendor: Angular, followed by our custom Javascripts -->
	<script src="js/angular.min.js"></script>
	<script src="js/angular-ui-router.min.js"></script>
	<script src="js/angular-jwt.min.js"></script>
	<script src="js/angular-storage.min.js"></script>
	<!-- Our Website Javascripts -->
	<script src="script/main.js"></script>
	<!-- Controllers -->
	<script src="script/controllers/home.controllers.js"></script>
	<script src="script/controllers/about.controller.js"></script>
	<script src="script/controllers/login.controller.js"></script>
	<script src="script/controllers/product-detail.controller.js"></script>
	<script src="script/controllers/register.controller.js"></script>

	<!-- Service -->
	<script src="script/services/authentication.service.js"></script>
	<script src="script/services/product-detail.service.js"></script>

	<script type="text/javascript">
		$(document).ready(function() {

			// 			var defaults = {
			// 				containerID: 'toTop', // fading element id
			// 				containerHoverID: 'toTopHover', // fading element hover id
			// 				scrollSpeed: 1200,
			// 				easingType: 'linear' 
			// 			};

			$().UItoTop({
				easingType : 'easeOutQuart'
			});

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