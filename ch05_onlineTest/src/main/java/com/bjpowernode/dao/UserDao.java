package com.bjpowernode.dao;

import com.bjpowernode.entity.Users;
import com.bjpowernode.util.JdbcUtil;

import javax.servlet.http.HttpServletRequest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class UserDao {
    JdbcUtil util=new JdbcUtil();
    //用户注册
    public  int add(Users user){
        //用户注册
       String sql="insert into users(userName,password,sex,email)"+" values(?,?,?,?)" ;
        PreparedStatement ps=util.createStatement(sql);
        int result=0;
        try {
            ps.setString(1,user.getUserName());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getSex());
            ps.setString(4,user.getEmail());
            result=ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close();
        }
        return result;
    }
    //---------------------------------
    public  int add(Users user, HttpServletRequest request){
        //用户注册
        String sql="insert into users(userName,password,sex,email)"+" values(?,?,?,?)" ;
        PreparedStatement ps=util.createStatement(sql,request);
        int result=0;
        try {
            ps.setString(1,user.getUserName());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getSex());
            ps.setString(4,user.getEmail());
            result=ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close(request);
        }
        return result;
    }
    //---------------------------------

    //查询所有用户信息
    public List find(){
        List<Users> usersList=new ArrayList<>();


        String sql="select * from users";
        PreparedStatement ps=util.createStatement(sql);
        ResultSet rs= null;
        try {
            rs = ps.executeQuery();
            while(rs.next()){
                Integer userId=rs.getInt("userId");
                String  username=rs.getString("userName");
                String userpasswd=rs.getString("password");
                String sex=rs.getString("sex");
                String email=rs.getString("email");
                Users user=new Users(userId,username,userpasswd,sex,email);
                usersList.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close();
        }


        return usersList;
    }

    //根据用户编号删除信息
    public int delete(String id) {
        String sql="delete from users where userId=?";
        PreparedStatement ps=util.createStatement(sql);//找车
        int result=0;
        try {
            ps.setInt(1,Integer.valueOf(id));//有参数才需要装人。没参数直接开车
            result=ps.executeUpdate();   //开车

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close();
        }

        return result;
    }

    //登录验证
    public int login(String userName,String password){
        String sql="select count(*) from users where userName=? and password=?";
        ResultSet rs=null;
        int result=0;
        PreparedStatement ps=util.createStatement(sql);
        try {
            ps.setString(1,userName);
            ps.setString(2,password);
            rs=ps.executeQuery();
            while(rs.next()){
                result = rs.getInt("count(*)");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close();
        }


        return result;

    }


}
