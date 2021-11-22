package com.aidsystem.dao.Impl;

import java.sql.Connection;
import java.util.List;

import com.aidsystem.bean.Transportation;
import com.aidsystem.dao.BaseDAO;
import com.aidsystem.dao.TransportationDAO;

public class TransportationDAOImpl extends BaseDAO<Transportation> implements TransportationDAO {

	/**
	 * 此时必须传入一个aid_id
	 * @author sanjin
	 */
	@Override
	public void insert(Connection conn, Transportation trans) {
		String sql = "insert into transportation values(?,?,?,?)";
		update(conn, sql, trans.getAidId(),trans.getTrpId(),trans.getDemId(),trans.isStatus());
	}

	@Override
	public void deleteByAidId(Connection conn, int aidId) {
//		String sql = "delete from transportation where aid_id=?";
//		update(conn, sql , aidId);
	}

	@Override
	public void updateTrans(Connection conn, Transportation trans) {
//		String sql = "update transportation set tran_per_id=?,org_id=?,status=? where aid_id=?";
//		update(conn, sql , trans.getTrpId(),trans.getOrgId(),trans.isStatus(),trans.getAidId());
	}

	@Override
	public Transportation getByAidId(Connection conn, int aidId) {
		return null;
//		String sql = "select aid_id aidId,tran_per_id trpId,org_id orgId,status from transportation where aid_id=?";
//		return query(conn, sql , aidId);
	}

	@Override
	public List<Transportation> getAll(Connection conn) {
		return null;
//		String sql = "select aid_id aidId,tran_per_id trpId,org_id orgId,status from transportation";
//		return queryList(conn, sql);
	}

	@Override
	public long getCount(Connection conn) {
		String sql = "select count(*) from transportation";
		return getValue(conn, sql);
	}

	@Override
	public void successByAidId(Connection conn, int aidId) {
		String sql = "update transportation set status=? where aid_id=?";
		update(conn, sql , true, aidId);
		
	}

}
