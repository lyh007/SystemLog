package com.lyh.systemlog.base;

import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author kevin
 * @version Revision: 1.00 Date: 11-8-19下午2:06
 * @Email liuyuhui007@gmail.com
 */
public class BaseTestCase extends TestCase {
    //Spring config file path
    private static String[] configLocations = {"classpath:applicationContext.xml"};
    private static ApplicationContext context;

    //set config path
    protected static void setConfigLocations(String[] locations) {
        configLocations = locations;
    }

    protected static ApplicationContext getApplicationContext() {
        if (context == null) {
            context = new ClassPathXmlApplicationContext(configLocations);
        }
        return context;
    }
}
