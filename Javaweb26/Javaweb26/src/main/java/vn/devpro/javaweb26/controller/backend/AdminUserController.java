package vn.devpro.javaweb26.controller.backend;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.devpro.javaweb26.controller.BaseController;
import vn.devpro.javaweb26.model.Role;
import vn.devpro.javaweb26.model.User;
import vn.devpro.javaweb26.service.RoleService;
import vn.devpro.javaweb26.service.UserService;

@Controller
public class AdminUserController extends BaseController {
	
	//SỬ dụng sẻvide để thao tác dữ liệu với database(tbl_user)
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	//-------------user list ---------------
	@RequestMapping(value = "/admin/user-list", method = RequestMethod.GET)
	public String userList(final Model model)throws IOException{
		//Lấy danh sách user từ tbl_user trong database
		List<User> users = userService.finalAllActive();
		model.addAttribute("users",users);
		return  "backend/user-list";
	}
	//-----------------add --------
	
	@RequestMapping(value = "/admin/user-add", method = RequestMethod.GET)
	public String userAdd(final Model model)throws IOException{
		//Lấy danh sách user từ tbl_user trong database
		List<User> users = userService.findAll();
		model.addAttribute("users",users);
		
		List<Role> roles = roleService.findAll();
		model.addAttribute("roles", roles);
		
		User user = new User();
		model.addAttribute("user", user);
		user.setCreateDate(new Date());
		
		return  "backend/user-add";
	}
	
	
	//Save user to database
	@RequestMapping(value = "/admin/user-add-save", method = RequestMethod.POST)
	public String userAddSave(final Model model,
			final HttpServletRequest request,
			@ModelAttribute("user") User user)throws IOException{
		   
		if(!StringUtils.isEmpty(request.getParameter("role"))) {
			int roleId = Integer.parseInt(request.getParameter("role"));
			//lấy role từ tbl_role trong DB
			Role role = roleService.getById(roleId);
			//Lưu user_id và role_id vào tbl_user_role
			user.addRelationalUserRole(role);
			
			//Mã hoá password 
			user.setPassword(new BCryptPasswordEncoder(4).encode(user.getPassword()));
			
			//Lưu user vào bảng tbl_user
			userService.saveOrUpdate(user);
		}
		//Không chọn role thì không lưu user
		return  "backend/user-add";
	}
	
	//-----------------edit user --------
	
	@RequestMapping(value = "/admin/user-edit/{userId}", method = RequestMethod.GET)
	public String userEdit(final Model model,
			@PathVariable("userId") int userId //Lấy user id kho click Edit
			)throws IOException{
		
		
		//Lấy user từ tbl_user trong database
		User user = userService.getById(userId);
		model.addAttribute("user",user);
		
		List<User> users = userService.findAll();
		model.addAttribute("users",users);
		
		return  "backend/user-edit";
	}
	
	
	//Save user to database
		@RequestMapping(value = "/admin/user-edit-save", method = RequestMethod.POST)
		public String userEditSave(final Model model,
				final HttpServletRequest request,
				@ModelAttribute("user") User user)throws IOException{
			   
			userService.saveOrUpdate(user);
			return  "redirect:/admin/user-list";
		}
		
	
	
		//-----------------delete user --------
		
//		@RequestMapping(value = "/admin/user-delete/{userId}", method = RequestMethod.GET)
//		public String userDelete(final Model model,
//				@PathVariable("userId") int userId //Lấy user id kho click Edit
//				)throws IOException{
//			
//			userService.deleteById(userId);
//			
//			return  "redirect:/admin/user-list";
//		}
		
		
		
		@RequestMapping(value = "/admin/user-delete/{userId}", method = RequestMethod.GET)
		public String userDelete(final Model model,
				@PathVariable("userId") int userId //Lấy user id kho click Edit
				)throws IOException{
			
			User user = userService.getById(userId);
			user.setStatus(Boolean.FALSE);
			
			
			userService.saveOrUpdate(user);
			
			return  "redirect:/admin/user-list";
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
