package mobileshop.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@ResponseBody
	@RequestMapping("items")
	public List<Hang> getManufacturer() {
		return hangService.list();
	}
	
	@ResponseBody
	@RequestMapping("insert")
	public String insert(Model model,
			@RequestParam("ma") String ma,
			@RequestParam("tenHang") String tenHang) {
		Hang hang = new Hang();
		hang.setMa(ma);
		hang.setTen(tenHang);
		try {
			hangService.insert(hang);
			return "Them thanh cong";
		} catch (Exception e) {
			
			return "Them that bai";
		}
		
	}
	
	@ResponseBody
	@RequestMapping("edit")
	public Hang edit(Model model,
			@RequestParam("ma") String ma) {
		Hang hang = hangService.get(ma);
		return hang;
	}
	
	@ResponseBody
	@RequestMapping("update")
	public String update(Model model,
			@RequestParam("ma") String ma,
			@RequestParam("tenHang") String tenHang) {
		Hang hang = hangService.get(ma);
		hang.setTen(tenHang);
		try {
			hangService.update(hang);
			return "Sua thanh cong";
		} catch (Exception e) {
			return "Sua that bai";
		}
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
