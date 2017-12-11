package mobileshop.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import mobileshop.entity.HoaDon;
import mobileshop.service.HoaDonService;

@Controller
@RequestMapping("admin/order")
public class OrderController {
	@Autowired
	HoaDonService hoaDonService;
	
	@RequestMapping("index")
	public String index(Model model) {
		model.addAttribute("item", new HoaDon());
		return "admin/order/index";
	}
	
	@ModelAttribute("items")
	public List<HoaDon> getOrderList() {
		return hoaDonService.list();
	}
	
	@RequestMapping("edit/{ma}")
	public String edit(Model model,
			@PathVariable("ma") Integer ma) {
		HoaDon order = hoaDonService.get(ma);
		model.addAttribute("item", order);
		return "admin/order/index";
	}
	
	@RequestMapping("update")
	public String update(Model model,
			@ModelAttribute("item") HoaDon order) {
		try {
			hoaDonService.update(order);
			model.addAttribute("message", "Cập nhật thành công");
			return "redirect:/admin/order/edit/" + order.getMa() + ".php";
		} catch (Exception e) {
			model.addAttribute("message", "Cập nhật thất bại");
		}
		return "admin/order/index";
	}
	
	@RequestMapping("delete")
	public String delete(Model model,
			@ModelAttribute("item") HoaDon order) {
		try {
			hoaDonService.delete(order);
			model.addAttribute("message", "Xóa thành công");
			return "redirect:/admin/order/index.php";
		} catch (Exception e) {
			model.addAttribute("message", "Xóa thất bại");
		}
		return "admin/order/index";
	}
}	
