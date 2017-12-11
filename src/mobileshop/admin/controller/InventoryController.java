package mobileshop.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import mobileshop.service.SanPhamService;

@Controller
@RequestMapping("admin/inventory")
public class InventoryController {
	@Autowired
	SanPhamService sanPhamService;
	
	@RequestMapping("byhang")
	public String byHang(ModelMap model) {
		List<Object[]> list = sanPhamService.inventoryByHang();
		model.addAttribute("items",list);
		return "admin/inventory/by-hang";
	}

}
