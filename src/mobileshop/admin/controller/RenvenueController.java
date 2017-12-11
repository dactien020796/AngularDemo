package mobileshop.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import mobileshop.service.CTHoaDonService;

@Controller
@RequestMapping("admin/revenue")
public class RenvenueController {
	@Autowired
	CTHoaDonService ctHoaDonService;
	
	@RequestMapping("bysanpham")
	public String bySanPham(ModelMap model) {
		List<Object[]> list = ctHoaDonService.revenueBySanPham();
		model.addAttribute("items",list);
		return "admin/revenue/by-sanpham";
	}
	
	@RequestMapping("byhang")
	public String byHang(ModelMap model) {
		List<Object[]> list = ctHoaDonService.revenueByHang();
		model.addAttribute("items",list);
		return "admin/revenue/by-hang";
	}
	
	@RequestMapping("bykhachhang")
	public String byKhachHang(ModelMap model) {
		List<Object[]> list = ctHoaDonService.revenueByKhachHang();
		model.addAttribute("items",list);
		return "admin/revenue/by-khachhang";
	}
	
	@RequestMapping("byyear")
	public String byYear(ModelMap model) {
		List<Object[]> list = ctHoaDonService.revenueByYear();
		model.addAttribute("items",list);
		return "admin/revenue/by-year";
	}
	
	@RequestMapping("bymonth")
	public String byMonth(ModelMap model) {
		List<Object[]> list = ctHoaDonService.revenueByMonth();
		model.addAttribute("items",list);
		return "admin/revenue/by-month";
	}
	
	@RequestMapping("byquarter")
	public String byQuarter(ModelMap model) {
		List<Object[]> list = ctHoaDonService.revenueByQuarter();
		model.addAttribute("items",list);
		return "admin/revenue/by-quarter";
	}
}
