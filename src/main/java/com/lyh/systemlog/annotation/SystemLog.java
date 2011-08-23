package com.lyh.systemlog.annotation;

import java.lang.annotation.*;

/**
 * @author kevin
 * @version Revision: 1.00 Date: 11-8-19下午1:56
 * @Email liuyuhui007@gmail.com
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemLog {
    public static enum Module {
        USER("用户模块"),
        GROUP("工作组模块"),
        DEPT("部门模块");
        String value;

        Module(String value) {
            this.value = value;
        }

        public static void main(String[] args) {
            Module type = Module.USER;
            System.out.println(type.value);
            System.out.println(type.toString());
        }
    }

    Module module();//模块名称

    String operateName(); //操作名称

    String value() default ""; //操作内容
}
