package vn.devpro.javaweb26.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.devpro.javaweb26.model.Category;

@Service
public class CategoryService  extends BaseService<Category>{
	
	@Override
	public Class<Category> clazz() {
		// TODO Auto-generated method stub
		return Category.class;
	}

	public List<Category> findAllActive() {
		
		return super.executeNativeSql("SELECT * FROM tbl_category WHERE status =1");
	}
}
