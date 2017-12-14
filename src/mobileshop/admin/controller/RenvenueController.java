package mobileshop.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import mobileshop.service.CTHoaDonService;

@Controller
@RequestMapping("admin/revenue")
public class RenvenueController {
	@Autowired
	CTHoaDonService ctHoaDonService;
	
	@ResponseBody
	@RequestMapping("bysanpham")
	public List<Object[]> bySanPham(ModelMap model) {
		List<Object[]> list = ctHoaDonService.revenueBySanPham();
		//model.addAttribute("items",list);
		return list;
	}
	
	@ResponseBody
	@RequestMapping("byhang")
	public List<Object[]> byHang(ModelMap model) {
		List<Object[]> list = ctHoaDonService.revenueByHang();
		//model.addAttribute("items",list);
		return list;
	}
	
	@ResponseBody
	@RequestMapping("bykhachhang")
	public List<Object[]> byKhachHang(ModelMap model) {
		List<Object[]> list = ctHoaDonService.revenueByKhachHang();
		//model.addAttribute("items",list);
		return list;
	}
	
	@ResponseBody
	@RequestMapping("byyear")
	public List<Object[]> byYear(ModelMap model) {
		List<Object[]> list = ctHoaDonService.revenueByYear();
		//model.addAttribute("items",list);
		return list;
	}
	
	@ResponseBody
	@RequestMapping("bymonth")
	public List<Object[]> byMonth(ModelMap model) {
		List<Object[]> list = ctHoaDonService.revenueByMonth();
		//model.addAttribute("items",list);
		return list;
	}
	
	@ResponseBody
	@RequestMapping("byquarter")
	public List<Object[]> byQuarter(ModelMap model) {
		List<Object[]> list = ctHoaDonService.revenueByQuarter();
		//model.addAttribute("items",list);
		return list;
	}
}
