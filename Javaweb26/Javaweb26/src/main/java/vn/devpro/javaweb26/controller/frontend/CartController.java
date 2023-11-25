package vn.devpro.javaweb26.controller.frontend;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.devpro.javaweb26.controller.BaseController;
import vn.devpro.javaweb26.dto.Cart;
import vn.devpro.javaweb26.dto.CartProduct;
import vn.devpro.javaweb26.dto.Jw26Constants;
import vn.devpro.javaweb26.model.Product;
import vn.devpro.javaweb26.model.User;
import vn.devpro.javaweb26.service.ProductService;

@Controller
public class CartController extends BaseController implements Jw26Constants {

	
	@Autowired 
	private ProductService productService;
	
	@RequestMapping(value = "/add-to-cart" ,method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> addToCart(
		final Model model,
		final HttpServletRequest request,
		final HttpServletResponse response,
		@RequestBody CartProduct addedProduct) throws IOException{
			
			//Lấy session
			HttpSession session = request.getSession();
			
			Cart cart = null;
			//Kiểm tra xem có gio chưa (cart)
			if (session.getAttribute("cart") == null) {//Chưa có giỏ hàng 
				cart = new Cart();
				session.setAttribute("cart", cart);
			}else {//Đã có giỏ hàng 
				cart = (Cart) session.getAttribute("cart");
			}
			
			//Thêm giỏ hàng 
			//+ Lấy product trong DB
			Product dbProduct = productService.getById(addedProduct.getProductId());
			//+ Tạo mới cart's product: 2 trường hợp
			int index = cart.findProductById(dbProduct.getId());
			if (index != -1) {//TH1 : Sản phẩm đã có trong giỏ -> Tăng quantity
				cart.getCartProducts().get(index).setQuantity(
						cart.getCartProducts().get(index).getQuantity()+
						addedProduct.getQuantity());
			}else {//Th2: Sản phẩm chưa có trong giỏ -> thêm mới 
				addedProduct.setAvatar(dbProduct.getAvatar());
				addedProduct.setProductName(dbProduct.getName());
				addedProduct.setPrice(dbProduct.getPrice());
				
				cart.getCartProducts().add(addedProduct);
			}
			
			//Thiết lập biến sesion cho cảt
			//Trả về tổng số sản phẩm 
			model.addAttribute("totalCartProducts", cart.totalCartProducts());
			
			Map<String, Object> jsonResult = new HashMap<String, Object>();
			jsonResult.put("code", 404);
			jsonResult.put("message", "Đã thêm sản phẩm '" + dbProduct.getName() + "' vào giỏ hàng");
			jsonResult.put("totalCartProducts", cart.totalCartProducts());
			return ResponseEntity.ok(jsonResult);
			
		}
		
	@RequestMapping(value= "/cart-view", method = RequestMethod.GET)
	public String cartViews(
			final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response) throws IOException{
		
		//Lấy giỏ hàng 
		HttpSession session = request.getSession();
		Cart cart = null;
		String message = null;
		
		if (session.getAttribute("cart") != null) {
			cart = (Cart)session.getAttribute("cart");
			message = "Có tổng cộng" + cart.totalCartProducts()+ " trong giỏ hàng";
			model.addAttribute("totalCartPrice", cart.totalCartPrice());
		}else {
			message = "Không có sản phẩm nào trong giỏ hàng ";
		}
		model.addAttribute("message",message);
		
		if(isLogined()){
			model.addAttribute("user", getLoginedUser());
		}else {
			model.addAttribute("user", new User());
		}
		
		
		return "frontend/cart-view"; 
		
	}
	@RequestMapping(value = "/product-cart-delete/{productId}", method = RequestMethod.GET)
	public String productCartDelete(final Model model,
			final HttpServletRequest request,
	        @PathVariable("productId") int productId
			) throws IOException{
		HttpSession session = request.getSession();
		Cart cart =(Cart)session.getAttribute("cart");
		
		int index = cart.findProductById(productId);
		if (index != -1) {
			cart.getCartProducts().remove(index);
		}
		if(cart.totalCartProducts() == 0) {
			cart = null;
		}
		session.setAttribute("cart", cart);
		
	   return "redirect:/cart-view";
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
