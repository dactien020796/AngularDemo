package mobileshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import mobileshop.entity.SanPham;
import mobileshop.service.ShoppingCart;


@Controller
@RequestMapping("shopping-cart")
public class ShoppingCartController {
	@Autowired
	ShoppingCart cart;
	
	@ResponseBody
	@RequestMapping("add")
	public String add(@RequestParam("ma") Integer ma) {
		cart.add(ma);
		String json = String.format("[%d]", cart.getCount());
//		return "["+cart.getCount()+","+cart.getAmount()+"]";
		return json;
	}
	
	@RequestMapping("view")
	public String view(ModelMap model) {
		model.addAttribute("cart",cart);
		return "user/shopping-cart/view";
	}
	
	@ResponseBody
	@RequestMapping("remove")
	public String remove(@RequestParam("ma") Integer ma) {
		cart.remove(ma);
		String json = String.format("[%d, %d]", cart.getCount(), cart.getAmount());
//		String json = String.format("[%d]", cart.getCount());
		return json;
	}
	
	@ResponseBody
	@RequestMapping("update")
	public String update(@RequestParam("ma") Integer ma,
			@RequestParam("qty") Integer qty) {
		cart.update(ma, qty);
		SanPham p = cart.getItem(ma);
		long amount = (long) (p.getDonGia() * p.getSoLuong() * (1.0 - p.getKhuyenMai()));
		System.out.println(amount);
		String json = String.format("[%d, %d, %d]", cart.getCount(), cart.getAmount(), amount);
		return json;
	}
	
	@RequestMapping("clear")
	public String clear(ModelMap model) {
		cart.clear();
		model.addAttribute("cart",cart);
		return "user/shopping-cart/view";
	}
}
