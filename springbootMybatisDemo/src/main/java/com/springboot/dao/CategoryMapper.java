package com.springboot.dao;

import com.springboot.bean.Category;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 商家表Mapper
 */
@Repository
@Mapper
public interface CategoryMapper extends BaseDao<Category>{
    List<Category> queryCategory(Map<String, Object> map);
}
