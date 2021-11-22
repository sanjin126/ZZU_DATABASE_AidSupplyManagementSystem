package com.aidsystem.service;

import java.sql.Connection;

import com.aidsystem.dao.Impl.TransportationDAOImpl;
import com.aidsystem.util.JDBCUtils;

public class TransSuccessService {
	/**
	 * 
	 * @Description 当调用此服务后，可更改对应运输信息的运输状态为到达
	 * @author sanjin
	 * @param aidId
	 */
	public static void successByAidId(int aidId) {
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();
			TransportationDAOImpl transDao = new TransportationDAOImpl();
			transDao.successByAidId(conn, aidId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeConnection(conn, null);			
		}
	}

}
