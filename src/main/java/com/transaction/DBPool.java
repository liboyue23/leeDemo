package com.transaction;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lee on 16/2/2.
 */
public class DBPool {
    //thread
    private ThreadLocal<Connection> threadLocal=new ThreadLocal<Connection>();
    private static int poolSize=2;
    private List<Connection> pool=new ArrayList<Connection>();

    public DBPool() {

    }

    public static void initPoolSize(int poolSize){
        DBPool.poolSize=poolSize;
    }

    private static class InnerDBPool{
        private static DBPool pool=new DBPool();
    }

    public static DBPool getPool(){
        return InnerDBPool.pool;
    }

    public Connection getConnection(){
        Connection conn=threadLocal.get();
        if(conn!=null){
            return conn;
        }

        if(pool.size()>0){
            synchronized (pool){
                if(pool.size()>0){
                    conn=pool.remove(0);
                    threadLocal.set(conn);
                    return conn;
                }
            }
        }
        throw new RuntimeException("当前线程池已经用完，请稍候使用！");
    }

    private void init0(){
        for(int i=0;i<poolSize;i++){
//            pool.add();
        }
    }

    private Connection getProxyConnection(){
        Connection connection=null;
//        Proxy.newProxyInstance(connection.getClass().getClassLoader(),)
        return null;
    }
}
