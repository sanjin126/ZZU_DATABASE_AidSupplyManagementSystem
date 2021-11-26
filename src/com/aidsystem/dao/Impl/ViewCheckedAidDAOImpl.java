package com.aidsystem.dao.Impl;

import java.sql.Connection;
import java.sql.ResultSet;

import com.aidsystem.bean.CheckedAidSupply;
import com.aidsystem.dao.BaseDAO;
import com.aidsystem.dao.ViewCheckedAidDAO;

public class ViewCheckedAidDAOImpl extends BaseDAO<CheckedAidSupply> implements ViewCheckedAidDAO {

	@Override
	public ResultSet getResultSetOfAll(Connection conn) {
		String sql = "SELECT * FROM checked_aidsupply";
		return getResultSet(conn, sql);
	}

	@Override
	public ResultSet getResultSetOfALLOrderByName(Connection conn) {
		String sql = "SELECT * FROM checked_aidsupply ORDER BY CONVERT(捐赠物资 USING gbk) COLLATE gbk_chinese_ci";
		return getResultSet(conn, sql);
	}

}
