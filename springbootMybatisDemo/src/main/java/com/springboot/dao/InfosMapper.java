package com.springboot.dao;

import com.springboot.bean.Infos;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 商家相关信息表Mapper
 */
@Repository
@Mapper
public interface InfosMapper extends BaseDao<Infos>{

}
