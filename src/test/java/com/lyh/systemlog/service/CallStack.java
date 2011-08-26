package com.lyh.systemlog.service;

import org.springframework.core.LocalVariableTableParameterNameDiscoverer;

import java.lang.reflect.Method;

/**
 * @author kevin
 * @version Revision: 1.00 Date: 11-8-25上午10:54
 * @Email liuyuhui007@gmail.com
 */
public class CallStack {
    //Spring 提供的获取参数方法
    private static LocalVariableTableParameterNameDiscoverer parameterNameDiscovere = new LocalVariableTableParameterNameDiscoverer();

    public static void main(String[] args) {
        methodA("good");
    }

    public static void methodA(String msg) {
        methodB(msg);
    }

    public static void methodB(String msg) {
        methodC(msg);
    }

    public static void methodC(String msg) {
        System.out.println(msg);
        Throwable ex = new Throwable();

        StackTraceElement[] stackElements = ex.getStackTrace();
        if (stackElements != null) {
            for (int i = 0; i < stackElements.length; i++) {
                System.out.println(stackElements[i].getClassName());
                System.out.println(stackElements[i].getFileName());
                System.out.println(stackElements[i].getLineNumber());
                System.out.println(stackElements[i].getMethodName());
                System.out.println("-----------------------------------");
                Method[] methods = stackElements[i].getClass().getMethods();
                for (Method method : methods) {
                    if(method.getName().equals(stackElements[i].getMethodName())) {
                        System.out.println("have");
                    }
                }
                System.out.println(sun.reflect.Reflection.getCallerClass(0));
                System.out.println("good");
                //String[] parameterNames = parameterNameDiscovere.getParameterNames(method);
            }
        }
    }
}
