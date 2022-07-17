package com.bjpowernode.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class TwoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int mt_money=20;
        int sj_money=30;
        int gf_money=15;
        String userName=null;
        int userMoney=0 ,yuer=0,xiaofei=0;
        Cookie newCookie=null;
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        //1.读取请求头参数信息，得到用户点餐食物类型
        String food = request.getParameter("food");
        //2.读取请求中的cookie
        Cookie[] cookies = request.getCookies();
        //3.划卡取餐
        for (Cookie cookie:cookies){
            String key= cookie.getName();//读取key值
            String value=cookie.getValue();//读取value值
            if("key1".equals(key)){
                userName=value;//赋值用户名
            }else if("key2".equals(key)){//先找到钱
                userMoney=Integer.valueOf(value);//赋值金额
                if("miaotiao".equals(food)){//然后在看买哪个食物
                    if(mt_money > userMoney){
                        out.println("余额不足以购买"+food);
                    }else {
                        newCookie=new Cookie("key2",(userMoney-mt_money)+"");
                        yuer=userMoney-mt_money;
                        xiaofei=mt_money;
                       // out.print("你以成功购买"+food+"，花费了"+mt_money+"元,还剩余额"+yuer+"元");
                    }
                }else if("jiaozi".equals(food)){
                    if(sj_money > userMoney){
                        out.println("余额不足以购买"+food);
                    }else {
                        newCookie=new Cookie("key2",(userMoney-sj_money)+"");
                        yuer=userMoney-sj_money;
                        xiaofei=sj_money;
                     //   out.print("你以成功购买"+food+"，花费了"+sj_money+"元,还剩余额"+yuer+"元");
                    }
                }else  if("gaifan".equals(food)){
                    if(gf_money > userMoney){
                        out.println("余额不足以购买"+food);
                    }else {
                        newCookie=new Cookie("key2",(userMoney-gf_money)+"");
                        yuer=userMoney-gf_money;
                        xiaofei=gf_money;
                       // out.print("你以成功购买"+food+"，花费了"+gf_money+"元,还剩余额"+yuer+"元");
                    }
                }
            }
        }
        //3.返还cookie
        response.addCookie(newCookie);
        //4.将消费记录写入到响应
        out.print("你以成功购买"+food+"，花费了"+xiaofei+"元,还剩余额"+yuer+"元");
    }


}
