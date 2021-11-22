package com.aidsystem.dao;

import java.sql.Connection;
import java.sql.ResultSet;

public interface ViewUnCheckedDemDAO {
	ResultSet getResultSetOfAll(Connection conn);
}
