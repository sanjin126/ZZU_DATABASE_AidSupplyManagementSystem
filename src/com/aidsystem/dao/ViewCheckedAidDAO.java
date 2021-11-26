package com.aidsystem.dao;

import java.sql.Connection;
import java.sql.ResultSet;

public interface ViewCheckedAidDAO {
	ResultSet getResultSetOfAll(Connection conn);
	
	ResultSet getResultSetOfALLOrderByName(Connection conn);

}
