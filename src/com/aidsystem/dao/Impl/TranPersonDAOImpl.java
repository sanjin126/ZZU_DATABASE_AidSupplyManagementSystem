package com.aidsystem.dao.Impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import com.aidsystem.bean.TranPerson;
import com.aidsystem.dao.BaseDAO;
import com.aidsystem.dao.TranPersonDAO;

public class TranPersonDAOImpl extends BaseDAO<TranPerson> implements TranPersonDAO {

	@Override
	public void insert(Connection conn, TranPerson trp) {
		String sql = "insert into tran_person values(?,?,?,?,?,?,?)";
		update(conn, sql , null,trp.getName(),trp.getGender(),trp.getAge(),trp.getPhone(),trp.getArea(),trp.getNumberPlate());
	}

	@Override
	public void deleteById(Connection conn, int id) {
		String sql = "delete from tran_person where id=?";
		update(conn, sql, id);
	}

	@Override
	public void updateTrp(Connection conn, TranPerson trp) {
		String sql = "update tran_person set name=?,gender=?,age=?,phone=?,responsible_area=?,number_plate=? "
				+ "where id=?";
		update(conn, sql , trp.getName(),trp.getGender(),trp.getAge(),trp.getPhone(),trp.getArea(),trp.getNumberPlate(),trp.getId());
	}

	@Override
	public TranPerson getById(Connection conn, int id) {
		String sql = "select id,name,gender,age,phone,responsible_area area,number_plate numberPlate from tran_person where id=?";
		return query(conn, sql, id);
	}

	@Override
	public List<TranPerson> getAll(Connection conn) {
		String sql = "select id,name,gender,age,phone,responsible_area area,number_plate numberPlate from tran_person";
		return queryList(conn, sql);
	}

	@Override
	public long getCount(Connection conn) {
		String sql = "select count(*) from tran_person";
		return getValue(conn, sql);
	}
	
	public ResultSet getResultSetOfAll(Connection conn) {
		String sql = "select * from `tran_person`";
		return getResultSet(conn, sql);
	}

	@Override
	public ResultSet getResultSetOfFreePerson(Connection conn) {
		String sql = "SELECT * \r\n" + 
				"FROM `tran_person` tp\r\n" + 
				"WHERE NOT EXISTS(\r\n" + 
				"SELECT *\r\n" + 
				"FROM transportation t\r\n" + 
				"WHERE tp.id=t.`tran_per_id`\r\n" + 
				")";
		return getResultSet(conn, sql);
	}

}
