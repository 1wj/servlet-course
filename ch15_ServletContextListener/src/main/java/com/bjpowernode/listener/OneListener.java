package com.bjpowernode.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//接口实现类   通过这个接口合法的检测全局作用域对象被初始化时刻以及被销毁时刻
public class OneListener implements ServletContextListener {
    //在全局作用域对象被Http服务器初始化被调用
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("欢迎建立");
    }

    // 在全局作用域对象被Http服务器销毁时候触发调用
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("一路走好");
    }
}
