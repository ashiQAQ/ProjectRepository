package com.springboot.dao;

import com.springboot.bean.Recommend;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 推荐商品表Mapper
 */
@Repository
@Mapper
public interface RecommendMapper extends BaseDao<Recommend>{

}
