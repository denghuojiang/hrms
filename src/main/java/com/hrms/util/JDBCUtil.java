package com.hrms.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @title: JDBCUtil
 * @Author HsNay
 * @Date: 2021/12/23 10:24
 * @Version 1.0
 */
public class JDBCUtil {
    private static String username;
    private static String password;
    private static String url;
    private static String driverClass;

    static {
        InputStream config = JDBCUtil.class.getClassLoader().getResourceAsStream("MysqlDB.properties");
        System.out.println(config);
        Properties properties = new Properties();
        try {
            properties.load(config);
            username = properties.getProperty("username");
            password = properties.getProperty("password");
            url = properties.getProperty("url");
            driverClass = properties.getProperty("driverClass");
            Class.forName(driverClass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnect() {
        Connection connection =null;
        try {
            connection = DriverManager.getConnection(url, username, password);
            return connection;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
    public static  void close(Connection connection){
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    public static  void close(ResultSet resultSet, Connection connection){
    	if(resultSet!=null) {
    		try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
    	}
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

}
