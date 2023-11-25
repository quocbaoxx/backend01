package vn.devpro.javaweb26.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.devpro.javaweb26.model.Role;
import vn.devpro.javaweb26.model.User;
import vn.devpro.javaweb26.service.RoleService;
import vn.devpro.javaweb26.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String homePage(final Model model, final HttpServletRequest request,
			final HttpServletResponse response) throws IOException {
		return "login";
	}


	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signAccount(final Model model, final HttpServletRequest request,
			final HttpServletResponse response) throws IOException {
		
		return "signup";
	}
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(final Model model, final HttpServletRequest request,
			final HttpServletResponse response) throws IOException {
		
		User user = new User();
		user.setUsername(request.getParameter("username"));
		user.setPassword(new BCryptPasswordEncoder(4).encode(request.getParameter("password")));
		user.setEmail(request.getParameter("email"));
		user.setMobile(request.getParameter("mobile"));
		
//		Set role cho user moi - mac dinh role la 'CUSTOMER'
//		+ Lay role co name la 'customer' trong DB
		Role role = roleService.getRoleByName("CUSTOMER");
		user.addRelationalUserRole(role);
		
		userService.saveOrUpdate(user);
		
		return "redirect:/login";
	}
}
