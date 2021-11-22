package com.aidsystem.dao.Impl;

import java.sql.Connection;
import java.util.List;

import com.aidsystem.bean.ItemToType;
import com.aidsystem.dao.BaseDAO;
import com.aidsystem.dao.ItemToTypeDAO;

public class ItemToTypeDAOImpl extends BaseDAO<ItemToType> implements ItemToTypeDAO {

	@Override
	public void insert(Connection conn, ItemToType itt) {
		String sql = "insert into item_to_type values(?,?)";
		update(conn, sql , itt.getName(),itt.getUnit());
	}

	@Override
	public void deleteByName(Connection conn, String name) {
		String sql = "delete from item_to_type where name=?";
		update(conn, sql , name);
	}

	@Override
	public void updateItt(Connection conn, ItemToType itt) {
		String sql = "update item_to_type set unit=? where name=?";
		update(conn, sql, itt.getUnit(),itt.getName());
	}

	@Override
	public ItemToType getByName(Connection conn, String name) {
		String sql = "select * from item_to_type where name=?";
		return query(conn, sql , name);
	}

	@Override
	public List<ItemToType> getAll(Connection conn) {
		String sql = "select * from item_to_type";
		return queryList(conn, sql);
	}

	@Override
	public long getCount(Connection conn) {
		String sql = "select count(*) from item_to_type";
		return getValue(conn, sql);
	}

}
