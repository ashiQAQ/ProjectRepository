package com.springboot.dao;

import com.springboot.bean.Ratings;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 评价表Mapper
 */
@Repository
@Mapper
public interface RatingsMapper extends BaseDao<Ratings>{
    List<Ratings> queryList(@Param("sellerId") Integer sellerId);
}
