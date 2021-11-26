package com.aidsystem.dao;

import java.sql.Connection;
import java.util.List;

import com.aidsystem.bean.ItemToUnit;

public interface ItemToUnitDAO {
	/**
	 * 
	 * @Description 保存一个物资类别对应信息
	 * @author sanjin
	 * @param conn
	 * @param itt
	 */
	void insert(Connection conn, ItemToUnit itt);
	/**
	 * 
	 * @Description 删除指定物资名的对应信息
	 * @author sanjin
	 * @param conn
	 * @param name
	 */
	void deleteByName(Connection conn, String name);
	/**
	 * 
	 * @Description 更新物资类别对应信息，通过传入一个对象方式，更新对应name的类别
	 * @author sanjin
	 * @param conn
	 * @param itt
	 */
	void updateItt(Connection conn, ItemToUnit itt);
	/**
	 * 
	 * @Description 查询指定name的物资对应信息
	 * @author sanjin
	 * @param conn
	 * @param name
	 * @return 返回一个物资类别对象
	 */
	ItemToUnit getByName(Connection conn, String name);
	/**
	 * 
	 * @Description 查询item_to_type表中的所有对应信息
	 * @author sanjin
	 * @param conn
	 * @return 返回一个存有所有对应信息对象的列表
	 */
	List<ItemToUnit> getAll(Connection conn);
	/**
	 * 
	 * @Description 查询表中共有多少物资类别对应信息
	 * @author sanjin
	 * @param conn
	 * @return 返回一个long值
	 */
	long getCount(Connection conn);
}
