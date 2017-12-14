<%@ page pageEncoding="utf-8"%>
<head>
<!-- 	<script src="js/shopping-cart.js"></script> -->
	<style id = "nn-cart-fly">
			
	</style>
</head>
<style id = "nn-cart-fly">
		
</style>

<div class="main" ng-controler="SearchHangCtrl">
    <div class="content">
        <div class="content_top">
            <div class="heading">
                <h3>Products</h3>
            </div>
            
            <div class="clear"></div>
        </div>
        <div class="section group">
            <div class="grid_1_of_4 images_1_of_4" ng-repeat="p in products" style="margin-left: 0; margin-right: 15px;">
                <div class="nn-box">
					<a ui-sref="product-detail({ id: p.ma })" >
						<img src="images/products/{{p.hinhAnh}}"/>
					</a>
				</div>
				<h2>{{p.ten}}</h2>
				
				<p>
					<span style="font-size: 20px"> 
						{{p.donGia | number:0 }} VND
					</span>
				</p>
				
				<div class="button">
					<span> 
						<button class="cart-button" data-cart-add={{p.ma}} ng-controller="ShoppingCartCtrl" ng-click="addCart(p.ma)">Thêm vào giỏ hàng</button>
					</span>
				</div>
            </div>

        </div>
    </div>
</div>