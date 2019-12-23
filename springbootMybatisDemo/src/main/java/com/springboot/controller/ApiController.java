package com.springboot.controller;

import com.springboot.bean.Category;
import com.springboot.bean.Ratings;
import com.springboot.bean.Seller;
import com.springboot.service.CategoryService;
import com.springboot.service.RatingsService;
import com.springboot.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {
    @Autowired
    public SellerService sellerService;

    @Autowired
    public CategoryService categoryService;

    @Autowired
    public RatingsService ratingsService;

        @RequestMapping("seller")
        public Seller seller(){
            return sellerService.querySellerList().get(0);
        }
        @RequestMapping("goods")
        public List<Category> category(){
            return categoryService.queryCategory();
        }

        @RequestMapping("ratings")
        public List<Ratings> rating(@RequestParam(name ="sellerId")Integer sellerId){
            List<Ratings> res =ratingsService.queryList(sellerId);
            return res;
        }
}
