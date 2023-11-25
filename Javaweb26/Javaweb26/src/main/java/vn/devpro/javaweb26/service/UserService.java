package vn.devpro.javaweb26.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import vn.devpro.javaweb26.model.User;



@Service
public  class UserService extends BaseService<User>{
	
	@Override
	public Class<User> clazz() {
		return User.class;
	}
	
	public List<User> finalAllActive() {
		return super.executeNativeSql("SELECT * FROM tbl_user WHERE status =1");
	}
	
	@Transactional
	private void deleteUserById(int id) {
		super.deleteById(id);
	}
}
