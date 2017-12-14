package mobileshop.admin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mobileshop.entity.Admin;
import mobileshop.service.AdminService;

@Controller
@RequestMapping("admin/home")
public class AdminHomeController {
	@Autowired
	AdminService adminService;
	
	@RequestMapping("index")
	public String index() {
		return "admin/home/index";
	}
	
//	@RequestMapping("login")
//	public String login(@RequestParam(value="out", defaultValue="false") Boolean out,
//			HttpSession httpSession) {
//		if (out == true) {
//			httpSession.removeAttribute("master");
//		}
//		return "admin/login/login";
//	}
	
	@RequestMapping("login")
	public String login2() {
		return "admin/login/login";
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String login(@RequestParam("id") String id,
			@RequestParam("pw") String pw,
			Model model,
			HttpSession httpSession) {
		try {
			Admin master = adminService.get(id);
			if (master.getMatKhau().equals(pw)) {
				httpSession.setAttribute("master", master);
				model.addAttribute("mess", "Đăng nhập thành công");
				
				String requestUrl = (String) httpSession.getAttribute("RequestUrl");
				if (requestUrl != null) {
					return "redirect:" + requestUrl;
				}
				return "redirect:/admin/home/index.php";
			}
			else {
				model.addAttribute("mess", "Sai mật khẩu");
			}
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("mess", "Sai tên đăng nhập");
		}
		return "admin/login/login";
	}
}
