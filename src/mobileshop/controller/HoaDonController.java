package mobileshop.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

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
	
	@ResponseBody
	@RequestMapping("checkout")
	public HoaDon checkout(ModelMap model, HttpSession session) {
		KhachHang user = (KhachHang) session.getAttribute("user");
		

		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		HoaDon order = new HoaDon();
		order.setTongTien(cart.getAmount());
		try {
			order.setNgayDat(formatter.parse(formatter.format(new Date())));
			
			Date date = new Date();
			date.setDate(date.getDate()+2);
			order.setNgayGiao(formatter.parse(formatter.format(date)));
		} catch (Exception e) {
			// TODO: handle exception
		}

		order.setKhachHang(user);
		order.setNguoiNhan(user.getHoTen());
		
//		model.addAttribute("order",order);
//		return "user/order/checkout";
		return order;
	}
	
	@ResponseBody
	@RequestMapping(value="checkout", method=RequestMethod.POST)
	public String checkout(ModelMap model,
			HttpSession session,
			@RequestParam("nguoiNhan") String nguoiNhan,
			@RequestParam("ngayDat") String ngayDat,
			@RequestParam("ngayGiao") String ngayGiao,
			@RequestParam("diaChi") String diaChi,
			@RequestParam("tongTien") Integer tongTien,
			@RequestParam("ghiChu") String ghiChu) {
		HoaDon order = new HoaDon();
		KhachHang user = (KhachHang) session.getAttribute("user");
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
		order.setKhachHang(user);
		order.setDiaChi(diaChi);
		order.setGhiChu(ghiChu);
		try {
			order.setNgayDat(df.parse(ngayDat));
			order.setNgayGiao(df.parse(ngayGiao));
		} catch (Exception e) {
			// TODO: handle exception
		}
		order.setNguoiNhan(nguoiNhan);
		order.setTongTien(tongTien);
		try {
			hoaDonService.purchase(order, cart);
			cart.clear();
			return "Dat hang thanh cong";
		}
		catch (Exception e) {
			return "Dat hang that bai";
		}
	}

	@RequestMapping("detail/{ma}")
	public String detail(ModelMap model, @PathVariable("ma") Integer ma)
	{
		HoaDon order = hoaDonService.get(ma);
		model.addAttribute("order", order);
		
		return "user/order/detail";
	}
	
	@ResponseBody
	@RequestMapping("list")
	public List<HoaDon> list(ModelMap model, HttpSession session)
	{
		KhachHang user = (KhachHang) session.getAttribute("user");
		
		List<HoaDon> list = hoaDonService.getOrderListByUser(user);
		return list;
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
