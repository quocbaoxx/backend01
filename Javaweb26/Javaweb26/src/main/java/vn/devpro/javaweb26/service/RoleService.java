package vn.devpro.javaweb26.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.devpro.javaweb26.model.Role;

@Service
public class RoleService extends BaseService<Role> {

	@Override
	public Class<Role> clazz() {
		// TODO Auto-generated method stub
		return Role.class;
	}
	public Role getRoleByName(String name) {
		
		String sql ="SELECT * FROM tbl_role WHERE name='" + name +"'";
		List<Role> roles = super.executeNativeSql(sql);
		
		if(roles.size()>0) {
			return roles.get(0);
		}else {
			return new Role();
		}
	}
	
	
}
