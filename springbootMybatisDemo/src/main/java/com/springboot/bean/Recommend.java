package com.springboot.bean;

import java.io.Serializable;

/**
 * 推荐商品表实体
 * 表名 recommend
 */
public class Recommend implements Serializable {
    private static final long serialVersionUID = 1L;

        //id 主键自增
        private Integer id;
        //评分的id
        private Integer ratingId;
        //id 推荐商品ids
        private String goodsId;
    
        /**
         * 设置：id 主键自增
         */
        public void setId(Integer id) {
            this.id = id;
        }

        /**
         * 获取：id 主键自增
         */
        public Integer getId() {
            return id;
        }
            /**
         * 设置：评分的id
         */
        public void setRatingId(Integer ratingId) {
            this.ratingId = ratingId;
        }

        /**
         * 获取：评分的id
         */
        public Integer getRatingId() {
            return ratingId;
        }
            /**
         * 设置：id 推荐商品ids
         */
        public void setGoodsId(String goodsId) {
            this.goodsId = goodsId;
        }

        /**
         * 获取：id 推荐商品ids
         */
        public String getGoodsId() {
            return goodsId;
        }
    }
