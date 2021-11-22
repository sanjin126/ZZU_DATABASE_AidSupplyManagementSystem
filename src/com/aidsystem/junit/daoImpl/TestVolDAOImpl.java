package com.aidsystem.junit.daoImpl;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import com.aidsystem.bean.DBObject;
import com.aidsystem.bean.Volunteer;
import com.aidsystem.dao.BaseDAO;
import com.aidsystem.dao.Impl.VolunteerDAOImpl;
import com.aidsystem.util.JDBCUtils;

public class TestVolDAOImpl {
	VolunteerDAOImpl dao = new VolunteerDAOImpl();

	@Test
	public void testInsertVol() {
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();
			Volunteer vol = new Volunteer(0, "test", "男", 18, "12222222222", "河南郑州");
			dao.insertVol(conn, vol);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JDBCUtils.closeConnection(conn, null);
	}

	@Test
	public void testDeleteVolById() throws Exception {
		Connection conn = JDBCUtils.getConnection();
		dao.deleteVolById(conn, 1016);
	}
	
	@Test
	public void testUpdateVol() throws Exception {
		Connection conn = JDBCUtils.getConnection();
		Volunteer vol = new Volunteer(1016, "test", "女", 20, "13333333333", "河南郑州");
		dao.updateVol(conn , vol );
	}

	@Test
	public void testGetVolById() throws Exception {
		Connection conn = JDBCUtils.getConnection();
		Volunteer volunteer = dao.getVolById(conn, 1010);
		System.out.println(volunteer);

	}

	@Test
	public void testGetAll() throws Exception {
		Connection conn = JDBCUtils.getConnection();
		List<Volunteer> list = dao.getAll(conn);
		list.forEach(System.out::println);
	}

	@Test
	public void testGetVolCount() throws Exception {
		Connection conn = JDBCUtils.getConnection();
		long volCount = dao.getVolCount(conn);
		System.out.println(volCount);
	}

	@Test
	public void testGetRSOfAllVolunteer() throws Exception {
		Connection conn = JDBCUtils.getConnection();
		
		ResultSet rs = dao.getResultSetOfAll(conn);

		if (rs.next()) {
			System.out.println(rs.getObject(1));
			System.out.println(rs.getObject(2));
			System.out.println(rs.getObject(3));
			
		}
//		JDBCUtils.closeConnection(conn, ps, rs);
		if (rs.next()) {
			System.out.println(rs.getObject(1));
			System.out.println(rs.getObject(2));
			System.out.println(rs.getObject(3));
			
		}
	}
}
