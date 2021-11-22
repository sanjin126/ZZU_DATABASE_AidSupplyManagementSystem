package com.aidsystem.junit.daoImpl;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

import com.aidsystem.bean.User;
import com.aidsystem.dao.Impl.UserDAOImpl;
import com.aidsystem.util.JDBCUtils;

public class TestUserDAOImpl {
	private UserDAOImpl dao = new UserDAOImpl();
	@Test
	public void testInsert() throws Exception {
		Connection conn = JDBCUtils.getConnection();
		User user = new User(0, "test", "123456", 1009);
	}

	@Test
	public void testDeleteById() throws Exception {
		Connection conn = JDBCUtils.getConnection();
		dao.deleteById(conn, 1);
	}

	@Test
	public void testUpdateUsr() throws Exception {
		Connection conn = JDBCUtils.getConnection();
		User user = new User(2, "root", "123", 1008);
		dao.updateUsr(conn, user);
	}

	@Test
	public void testGetById() throws Exception {
		Connection conn = JDBCUtils.getConnection();
		System.out.println(dao.getById(conn, 2));
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
