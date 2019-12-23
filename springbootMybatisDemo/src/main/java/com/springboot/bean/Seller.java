package com.springboot.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 商家表实体
 * 表名 seller
 */
public class Seller implements Serializable {
    private static final long serialVersionUID = 1L;

        //商家id 主键自增
        private Integer id;
        //商家名称
        private String name;
        //商家描述
        private String description;
        //商家头像
        private String avatar;
        //配送长 x分钟(整)
        private Integer deliveryTime;
        //商家综合评分
        private Double score;
        //服务态度
        private Double serviceScore;
        //商品评分
        private Double foodScore;
        //高于周边n%的评分
        private Double rankRate;
        //起送金额
        private Double minPrice;
        //配送费
        private Double deliveryPrice;
        //评价数
        private Integer ratingCount;
        //月售订单数
        private Integer sellCount;
        //商家公告
        private String bulletin;


        //支持的活动
        private List<Supports> supports;
        //商家图片
        private List<Pictures> pictures;
        //商家信息
        private List<Infos> infos;
    
        /**
         * 设置：商家id 主键自增
         */
        public void setId(Integer id) {
            this.id = id;
        }

        /**
         * 获取：商家id 主键自增
         */
        public Integer getId() {
            return id;
        }
            /**
         * 设置：商家名称
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * 获取：商家名称
         */
        public String getName() {
            return name;
        }
            /**
         * 设置：商家描述
         */
        public void setDescription(String description) {
            this.description = description;
        }

        /**
         * 获取：商家描述
         */
        public String getDescription() {
            return description;
        }
            /**
         * 设置：商家头像
         */
        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        /**
         * 获取：商家头像
         */
        public String getAvatar() {
            return avatar;
        }
            /**
         * 设置：配送长 x分钟(整)
         */
        public void setDeliveryTime(Integer deliveryTime) {
            this.deliveryTime = deliveryTime;
        }

        /**
         * 获取：配送长 x分钟(整)
         */
        public Integer getDeliveryTime() {
            return deliveryTime;
        }
            /**
         * 设置：商家综合评分
         */
        public void setScore(Double score) {
            this.score = score;
        }

        /**
         * 获取：商家综合评分
         */
        public Double getScore() {
            return score;
        }
            /**
         * 设置：服务态度
         */
        public void setServiceScore(Double serviceScore) {
            this.serviceScore = serviceScore;
        }

        /**
         * 获取：服务态度
         */
        public Double getServiceScore() {
            return serviceScore;
        }
            /**
         * 设置：商品评分
         */
        public void setFoodScore(Double foodScore) {
            this.foodScore = foodScore;
        }

        /**
         * 获取：商品评分
         */
        public Double getFoodScore() {
            return foodScore;
        }
            /**
         * 设置：高于周边n%的评分
         */
        public void setRankRate(Double rankRate) {
            this.rankRate = rankRate;
        }

        /**
         * 获取：高于周边n%的评分
         */
        public Double getRankRate() {
            return rankRate;
        }
            /**
         * 设置：起送金额
         */
        public void setMinPrice(Double minPrice) {
            this.minPrice = minPrice;
        }

        /**
         * 获取：起送金额
         */
        public Double getMinPrice() {
            return minPrice;
        }
            /**
         * 设置：配送费
         */
        public void setDeliveryPrice(Double deliveryPrice) {
            this.deliveryPrice = deliveryPrice;
        }

        /**
         * 获取：配送费
         */
        public Double getDeliveryPrice() {
            return deliveryPrice;
        }
            /**
         * 设置：评价数
         */
        public void setRatingCount(Integer ratingCount) {
            this.ratingCount = ratingCount;
        }

        /**
         * 获取：评价数
         */
        public Integer getRatingCount() {
            return ratingCount;
        }
            /**
         * 设置：月售订单数
         */
        public void setSellCount(Integer sellCount) {
            this.sellCount = sellCount;
        }

        /**
         * 获取：月售订单数
         */
        public Integer getSellCount() {
            return sellCount;
        }
            /**
         * 设置：商家公告
         */
        public void setBulletin(String bulletin) {
            this.bulletin = bulletin;
        }

        /**
         * 获取：商家公告
         */
        public String getBulletin() {
            return bulletin;
        }

    public List<Supports> getSupports() {
        return supports;
    }

    public void setSupports(List<Supports> supports) {
        this.supports = supports;
    }

    public List<Pictures> getPictures() {
        return pictures;
    }

    public void setPictures(List<Pictures> pictures) {
        this.pictures = pictures;
    }

    public List<Infos> getInfos() {
        return infos;
    }

    public void setInfos(List<Infos> infos) {
        this.infos = infos;
    }
}
