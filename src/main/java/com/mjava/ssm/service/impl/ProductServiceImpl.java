package com.mjava.ssm.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjava.ssm.mapper.ProductMapper;
import com.mjava.ssm.po.Product;
import com.mjava.ssm.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductMapper productMapper;

	@Override
	public List<Product> listProduct(Map m) {
		return productMapper.listProduct(m);
	}

	@Override
	public void addProduct(Product p) {
		productMapper.addProduct(p);
		
	}

	@Override
	public void updateProduct(Product p) {
		productMapper.updateProduct(p);
		
	}

	@Override
	public void deleteProduct(int id) {
		productMapper.deleteProduct(id);
		
	}

	@Override
	public Product getProduct(int id) {
		return productMapper.getProduct(id);
	}
	
	

}
