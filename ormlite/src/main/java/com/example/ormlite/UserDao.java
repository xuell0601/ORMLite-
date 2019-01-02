package com.example.ormlite;

import android.content.Context;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by xueliang on 2019/1/2 0002.
 */
public class UserDao {

    private final Basesql instance;
    private Dao getdao = null;


    public UserDao(Context context)  {
        this.instance = Basesql.getInstance(context);
        try {
            this.getdao = instance.getdao(User.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //添加操作
    public void add(User user){
        try {
            getdao.create(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //删除
    public void detele() throws SQLException {
        getdao.deleteById(2);
    }
    //查询
    public List<User> Query(){
        List list=null;
        try {
            list = getdao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
 return list;
    };


    public void updates(User user){
        try {

            getdao.update(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * 构建BUilder 删除条件比较复杂
     */
//    public void shanchu(User user){
//        try {
//            UpdateBuilder updateBuilder = getdao.updateBuilder();
//            //updateBuilder.where()
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

}
