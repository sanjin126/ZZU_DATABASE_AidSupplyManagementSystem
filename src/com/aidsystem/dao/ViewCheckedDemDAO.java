package com.aidsystem.dao;

import java.sql.Connection;
import java.sql.ResultSet;

public interface ViewCheckedDemDAO {
	ResultSet getResultSetOfAll(Connection conn);
	
	ResultSet getResultSetOfAllOrderByName(Connection conn);	

}
