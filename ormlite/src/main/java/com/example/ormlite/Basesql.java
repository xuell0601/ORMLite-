package com.example.ormlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.HashMap;

/**
 * Created by xueliang on 2019/1/2 0002.
 */
public class Basesql extends OrmLiteSqliteOpenHelper {
    private final static String DATABASE="myad.db";
    private final static int VERSION=1;
    public HashMap<String ,Dao> maps=new HashMap<>();
    public Basesql(Context context) {
        super(context, DATABASE, null, VERSION);
    }
    private static Basesql instance;
    public static synchronized Basesql getInstance(Context context){

        if(instance==null){
             synchronized (Basesql.class){
                 if(instance==null){
                     instance=new Basesql(context);
                 }
             }
        }
        return instance;
    };

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource,User.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    //获取到
    public synchronized Dao getdao(Class cla) throws SQLException {
          Dao dao=null;
        String simpleName = cla.getSimpleName();
        if(maps.containsKey(simpleName)){
               dao=maps.get(simpleName);
        }else{
            dao=super.getDao(cla);
            maps.put(simpleName,dao);
        }
          return dao;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {

    }
}
