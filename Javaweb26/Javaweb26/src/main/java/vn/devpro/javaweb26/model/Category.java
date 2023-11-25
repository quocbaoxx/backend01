package vn.devpro.javaweb26.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_category")
public class Category  extends BaseModel{
	
	@Column(name = "name", length = 300, nullable = false)
	private String name;
	
	@Column(name = "description", length = 500, nullable = true)
	private String description;
	
	@Column(name = "seo", length = 1000, nullable = true)
	private String seo;
	
	//--------Mapping many-to-one: user-to-category(user create user)
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "create_by")
	private User userCreateCategory;
	
	//--------Mapping many-to-one: user-to-category(user update user)
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "update_by")
	private User userUpdateCategory;
	
	//------Mapping one-to-many: user-to-category(for user create category)
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy ="userCreateCategory")
	private Set<Category> userCreateCategorys = new HashSet<Category>();

	//------Mapping one-to-many: user-to-category(for user update category)
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userUpdateCategory")
	private Set<Category> userUpdateCategorys = new HashSet<Category>();
	
	
	//------Mapping one-to-many: tbl_category-to-tbl_product--
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy ="category")
	private Set<Product> products = new HashSet<Product>();
	
	//Methods add and remove elements in relatioal product list
	public void addRelationalProduct(Product product) {
		products.add(product);
		product.setCategory(this);
	}
	public void removeRelationalProduct(Product product) {
		products.remove(product);
		product.setCategory(null);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSeo() {
		return seo;
	}
	public void setSeo(String seo) {
		this.seo = seo;
	}
	public User getUserCreateCategory() {
		return userCreateCategory;
	}
	public void setUserCreateCategory(User userCreateCategory) {
		this.userCreateCategory = userCreateCategory;
	}
	public User getUserUpdateCategory() {
		return userUpdateCategory;
	}
	public void setUserUpdateCategory(User userUpdateCategory) {
		this.userUpdateCategory = userUpdateCategory;
	}
	public Set<Category> getUserCreateCategorys() {
		return userCreateCategorys;
	}
	public void setUserCreateCategorys(Set<Category> userCreateCategorys) {
		this.userCreateCategorys = userCreateCategorys;
	}
	public Set<Category> getUserUpdateCategorys() {
		return userUpdateCategorys;
	}
	public void setUserUpdateCategorys(Set<Category> userUpdateCategorys) {
		this.userUpdateCategorys = userUpdateCategorys;
	}
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	public Category(Integer id, Date createDate, Date updateDate, Boolean status, String name, String description,
			String seo, User userCreateCategory, User userUpdateCategory, Set<Category> userCreateCategorys,
			Set<Category> userUpdateCategorys, Set<Product> products) {
		super(id, createDate, updateDate, status);
		this.name = name;
		this.description = description;
		this.seo = seo;
		this.userCreateCategory = userCreateCategory;
		this.userUpdateCategory = userUpdateCategory;
		this.userCreateCategorys = userCreateCategorys;
		this.userUpdateCategorys = userUpdateCategorys;
		this.products = products;
	}
	public Category(Integer id, Date createDate, Date updateDate, Boolean status) {
		super(id, createDate, updateDate, status);
	}
	public Category() {
		super();
	}
	
	
	
	
	
	
}
