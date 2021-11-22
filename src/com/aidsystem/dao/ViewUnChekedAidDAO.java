package com.aidsystem.dao;

import java.sql.Connection;
import java.sql.ResultSet;

public interface ViewUnChekedAidDAO {
	ResultSet getResultSetOfAll(Connection conn);

}
