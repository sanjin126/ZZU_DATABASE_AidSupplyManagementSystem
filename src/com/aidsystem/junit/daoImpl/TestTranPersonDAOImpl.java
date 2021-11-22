package com.aidsystem.junit.daoImpl;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.aidsystem.bean.TranPerson;
import com.aidsystem.dao.Impl.TranPersonDAOImpl;
import com.aidsystem.util.JDBCUtils;

public class TestTranPersonDAOImpl {
	private TranPersonDAOImpl dao = new TranPersonDAOImpl();
	@Test
	public void testInsert() {
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();
			conn.setAutoCommit(false);
			TranPerson trp = new TranPerson(0, "test", null, null, "12344555", null, "豫A12");
			dao.insert(conn, trp);
			System.out.println("commitpre");
			conn.commit();
			System.out.println("commit");
		} catch (Exception e) {
			try {
				conn.rollback();
				System.out.println("rollback");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				conn.setAutoCommit(false);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			JDBCUtils.closeConnection(conn, null);			
		}
	}

	@Test
	public void testDeleteById() throws Exception {
		Connection conn = JDBCUtils.getConnection();
		
		dao.deleteById(conn, 1022);
	}

	@Test
	public void testUpdateTrp() throws Exception {
		Connection conn = JDBCUtils.getConnection();
		TranPerson trp = new TranPerson(1025, "test", "男", 19, "12344555", "西宁", "豫A12332");
		dao.updateTrp(conn, trp);
	}

	@Test
	public void testGetById() throws Exception {
		Connection conn = JDBCUtils.getConnection();
		System.out.println(dao.getById(conn, 1025));
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

}
