package com.springboot.bean;

import java.io.Serializable;

/**
 * 商家相关图片表实体
 * 表名 pictures
 */
public class Pictures implements Serializable {
    private static final long serialVersionUID = 1L;

        //图片id 主键自增
        private Integer id;
        //商家id
        private Integer sellerId;
        //pic_url
        private String url;
    
            /**
         * 设置：图片id 主键自增
         */
        public void setId(Integer id) {
            this.id = id;
        }

        /**
         * 获取：图片id 主键自增
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
         * 设置：pic_url
         */
        public void setUrl(String url) {
            this.url = url;
        }

        /**
         * 获取：pic_url
         */
        public String getUrl() {
            return url;
        }
    }
