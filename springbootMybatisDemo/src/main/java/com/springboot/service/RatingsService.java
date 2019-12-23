package com.springboot.service;

import com.springboot.bean.Category;
import com.springboot.bean.Ratings;
import com.springboot.dao.CategoryMapper;
import com.springboot.dao.RatingsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingsService {
	@Autowired
	private RatingsMapper ratingsMapper;

	public List<Ratings> queryList(Integer sellerId){
		return ratingsMapper.queryList(sellerId);
	}

}