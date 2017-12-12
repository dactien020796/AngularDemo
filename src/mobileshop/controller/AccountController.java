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
	
	@ResponseBody
	@RequestMapping(value="register", method=RequestMethod.POST)
	public String register(ModelMap model,
			@RequestParam("username") String username,
			@RequestParam("hoten") String hoten,
			@RequestParam("matkhau") String matkhau,
			@RequestParam("email") String email,
		
			HttpServletRequest request) {
		try {
				KhachHang user = new KhachHang();
				user.setMa(username);
				user.setHoTen(hoten);
				user.setMatKhau(matkhau);
				user.setEmail(email);
				
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
				//model.addAttribute("message", "Gửi mail thành công, vui lòng kiểm tra email để kích hoạt tài khoản");
				return "Gui mail thanh cong, vui";
			} catch (Exception e) {
				// TODO: handle exception
				//model.addAttribute("message", "Không gửi được mail");
				return "Khong gui duoc mail";
			}
			
		
		} 
		catch (Exception e) {
			// TODO: handle exception
			//model.addAttribute("message", "Đăng ký thất bại");
			return "Dang ki that bai";
		}
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
	
	@ResponseBody
	@RequestMapping("edit")
	public KhachHang edit(ModelMap model , HttpSession httpSession) {
		KhachHang user = (KhachHang) httpSession.getAttribute("user");
		return user;
	}
	
	@ResponseBody
	@RequestMapping(value="edit", method=RequestMethod.POST)
	public String edit(ModelMap model, 
			HttpSession httpSession,
			@RequestParam("hoTen") String hoTen,
			@RequestParam("email") String email
			) {
		KhachHang user = (KhachHang) httpSession.getAttribute("user");
		user.setHoTen(hoTen);
		user.setEmail(email);
		try {
			khachHangService.update(user);
			httpSession.setAttribute("user", user);
			return "Cap nhat thanh cong";
		} catch (Exception e) {
			// TODO: handle exception
			return "Cap nhat that bai";
		}
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
	
	@ResponseBody
	@RequestMapping(value="change", method=RequestMethod.POST)
	public String change(ModelMap model,
			@RequestParam("password") String password,
			@RequestParam("password1") String password1,
			@RequestParam("password2") String password2,
			HttpSession httpSession) {
		if (password1.equals(password2)) {
			KhachHang user = (KhachHang) httpSession.getAttribute("user");
			if (password.equals(user.getMatKhau())) {
				user.setMatKhau(password1);
				khachHangService.update(user);
				
				httpSession.setAttribute("user", user);
				return "Cap nhat mat khau thanh cong";
			}
			else {
				return "Sai mat khau hien tai";
			}
		}
		else {
			return "Xac nhan mat khau khong chinh xac";
		}
	}
}
