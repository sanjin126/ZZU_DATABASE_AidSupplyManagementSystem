package com.aidsystem.junit.daoImpl;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.sql.Connection;

import org.junit.Test;

import com.aidsystem.bean.Donator;
import com.aidsystem.dao.Impl.DonatorDAOImpl;
import com.aidsystem.util.JDBCUtils;

public class TestDonatorDAOImpl {

	private DonatorDAOImpl dao = new DonatorDAOImpl();
	@Test
	public void testInsert() throws Exception {
		Connection conn = JDBCUtils.getConnection();
		Donator don = new Donator(0, "test", "1111111111");
		dao.insert(conn, don);
		BigInteger lastInsertId = dao.getLastInsertId(conn);
		System.out.println(lastInsertId);
	}

	@Test
	public void testDeleteById() throws Exception {
		Connection conn = JDBCUtils.getConnection();
		dao.deleteById(conn, 1011);
	}

	@Test
	public void testUpdateDonator() throws Exception {
		Connection conn = JDBCUtils.getConnection();
		Donator don = new Donator(1012, "test", "22222222222");
		dao.updateDonator(conn, don);
	}

	@Test
	public void testGetById() throws Exception {
		Connection conn = JDBCUtils.getConnection();
		System.out.println(dao.getById(conn, 1002));
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
	public void testGetLastInsertId() throws Exception {
		Connection conn = JDBCUtils.getConnection();
		BigInteger lastInsertId = dao.getLastInsertId(conn);
		System.out.println(lastInsertId);

	}
	
	@Test
	public void testGetIdByNameAndPhone() throws Exception {
		Connection conn = JDBCUtils.getConnection();
		System.out.println(dao.getIdByNameAndPhone(conn, "三金", "1111"));
	}

}
