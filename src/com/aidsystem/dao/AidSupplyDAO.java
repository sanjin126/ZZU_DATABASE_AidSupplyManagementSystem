package com.aidsystem.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import com.aidsystem.bean.AidSupply;
import com.aidsystem.bean.DBObject;

public interface AidSupplyDAO {
	/**
	 * 
	 * @Description 保存一个救援物资信息
	 * @author sanjin
	 * @param conn
	 * @param aid
	 */
	void insertAid(Connection conn, AidSupply aid);
	/**
	 * 
	 * @Description 删除指定id的救援物资，可用于志愿者审核后发现为假消息的情况
	 * @author sanjin
	 * @param conn
	 * @param id
	 */
	void deleteAidById(Connection conn, int id);
	/**
	 * 
	 * @Description 更新救援物资信息，通过传入一个AidSupply对象方式，更新对应id的物资信息
	 * @author sanjin
	 * @param conn
	 * @param aid
	 */
	void updateAid(Connection conn, AidSupply aid);
	/**
	 * 
	 * @Description 查询指定id的救援物资
	 * @author sanjin
	 * @param conn
	 * @param id
	 * @return 返回一个救援物资对象
	 */
	AidSupply getAidById(Connection conn, int id);
	/**
	 * 
	 * @Description 查询aidsupply表中的所有物资信息
	 * @author sanjin
	 * @param conn
	 * @return 返回一个存有救援物资对象的列表
	 */
	List<AidSupply> getAll(Connection conn);
	/**
	 * 
	 * @Description 查询表中共有多少救援物资
	 * @author sanjin
	 * @param conn
	 * @return 返回一个long值
	 */
	long getCount(Connection conn);
	/**
	 * 
	 * @Description 改变物资的审核状态由未审核到审核,同时更新字段值
	 * @author sanjin
	 * @param conn
	 * @param id
	 */
	void checkthroughById(Connection conn, int id, AidSupply aid);
	/**
	 * 
	 * @Description 
	 * @author sanjin
	 * @param conn
	 * @return
	 */
	ResultSet getResultSetOfUncheckedAid(Connection conn) ;
	/**
	 * 
	 * @Description 
	 * @author sanjin
	 * @param conn
	 * @return
	 */
	ResultSet getResultSetOfCheckedAid(Connection conn);
	
	void transById(Connection conn, int id);

}
