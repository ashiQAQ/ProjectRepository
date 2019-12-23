package com.springboot.dao;

import com.springboot.bean.Supports;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 商家参与活动表Mapper
 */
@Repository
@Mapper
public interface SupportsMapper extends BaseDao<Supports>{

}
