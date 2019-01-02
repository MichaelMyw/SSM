package com.mjava.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjava.ssm.mapper.CategoryMapper;
import com.mjava.ssm.po.Category;
import com.mjava.ssm.service.CategoryService;

@Service
public class CategorySeviceImpl implements CategoryService{

	@Autowired
	private CategoryMapper categoryMapper;
	
	@Override
	public List<Category> listCategory() {
		return categoryMapper.listCategory();
	}

	@Override
	public void addCategory(Category c) {
		categoryMapper.addCategory(c);
		
	}

	@Override
	public void updateCategory(Category c) {
		categoryMapper.updateCategory(c);
		
	}

	@Override
	public void deleteCategory(int id) {
		categoryMapper.deleteCategory(id);
		
	}

	@Override
	public Category getCategory(int id) {
		return categoryMapper.getCategory(id);
	}
	
	
}
