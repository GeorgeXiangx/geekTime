package com.learn.test;

import java.sql.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by XJH on 2019/6/28.
 *
 * @Description:
 */
public class JDBCHelper {
    private final int MAX_SIZE = 10;
    private static JDBCHelper instsance = null;
    private LinkedList<Connection> dataSource = new LinkedList<>();

    static {
        //反射加载mysql driver
        try {
            Class.forName("");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private JDBCHelper() {
        for (int i = 0; i < MAX_SIZE; i++) {
            String url = "";
            String user = "";
            String password = "";
            Connection conn = null;
            try {
                conn = DriverManager.getConnection(url, user, password);
                dataSource.push(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static JDBCHelper getInstsance() {
        if (instsance == null) {
            synchronized (JDBCHelper.class) {
                if (instsance == null) {
                    instsance = new JDBCHelper();
                }
            }
        }
        return instsance;
    }

    public synchronized Connection getConnection() {
        while (dataSource.size() == 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return dataSource.poll();
    }

    public void executeQuery(String sql, Object[] params, CallBack callBack) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            connection = getConnection();
            pstmt = connection.prepareStatement(sql);

            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }

            rs = pstmt.executeQuery();

            callBack.process(rs);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static interface CallBack {
        void process(ResultSet rs) throws Exception;
    }

    public static void main(String[] args) {
        final Map<String, Object> testUser = new HashMap<>();

        String sql = "";
        Object[] params = new Object[]{"leo", 1};

        JDBCHelper jdbcHelper = JDBCHelper.getInstsance();
        jdbcHelper.executeQuery(sql, params, new CallBack() {
            @Override
            public void process(ResultSet rs) throws Exception {
                String name = rs.getString(1);
                int age = rs.getInt(2);

                testUser.put("name", name);
                testUser.put("age", age);
            }
        });

        System.out.println(testUser.get("name") + " " + testUser.get("age"));
    }
}
