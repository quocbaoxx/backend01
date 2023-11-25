package vn.devpro.javaweb26.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_sale_order")
public class SaleOrder  extends BaseModel{

	@Column(name ="code",length = 60, nullable = false)
	private String code;
	
	@Column(name = "total", nullable = true)
	private String total;
	
	@Column(name = "customer_name", length = 300, nullable = false)
	private String customer_name;
	
	@Column(name ="customer_mobile", length = 120, nullable = true)
	private String customer_mobile;
	
	@Column(name = "customer_email", length = 120, nullable = true)
	private String customer_email;
	
	@Column(name= "customer_address", length = 300, nullable =  false)
	private String customer_address;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "create_by")
	private User userCreateSaleOder;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "update_by")
	private User userUpdateSaleOder;
	
	
	
}
