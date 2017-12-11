package mobileshop.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mobileshop.entity.HoaDon;
import mobileshop.entity.KhachHang;
import mobileshop.entity.SanPham;
import mobileshop.service.HoaDonService;
import mobileshop.service.ShoppingCart;

@Controller
@RequestMapping("order")
public class HoaDonController {
	@Autowired
	ShoppingCart cart;
	@Autowired
	HoaDonService hoaDonService;
	
	@RequestMapping("checkout")
	public String checkout(ModelMap model, HttpSession session) {
		KhachHang user = (KhachHang) session.getAttribute("user");
		
		HoaDon order = new HoaDon();
		order.setTongTien(cart.getAmount());
		order.setNgayDat(new Date());
		
		Date date = new Date();
		date.setDate(date.getDate()+2);
		order.setNgayGiao(date);
		
		order.setKhachHang(user);
		order.setNguoiNhan(user.getHoTen());
		
		model.addAttribute("order",order);
		return "user/order/checkout";
	}
	
	@RequestMapping(value="checkout", method=RequestMethod.POST)
	public String checkout(ModelMap model, @ModelAttribute("order") HoaDon order) {
		
		try {
			hoaDonService.purchase(order, cart);
			cart.clear();
			model.addAttribute("message","Dat hang thanh cong");
			
			return "redirect:/order/detail/"+order.getMa()+".php";// chuyen ve chi tiet don hang
		}
		catch (Exception e) {
			model.addAttribute("message","Dat hang that bai");
			return "user/order/checkout";
		}
	}

	@RequestMapping("detail/{ma}")
	public String detail(ModelMap model, @PathVariable("ma") Integer ma)
	{
		HoaDon order = hoaDonService.get(ma);
		model.addAttribute("order", order);
		
		return "user/order/detail";
	}
	
	@RequestMapping("list")
	public String list(ModelMap model, HttpSession session)
	{
		KhachHang user = (KhachHang) session.getAttribute("user");
		
		List<HoaDon> list = hoaDonService.getOrderListByUser(user);
		model.addAttribute("orders", list);
		
		return "user/order/list";
	}
	
	@RequestMapping("items")
	public String items(ModelMap model, HttpSession session)
	{
		KhachHang user = (KhachHang) session.getAttribute("user");
		
		List<SanPham> list = hoaDonService.getPurchasedItems(user);
		model.addAttribute("sanphams", list);
		
		return "user/product/list";
	}
}
