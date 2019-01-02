package com.example.ormlite;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.sql.SQLException;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private final String TAG="sd";
    private  UserDao  userDao = new UserDao(MainActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void tt(View v){
        User user = new User();
        user.setId(1);
        user.setName("张三");
        try {

//            userDao.add(user);
            List<User> query = userDao.Query();
            for(User user1:query){
                Log.d(TAG, "tt: "+user1.getId()+user1.getName());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        Toast.makeText(MainActivity.this, "添加成功", Toast.LENGTH_SHORT).show();
    }

    public void shan(View v){
        try {
            userDao.detele();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void xiu(View v){
        Toast.makeText(MainActivity.this, "添加成功", Toast.LENGTH_SHORT).show();
       // Toast.makeText(MainActivity.this, "添加成功", Toast.LENGTH_SHORT).show();
        User users = new User();
        users.setId(2);
        users.setName("李三");
        userDao.updates(users);
    }

    public void cha(View v){
//        userDao.detele();

        Toast.makeText(MainActivity.this, "添加成功", Toast.LENGTH_SHORT).show();
    }
}
