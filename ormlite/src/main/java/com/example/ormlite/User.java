package com.example.ormlite;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by xueliang on 2019/1/2 0002.
 */
@DatabaseTable(tableName = "user_info")//创建表名
public class User {
    public User() {
    }

    @DatabaseField(generatedId = true)//绑定字段

    private int id;
    @DatabaseField(columnName = "name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
