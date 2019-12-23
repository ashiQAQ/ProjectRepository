package com.springboot.bean;

import java.io.Serializable;

/**
 * 商家相关信息表实体
 * 表名 infos
 */
public class Infos implements Serializable {
    private static final long serialVersionUID = 1L;

        //图片id 主键自增
        private Integer id;
        //商家id
        private Integer sellerId;
        //信息内容
        private String content;
    
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
         * 设置：信息内容
         */
        public void setContent(String content) {
            this.content = content;
        }

        /**
         * 获取：信息内容
         */
        public String getContent() {
            return content;
        }
    }
