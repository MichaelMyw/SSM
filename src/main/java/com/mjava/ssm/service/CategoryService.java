package com.mjava.ssm.service;

import java.util.List;

import com.mjava.ssm.po.Category;

public interface CategoryService {
	public List<Category> listCategory();	
	
	public void addCategory(Category c);
	public void updateCategory(Category c);
	public void deleteCategory(int id);
	
	public Category getCategory(int id);

}
