package com.bjpowernode.dao;

import com.bjpowernode.entity.Question;
import com.bjpowernode.util.JdbcUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionDao {
    JdbcUtil util=new JdbcUtil();
    public int add(Question qs){
        String sql="insert into question(title,optionA,optionB,optionC,optionD,answer)  values(?,?,?,?,?,?)";
        PreparedStatement ps = util.createStatement(sql);
        int result=0;
        try {
            ps.setString(1,qs.getTitle());
            ps.setString(2,qs.getOptionA());
            ps.setString(3,qs.getOptionB());
            ps.setString(4,qs.getOptionC());
            ps.setString(5,qs.getOptionD());
            ps.setString(6,qs.getAnswer());
           result= ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
           util.close();
        }
        return  result;
    }

    public List find() {
        String sql="select * from question";
        PreparedStatement ps=util.createStatement(sql);
        List<Question> list=new ArrayList();
        ResultSet rs=null;
        try {
             rs = ps.executeQuery();
            while (rs.next()){
                int questionid = rs.getInt("questionId");
                String title = rs.getString("title");
                String optionA = rs.getString("optionA");
                String optionB = rs.getString("optionB");
                String optionC = rs.getString("optionC");
                String optionD = rs.getString("optionD");
                String answer= rs.getString("answer");
              Question q=new Question(questionid,title,optionA,optionB,optionC,optionD,answer);
              list.add(q);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close();
        }
        return list;
    }

    public Question findId(String questionId) {
        String sql="select * from question where questionId=?";
        PreparedStatement ps=util.createStatement(sql);
        ResultSet rs=null;
        Question qu=new Question();
        try {
            ps.setInt(1,Integer.valueOf(questionId));
            rs=ps.executeQuery();
            while(rs.next()){
                int questionid = rs.getInt("questionId");
                String title = rs.getString("title");
                String optionA = rs.getString("optionA");
                String optionB = rs.getString("optionB");
                String optionC = rs.getString("optionC");
                String optionD = rs.getString("optionD");
                String answer= rs.getString("answer");
                 qu=new Question(questionid,title,optionA,optionB,optionC,optionD,answer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close();
        }
        return qu;
    }

    public int update(Question qs) {
        int i=0;
        String sql="update question set title=?,optionA=?,optionB=?,optionC=?, optionD=?,answer=? where questionId=?";
        PreparedStatement ps = util.createStatement(sql);
        try {
            ps.setString(1,qs.getTitle());
            ps.setString(2,qs.getOptionA());
            ps.setString(3,qs.getOptionB());
            ps.setString(4,qs.getOptionC());
            ps.setString(5,qs.getOptionD());
            ps.setString(6,qs.getAnswer());
            ps.setInt(7,qs.getQuestionId());
             i = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close();
        }
        return i;
    }

    public int delete(String qs) {
        String sql="delete from question where questionId=?";
        int result=0;
        PreparedStatement ps = util.createStatement(sql);
        try {
            ps.setInt(1,Integer.valueOf(qs));
             result = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close();
        }
        return result;
    }
}
