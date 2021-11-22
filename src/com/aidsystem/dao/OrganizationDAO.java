package com.aidsystem.dao;

import java.math.BigInteger;
import java.sql.Connection;
import java.util.List;

import com.aidsystem.bean.Organization;

public interface OrganizationDAO {
	/**
	 * 
	 * @Description 保存一个组织信息
	 * @author sanjin
	 * @param conn
	 * @param org
	 */
	void insert(Connection conn, Organization org);
	/**
	 * 
	 * @Description 删除指定id的组织
	 * @author sanjin
	 * @param conn
	 * @param id
	 */
	void deleteById(Connection conn, int id);
	/**
	 * 
	 * @Description 更新组织信息，通过传入一个对象方式，更新对应id的组织
	 * @author sanjin
	 * @param conn
	 * @param org
	 */
	void updateOrg(Connection conn, Organization org);
	/**
	 * 
	 * @Description 查询指定id的组织
	 * @author sanjin
	 * @param conn
	 * @param id
	 * @return 返回一个组织对象
	 */
	Organization getById(Connection conn, int id);
	/**
	 * 
	 * @Description 查询organization表中的所有组织信息
	 * @author sanjin
	 * @param conn
	 * @return 返回一个存有组织对象的列表
	 */
	List<Organization> getAll(Connection conn);
	/**
	 * 
	 * @Description 查询表中共有多少组织
	 * @author sanjin
	 * @param conn
	 * @return 返回一个long值
	 */
	long getCount(Connection conn);
	/**
	 * 
	 * @Description 审核
	 * @author sanjin
	 * @param conn
	 * @param orgId
	 * @param org
	 */
	void checkThroughById(Connection conn, int orgId, Organization org) ;
	/**
	 * 
	 * @Description 
	 * @author sanjin
	 * @param conn
	 * @param demId
	 * @return
	 */
	int getOrgIdByDemId(Connection conn, int demId);
	/**
	 * 
	 * @Description 获取上一次插入的自增键值
	 * @author sanjin
	 * @param conn
	 * @return
	 */
	BigInteger getLastInsertId(Connection conn);
	/**
	 * 
	 * @Description 通过负责人和电话去重，一般这两项不可能重复
	 * @author sanjin
	 * @param conn
	 * @param director
	 * @param phone
	 * @return
	 */
	Integer getIdByDirectorAndPhone(Connection conn, String director, String phone);
}
