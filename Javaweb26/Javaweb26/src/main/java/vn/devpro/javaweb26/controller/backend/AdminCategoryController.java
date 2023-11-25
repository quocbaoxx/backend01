package vn.devpro.javaweb26.controller.backend;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import vn.devpro.javaweb26.controller.BaseController;
import vn.devpro.javaweb26.model.Category;
import vn.devpro.javaweb26.model.User;
import vn.devpro.javaweb26.service.CategoryService;
import vn.devpro.javaweb26.service.UserService;

@Controller
public class AdminCategoryController extends BaseController {
	
	@Autowired
	private  CategoryService categoryService;
	
	@Autowired
	private UserService userService;
	
	//-----------Category list------------
	@RequestMapping(value = "/admin/category-list",method = RequestMethod.GET)
	public String categoryList(
			final Model model
			)throws IOException{
		List<Category> categorys = categoryService.findAllActive();
		model.addAttribute("categorys", categorys);
		return "backend/category-list";
	}
	
	//---------Category-add---------
	@RequestMapping(value = "/admin/category-add" , method = RequestMethod.GET)
	public String  categoryAddSave(
			final Model model)throws IOException{
		List<User> users = userService.findAll();
		model.addAttribute("users",users);
		
		List<Category> categorys = categoryService.findAll();
		model.addAttribute("categorys", categorys);
		
		Category category = new Category();
		model.addAttribute("category", category);
		category.setCreateDate(new Date());
		
		return "backend/category-add";
	}
	
//	Save category vào dataBase
	@RequestMapping(value = "/admin/category-add-save", method = RequestMethod.POST)
	public String categoryAddSave(final Model model,
			final HttpServletRequest request,
			@ModelAttribute("category") Category category)throws IOException{
			
			categoryService.saveOrUpdate(category);
			
		return "redirect:/admin/category-add";
	}
	
	@RequestMapping(value = "/admin/category-edit/{categoryId}", method = RequestMethod.GET)
	public String categoryEdit(final Model model,
			@PathVariable("categoryId") int categoryId //Lấy user id kho click Edit
			)throws IOException{
		List<User> users = userService.findAll();
		model.addAttribute("users",users);
		
		Category category = categoryService.getById(categoryId);
		model.addAttribute("category",category);
		
		List<Category> categories = categoryService.findAll();
		model.addAttribute("categories",categories);
		
		return  "backend/category-edit";
	}
	
	
	//Save user to database
		@RequestMapping(value = "/admin/category-edit-save", method = RequestMethod.POST)
		public String categoryEditSave(final Model model,
				final HttpServletRequest request,
				@ModelAttribute("category") Category category)throws IOException{
			   
			categoryService.saveOrUpdate(category);
			return  "redirect:/admin/category-list";
		}
	
	
		@RequestMapping(value = "/admin/category-delete/{categoryId}", method = RequestMethod.GET)
		public String userDelete(final Model model,
				@PathVariable("categoryId") int categoryId //Lấy user id kho click Edit
				)throws IOException{
			
			Category category = categoryService.getById(categoryId);
			category.setStatus(Boolean.FALSE);
			
			
			categoryService.saveOrUpdate(category);
			
			return  "redirect:/admin/category-list";
		}
		
		
	
	
	
	
}
