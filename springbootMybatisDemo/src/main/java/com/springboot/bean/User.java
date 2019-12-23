package com.springboot.bean;

import java.io.Serializable;

/**
 * 用户表实体
 * 表名 user
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

        //id 主键自增
        private Integer id;
        //用户名
        private String username;
        //用户头像
        private String avatar;
    
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
         * 设置：用户名
         */
        public void setUsername(String username) {
            this.username = username;
        }

        /**
         * 获取：用户名
         */
        public String getUsername() {
            return username;
        }
            /**
         * 设置：用户头像
         */
        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        /**
         * 获取：用户头像
         */
        public String getAvatar() {
            return avatar;
        }
    }
