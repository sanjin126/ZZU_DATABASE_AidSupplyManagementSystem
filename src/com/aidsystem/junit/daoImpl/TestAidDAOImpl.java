package com.aidsystem.junit.daoImpl;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.Timestamp;
import java.util.List;


import org.junit.Test;

import com.aidsystem.bean.AidSupply;
import com.aidsystem.dao.Impl.AidSupplyDAOImpl;
import com.aidsystem.util.JDBCUtils;

public class TestAidDAOImpl {

	private AidSupplyDAOImpl dao = new AidSupplyDAOImpl(); 
	@Test
	public void testInsertAid() throws Exception {
		Connection conn = JDBCUtils.getConnection();
		AidSupply aid = new AidSupply(0, "test", null, "", new Timestamp(new java.util.Date().getTime()), false, null, null, false, false);
		dao.insertAid(conn, aid);
		JDBCUtils.closeConnection(conn, null);
	}

	@Test
	public void testDeleteAidById() throws Exception {
		Connection conn = JDBCUtils.getConnection();
		dao.deleteAidById(conn, 10014);
	}

	@Test
	public void testUpdateAid() throws Exception {
		Connection conn = JDBCUtils.getConnection();
		AidSupply aid = new AidSupply(10015, "test", null, null, new Timestamp(new java.util.Date().getTime()), false, null, null, false, false);
		dao.updateAid(conn, aid);
	}

	@Test
	public void testGetAidById() throws Exception {
		Connection conn = JDBCUtils.getConnection();
		AidSupply aidById = dao.getAidById(conn, 10001);
		System.out.println(aidById);
	}

	@Test
	public void testGetAll() throws Exception {
		Connection conn = JDBCUtils.getConnection();
		List<AidSupply> list = dao.getAll(conn);
		list.forEach(System.out::println);
	}

	@Test
	public void testGetAidCount() throws Exception {
		Connection conn = JDBCUtils.getConnection();
		System.out.println(dao.getCount(conn));
	}
	@Test //ac
	public void testCheckthroughById() throws Exception {
		Connection conn = JDBCUtils.getConnection();
		dao.checkthroughById(conn, 10003, new AidSupply(0, "火腿肠", 300, "新乡市新一街中学对面", null, true, null, 1008, true, false));
	}

}
