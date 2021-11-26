package com.aidsystem.dao.Impl;

import java.sql.Connection;
import java.util.List;

import com.aidsystem.bean.ItemToUnit;
import com.aidsystem.dao.BaseDAO;
import com.aidsystem.dao.ItemToUnitDAO;

public class ItemToUnitDAOImpl extends BaseDAO<ItemToUnit> implements ItemToUnitDAO {

	@Override
	public void insert(Connection conn, ItemToUnit itt) {
		String sql = "insert into item_to_unit values(?,?)";
		update(conn, sql , itt.getName(),itt.getUnit());
	}

	@Override
	public void deleteByName(Connection conn, String name) {
		String sql = "delete from item_to_unit where name=?";
		update(conn, sql , name);
	}

	@Override
	public void updateItt(Connection conn, ItemToUnit itt) {
		String sql = "update item_to_unit set unit=? where name=?";
		update(conn, sql, itt.getUnit(),itt.getName());
	}

	@Override
	public ItemToUnit getByName(Connection conn, String name) {
		String sql = "select * from item_to_unit where name=?";
		return query(conn, sql , name);
	}

	@Override
	public List<ItemToUnit> getAll(Connection conn) {
		String sql = "select * from item_to_unit";
		return queryList(conn, sql);
	}

	@Override
	public long getCount(Connection conn) {
		String sql = "select count(*) from item_to_unit";
		return getValue(conn, sql);
	}

}
