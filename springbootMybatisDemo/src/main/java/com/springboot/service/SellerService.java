package com.springboot.service;

import com.springboot.bean.Seller;
import com.springboot.dao.SellerMapper;
import com.springboot.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class SellerService {
    @Autowired
	private SellerMapper sellerMapper;
	
	public List<Seller> querySellerList(){
		return sellerMapper.queryList1(null);
	}
    
}