package com.springboot.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 商品表实体
 * 表名 foods
 */
public class Foods implements Serializable {
    private static final long serialVersionUID = 1L;

        //商品id 主键自增
        private Integer id;
        //分类id
        private Integer categoryId;
        //商品name
        private String name;
        //商品价格
        private Double price;
        //商品价格
        private Double oldPrice;
        //商品name
        private String description;
        //销售量
        private Integer sellCount;
        //好评率
        private Integer rating;
        //详情
        private String info;
        //icon_url
        private String icon;
        //image_url
        private String image;
        //商品所包含的评价列表
        private List<Ratings> ratings;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(Integer categoryId) {
            this.categoryId = categoryId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        public Double getOldPrice() {
            return oldPrice;
        }

        public void setOldPrice(Double oldPrice) {
            this.oldPrice = oldPrice;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Integer getSellCount() {
            return sellCount;
        }

        public void setSellCount(Integer sellCount) {
            this.sellCount = sellCount;
        }

        public Integer getRating() {
            return rating;
        }

        public void setRating(Integer rating) {
            this.rating = rating;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public List<Ratings> getRatings() {
            return ratings;
        }

        public void setRatings(List<Ratings> ratings) {
            this.ratings = ratings;
        }
}
