package mobileshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import mobileshop.entity.Hang;
import mobileshop.entity.SanPham;
import mobileshop.service.HangService;
import mobileshop.service.SanPhamService;

@Controller
@RequestMapping("home")
public class HomeController {
	@Autowired
	HangService hangService;
	@Autowired
	SanPhamService sanPhamService;
	
	@ResponseBody
	@RequestMapping("index")
	public List<SanPham> index(ModelMap model) {
//		List<Hang> hangs = hangService.list();
//		model.addAttribute("hangs",hangs);
//		
//		List<SanPham> dacbiets = sanPhamService.get5SanPhamDacBiet();
//		model.addAttribute("dacbiets",dacbiets);
		
		List<SanPham> moinhats = sanPhamService.get5SanPhamMoiNhat();
		//model.addAttribute("moinhats",moinhats);
		
		//String temp = new Gson().toJson(moinhats);
		return moinhats;
		//return "home/index";
	}
	
	@RequestMapping("about")
	public String about() {
		return "user/home/about";
	}
	
	@RequestMapping("contact")
	public String contact() {
		return "user/home/contact";
	}
	
	@RequestMapping("faq")
	public String faq() {
		return "user/home/faq";
	}
}
