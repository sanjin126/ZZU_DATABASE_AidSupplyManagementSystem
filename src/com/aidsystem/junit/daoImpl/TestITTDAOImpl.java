package com.aidsystem.junit.daoImpl;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

import com.aidsystem.bean.ItemToType;
import com.aidsystem.dao.Impl.ItemToTypeDAOImpl;
import com.aidsystem.util.JDBCUtils;

public class TestITTDAOImpl {
	private ItemToTypeDAOImpl dao = new ItemToTypeDAOImpl();
	@Test
	public void testInsert() throws Exception {
		Connection conn = JDBCUtils.getConnection();
		ItemToType itt = new ItemToType("test2", "test");
		dao.insert(conn, itt );
	}

	@Test
	public void testDeleteByName() throws Exception {
		Connection conn = JDBCUtils.getConnection();
		dao.deleteByName(conn, "test1");
	}

	@Test
	public void testUpdateItt() throws Exception {
		Connection conn = JDBCUtils.getConnection();
		ItemToType itt = new ItemToType("test2", "test3");
		dao.updateItt(conn, itt);
	}

	@Test
	public void testGetByName() throws Exception {
		Connection conn = JDBCUtils.getConnection();
		System.out.println(dao.getByName(conn, "test2"));
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
