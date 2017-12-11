$(function(){
	/**
	 * bo vao gio hang
	 */
	$("a[data-cart-add]").click(function(){
		var id = $(this).attr("data-cart-add");
		$.ajax({
			url: "shopping-cart/add.php",
			data: {ma:id},
			success: function(response){
				$("#count").html( '(' + response[0] );
			},
			dataType: "json"
		});
//		var img = $($(this).parent(".button")).parent(".nn-box").find("img");
		var img = $(this).parents(".grid_1_of_4").find(".nn-box img");
		img.effect("bounce");
//		var src = img.attr("src");
//		var css = '.nn-cart-fly{background-image: url("'+src+'");background-size: 100% 100%;}';
//		$("#nn-cart-fly").html(css);
//		img.effect("transfer",{to:".shopping_cart", className:"nn-cart-fly"}, 1000);
	});
	
	/**
	 * xoa khoi gio hang
	 */
	$("button[data-cart-remove]").click(function(){
		var ma = $(this).attr("data-cart-remove");
		$.ajax({
			url: "shopping-cart/remove.php",
			data: {ma:ma},
			success: function(response){
				$("#count").html('('+response[0]);
				
				var value = response[1];
				var num = value.toFixed(0).replace(/(\d)(?=(\d\d\d)+(?!\d))/g, "$1,");
				$("#tongtien").html(num + ' VND');
				
			},
			dataType: "json"
		});
		$(this).parents("tr").hide(300);
	});
	
	/**
	 * cap nhap gio hang
	 */
	$("input[data-cart-update]").change(function(){
		var ma = $(this).attr("data-cart-update");
		var qty = $(this).val();
		td_amt = $(this).parents("tr").find(".amt");
		$.ajax({
			url: "shopping-cart/update.php",
			data: {ma:ma, qty: qty},
			success: function(response){
//				alert(response[1]);
				$("#count").html(response[0]);
//				$("#amount").html(response[1]);
//				td_amt.html(response[1].toString("#,##")+ ' VND');
//				td_amt.html(format_number(response[1], '.',','));
				
				var value1 = response[1];
				var num1 = value1.toFixed(0).replace(/(\d)(?=(\d\d\d)+(?!\d))/g, "$1,");
				$("#tongtien").html(num1 + ' VND');
				
				var value = response[2];
				var num = value.toFixed(0).replace(/(\d)(?=(\d\d\d)+(?!\d))/g, "$1,");
				td_amt.html(num + ' VND');
			},
			dataType: "json"
		});
		
	});
	
});