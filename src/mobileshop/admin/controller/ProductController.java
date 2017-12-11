package mobileshop.admin.controller;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import mobileshop.entity.Hang;
import mobileshop.entity.SanPham;
import mobileshop.service.HangService;
import mobileshop.service.SanPhamService;

@Controller
@RequestMapping("admin/product")
public class ProductController {
	@Autowired
	SanPhamService sanPhamService;
	@Autowired
	HangService hangService;
	@Autowired
	ServletContext app;

	@RequestMapping("index")
	public String index(Model model) {
		model.addAttribute("item", new SanPham());
		return "admin/product/index";
	}

	@ModelAttribute("items")
	public List<SanPham> getProductList() {
		return sanPhamService.list();
	}

	@ModelAttribute("sitems")
	public List<Hang> getManufacturer() {
		return hangService.list();
	}

	@RequestMapping("insert")
	public String insert(Model model, @ModelAttribute("item") SanPham product,
			@RequestParam("uphinhAnh") MultipartFile uphinhAnh) {
		try {
			// Kiểm tra xem ngta có upload hình ko
			if (uphinhAnh.isEmpty()) {
				product.setHinhAnh("product.png");
			} else {
				// gán tên hình vào thuộc tinh
				product.setHinhAnh(uphinhAnh.getOriginalFilename());

				// Lưu file hình vào thư mục
				String path = app.getRealPath("/images/products/" + product.getHinhAnh());
				uphinhAnh.transferTo(new File(path));
			}
			sanPhamService.insert(product);
			model.addAttribute("message", "Thêm thành công");
			return "redirect:/admin/product/index.php";
		} catch (Exception e) {
			model.addAttribute("message", "Thêm thất bại");
		}
		return "admin/product/index";
	}

	@RequestMapping("edit/{ma}")
	public String edit(Model model, @PathVariable("ma") Integer ma) {
		SanPham product = sanPhamService.get(ma);
		model.addAttribute("item", product);
		return "admin/product/index";
	}

	@RequestMapping("update")
	public String update(Model model, @ModelAttribute("item") SanPham product,
			@RequestParam("uphinhAnh") MultipartFile uphinhAnh) {
		try {
			if (!uphinhAnh.isEmpty()) {
				// gán tên hình vào thuộc tinh
				product.setHinhAnh(uphinhAnh.getOriginalFilename());

				// Lưu file hình vào thư mục
				String path = app.getRealPath("/images/products/" + product.getHinhAnh());
				uphinhAnh.transferTo(new File(path));
			}
			sanPhamService.update(product);
			model.addAttribute("message", "Cập nhật thành công");
			return "redirect:/admin/product/edit/" + product.getMa() + ".php";
		} catch (Exception e) {
			model.addAttribute("message", "Cập nhật thất bại");
		}
		return "admin/product/index";
	}

	@RequestMapping("delete")
	public String delete(Model model, @ModelAttribute("item") SanPham product) {
		try {
			sanPhamService.delete(product);
			model.addAttribute("message", "Xóa thành công");
			return "redirect:/admin/product/index.php";
		} catch (Exception e) {
			model.addAttribute("message", "Xóa thất bại");
		}
		return "admin/product/index";
	}

	// Phân trang AJAX
	@RequestMapping("loadpage")
	public String loadPage(Model model, @RequestParam(value = "pageNo", defaultValue = "0") int pageNo,
			@RequestParam(value = "pageSize", defaultValue = "6") int pageSize) {
		List<SanPham> items = sanPhamService.loadPage(pageNo, pageSize);
		model.addAttribute("items", items);
		return "blank/product/gridview";
	}

	@ResponseBody
	@RequestMapping("pagecount")
	public String getPageCount(Model model, @RequestParam(value = "pageSize", defaultValue = "6") int pageSize) {
		int rowCount = sanPhamService.list().size();
		int pageCount = (int) Math.ceil(1.0 * rowCount / pageSize);
		return String.valueOf(pageCount);
	}
}
