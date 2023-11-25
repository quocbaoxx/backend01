package vn.devpro.javaweb26.service;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import vn.devpro.javaweb26.dto.Jw26Constants;
import vn.devpro.javaweb26.dto.SearchModel;
import vn.devpro.javaweb26.model.Product;
import vn.devpro.javaweb26.model.ProductImage;

@Service
public class ProductService extends BaseService<Product>  implements Jw26Constants{

	@Override
	public Class<Product> clazz() {
		// TODO Auto-generated method stub
		return Product.class;
	}
	
    public List<Product> findAllActive() {
		
		return super.executeNativeSql("SELECT * FROM tbl_product WHERE status =1");
	}
	
	
	//Hàm kiểm tra 1 file có được upoload không 
	public boolean isUploadFile(MultipartFile file) {
		if(file == null || file.getOriginalFilename().isEmpty()) {
			return false;//Khoong upload
		}
		return true; // có upload
	}
	//Hàm kiểm tra dnah sách file có upload file nào không ?
	public boolean isUploadFiles(MultipartFile[] files) {
		if(files == null || files.length ==0) {
			return false;//Khoong upload
		}
		return true; // có upload it nhất 1 file
	}
	//-------------------- Save new product -------------------------
	@Transactional
	public Product saveAddProduct( Product product , MultipartFile avatarFile, MultipartFile[] imageFiles) throws IOException {
		//Lưu avatr  file
		if(isUploadFile(avatarFile)) {//có file upload file avatar
			//Lưu file vào thư mục Product/Avatar
			String path = FOLFER_UPLOAD + "Product/Avatar/" + avatarFile.getOriginalFilename();
			File file = new File(path);
			avatarFile.transferTo(file);
			//Lưu đường dẫn vào  bảng tbl_product
			product.setAvatar("Product/Avatar/" + avatarFile.getOriginalFilename());
		}
		//Lưu images file
		if(isUploadFiles(imageFiles)) {//Có upload danh sách ảnh
			//Duyet danh sach file images
			for(MultipartFile imageFile : imageFiles) {
				if(isUploadFile(imageFile)) {//file cos upload
					//luu file vao thu muc Product/Image
					String path = FOLFER_UPLOAD + "Product/Image/" + imageFile.getOriginalFilename();
					File file = new File(path);
					imageFile.transferTo(file);
					//Luu duong dan vao tbl_product_image
					ProductImage productImage = new ProductImage();
					productImage.setTitle(imageFile.getOriginalFilename());
					productImage.setPath("Product/Image/" + imageFile.getOriginalFilename());
					productImage.setStatus(Boolean.TRUE);
					product.addRelationalProductImage(productImage);//Lu sang bang tbl_product_image
				}
			}
		}
		return super.saveOrUpdate(product);
	}
	//-------------------- Save edit product -------------------------
		@Transactional
		public Product saveEditProduct( Product product , MultipartFile avatarFile, MultipartFile[] imageFiles) throws IOException {
			
			
			
			//Lấy product trong DB
			Product dbProduct  = super.getById(product.getId());
			
			
			
			
			//Lưu avatr  file mới nếu  người dùng có upload avatar
			if(isUploadFile(avatarFile)) {//có file upload file avatar
				
				//xoá avtar cũ 
				String path = FOLFER_UPLOAD +  dbProduct.getAvatar();
				File file = new File(path);
				file.delete();
				
				
				//Lưu file avatar mới vào thư mục Avatar
				path = FOLFER_UPLOAD + avatarFile.getOriginalFilename();
//				File file = new File(path);
				avatarFile.transferTo(file);
				//Lưu đường dẫn của avatar mới vào bảng tbl_product
				product.setAvatar("Product/Avatar/" + avatarFile.getOriginalFilename());
			}else {//người dùng không upload avatar file 
				//giữ nguyên avatar cũ
				product.setAvatar(dbProduct.getAvatar());
				
			}
			//Lưu images file
			if(isUploadFiles(imageFiles)) {//Có upload danh sách ảnh
				//Duyet danh sach file images
				for(MultipartFile imageFile : imageFiles) {
					if(isUploadFile(imageFile)) {//file cos upload
						//luu file vao thu muc Product/Image
						String path = FOLFER_UPLOAD + "Product/Avatar/" +  imageFile.getOriginalFilename();
						File file = new File(path);
						imageFile.transferTo(file);
						//Luu duong dan vao tbl_product_image
						ProductImage productImage = new ProductImage();
						productImage.setTitle(imageFile.getOriginalFilename());
						productImage.setPath("Product/Image/" + imageFile.getOriginalFilename());
						productImage.setStatus(Boolean.TRUE);
						product.setCreateDate(new Date());
						
						product.addRelationalProductImage(productImage);//Luu  sang bang tbl_product_image
					}
					
				}
			}
			return super.saveOrUpdate(product);
		}
	
	
	// -------------deleteProduct-------------------
		
