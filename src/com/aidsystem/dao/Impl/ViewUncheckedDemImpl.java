package com.aidsystem.dao.Impl;

import java.sql.Connection;
import java.sql.ResultSet;

import com.aidsystem.bean.UnCheckedDemSupply;
import com.aidsystem.dao.BaseDAO;
import com.aidsystem.dao.ViewUnCheckedDemDAO;

public class ViewUncheckedDemImpl extends BaseDAO<UnCheckedDemSupply> implements ViewUnCheckedDemDAO {

	@Override
	public ResultSet getResultSetOfAll(Connection conn) {
		
		String sql = "SELECT * FROM unchecked_demsupply";
		return getResultSet(conn, sql);
	}

}
