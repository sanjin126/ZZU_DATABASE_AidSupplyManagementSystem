package com.aidsystem.junit.daoImpl;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

import com.aidsystem.bean.Organization;
import com.aidsystem.dao.Impl.OrganizationDAOImpl;
import com.aidsystem.util.JDBCUtils;

public class TestOrganizationDAOImpl {
	private OrganizationDAOImpl dao = new OrganizationDAOImpl(); 
	@Test
	public void testInsert() throws Exception {
		Connection conn = JDBCUtils.getConnection();
		Organization org = new Organization(0, null, "测试", "测试", "测试", null);
		dao.insert(conn, org );
	}

	@Test
	public void testDeleteById() throws Exception {
		Connection conn = JDBCUtils.getConnection();
		dao.deleteById(conn, 1011);
	}

	@Test
	public void testUpdateOrg() throws Exception {
		Connection conn = JDBCUtils.getConnection();
		Organization org = new Organization(1012, "test", "测试1", "测试1", "测试1", "test");
		dao.updateOrg(conn, org);
	}

	@Test
	public void testGetById() throws Exception {
		Connection conn = JDBCUtils.getConnection();
		System.out.println(dao.getById(conn, 1003));
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
	@Test //ac
	public void testCheckThroughById() throws Exception {
		Connection conn = JDBCUtils.getConnection();
		Organization org = new Organization(1001, "test3", "郑州大学", "sanjin", "11111111111", "紧急救援");
		dao.checkThroughById(conn, 1012, org );
	}
	
	@Test
	public void testGetOrgIdByDemId() throws Exception{
		Connection conn = JDBCUtils.getConnection();
		System.out.println(dao.getOrgIdByDemId(conn, 10333));
	}
	
	@Test //ac
	public void testGetIdByDirectorAndPhone() throws Exception {
		Connection conn = JDBCUtils.getConnection();
		System.out.println(dao.getIdByDirectorAndPhone(conn, "sanjin", "测试1"));
	}

}
