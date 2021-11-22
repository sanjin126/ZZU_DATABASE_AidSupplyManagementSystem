package com.aidsystem.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {
	/**
	 * 
	 * @Description 获取数据库连接
	 * @author sanjin
	 * @date 2021年11月14日下午8:42:43
	 * @return 返回conn
	 * @throws Exception 不能用trycatch处理，以免返回空对象
	 */
	public static Connection getConnection() throws Exception {
		//读取jdbc配置文件，位于src目录下
		InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
		Properties pros = new Properties();
		pros.load(is);
		String url = pros.getProperty("url");
		String user = pros.getProperty("user");
		String password = pros.getProperty("password");
		String driverClass = pros.getProperty("driverClass");
		
		//加载并自动注册DriverManager类
		Class.forName(driverClass);
		//获取连接
		Connection conn = DriverManager.getConnection(url, user, password);
		
		return conn;
	}
	
	public static void closeConnection(Connection conn, PreparedStatement ps) {
		try {
			if (conn != null) {
				conn.close();				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (ps != null) {
				ps.close();				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void closeConnection(Connection conn, Statement ps, ResultSet rs) {
		try {
			if (ps != null) {
				ps.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (conn!=null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (rs != null) {
				rs.close();				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
