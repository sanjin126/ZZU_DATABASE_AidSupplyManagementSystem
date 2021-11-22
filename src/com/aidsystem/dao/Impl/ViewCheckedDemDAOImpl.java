package com.aidsystem.dao.Impl;

import java.sql.Connection;
import java.sql.ResultSet;

import com.aidsystem.bean.CheckedDemSupply;
import com.aidsystem.dao.BaseDAO;
import com.aidsystem.dao.ViewCheckedDemDAO;

public class ViewCheckedDemDAOImpl extends BaseDAO<CheckedDemSupply> implements ViewCheckedDemDAO {

	@Override
	public ResultSet getResultSetOfAll(Connection conn) {
		String sql = "SELECT * FROM checked_demsupply";
		return getResultSet(conn, sql);
	}

}
