package com.springboot.service;

import com.springboot.BaseTest;
import com.springboot.bean.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author gyx
 * @time 2019/12/21
 */
public class ServiceTest extends BaseTest {


    @Autowired
    private UserService userService;

    @Test
    public void dynamicDataSourceTest() throws Exception {
        List<User> userList = userService.getByMap(null);
        System.out.println("--userList---" + userList.size());

    }
}
