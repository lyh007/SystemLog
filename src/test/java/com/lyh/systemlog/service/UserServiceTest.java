package com.lyh.systemlog.service;

import com.lyh.systemlog.base.BaseTestCase;
import com.lyh.systemlog.bo.User;
import org.junit.Test;

/**
 * @author kevin
 * @version Revision: 1.00 Date: 11-8-19下午2:03
 * @Email liuyuhui007@gmail.com
 */
public class UserServiceTest extends BaseTestCase {
    private UserService userService;

    public UserServiceTest() {
        userService = (UserService) getApplicationContext().getBean("userService");
    }

    @Test
    public void testSayHello() {
        User user=new User();
        user.setId(1);
        user.setName("yhliu");
        userService.sayHello(user,888L);
    }
}
