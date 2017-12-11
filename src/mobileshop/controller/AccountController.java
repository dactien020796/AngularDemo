package mobileshop.controller;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import mobileshop.entity.KhachHang;
import mobileshop.service.KhachHangService;
import mobileshop.service.MailerService;

@Controller
@RequestMapping("account")
public class AccountController {
	@Autowired
	KhachHangService khachHangService;
	
	// Gửi mail
	@Autowired
	MailerService mailerService;

	// Dùng để lấy đường dẫn từ web (upload ảnh)
	@Autowired
	ServletContext app;
	
	@RequestMapping("register")
	public String register(ModelMap model) {
		model.addAttribute("user", new KhachHang());
		return "user/account/login-register";
	}
	
	@RequestMapping(value="register", method=RequestMethod.POST)
	public String register(ModelMap model,
			@ModelAttribute("user") KhachHang user,
			HttpServletRequest request,
			@RequestParam("uphinhAnh") MultipartFile photo) {
		try {
			//xử lý upload photo
			//nếu photo có dữ liệu thì upload
			System.out.println("Test");
			if (!photo.isEmpty()) {
				String fileName = System.currentTimeMillis() + "-" + photo.getOriginalFilename();
				user.setHinhAnh(fileName);
				
				//Lưu ảnh vào thư mục
				String path = app.getRealPath("/images/customers/" + user.getHinhAnh());
				photo.transferTo(new File(path));
			}
			//nếu ko upload photo thì set hình mặc định
			else {
				user.setHinhAnh("user.png");
			}
			
			user.setTrangThai(false);
			khachHangService.insert(user);
			model.addAttribute("message", "Đăng ký thành công");
			
			/**
			 * Gửi mail kích hoạt tài khoản
			 * */
			
			try {
				String url = request.getRequestURL().toString().replace("register", "activate/" + user.getMa());
				String to = user.getEmail();
				String subject = "Welcome to Smart Store";
				String body = "Click vào đây liên kết sau đây để kích hoạt tài khoản<hr>" +
						"<a href='"+url+"'>Kích hoạt tài khoản</a>";
				mailerService.send(to, subject, body);
				model.addAttribute("message", "Gửi mail thành công, vui lòng kiểm tra email để kích hoạt tài khoản");
			} catch (Exception e) {
				// TODO: handle exception
				model.addAttribute("message", "Không gửi được mail");
			}
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("message", "Đăng ký thất bại");
		}
		return "user/account/login-register";
	}
	
	/**
	 * Kích hoạt tài khoản
	 * */
	@RequestMapping("activate/{id}")
	public String activate(@PathVariable("id") String id) {
		KhachHang user = khachHangService.get(id);
		user.setTrangThai(true);
		khachHangService.update(user);
		return "redirect:/home/index.php";
	}
	
	/**
	 * Đăng nhập
	 * */
	@RequestMapping("login")
	public String login() {
		return "user/account/login-register";
	}
	
	@ResponseBody
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String login(ModelMap model,
			@RequestParam("id") String id,
			@RequestParam("password") String password,
			HttpSession httpSession,
			HttpServletResponse response) {
		model.addAttribute("user", new KhachHang());
		try {
			KhachHang user = khachHangService.get(id);
			if (user.getTrangThai() == false) {
				//model.addAttribute("message_dangNhap", "Tài khoản chưa được kích hoạt");
				return "Tai khoan chua duoc kich hoat";
			}
			else if (user.getMatKhau().equals(password)) {
				httpSession.setAttribute("user", user);
				//model.addAttribute("message_dangNhap", "Đăng nhập thành công");
				return "Dang nhap thanh cong";
			}
			else {
				//model.addAttribute("message_dangNhap", "Sai mật khẩu");
				return "Sai mat khau";
			}
		} catch (Exception e) {
			// TODO: handle exception
			//model.addAttribute("message_dangNhap", "Sai tên đăng nhập");
			return "Sai ten dang nhap";
		}
		//return "user/account/login-register";
	}
	
	/**
	 * Đăng xuất
	 * */
	@ResponseBody
	@RequestMapping("logoff")
	public String logoff(HttpSession httpSession) {
		httpSession.removeAttribute("user");
		//Redirect to action
		return "logoff";
	}
	
	@RequestMapping("edit")
	public String edit(ModelMap model , HttpSession httpSession) {
		KhachHang user = (KhachHang) httpSession.getAttribute("user");
		model.addAttribute("user", user);
		return "user/account/edit";
	}
	
	@RequestMapping(value="edit", method=RequestMethod.POST)
	public String edit(ModelMap model, 
			HttpSession httpSession,
			@ModelAttribute("user") KhachHang user,
			@RequestParam("uphinhAnh") MultipartFile photo) {
		try {
			if (!photo.isEmpty()) {
				//Xóa file hình ảnh cũ => tránh nặng server
				String path = app.getRealPath("/images/customers/" + user.getHinhAnh());
				File oldFile = new File(path);
				oldFile.delete();
				
				String filename = System.currentTimeMillis() + "-" + photo.getOriginalFilename();
				user.setHinhAnh(filename);
				path = app.getRealPath("/images/customers/" + user.getHinhAnh());
				photo.transferTo(new File(path));
				//System.out.println(path);
			}
			khachHangService.update(user);
			model.addAttribute("message", "Cập nhật thành công");
			httpSession.setAttribute("user", user);
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("message", "Cập nhật thất bại");
		}
		return "user/account/edit";
	}
	
	/**
	 * Quên mật khẩu
	 * */
	@RequestMapping("forgot")
	public String forgot() {
		return "user/account/forgot";
	}
	
	@RequestMapping(value="forgot", method=RequestMethod.POST)
	public String forgot(ModelMap model,
			@RequestParam("ma") String id,
			@RequestParam("email") String email) {
		try {
			KhachHang user = khachHangService.get(id);
			if (email.equals(user.getEmail())) {
				//Gửi mail mật khẩu
				try {
					mailerService.send(email, "Forgot Password", user.getMatKhau());
					model.addAttribute("message", "Mật khẩu của bạn đã được gửi qua email");
				} catch (Exception e) {
					// TODO: handle exception
					model.addAttribute("message", "Không gửi được email");
				}
			}
			else {
				model.addAttribute("message", "Sai email đăng ký");
			}
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("message", "Sai tên đăng nhập");
		}
		return "user/account/forgot";
	}
	
	/**
	 * Đổi mật khẩu
	 * */
	@RequestMapping("change")
	public String change() {
		return "user/account/change";
	}
	
	@RequestMapping(value="change", method=RequestMethod.POST)
	public String change(ModelMap model,
			@RequestParam("ma") String id,
			@RequestParam("matKhau") String password,
			@RequestParam("password1") String password1,
			@RequestParam("password2") String password2,
			HttpSession httpSession) {
		if (password1.equals(password2)) {
			try {
				KhachHang user = khachHangService.get(id);
				if (password.equals(user.getMatKhau())) {
					user.setMatKhau(password1);
					khachHangService.update(user);
					
					model.addAttribute("message", "Đổi mật khẩu thành công");
					httpSession.setAttribute("user", user);
				}
				else {
					model.addAttribute("message", "Sai mật khẩu");
				}
			} catch (Exception e) {
				// TODO: handle exception
				model.addAttribute("message", "Sai tên đăng nhập");
			}
		}
		else {
			model.addAttribute("message", "Xác nhận mật khẩu không đúng");
		}
		return "user/account/change";
	}
}
