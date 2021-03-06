<script src="js/shopping-cart.js"></script>
<style id = "nn-cart-fly">
		
</style>

<div class="main" ng-controler="HomeCtrl">
    <div class="content">
        <div class="content_top">
            <div class="heading">
                <h3>News Products</h3>
            </div>
            
            <div class="clear"></div>
        </div>
        <div class="section group" >
            <div class="grid_1_of_4 images_1_of_4" ng-repeat="p in products" style="margin-left: 0; margin-right: 15px;">
                <div class="nn-box">
					<a ui-sref="product-detail" ng-controler="Product-Detail-Controller" ng-click="detail(p[0])">
						<img src="images/products/{{p[3]}}"/>
					</a>
				</div>
				<h2>{{p[1]}}</h2>
				
				<p>
					<span style="font-size: 20px"> 
						{{p[2]}} VND
					</span>
				</p>
				
				<div class="button">
					<span> 
						<a class="cart-button" data-cart-add={{p[0]}}>Add to Cart</a>
					</span>
				</div>
            </div>

        </div>
    </div>
</div>