package com.aidsystem.dao.Impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.List;

import com.aidsystem.bean.AidSupply;
import com.aidsystem.bean.DBObject;
import com.aidsystem.dao.AidSupplyDAO;
import com.aidsystem.dao.BaseDAO;

public class AidSupplyDAOImpl extends BaseDAO<AidSupply> implements AidSupplyDAO {
	/**
	 * 
	 * @author sanjin
	 */
	@Override
	public void insertAid(Connection conn, AidSupply aid) {
		String sql = "insert into aid_supply values(?,?,?,?,?,?,?,?,?,?)";
		update(conn, sql, null, aid.getName(), aid.getQuantity(), aid.getAddress(), new Timestamp(new java.util.Date().getTime()),aid.isNeedTransport(),aid.getDonId(),aid.getVolId(),aid.isCheckStatus(),aid.isStatus());
	}
	/**
	 * 
	 * @author sanjin
	 */
	@Override
	public void deleteAidById(Connection conn, int id) {
		String sql = "delete from aid_supply where id=?";
		update(conn, sql , id);
	}
	/**
	 * 
	 * @author sanjin
	 */
	@Override
	public void updateAid(Connection conn, AidSupply aid) {
		String sql = "update aid_supply set name=?,quantity=?,address=?,aid_date=?,need_transport=?,don_id=?,vol_id=?,check_status=?,status=? where id=?";
		update(conn, sql, aid.getName(),aid.getQuantity(),aid.getAddress(),aid.getAidDate(),aid.isNeedTransport(),aid.getDonId(),aid.getVolId(),aid.isCheckStatus(),aid.isStatus(),aid.getId());
	}

	@Override
	public AidSupply getAidById(Connection conn, int id) {
		String sql = "select id,name,quantity,address,aid_date aidDate,need_transport needTransport,don_id donId,vol_id volId,check_status checkStatus,status "
				+ "from aid_supply where id=?";
		return query(conn, sql, id);

	}

	@Override
	public List<AidSupply> getAll(Connection conn) {
		String sql = "select id,name,quantity,address,aid_date aidDate,need_transport needTransport,don_id donId,vol_id volId,check_status checkStatus,status from aid_supply";
		return queryList(conn, sql);
		
	}
	
	@Override
	public long getCount(Connection conn) {
		String sql = "select count(*) from aid_supply";
		return getValue(conn, sql);
		
	}
	/**
	 * @Description 可修改的字段：name=?,quantity=?,address=?,need_transport=?,vol_id=?,check_status=? where id=?
	 * @author sanjin
	 */
	@Override
	public void checkthroughById(Connection conn, int id, AidSupply aid) {
		String sql = "update aid_supply set name=?,quantity=?,address=?,need_transport=?,vol_id=?,check_status=? where id=?";
//		String sql = "update aid_supply set check_status=1 where id=?";
		update(conn, sql, aid.getName(),aid.getQuantity(),aid.getAddress(),aid.isNeedTransport(),aid.getVolId(),true,id);
		
	}
	
	@Override
	public void transById(Connection conn, int id) {
		String sql = "update aid_supply set status=? where id=?";
		update(conn, sql, true, id);
	}
	@Deprecated
	@Override
	public ResultSet getResultSetOfUncheckedAid(Connection conn) {
		String sql = "select * from aid_supply where check_status = 0";
		return getResultSet(conn, sql);
		
	}
	@Deprecated
	@Override
	public ResultSet getResultSetOfCheckedAid(Connection conn) {
		String sql = "select * from aid_supply where check_status = 1";
		return getResultSet(conn, sql);
	}

}
