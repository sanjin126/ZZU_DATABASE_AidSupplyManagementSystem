package com.aidsystem.dao.Impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import com.aidsystem.bean.DBObject;
import com.aidsystem.bean.Volunteer;
import com.aidsystem.dao.BaseDAO;
import com.aidsystem.dao.VolunteerDAO;

public class VolunteerDAOImpl extends BaseDAO<Volunteer> implements VolunteerDAO {
	/**
	 * 
	 * @author sanjin
	 */
	@Override
	public void insertVol(Connection conn, Volunteer vol) {
		String sql = "insert into volunteer values(?,?,?,?,?,?)";
		update(conn, sql, null,vol.getName(),vol.getGender(),vol.getAge(),vol.getPhone(),vol.getAddress());
	}
	/**
	 * 
	 * @author sanjin
	 */
	@Override
	public void deleteVolById(Connection conn, int id) {
		String sql = "delete from volunteer where id=?";
		update(conn, sql , id);
	}
	/**
	 * 
	 * @author sanjin
	 */
	@Override
	public void updateVol(Connection conn, Volunteer vol) {
		String sql = "update volunteer set name=?,gender=?,age=?,phone=?,address=? where id=?";
		update(conn, sql , vol.getName(),vol.getGender(),vol.getAge(),vol.getPhone(),vol.getAddress(),vol.getId());
	}

	@Override
	public Volunteer getVolById(Connection conn, int id) {
		String sql = "select * from volunteer where id=?";
		Volunteer volunteer = query(conn, sql, id);
		return volunteer;
	}

	@Override
	public List<Volunteer> getAll(Connection conn) {
		String sql = "select * from volunteer";
		List<Volunteer> list = queryList(conn, sql );
		return list;
	}

	@Override
	public long getVolCount(Connection conn) {
		String sql = "select count(*) from volunteer";
		return getValue(conn, sql);
	}
	@Override
	public ResultSet getResultSetOfAll(Connection conn) {
		String sql = "select * from volunteer";
		return getResultSet(conn, sql);
	}
	@Override
	public Volunteer getByIdAndName(Connection conn, int id, String name) {
		String sql = "select * from volunteer where id=? and name=?";
		return query(conn, sql, id, name);
	}

	
	



}
