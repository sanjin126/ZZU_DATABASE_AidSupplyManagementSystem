package com.aidsystem.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import com.aidsystem.bean.DBObject;
import com.aidsystem.bean.DemandSupply;

public interface DemandSupplyDAO {
	/**
	 * 
	 * @Description 保存一个需求物资信息
	 * @author sanjin
	 * @param conn
	 * @param demand
	 */
	void insertDemand(Connection conn, DemandSupply demand);
	/**
	 * 
	 * @Description 删除指定id的需求物资，可用于志愿者审核后发现为假消息的情况
	 * @author sanjin
	 * @param conn
	 * @param id
	 */
	void deleteDemandById(Connection conn, int id);
	/**
	 * 
	 * @Description 更新需求物资信息，通过传入一个DemandSupply对象方式，更新对应id的物资信息
	 * @author sanjin
	 * @param conn
	 * @param demand
	 */
	void updateDemand(Connection conn, DemandSupply demand);
	/**
	 * 
	 * @Description 查询指定id的需求物资
	 * @author sanjin
	 * @param conn
	 * @param id
	 * @return 返回一个需求物资对象
	 */
	DemandSupply getDemandById(Connection conn, int id);
	/**
	 * 
	 * @Description 查询demandsupply表中的所有物资信息
	 * @author sanjin
	 * @param conn
	 * @return 返回一个存有需求物资对象的列表
	 */
	List<DemandSupply> getAll(Connection conn);
	/**
	 * 
	 * @Description 查询表中共有多少需求物资
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
	 * @param sql
	 * @param dem
	 */
	void checkthroughById(Connection conn, int id, DemandSupply dem);
	/**
	 * 
	 * @Description 获取到包含有未审核物资信息的rs和ps的DBObject类
	 * @author sanjin
	 * @param conn
	 * @return
	 */
	@Deprecated
	ResultSet getResultSetOfUncheckedDem(Connection conn) ;
	/**
	 * 
	 * @Description 
	 * @author sanjin
	 * @param conn
	 * @return
	 */
	@Deprecated
	ResultSet getResultSetOfCheckedDem(Connection conn) ;
	@Deprecated
	void transById(Connection conn, int id);

}
