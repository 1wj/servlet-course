package com.bjpowernode.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
 *      抽象类作用：降低接口接口实现类对接口实现的难度
 *       将接口中不需要使用的抽象方法交给抽象类进行完成
 *       这样接口(继承抽象类的)实现类只需要对需要的接口方法进行重写
 *     servlet接口：
 *              init()
 *              getServletConfig()
 *              getServletInfo()
 *              destroy()------------>四个方法对于Servlet接口实现类没用
 *              service()----------->有用
 *      tomcat根据Servlet规范调用Servlet接口实现类规则：
 *          1.Tomcat有权创建Servlet接口实现类的对象
 *            Servlet oneServlet=new OneServlet();
 *          2.Tomcat根据实例对象调用service方法处理当前请求
 *             oneServlet.service();
 *
 *             extends                extends                       implements
 * oneServlet---->(abstract)HtpServlet---->(abstract)GenericServlet---->servlet接口
 *                                                   init
 *                                                   destory
 *                                                   getServletInfo
 *                                                   getServletConfig
 * 通过父类决定在何种情况下调用子类中的方法  【设计模式】-----模板设计模式
 * httpServlet:
 *     service（）{
 *      if(浏览器使用get方法){
 *          this.doget();
 *      }else if(浏览器使用post方法){
 *          this.dopost();
 *      }
 * }
 * OneServlet{
 *      Servlet oneServlet=new OneServlet();
 *      oneServlet.service();
 * }
 *
 *
 *
 */
public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("OneServlet类针对浏览器的get方式做出回应");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("OneServlet类针对浏览器的post方式做出回应");
    }
}
