package com.aidsystem.dao;

import java.math.BigInteger;
import java.sql.Connection;
import java.util.List;

import com.aidsystem.bean.Donator;

public interface DonatorDAO {
	/**
	 * 
	 * @Description 保存一个捐赠者信息
	 * @author sanjin
	 * @param conn
	 * @param don
	 */
	void insert(Connection conn, Donator don);
	/**
	 * 
	 * @Description 删除指定id的捐赠者
	 * @author sanjin
	 * @param conn
	 * @param id
	 */
	void deleteById(Connection conn, int id);
	/**
	 * 
	 * @Description 更新捐赠者信息，通过传入一个对象方式，更新对应id的捐赠者
	 * @author sanjin
	 * @param conn
	 * @param don
	 */
	void updateDonator(Connection conn, Donator don);
	/**
	 * 
	 * @Description 查询指定id的捐赠者
	 * @author sanjin
	 * @param conn
	 * @param id
	 * @return 返回一个捐赠者对象
	 */
	Donator getById(Connection conn, int id);
	/**
	 * 
	 * @Description 查询donator表中的所有捐赠者信息
	 * @author sanjin
	 * @param conn
	 * @return 返回一个存有捐赠者对象的列表
	 */
	List<Donator> getAll(Connection conn);
	/**
	 * 
	 * @Description 查询表中共有多少捐赠者
	 * @author sanjin
	 * @param conn
	 * @return 返回一个long值
	 */
	long getCount(Connection conn);
	/**
	 * 
	 * @Description 获取此次连接中，上一次插入的自增键值，是线程安全的，不会造成并发错误问题
	 * 使用select last_insert_id()时要注意，当一次插入多条记录时，只是获得第一次插入的id值，务必注意。
	 * @author sanjin
	 * @param conn
	 * @return
	 */
	BigInteger getLastInsertId(Connection conn);
	/**
	 * 
	 * @Description 查重，后期可考虑通过账号的方式记录捐赠者和组织
	 * @author sanjin
	 * @param conn
	 * @param name
	 * @param phone
	 * @return
	 */
	Integer getIdByNameAndPhone(Connection conn, String name, String phone);

}
