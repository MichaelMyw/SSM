package com.mjava.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mjava.ssm.po.Category;
import com.mjava.ssm.service.CategoryService;
import com.mjava.ssm.util.Page;

@Controller
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping("/listCategory")
	public ModelAndView listCategory(Page page) {
		
		PageHelper.offsetPage(page.getStart(), 5);
		List<Category> list = categoryService.listCategory();
		int total = (int) new PageInfo<>(list).getTotal();
	
		page.calculateLast(total);		
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("listCategory");
		return mav;
	}
	
	
	@RequestMapping("/addCategory")
	public ModelAndView addCategory(Category c) {
		categoryService.addCategory(c);	
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:listCategory");
		return mav;
	}
	
	@RequestMapping("/deleteCategory")
	public ModelAndView deleteCategory(int id) {
		categoryService.deleteCategory(id);	
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:listCategory");
		return mav;
	}
	

	@RequestMapping("/editCategory")
	public ModelAndView editCategory(int id) {
		Category c = categoryService.getCategory(id);
		ModelAndView mav = new ModelAndView();
		mav.addObject("c", c);
		mav.setViewName("editCategory");
		return mav;
	}
	
	@RequestMapping("/updateCategory")
	public ModelAndView updateCategory(Category c) {
		categoryService.updateCategory(c);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:listCategory");
		return mav;
	}
}
