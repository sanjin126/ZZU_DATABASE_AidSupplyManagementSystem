package com.aidsystem.dao.Impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.List;

import com.aidsystem.bean.DBObject;
import com.aidsystem.bean.DemandSupply;
import com.aidsystem.dao.BaseDAO;
import com.aidsystem.dao.DemandSupplyDAO;

public class DemandSupplyDAOImpl extends BaseDAO<DemandSupply> implements DemandSupplyDAO {

	@Override
	public void insertDemand(Connection conn, DemandSupply demand) {
		String sql = "insert into demand_supply values(?,?,?,?,?,?,?,?,?)";
		update(conn, sql, null,demand.getName(),demand.getQuantity(),new Timestamp(new java.util.Date().getTime()),demand.getDescription(),demand.getOrgId(),demand.getVolId(),demand.isCheckStatus(),demand.isStatus());
	}

	@Override
	public void deleteDemandById(Connection conn, int id) {
		String sql = "delete from demand_supply where id=?";
		update(conn, sql, id);
	}

	@Override
	public void updateDemand(Connection conn, DemandSupply demand) {
		String sql = "update demand_supply set name=?,quantity=?,demand_date=?,description=?,org_id=?,vol_id=?,check_status=?,status=? "
				+ "where id=?";
		update(conn, sql , demand.getName(),demand.getQuantity(),demand.getDemandDate(),demand.getDescription(),demand.getOrgId(),demand.getVolId(),demand.isCheckStatus(),demand.isStatus(),demand.getId());
	}

	@Override
	public DemandSupply getDemandById(Connection conn, int id) {
		String sql = "select id,name,quantity,demand_date demandDate,description,org_id orgId,vol_id volId,check_status checkStatus,status from demand_supply where id=?";
		return query(conn, sql, id);
		
	}

	@Override
	public List<DemandSupply> getAll(Connection conn) {
		String sql = "select id,name,quantity,demand_date demandDate,description,org_id orgId,vol_id volId,check_status checkStatus,status from demand_supply";
		return queryList(conn, sql);
	}

	@Override
	public long getCount(Connection conn) {
		String sql = "select count(*) from demand_supply";
		return getValue(conn, sql);
	
	}
	/**
	 * @desc 可更新的字段值：name=?,quantity=?,description,org_id=?,vol_id=?,check_status=?
	 * @author sanjin
	 */
	@Override
	public void checkthroughById(Connection conn, int id, DemandSupply dem) {
		String sql = "update demand_supply set name=?,quantity=?,description=?,vol_id=?,check_status=? "
				+ "where id=?";
		update(conn, sql , dem.getName(),dem.getQuantity(),dem.getDescription(),dem.getVolId(),true,dem.getId());
		
	}
	
	@Override
	public void transById(Connection conn, int id) {
		String sql = "update demand_supply set status=? "
				+ "where id=?";
		update(conn, sql , true, id);
	}

	@Override
	public ResultSet getResultSetOfUncheckedDem(Connection conn) {
		String sql = "select * from demand_supply where check_status = 0";
		return getResultSet(conn, sql);
	}

	@Override
	public ResultSet getResultSetOfCheckedDem(Connection conn) {
		String sql = "select * from demand_supply where check_status = 1";
		return getResultSet(conn, sql);
	}

}
