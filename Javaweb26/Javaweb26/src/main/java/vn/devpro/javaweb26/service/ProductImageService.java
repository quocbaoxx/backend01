package vn.devpro.javaweb26.service;

import org.springframework.stereotype.Service;

import vn.devpro.javaweb26.model.ProductImage;
@Service
public class ProductImageService extends BaseService<ProductImage>{
	@Override
	public Class<ProductImage> clazz() {
		// TODO Auto-generated method stub
		return ProductImage.class;
	}
}
