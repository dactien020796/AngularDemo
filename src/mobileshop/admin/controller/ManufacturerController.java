package mobileshop.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import mobileshop.entity.Hang;
import mobileshop.service.HangService;

@Controller
@RequestMapping("admin/manufacturer")
public class ManufacturerController {
	@Autowired
	HangService hangService;
	
	@RequestMapping("index")
	public String index(Model model) {
		model.addAttribute("item", new Hang());
		return "admin/manufacturer/index";
	}
	
	@ModelAttribute("items")
	public List<Hang> getManufacturer() {
		return hangService.list();
	}
	
	@RequestMapping("insert")
	public String insert(Model model,
			@ModelAttribute("item") Hang hang) {
		try {
			hangService.insert(hang);
			model.addAttribute("message", "Thêm thành công");
			return "redirect:/admin/manufacturer/index.php";
		} catch (Exception e) {
			model.addAttribute("message", "Thêm thất bại");
		}
		return "admin/manufacturer/index";
	}
	
	@RequestMapping("edit/{ma}")
	public String edit(Model model,
			@PathVariable("ma") String ma) {
		Hang hang = hangService.get(ma);
		model.addAttribute("item", hang);
		return "admin/manufacturer/index";
	}
	
	@RequestMapping("update")
	public String update(Model model,
			@ModelAttribute("item") Hang hang) {
		try {
			hangService.update(hang);
			model.addAttribute("message", "Cập nhật thành công");
			return "redirect:/admin/manufacturer/index.php";
		} catch (Exception e) {
			model.addAttribute("message", "Cập nhật thất bại");
		}
		return "admin/manufacturer/index";
	}
	
	@RequestMapping("delete")
	public String delete(Model model,
			@ModelAttribute("item") Hang hang) {
		try {
			hangService.delete(hang);
			model.addAttribute("message", "Xóa thành công");
			return "redirect:/admin/manufacturer/index.php";
		} catch (Exception e) {
			model.addAttribute("message", "Xóa thất bại");
		}
		return "admin/manufacturer/index";
	}
}
