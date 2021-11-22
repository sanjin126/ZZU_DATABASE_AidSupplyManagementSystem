package com.aidsystem.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import com.aidsystem.bean.TranPerson;

public interface TranPersonDAO {
	/**
	 * 
	 * @Description 保存一个运输人员信息
	 * @author sanjin
	 * @param conn
	 * @param trp
	 */
	void insert(Connection conn, TranPerson trp);
	/**
	 * 
	 * @Description 删除指定id的运输人员
	 * @author sanjin
	 * @param conn
	 * @param id
	 */
	void deleteById(Connection conn, int id);
	/**
	 * 
	 * @Description 更新运输人员信息，通过传入一个对象方式，更新对应id的运输人员
	 * @author sanjin
	 * @param conn
	 * @param trp
	 */
	void updateTrp(Connection conn, TranPerson trp);
	/**
	 * 
	 * @Description 查询指定id的运输人员
	 * @author sanjin
	 * @param conn
	 * @param id
	 * @return 返回一个运输人员对象
	 */
	TranPerson getById(Connection conn, int id);
	/**
	 * 
	 * @Description 查询tranperson表中的所有运输人员信息
	 * @author sanjin
	 * @param conn
	 * @return 返回一个存有运输人员对象的列表
	 */
	List<TranPerson> getAll(Connection conn);
	/**
	 * 
	 * @Description 查询表中共有多少运输人员
	 * @author sanjin
	 * @param conn
	 * @return 返回一个long值
	 */
	long getCount(Connection conn);
	
	ResultSet getResultSetOfAll(Connection conn);
	
	ResultSet getResultSetOfFreePerson(Connection conn);
}
