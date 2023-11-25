package vn.devpro.javaweb26.controller.backend;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import vn.devpro.javaweb26.controller.BaseController;
import vn.devpro.javaweb26.dto.Jw26Constants;
import vn.devpro.javaweb26.dto.SearchModel;
import vn.devpro.javaweb26.model.Category;
import vn.devpro.javaweb26.model.Product;
import vn.devpro.javaweb26.model.User;
import vn.devpro.javaweb26.service.CategoryService;
import vn.devpro.javaweb26.service.ProductService;
import vn.devpro.javaweb26.service.UserService;

@Controller
public class AdminProductCotroller  extends BaseController implements Jw26Constants{
	
	@Autowired
	private ProductService productService;
	
	@Autowired 
	private CategoryService categoryService;
	
	@Autowired 
	private UserService userService;
	
	//------------ list ---------------
		@RequestMapping(value = "/admin/product-list", method = RequestMethod.GET)
		public String productList(final Model model,
				final HttpServletRequest request
				)throws IOException{
			//Lấy danh sách user từ tbl_user trong database
			List<Category> categories = categoryService.findAll();
			model.addAttribute("categories",categories);
//			List<Product> products = productService.findAll();
			
			SearchModel productSearch = new SearchModel();
			
			
			
//			TÌM VỚI TIUEE CHÍ STATUS
			productSearch.setStatus(2);//Không chọn all
			if(!StringUtils.isEmpty(request.getParameter("status"))) {// có chọn
				productSearch.setStatus(Integer.parseInt(request.getParameter("status")));
			}
			
//			Tìm với tiêu chí category
			productSearch.setCategoryId(0);//Không chọn category(all)
			if(!StringUtils.isEmpty(request.getParameter("categoryId"))) {// có chọn
				productSearch.setCategoryId(Integer.parseInt(request.getParameter("categoryId")));
			}
			
			
//			Tìm kiếm với  tiêu chí keyword
			productSearch.setKeyword(request.getParameter("keyword"));
			
			
//			Tìm với tiêu chí from date to date 
			productSearch.setBeginDate(request.getParameter("beginDate"));
			productSearch.setEndDate(request.getParameter("endDate"));
			
//			bắt đầu pân trang 
			
			if (!StringUtils.isEmpty(request.getParameter("page"))) {//bấm nút chuyển trang 
				productSearch.setCurrentPage(Integer.parseInt(request.getParameter("page")));
			}else {
                productSearch.setCurrentPage(1);//lần đầu truy cập luôn hiển thị trang 1 
			}
			
			List<Product> allProducts = productService.searchProduct(productSearch);
			
			List<Product> products = new ArrayList<Product>();
			
			//nếu tổng số trang nhỏ hơn trang hiện tại
			int totalPages = allProducts.size() / SIZE_OF_PAGE;
			if (allProducts.size()  % SIZE_OF_PAGE > 0) {
				totalPages ++;
			}
			if(totalPages < productSearch.getCurrentPage()) {
				productSearch.setCurrentPage(1);
			}
			
			int firstIndex = (productSearch.getCurrentPage()-1)* SIZE_OF_PAGE;
			int index = firstIndex, count = 0;
			while(index < allProducts.size() && count < SIZE_OF_PAGE) {
				products.add(allProducts.get(index));
				index ++;
				count ++;
			}
			
			productSearch.setSizeOfPage(SIZE_OF_PAGE);//số bản ghi trên một trang 
			productSearch.setTotalItems(allProducts.size());//Tổng số sản phẩm 
			

			model.addAttribute("products",products);
			model.addAttribute("productSearch",productSearch);
			return  "backend/product-list";
		}
	
		//-----------------add --------
		
		@RequestMapping(value = "/admin/product-add", method = RequestMethod.GET)
		public String productAdd(final Model model)throws IOException{
			//Lấy danh sách product từ tbl_product trong database
			List<User> users = userService.findAll();
			model.addAttribute("users",users);
			
			List<Category> categories = categoryService.findAll();
			model.addAttribute("categories", categories);
			
			Product product = new Product();
			model.addAttribute("product", product);
			product.setCreateDate(new Date());
			product.setUpdateDate(new Date());
			
			return  "backend/product-add";
		}
		//Save to database
		@RequestMapping(value = "/admin/product-add-save", method = RequestMethod.POST)
		public String productAddSave(final Model model,
				final HttpServletRequest request,
				@RequestParam("avatarFile") MultipartFile avatarFile,
				@RequestParam("imageFiles") MultipartFile[] imageFiles,
				@ModelAttribute("product") Product product
				)throws IOException{

			productService.saveAddProduct(product,avatarFile, imageFiles );
			
			
			return  "backend/product-add";
		}
		@RequestMapping(value = "/admin/product-edit/{productId}", method = RequestMethod.GET)
		public String productEdit(final Model model,
				@PathVariable("productId") int productId 
				)throws IOException{
			List<User> users = userService.findAll();
			model.addAttribute("users",users);
			
			List<Category> categories = categoryService.findAll();
			model.addAttribute("categories", categories);
			
			//lấy product trpmg DB
			Product product = productService.getById(productId);
			product.setCreateDate(new Date());
			model.addAttribute("product", product);
			
			return  "backend/product-edit";
		}
		
//      ------------------deleteProduct----------------------
//		@RequestMapping(value = "/admin/product-delete/{productId}", method = RequestMethod.GET)
//		public String productDelete(final Model model,
//				@PathVariable("productId") int productId //Lấy user id kho click Edit
//				)throws IOException{
//			
//			
//			productService.deleteProductById(productId);
//			
//			
//			return  "redirect:/admin/product-list";
//		}
		
//		------------Inactive Product -------------------------
		@RequestMapping(value = "/admin/product-delete/{productId}", method = RequestMethod.GET)
		public String userDelete(final Model model,
				@PathVariable("productId") int productId //Lấy user id kho click Edit
				)throws IOException{
			
			Product product = productService.getById(productId);
			product.setStatus(Boolean.FALSE);
			
			
			productService.saveOrUpdate(product);
			
			return  "redirect:/admin/product-list";
		}
		
		
		//Save product to database
			@RequestMapping(value = "/admin/product-edit-save", method = RequestMethod.POST)
			public String productEditSave(final Model model,
					@RequestParam("avatarFile") MultipartFile avatarFile,
					@RequestParam("imageFiles") MultipartFile[] imageFiles,
					@ModelAttribute("product") Product product)throws IOException{
				   
				productService.saveEditProduct(product , avatarFile,imageFiles);
				return  "redirect:/admin/product-list";
			}
		
			
			
		
		
		
		
		
		
}
