package com.mjava.ssm.service;

import java.util.List;
import java.util.Map;

import com.mjava.ssm.po.Product;

public interface ProductService {
	public List<Product> listProduct(Map m);	
	public void addProduct(Product p);
	public void updateProduct(Product p);
	public void deleteProduct(int id);
	
	public Product getProduct(int id);

}
