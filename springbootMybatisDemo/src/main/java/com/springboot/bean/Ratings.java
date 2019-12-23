package com.springboot.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 评价表实体
 * 表名 ratings
 */
public class Ratings implements Serializable {
    private static final long serialVersionUID = 1L;

        //id 主键自增
        private Integer id;
        //商家id
        private Integer sellerId;
        //用户id
        private Integer userId;
        //评价时间
        private Long rateTime;
        //配送时间
        private Integer deliveryTime;
        //评分
        private Double score;
        //评价类型
        private Integer rateType;
        //评价内容
        private String text;


        //评价用户
        private User user;
        //用户在此评价中推荐的商品
        private List<Foods> recommend = new ArrayList<Foods>();


    
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

        public Integer getSellerId() {
            return sellerId;
        }

        public void setSellerId(Integer sellerId) {
            this.sellerId = sellerId;
        }

    /**
         * 设置：用户id
         */
        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        /**
         * 获取：用户id
         */
        public Integer getUserId() {
            return userId;
        }
            /**
         * 设置：评价时间
         */
        public void setRateTime(Long rateTime) {
            this.rateTime = rateTime;
        }

        /**
         * 获取：评价时间
         */
        public Long getRateTime() {
            return rateTime;
        }
            /**
         * 设置：配送时间
         */
        public void setDeliveryTime(Integer deliveryTime) {
            this.deliveryTime = deliveryTime;
        }

        /**
         * 获取：配送时间
         */
        public Integer getDeliveryTime() {
            return deliveryTime;
        }
            /**
         * 设置：
         */
        public void setScore(Double score) {
            this.score = score;
        }

        /**
         * 获取：
         */
        public Double getScore() {
            return score;
        }
            /**
         * 设置：评价类型
         */
        public void setRateType(Integer rateType) {
            this.rateType = rateType;
        }

        /**
         * 获取：评价类型
         */
        public Integer getRateType() {
            return rateType;
        }
            /**
         * 设置：评价内容
         */
        public void setText(String text) {
            this.text = text;
        }

        /**
         * 获取：评价内容
         */
        public String getText() {
            return text;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public List<Foods> getRecommend() {
            return recommend;
        }

        public void setRecommend(List<Foods> recommend) {
            this.recommend = recommend;
        }


/*
    本来如果不association的话 本类做一个类似于vo的类 用下面两个字段去接收关联user的查询结果也可以
    但从业务角度来讲 用户信息是在user表的 故 虽然如果不改成association的话 返回结构和前端mock的数据更契合 但还是改掉啦
    //用户名
    private String username;
    //用户头像
    private String avatar;
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }
 */
}
