package com.transaction;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by lee on 16/2/2.
 */
public class TransactionManager {
    private static DBPool pool=DBPool.getPool();

    /**
     * 开启事务
     */
    public static void startTransaction(){
        Connection conn=pool.getConnection();
        if(conn!=null){
            try {
                conn.setAutoCommit(false);
                System.out.println("事务开启");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void commitTransaction(){
        Connection conn=pool.getConnection();

    }

    public static void releaseConnection(){
        try {
            pool.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
