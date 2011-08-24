Spring AOP 实现记录系统日志!

示例代码:
 //Velocity
    // @SystemLog(module = SystemLog.Module.USER, operateName = "测试一下", value = "用户$user.name正在更新系统配置参数,他的数据库标识是$user.id.工单号是$gongdanId,登录IP是$ip")
    //FreeMarker
    @SystemLog(module = SystemLog.Module.USER, operateName = "测试一下", value = "用户${user.name}正在更新系统配置参数,他的数据库标识是${user.id}.工单号是${gongdanId},登录IP是${ip}")
    public void sayHello(User user, Long gongdanId) {
        System.out.println("*********** user info **************");
        System.out.println("*** Id=" + user.getId() + " name=" + user.getName() + " gongdanId=" + gongdanId + " *******");
    }
	

13:35:14,703 DEBUG main freemarker.cache:81 - Could not find template in cache, creating new one; id=[[zh_CN,UTF-8,parsed] ]
13:35:14,703 DEBUG main freemarker.cache:81 - Compiling FreeMarker template [zh_CN,UTF-8,parsed]  from 用户${user.name}正在更新系统配置参数,他的数据库标识是${user.id}.工单号是${gongdanId},登录IP是${ip}
解析后描述为：用户yhliu正在更新系统配置参数,他的数据库标识是1.工单号是888,登录IP是192.168.0.32
*********** user info **************
*** Id=1 name=yhliu gongdanId=888 *******
