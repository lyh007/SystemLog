package com.lyh.systemlog.service;

import com.lyh.systemlog.annotation.SystemLog;
import com.lyh.systemlog.bo.User;

/**
 * @author kevin
 * @version Revision: 1.00 Date: 11-8-19下午2:02
 * @Email liuyuhui007@gmail.com
 */
public interface UserService {
    void sayHello(User user,Long gongdanId);
}
