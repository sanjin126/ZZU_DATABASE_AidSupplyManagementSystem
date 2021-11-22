package com.aidsystem.junit.daoImpl;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

import com.aidsystem.bean.Transportation;
import com.aidsystem.dao.Impl.TransportationDAOImpl;
import com.aidsystem.util.JDBCUtils;

public class TestTransportationDAOImpl {
	private TransportationDAOImpl dao = new TransportationDAOImpl();
	@Test
	public void testInsert() throws Exception {
		Connection conn = JDBCUtils.getConnection();
		Transportation trans = new Transportation(10004, 1001, 1001, false);
		dao.insert(conn, trans );
	}

	@Test
	public void testDeleteByAidId() throws Exception {
		Connection conn = JDBCUtils.getConnection();
		dao.deleteByAidId(conn, 10001);
	}

	@Test
	public void testUpdateTrans() throws Exception {
		Connection conn = JDBCUtils.getConnection();
		Transportation trans = new Transportation(10002, 1001, 1001, true);
		dao.updateTrans(conn, trans);
	}

	@Test
	public void testGetByAidId() throws Exception {
		Connection conn = JDBCUtils.getConnection();
		System.out.println(dao.getByAidId(conn, 10004));
		
	}

	@Test
	public void testGetAll() throws Exception {
		Connection conn = JDBCUtils.getConnection();
		dao.getAll(conn).forEach(System.out::println);
	}

	@Test
	public void testGetCount() throws Exception {
		Connection conn = JDBCUtils.getConnection();
		System.out.println(dao.getCount(conn));
	}
	
	@Test
	public void testSuccessById() throws Exception {
		Connection conn = JDBCUtils.getConnection();
		dao.successByAidId(conn, 10004);
	}

}
