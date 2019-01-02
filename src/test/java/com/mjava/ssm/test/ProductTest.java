package com.mjava.ssm.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mjava.ssm.mapper.CategoryMapper;
import com.mjava.ssm.mapper.ProductMapper;
import com.mjava.ssm.po.Category;
import com.mjava.ssm.po.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ProductTest {
	
	@Autowired
	private CategoryMapper categoryMapper;
	
	@Autowired
	private ProductMapper productMapper;
	
	@Test
	public void listProductTest() {
		
		Category c = categoryMapper.getCategory(2);
		System.out.println(c);
		Map<String,Category> m = new HashMap<String,Category>();
		m.put("category", c);
		List<Product> list = productMapper.listProduct(m);
		for (Product product : list) {
			System.out.println(product.getName());
		}
	}
	
	@Test
	public void addProductTest() {
		Category c = categoryMapper.getCategory(2);
		Product p = new Product();
		p.setName("电脑");
		p.setPrice(5000f);
		p.setCategory(c);
		productMapper.addProduct(p);
	}
	
	@Test
	public void updateProductTest() {
		Category c = categoryMapper.getCategory(2);
		Product p =productMapper.getProduct(14);
		p.setName("电脑");
		p.setPrice(6000f);
		p.setCategory(c);
		productMapper.updateProduct(p);
	}
	
	@Test
	public void deleteProductTest() {
	
		productMapper.deleteProduct(15);
	}

}
