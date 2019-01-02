package com.mjava.ssm.mapper;

import java.util.List;

import com.mjava.ssm.po.Category;

public interface CategoryMapper {
	public List<Category> listCategory();
	
	public void addCategory(Category c);
	public void updateCategory(Category c);
	public void deleteCategory(int id);
	
	public Category getCategory(int id);
}
