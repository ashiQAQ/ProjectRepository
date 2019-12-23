package com.springboot.dao;

import com.springboot.bean.Seller;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 商家表Mapper
 */
@Repository
@Mapper
public interface SellerMapper extends BaseDao<Seller>{
    List<Seller> queryList1(Map<String, Object> map);
}
