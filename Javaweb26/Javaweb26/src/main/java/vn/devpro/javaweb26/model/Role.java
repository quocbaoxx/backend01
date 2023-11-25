package vn.devpro.javaweb26.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "tbl_role")
public class Role extends BaseModel implements GrantedAuthority{
	
	@Column(name ="name", length = 300 , nullable = false)
	private String name;
	
	@Column(name ="description", length = 500, nullable = true)
	private String description;
	
	//Mapping many-to-many: tbl_roles-to-tbl_user--------
	//First side: owner(user has some roles)
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name ="tbl_user_role", joinColumns =@JoinColumn(name = "role_id"),
	            inverseJoinColumns = @JoinColumn(name="user_id"))
	private List<User> users = new ArrayList<User>();

	//---------------------------------------
	
	//Mapping many-to-one: tbl_role-to-tbl_user(for create role)
	@ManyToOne(fetch =  FetchType.EAGER)
	@JoinColumn(name = "create_by")
	private User userCreateRole;
	
	//Mapping many-to-one: tbl_role-to-tbl_user(for update role)
		@ManyToOne(fetch =  FetchType.EAGER)
		@JoinColumn(name = "update_by")
		private User userupdateRole;
	
	
	public User getUserCreateRole() {
		return userCreateRole;
	}

	public void setUserCreateRole(User userCreateRole) {
		this.userCreateRole = userCreateRole;
	}

	public User getUserupdateRole() {
		return userupdateRole;
	}

	public void setUserupdateRole(User userupdateRole) {
		this.userupdateRole = userupdateRole;
	}
	
	//-------------------------------------------
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Role(Integer id, Date createDate, Date updateDate, Boolean status, String name, String description,
			List<User> users) {
		super(id, createDate, updateDate, status);
		this.name = name;
		this.description = description;
		this.users = users;
	}

	public Role() {
		super();
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

	@Override
	public String getAuthority() {
		// trả về tên role
		return this.name;
	}
	
	
}
