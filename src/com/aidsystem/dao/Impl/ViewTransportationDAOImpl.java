package com.aidsystem.dao.Impl;

import java.sql.Connection;
import java.sql.ResultSet;

import com.aidsystem.bean.TransportationInfo;
import com.aidsystem.dao.BaseDAO;
import com.aidsystem.dao.ViewTransportationDAO;

public class ViewTransportationDAOImpl extends BaseDAO<TransportationInfo> implements ViewTransportationDAO {

	@Override
	public ResultSet getResultSetOfAll(Connection conn) {
		String sql = "SELECT * FROM `transportation_info`";
		return getResultSet(conn, sql);
	}

}
