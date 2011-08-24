package com.lyh.systemlog.service.impl;

import com.lyh.systemlog.annotation.SystemLog;
import com.lyh.systemlog.bo.User;
import com.lyh.systemlog.service.UserService;

/**
 * @author kevin
 * @version Revision: 1.00 Date: 11-8-19下午1:58
 * @Email liuyuhui007@gmail.com
 */
public class UserServiceImpl implements UserService {
    //Velocity
    // @SystemLog(module = SystemLog.Module.USER, operateName = "测试一下", value = "用户$user.name正在更新系统配置参数,他的数据库标识是$user.id.工单号是$gongdanId,登录IP是$ip")
    //FreeMarker
    @SystemLog(module = SystemLog.Module.USER, operateName = "测试一下", value = "用户${user.name}正在更新系统配置参数,他的数据库标识是${user.id}.工单号是${gongdanId},登录IP是${ip}")
    public void sayHello(User user, Long gongdanId) {
        System.out.println("*********** user info **************");
        System.out.println("*** Id=" + user.getId() + " name=" + user.getName() + " gongdanId=" + gongdanId + " *******");
    }
}
