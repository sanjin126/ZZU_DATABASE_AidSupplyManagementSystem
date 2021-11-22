package com.aidsystem.dao;

import java.sql.Connection;
import java.util.List;

import com.aidsystem.bean.User;

public interface UserDAO {
	/**
	 * 
	 * @Description 保存一个用户信息
	 * @author sanjin
	 * @param conn
	 * @param user
	 * @return 
	 */
	void insert(Connection conn, User user);
	/**
	 * 
	 * @Description 删除指定id的用户
	 * @author sanjin
	 * @param conn
	 * @param id
	 */
	void deleteById(Connection conn, int id);
	/**
	 * 
	 * @Description 更新用户信息，通过传入一个对象方式，更新对应id的用户
	 * @author sanjin
	 * @param conn
	 * @param user
	 */
	void updateUsr(Connection conn, User user);
	/**
	 * 
	 * @Description 查询指定id的用户
	 * @author sanjin
	 * @param conn
	 * @param id
	 * @return 返回一个用户对象
	 */
	User getById(Connection conn, int id);
	/**
	 * 
	 * @Description 查询user表中的所有运输人员信息
	 * @author sanjin
	 * @param conn
	 * @return 返回一个存有用户对象的列表
	 */
	List<User> getAll(Connection conn);
	/**
	 * 
	 * @Description 查询表中共有多少用户
	 * @author sanjin
	 * @param conn
	 * @return 返回一个long值
	 */
	long getCount(Connection conn);
	
	User getByNameAndPwd(Connection conn, String name, String pwd);

	public User getName(Connection conn, String name);
	
	User getByVolId(Connection conn, int id);
}
