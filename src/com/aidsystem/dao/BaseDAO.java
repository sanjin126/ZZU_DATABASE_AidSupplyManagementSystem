package com.aidsystem.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.aidsystem.bean.DBObject;
import com.aidsystem.util.JDBCUtils;


public abstract class BaseDAO<T> {
	
	private Class<T> clazz = null;
	
	//利用反射，初始化clazz，无需每次调用crud方法时传入指定Class
	{
		Type type = this.getClass().getGenericSuperclass();
		ParameterizedType paraType = (ParameterizedType) type;
		Type[] genericClasses = paraType.getActualTypeArguments();
		clazz = (Class<T>) genericClasses[0];
	}
	
	/**
	 * 
	 * @Description 通用的更新操作(考虑事务)
	 * @author sanjin
	 * @date 2021年11月14日下午10:35:08
	 * @param conn
	 * @param sql 
	 * @param args 占位符所要填充的值
	 * @return 返回更新操作所影响条数。0代表失败。
	 * @throws SQLException 
	 */
	public int update(Connection conn, String sql, Object ...args){
		QueryRunner runner = new QueryRunner();
		int updateCount = 0;
		try {
			updateCount = runner.update(conn, sql, args);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return updateCount;
	}
	
	/**
	 * 
	 * @Description 通用的查询单条记录操作
	 * @author sanjin
	 * @date 2021年11月14日下午10:55:01
	 * @param <T>
	 * @param clazz
	 * @param conn
	 * @param sql
	 * @param args
	 * @return 返回单个对象
	 */
	public T query(Connection conn, String sql, Object ...args) {
		try {
			QueryRunner runner = new QueryRunner();
			ResultSetHandler<T> rsh = new BeanHandler<T>(clazz);
			T t = runner.query(conn, sql, rsh, args);
			return t;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
		
	}
	/**
	 * 
	 * @Description 通用的查询多条记录操作
	 * @author sanjin
	 * @date 2021年11月14日下午10:55:27
	 * @param <T>
	 * @param clazz
	 * @param conn
	 * @param sql
	 * @param args
	 * @return 返回查询结果的list集合
	 */
	public List<T> queryList(Connection conn, String sql, Object ...args) {
		try {
			QueryRunner runner = new QueryRunner();
			BeanListHandler<T> rsh = new BeanListHandler<T>(clazz);
			List<T> list = runner.query(conn, sql, rsh, args);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	/**
	 * 
	 * @Description 用于只返回单个值的查询，例如聚集函数(max，count等)
	 * @author sanjin
	 * @date 2021年11月15日上午9:35:14
	 * @param <E>
	 * @param conn
	 * @param sql
	 * @param args
	 * @return 返回一个值，值的类型由调用者决定
	 */
	public <E> E getValue(Connection conn, String sql, Object ...args) {
		QueryRunner runner = new QueryRunner();
		ResultSetHandler<E> rsh = (ResultSetHandler<E>) new ScalarHandler();
		try {
			return runner.query(conn, sql, rsh , args);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	/**
	 * 
	 * @Description 只获取数据的结果集，而不将数据封装为对象
	 * @author sanjin
	 * @param conn
	 * @param sql
	 * @param args
	 * @return
	 */
	public ResultSet getResultSet(Connection conn, String sql, Object ...args) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {

			//预编译sql语句，获取PreparedStatemnet对象
			ps = conn.prepareStatement(sql);
			//填充sql语句占位符
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i+1, args[i]);
			}
			//执行sql语句，获取查询结果resultSet
			rs = ps.executeQuery();
			//利用离线的rowset，可以在关闭连接的同时获取数据，数据被加载到了内存中
			RowSetFactory factory = RowSetProvider.newFactory();
			CachedRowSet cachedRs = factory.createCachedRowSet();
			cachedRs.populate(rs);
			JDBCUtils.closeConnection(conn, ps);
			rs = cachedRs; //多态特性，减少了耦合
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
//			JDBCUtils.closeConnection(null, ps);				
		}
		return null;
			
	}

}
