package mobileshop.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import mobileshop.entity.Hang;
import mobileshop.entity.SanPham;
import mobileshop.service.HangService;
import mobileshop.service.SanPhamService;

@Controller
@RequestMapping("product")
public class SanPhamController {
	@Autowired
	HangService hangService;
	@Autowired
	SanPhamService sanPhamService;
	
	@RequestMapping("list-by-hang/{ma}")
	public String listByHang(ModelMap model, 
			@PathVariable("ma") String ma) {
		Hang hang = hangService.get(ma);
		model.addAttribute("sanphams",hang.getSanPhams());
		return "user/product/list";
	}
	
	@ResponseBody
	@RequestMapping("detail/{ma}")
	public SanPham detail(@PathVariable("ma") Integer ma, ModelMap model) {
		SanPham sanPham = sanPhamService.get(ma);
		//model.addAttribute("sanpham", sanPham);
		
//		List<SanPhamMau> sanPhamMau = (List<SanPhamMau>) sanPhamService.get(ma).getSanPhamMaus();
//		model.addAttribute("sanphammau", sanPhamMau);
		
//		Hang hang = hangService.get(sanPham.getHang().getMa());
//		model.addAttribute("sameHangItems", hang.getSanPhams());
		
		return sanPham;
	}
	
	@RequestMapping("search")
	public String search(@RequestParam("Keywords") String keywords, ModelMap model) {
		List<SanPham> sanPhams = sanPhamService.search(keywords);
		model.addAttribute("sanphams", sanPhams);
		return "user/product/list";
	}
}
