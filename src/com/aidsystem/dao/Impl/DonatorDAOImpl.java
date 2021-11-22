package com.aidsystem.dao.Impl;

import java.math.BigInteger;
import java.sql.Connection;
import java.util.List;

import com.aidsystem.bean.Donator;
import com.aidsystem.dao.BaseDAO;
import com.aidsystem.dao.DonatorDAO;

public class DonatorDAOImpl extends BaseDAO<Donator> implements DonatorDAO {

	@Override
	public void insert(Connection conn, Donator don) {
		String sql = "insert into donator values(?,?,?)";
		update(conn, sql , null,don.getName(),don.getPhone());
	}

	@Override
	public void deleteById(Connection conn, int id) {
		String sql = "delete from donator where id=?";
		update(conn, sql, id);
		
	}
	/**
	 * 
	 * @author sanjin
	 */
	@Override
	public void updateDonator(Connection conn, Donator don) {
		String sql = "update donator set name=?,phone=? where id=?";
		update(conn, sql, don.getName(),don.getPhone(),don.getId());
	}

	@Override
	public Donator getById(Connection conn, int id) {
		String sql = "select * from donator where id=?";
		return query(conn, sql , id);
		
	}

	@Override
	public List<Donator> getAll(Connection conn) {
		String sql = "select * from donator";
		return queryList(conn, sql);
	}

	@Override
	public long getCount(Connection conn) {
		String sql = "select count(*) from donator";
		return getValue(conn, sql);
	}

	@Override
	public BigInteger getLastInsertId(Connection conn) {
		String sql = "SELECT LAST_INSERT_ID()";
		return getValue(conn, sql);
	}

	@Override
	public Integer getIdByNameAndPhone(Connection conn, String name, String phone) {
		String sql = "select id from donator where name=? and phone=?";
		return getValue(conn, sql , name, phone);
	}

}
