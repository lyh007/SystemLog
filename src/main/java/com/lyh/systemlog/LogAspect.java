package com.lyh.systemlog;

import com.lyh.systemlog.annotation.SystemLog;
import com.lyh.systemlog.freemarker.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author kevin
 * @version Revision: 1.00 Date: 11-8-19下午2:22
 * @Email liuyuhui007@gmail.com
 */
public class LogAspect {
    //日志初始化
    private Log logger = LogFactory.getLog(LogAspect.class);
    //Spring 提供的获取参数方法
    private static LocalVariableTableParameterNameDiscoverer parameterNameDiscovere = new LocalVariableTableParameterNameDiscoverer();

    /**
     * 保存系统操作日志
     *
     * @param joinPoint 连接点
     * @return 方法执行结果
     * @throws Throwable 调用出错
     */
    @Around(value = "@annotation(com.lyh.systemlog.annotation.SystemLog)")
    public Object saveLog(ProceedingJoinPoint joinPoint) throws Throwable {
        //获取设置SystemLog注释的方法
        Method method = getMethod(joinPoint);
        //获取注释信息
        SystemLog systemLogAnnotation = method.getAnnotation(SystemLog.class);
        //获取模块名称
        SystemLog.Module module = systemLogAnnotation.module();
        //获取操作名称
        String operateName = systemLogAnnotation.operateName();
        //解析描述
        String description = executeTemplateFreeMarker(systemLogAnnotation.value(), joinPoint);
        System.out.println("解析后描述为：" + description);
        //这里保存日志到库中
        //方法执行前拦截
        return joinPoint.proceed();
    }

    /**
     * 解析执行SystemLog的value模板。
     *
     * @param template  描述模板
     * @param joinPoint 连接点
     * @return 解析后描述
     */
    private String executeTemplateFreeMarker(String template, ProceedingJoinPoint joinPoint) {
        //获取被调用的方法
        Method method = getMethod(joinPoint);
        //获取方法中定义的参数名称
        String[] parameterNames = parameterNameDiscovere.getParameterNames(method);
        //获取参数实例对象
        Object[] args = joinPoint.getArgs();
        Configuration configuration = freeMarkerConfigurer.getConfiguration();
        configuration.setTemplateLoader(new StringTemplateLoader(template));
        StringWriter writer = new StringWriter();
        try {
            Template freeMarkerTemplate = configuration.getTemplate("");
            Map context = new HashMap();
            for (int i = 0; i < parameterNames.length; i++) {
                context.put(parameterNames[i], args[i]);
            }
            context.put("ip", "192.168.0.32");
            freeMarkerTemplate.process(context, writer);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        return writer.toString();
    }

    /**
     * 解析执行SystemLog的value模板。
     *
     * @param template  描述模板
     * @param joinPoint 连接点
     * @return 解析后描述
     */
    private String executeTemplateVelocity(String template, ProceedingJoinPoint joinPoint) {
        //获取被调用的方法
        Method method = getMethod(joinPoint);
        //获取方法中定义的参数名称
        String[] parameterNames = parameterNameDiscovere.getParameterNames(method);
        //获取参数实例对象
        Object[] args = joinPoint.getArgs();
        //初始化Velocity
        Velocity.init();
        //定义上下文
        VelocityContext context = new VelocityContext();
        //定义写入结果
        StringWriter outString = new StringWriter();
        //向上下文中写入变量
        for (int i = 0; i < parameterNames.length; i++) {
            context.put(parameterNames[i], args[i]);
        }
        context.put("ip", "192.168.0.32");
        //这里可以放置内置函数IP,登录用户名等等
        //解析模板
        Velocity.evaluate(context, outString, "mystring", template);
        return outString.toString();
    }

    /**
     * 获取当前执行的方法
     *
     * @param joinPoint 连接点
     * @return 方法
     */
    private Method getMethod(ProceedingJoinPoint joinPoint) {
        //获取方法签名
        String methodName = joinPoint.getSignature().getName();
        //获取目标类的所有方法
        Method[] methods = joinPoint.getTarget().getClass().getMethods();
        Method resultMethod = null;
        //查询当前调用的方法
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                //找到当前要执行的方法
                resultMethod = method;
                break;
            }
        }
        return resultMethod;
    }

    private FreeMarkerConfigurer freeMarkerConfigurer;
    private FreeMarkerConfigurationFactoryBean freeMarkerConfiguration;

    public FreeMarkerConfigurer getFreeMarkerConfigurer() {
        return freeMarkerConfigurer;
    }

    public void setFreeMarkerConfigurer(FreeMarkerConfigurer freeMarkerConfigurer) {
        this.freeMarkerConfigurer = freeMarkerConfigurer;
    }

    public FreeMarkerConfigurationFactoryBean getFreeMarkerConfiguration() {
        return freeMarkerConfiguration;
    }

    public void setFreeMarkerConfiguration(FreeMarkerConfigurationFactoryBean freeMarkerConfiguration) {
        this.freeMarkerConfiguration = freeMarkerConfiguration;
    }
}
