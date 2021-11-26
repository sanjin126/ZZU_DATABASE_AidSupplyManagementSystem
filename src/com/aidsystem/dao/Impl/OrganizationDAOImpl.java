package com.aidsystem.dao.Impl;

import java.math.BigInteger;
import java.sql.Connection;
import java.util.List;

import com.aidsystem.bean.Organization;
import com.aidsystem.dao.BaseDAO;
import com.aidsystem.dao.OrganizationDAO;

public class OrganizationDAOImpl extends BaseDAO<Organization> implements OrganizationDAO {

	@Override
	public void insert(Connection conn, Organization org) {
		String sql = "insert into organization values(?,?,?,?,?)";
		update(conn, sql , null,org.getName(),org.getAddress(),org.getDirector(),org.getPhone());
	}

	@Override
	public void deleteById(Connection conn, int id) {
		String sql = "delete from organization where id=?";
		update(conn, sql , id);
	}

	@Override
	public void updateOrg(Connection conn, Organization org) {
		String sql = "update organization set name=?,address=?,phone=?,description=? where id=?";
		update(conn, sql, org.getName(),org.getAddress(),org.getDirector(),org.getPhone(),org.getId());
	}

	@Override
	public Organization getById(Connection conn, int id) {
		String sql = "select * from organization where id=?";
		return query(conn, sql , id);
	}

	@Override
	public List<Organization> getAll(Connection conn) {
		String sql = "select * from organization";
		return queryList(conn, sql);
	}

	@Override
	public long getCount(Connection conn) {
		String sql = "select count(*) from organization";
		return getValue(conn, sql);
	}
	/**
	 * set name=?,address=?,director=?
	 * @author sanjin
	 */
	@Override
	public void checkThroughById(Connection conn, int orgId, Organization org) {
		String sql = "update organization set name=?,address=?,director=? where id=?";
		update(conn, sql, org.getName(),org.getAddress(),org.getDirector(),orgId);
	}
	/**
	 * 找得到返回id，找不到返回-1
	 * @author sanjin
	 */
	@Override
	public int getOrgIdByDemId(Connection conn, int demId) {
		String sql = "SELECT o.id " + 
				"FROM organization o " + 
				"INNER JOIN demand_supply d ON d.org_id = o.id " + 
				"WHERE d.id = ?";
		Integer orgId = getValue(conn, sql, demId);
		if (orgId != null) {
			return orgId;
		} else {
			return -1;
		}

	}

	@Override
	public BigInteger getLastInsertId(Connection conn) {
		String sql = "SELECT LAST_INSERT_ID()";
		return getValue(conn, sql);
	}
	/**
	 * 
	 * @author sanjin
	 */
	@Override
	public Integer getIdByDirectorAndPhone(Connection conn, String director, String phone) {
		String sql = "select id from organization where director=? and phone=?";
		return getValue(conn, sql , director, phone);
	}



}
