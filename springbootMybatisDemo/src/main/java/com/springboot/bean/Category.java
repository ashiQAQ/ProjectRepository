package com.springboot.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 用户表实体
 * 表名 user
 */
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;

    //分类id 主键自增
    private Integer id;

    //分类名称
    private String name;

    //分类类型
    private Integer type;

    //分类下商品
    private List<Foods> foods;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public List<Foods> getFoods() {
        return foods;
    }

    public void setFoods(List<Foods> foods) {
        this.foods = foods;
    }
}
