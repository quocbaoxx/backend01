package vn.devpro.javaweb26.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name= "tbl_sale_oder_product")
public class SaleOrderProduct extends BaseModel {
	
	@Column(name = "quantity", nullable = true)
	private String quantity;
	
	@Column(name = "desription", nullable = true, length = 500)
	private String desription;
	
}
