package com.bjpowernode.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class OneListener implements ServletContextAttributeListener {
    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        System.out.println("servletContext添加了数据");
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        System.out.println("servletContext删除了数据");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        System.out.println("servletContext修改了数据");
    }
}