		@Autowired ProductImageService productImageService;
		
		@Transactional
		public void deleteProductById(int productId) {
			//lấy product trong DB
			Product product = super.getById(productId);
			
			
			//+ Lấy dánh sách các ảnh của product trong tbl_product_image
			String sql="SELECT * FROM 	tbl_product_image where product_id = " + productId;
			List<ProductImage> productImages = productImageService.executeNativeSql(sql);
			//xoá lần lượt các ảnh của product trong prodcut/image 
			//Xoá lần lượn các đường dẫn ảnh trong tbl_product_image
		   for (ProductImage productImage : productImages) {
			//Xoá file trong thư mục Product image(trước)
			   String path = FOLFER_UPLOAD +  productImage.getPath();
				File file = new File(path);
				file.delete();	
				//Xoá tjppmg tin ảnh trong tbl_product_image
//				product.removeRelationalProductImage(productImage);//restrict
		}
		 //xoá file avtar trong thư mục Product/avatar
			String path = FOLFER_UPLOAD +  product.getAvatar();
			File file = new File(path);
			file.delete();
		   //Xoá product trong db
		   super.delete(product);

		}
//		
//		public List<Product> finalAllActive() {
//			return super.executeNativeSql("SELECT * FROM tbl_product WHERE status =1");
//		}
	
	
		
		
		
		
//	    Search product
		public List<Product> searchProduct(SearchModel productSearch) {
			//tạo câu lệnh sql
			String  sql = "SELECT * FROM tbl_product p WHERE 1=1";
			
			//Tìm kiếm với status
			if(productSearch.getStatus() != 2) { //có chọn active/ inactive
				sql += " AND p.status=" + productSearch.getStatus();
			}
			
			//tìm với tiêu chí category
			if (productSearch.getCategoryId() !=0) {
				sql += " AND p.category_id=" + productSearch.getCategoryId();
			}
			
//			tìm kiếm với tiêu chí keyword
			if (!StringUtils.isEmpty(productSearch.getKeyword())) {
				String keyword = productSearch.getKeyword().toLowerCase();
				sql += " AND (LOWER(p.name) like '%" + keyword +"%'"+
			           " OR LOWER(p.short_description) like '%" + keyword +"%'" + 
					   " OR LOWER(p.seo) like '%" + keyword + "%')";
						
			}
			
			if (!StringUtils.isEmpty(productSearch.getBeginDate())&&
					!StringUtils.isEmpty(productSearch.getEndDate())) {
				String beginDate = productSearch.getBeginDate();
				String endDate = productSearch.getEndDate();
				sql += " AND p.create_date BETWEEN '" + beginDate +"' AND '" + endDate + "'";
			}
			
			return super.executeNativeSql(sql);
//			return super.executeNativeSql(sql, productSearch.getCurrentPage(),productSearch.getSizeOfPage());
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
}
