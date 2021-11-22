package com.aidsystem.service;

import java.sql.Connection;

import com.aidsystem.bean.AidSupply;
import com.aidsystem.bean.DemandSupply;
import com.aidsystem.bean.Organization;
import com.aidsystem.dao.Impl.AidSupplyDAOImpl;
import com.aidsystem.dao.Impl.DemandSupplyDAOImpl;
import com.aidsystem.dao.Impl.OrganizationDAOImpl;
import com.aidsystem.util.JDBCUtils;

/**
 * 
 * @Description 用于处理救援物资以及需求物资的审核
 * @author sanjin
 * @version
 * @date 2021年11月18日上午11:09:36
 *
 */
public class CheckService {
	
	/**
	 * 
	 * @Description 可修改的字段：name=?,quantity=?,address=?,need_transport=?,vol_id=?,check_status=? where id=?
	 * @author sanjin
	 * @param id
	 * @param success
	 * @param aid
	 */
	public static void checkAidSupplyService(int aidId, boolean success, AidSupply aid) {
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();
			AidSupplyDAOImpl aidDao = new AidSupplyDAOImpl();
			if (success) {
				aidDao.checkthroughById(conn, aidId, aid);
			} else {
				aidDao.deleteAidById(conn, aidId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.closeConnection(conn, null);
		}
	}
	/**
	 * 
	 * 可更新的字段值：demand:name=?,quantity=?,vol_id=?,check_status=?
	 * 			   Organization:name=?,address=?,director=?,description=?
	 * @author sanjin
	 * @param id
	 * @param success
	 * @param dem
	 */
	public static void checkDemSupplyService(int demId, int orgId, boolean success, DemandSupply dem, Organization org) {
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();
			DemandSupplyDAOImpl demDao = new DemandSupplyDAOImpl();
			OrganizationDAOImpl orgDao = new OrganizationDAOImpl();
			if (success) {
				demDao.checkthroughById(conn, demId, dem);
				orgDao.checkThroughById(conn, orgId, org);
			} else {
				demDao.deleteDemandById(conn, demId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.closeConnection(conn, null);
		}
	}

}
