package com.aidsystem.dao.Impl;

import java.sql.Connection;
import java.sql.ResultSet;

import com.aidsystem.bean.UnCheckedAidSupply;
import com.aidsystem.dao.BaseDAO;
import com.aidsystem.dao.ViewUnChekedAidDAO;

public class ViewUnCheckedAidImpl extends BaseDAO<UnCheckedAidSupply> implements ViewUnChekedAidDAO {

	@Override
	public ResultSet getResultSetOfAll(Connection conn) {
		String sql = "SELECT * FROM unchecked_aidsupply";
		return getResultSet(conn, sql );
	}

}
