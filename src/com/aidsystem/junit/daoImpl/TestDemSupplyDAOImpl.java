package com.aidsystem.junit.daoImpl;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.aidsystem.bean.DemandSupply;
import com.aidsystem.dao.Impl.DemandSupplyDAOImpl;
import com.aidsystem.util.JDBCUtils;

public class TestDemSupplyDAOImpl {

	private DemandSupplyDAOImpl dao = new DemandSupplyDAOImpl();

	@Test
	public void testInsertDemand() throws Exception {
		Connection conn = JDBCUtils.getConnection();
		DemandSupply demand = new DemandSupply(0, "test", null, new Timestamp(new Date().getTime()),null, 1001, null, false, false);
		dao.insertDemand(conn, demand);
	}

	@Test
	public void testDeleteDemandById() throws Exception {
		Connection conn = JDBCUtils.getConnection();
		dao.deleteDemandById(conn, 15);
	}

	@Test
	public void testUpdateDemand() throws Exception {
		Connection conn = JDBCUtils.getConnection();
		DemandSupply demand = new DemandSupply(1, "test", null, new Timestamp(new Date().getTime()),"", 1002, null, false, false);
		dao.updateDemand(conn, demand);
	}

	@Test
	public void testGetDemandById() throws Exception {
		Connection conn = JDBCUtils.getConnection();
		System.out.println(dao.getDemandById(conn, 13));
	}

	@Test
	public void testGetAll() throws Exception {
		Connection conn = JDBCUtils.getConnection();
		List<DemandSupply> list = dao.getAll(conn);
		list.forEach(System.out::println);
	}

	@Test
	public void testGetDemandCount() throws Exception {
		Connection conn = JDBCUtils.getConnection();
		System.out.println(dao.getCount(conn));
	}

}
