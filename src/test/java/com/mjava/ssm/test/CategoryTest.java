package com.mjava.ssm.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mjava.ssm.mapper.CategoryMapper;
import com.mjava.ssm.po.Category;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class CategoryTest {
	
	@Autowired
	private CategoryMapper categoryMapper;
	
	@Test
	public void listCategoryTest() {
		List<Category> list = categoryMapper.listCategory();
		System.out.println(list);	
	}
	
	@Test
	public void addCategoryTest() {
		Category c = new Category();
		c.setName("ccc10");
		categoryMapper.addCategory(c);
			
	}
	
	@Test
	public void getCategoryTest() {
		Category c = categoryMapper.getCategory(1);
		System.out.println(c);	
	}
	
	@Test
	public void updateCategoryTest() {
		Category c = categoryMapper.getCategory(25);
		c.setName("ccccas");
		categoryMapper.updateCategory(c);
			
	}
	
	@Test
	public void deleteCategoryTest() {
		Category c = categoryMapper.getCategory(25);
		categoryMapper.deleteCategory(25);
			
	}
}
