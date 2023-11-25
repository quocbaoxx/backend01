package vn.devpro.javaweb26.dto;

import java.math.BigDecimal;

public class CartProduct {
	
	private int productId;
	private Integer quantity;
	private BigDecimal price;
	private String productName;
	private String avatar;
	
	
	public BigDecimal totalPrice() {
		return this.price.add(new BigDecimal(this.quantity.toString()) );
	}
	
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public CartProduct(int productId, int quantity, BigDecimal price, String productName, String avatar) {
		super();
		this.productId = productId;
		this.quantity = quantity;
		this.price = price;
		this.productName = productName;
		this.avatar = avatar;
	}
	public CartProduct() {
		super();
	}
	
	
	
	
}
