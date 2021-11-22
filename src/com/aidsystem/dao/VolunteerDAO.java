package com.aidsystem.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import com.aidsystem.bean.DBObject;
import com.aidsystem.bean.Volunteer;

public interface VolunteerDAO {
	/**
	 * 
	 * @Description 保存一个志愿者信息
	 * @author sanjin
	 * @param conn
	 * @param vol
	 */
	void insertVol(Connection conn, Volunteer vol);
	/**
	 * 
	 * @Description 删除指定id的志愿者
	 * @author sanjin
	 * @param conn
	 * @param id
	 */
	void deleteVolById(Connection conn, int id);
	/**
	 * 
	 * @Description 更新志愿者信息，通过传入一个Volunteer对象方式，更新对应id的志愿者
	 * @author sanjin
	 * @param conn
	 * @param vol
	 */
	void updateVol(Connection conn, Volunteer vol);
	/**
	 * 
	 * @Description 查询指定id的志愿者
	 * @author sanjin
	 * @param conn
	 * @param id
	 * @return 返回一个志愿者对象
	 */
	Volunteer getVolById(Connection conn, int id);
	/**
	 * 
	 * @Description 查询volunteer表中的所有志愿者信息
	 * @author sanjin
	 * @param conn
	 * @return 返回一个存有志愿者对象的列表
	 */
	List<Volunteer> getAll(Connection conn);
	/**
	 * 
	 * @Description 查询表中共有多少志愿者
	 * @author sanjin
	 * @param conn
	 * @return 返回一个long值
	 */
	long getVolCount(Connection conn);
	/**
	 * 
	 * @Description 获取到一个包含有PreparedStatement对象和ResultSet对象的实例
	 * @author sanjin
	 * @return
	 */
	ResultSet getResultSetOfAll(Connection conn);
	
	Volunteer getByIdAndName(Connection conn, int id, String name);
	
	
	
}
