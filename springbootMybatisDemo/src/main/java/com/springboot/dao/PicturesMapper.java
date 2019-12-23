package com.springboot.dao;

import com.springboot.bean.Pictures;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 商家相关图片表Mapper
 */
@Repository
@Mapper
public interface PicturesMapper extends BaseDao<Pictures>{

}
