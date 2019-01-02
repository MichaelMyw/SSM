package com.mjava.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mjava.ssm.po.Category;
import com.mjava.ssm.po.Product;
import com.mjava.ssm.service.CategoryService;
import com.mjava.ssm.service.ProductService;
import com.mjava.ssm.util.Page;

@Controller
public class ProductController {
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ProductService productService;
	
	
	@RequestMapping("/listProduct")
	public ModelAndView listProduct(Category category,Page page) {
		category = categoryService.getCategory(category.getId());
		PageHelper.offsetPage(page.getStart(), 5);
		
		Map<String,Category> m = new HashMap<String,Category>();
		m.put("category", category);
		List<Product> ps = productService.listProduct(m);
		int total = (int) new PageInfo<>(ps).getTotal();
	
		page.calculateLast(total);	
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("ps", ps);
		mav.addObject("category",category);
		
		mav.setViewName("listProduct");
		return mav;
	}				
	
	@RequestMapping("/addProduct")
	public ModelAndView addProduct(Product product) {
		productService.addProduct(product);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/listProduct?id="+product.getCategory().getId());
		return mav;
	}
	
	@RequestMapping("/deleteProduct")
	public ModelAndView deleteProduct(int id) {
		Product product = productService.getProduct(id);
		productService.deleteProduct(id);	
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/listProduct?id="+product.getCategory().getId());
		return mav;
	}
	

	@RequestMapping("/editProduct")
	public ModelAndView editProduct(int id) {
		Product p = productService.getProduct(id);
		ModelAndView mav = new ModelAndView();
		mav.addObject("p", p);
		mav.setViewName("editProduct");
		return mav;
	}
	
	@RequestMapping("/updateProduct")
	public ModelAndView updateProduct(Product product) {
		productService.updateProduct(product);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/listProduct?id="+product.getCategory().getId());
		return mav;
	}
	

}
