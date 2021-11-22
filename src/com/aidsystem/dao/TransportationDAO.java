package com.aidsystem.dao;

import java.sql.Connection;
import java.util.List;

import com.aidsystem.bean.Transportation;

public interface TransportationDAO {
	/**
	 * 
	 * @Description 保存一个运输信息
	 * @author sanjin
	 * @param conn
	 * @param trans
	 */
	void insert(Connection conn, Transportation trans);
	/**
	 * 
	 * @Description 删除指定aidId的运输信息
	 * @author sanjin
	 * @param conn
	 * @param aidId
	 */
	void deleteByAidId(Connection conn, int aidId);
	/**
	 * 
	 * @Description 更新用户信息，通过传入一个对象方式，更新对应aidId的用户
	 * @author sanjin
	 * @param conn
	 * @param trans
	 */
	void updateTrans(Connection conn, Transportation trans);
	/**
	 * 
	 * @Description 查询指定aidId的用户
	 * @author sanjin
	 * @param conn
	 * @param aidId
	 * @return 返回一个运输信息对象
	 */
	Transportation getByAidId(Connection conn, int aidId);
	/**
	 * 
	 * @Description 查询transportation表中的所有运输人员信息
	 * @author sanjin
	 * @param conn
	 * @return 返回一个存有运输信息对象的列表
	 */
	List<Transportation> getAll(Connection conn);
	/**
	 * 
	 * @Description 查询表中共有多少条运输信息
	 * @author sanjin
	 * @param conn
	 * @return 返回一个long值
	 */
	long getCount(Connection conn);
	
	void successByAidId(Connection conn, int aidId);

}
