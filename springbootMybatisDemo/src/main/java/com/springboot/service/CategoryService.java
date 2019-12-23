package com.springboot.service;

import com.springboot.bean.Category;
import com.springboot.bean.Seller;
import com.springboot.dao.CategoryMapper;
import com.springboot.dao.SellerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryService {
	@Autowired
	private CategoryMapper categoryMapper;

	public List<Category> queryCategory(){
		return categoryMapper.queryCategory(null);
	}

}