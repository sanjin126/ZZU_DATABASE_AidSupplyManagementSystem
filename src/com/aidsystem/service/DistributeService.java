package com.aidsystem.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.aidsystem.bean.Transportation;
import com.aidsystem.dao.Impl.AidSupplyDAOImpl;
import com.aidsystem.dao.Impl.DemandSupplyDAOImpl;
import com.aidsystem.dao.Impl.OrganizationDAOImpl;
import com.aidsystem.dao.Impl.TransportationDAOImpl;
import com.aidsystem.util.JDBCUtils;

public class DistributeService {
	
	private static TransportationDAOImpl transDao = new TransportationDAOImpl();
	private static OrganizationDAOImpl orgDao = new OrganizationDAOImpl();
	private static AidSupplyDAOImpl aidDao = new AidSupplyDAOImpl();
	private static DemandSupplyDAOImpl demDao = new DemandSupplyDAOImpl();
	
	public static void distribute(int aidId, int demId, Integer trpId) {
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();
			conn.setAutoCommit(false);
			Transportation trans = new Transportation(aidId, trpId, demId, false);
			transDao.insert(conn, trans);
//			aidDao.transById(conn, aidId);
//			demDao.transById(conn, demId); //通过触发器实现
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		JDBCUtils.closeConnection(conn, null);
	}

}
