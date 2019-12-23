package com.springboot.bean;

import java.io.Serializable;

/**
 * 商家参与活动表实体
 * 表名 supports
 */
public class Supports implements Serializable {
    private static final long serialVersionUID = 1L;

        //活动id 主键自增
        private Integer id;
        //商家id
        private Integer sellerId;
        //类型
        private Integer type;
        //活动描述
        private String description;
    
        /**
         * 设置：活动id 主键自增
         */
        public void setId(Integer id) {
            this.id = id;
        }

        /**
         * 获取：活动id 主键自增
         */
        public Integer getId() {
            return id;
        }
            /**
         * 设置：商家id
         */
        public void setSellerId(Integer sellerId) {
            this.sellerId = sellerId;
        }

        /**
         * 获取：商家id
         */
        public Integer getSellerId() {
            return sellerId;
        }
            /**
         * 设置：类型
         */
        public void setType(Integer type) {
            this.type = type;
        }

        /**
         * 获取：类型
         */
        public Integer getType() {
            return type;
        }
            /**
         * 设置：活动描述
         */
        public void setDescription(String description) {
            this.description = description;
        }

        /**
         * 获取：活动描述
         */
        public String getDescription() {
            return description;
        }
    }
