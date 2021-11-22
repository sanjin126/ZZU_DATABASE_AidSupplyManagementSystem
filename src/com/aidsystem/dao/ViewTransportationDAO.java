package com.aidsystem.dao;

import java.sql.Connection;
import java.sql.ResultSet;

public interface ViewTransportationDAO {
	ResultSet getResultSetOfAll(Connection conn);

}
