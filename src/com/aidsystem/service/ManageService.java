package com.aidsystem.service;

import java.sql.Connection;

import com.aidsystem.bean.TranPerson;
import com.aidsystem.bean.Volunteer;
import com.aidsystem.dao.Impl.TranPersonDAOImpl;
import com.aidsystem.dao.Impl.VolunteerDAOImpl;
import com.aidsystem.util.JDBCUtils;
import com.aidsystem.util.StringUtils;

public class ManageService {
	public static void addVol(String name, String gender, String age, String phone, String address) {
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();
			VolunteerDAOImpl volDao = new VolunteerDAOImpl();
			Integer newAge = StringUtils.removeUnimportantChar(age)==null?null:new Integer(StringUtils.removeUnimportantChar(age));
			Volunteer vol = new Volunteer(0, 
					StringUtils.removeUnimportantChar(name), 
					StringUtils.removeUnimportantChar(gender), 
					newAge, 
					StringUtils.removeUnimportantChar(phone), 
					StringUtils.removeUnimportantChar(address)
					);
			volDao.insertVol(conn, vol);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.closeConnection(conn, null);
			
		}
	}
	public static void deleteVol(String id) {
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();
			VolunteerDAOImpl volDao = new VolunteerDAOImpl();
			int newId = new Integer(id);
			volDao.deleteVolById(conn, newId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.closeConnection(conn, null);
			
		}
	}
	public static void updateVol(String id, String name, String gender, String age, String phone, String address) {
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();
			VolunteerDAOImpl volDao = new VolunteerDAOImpl();
			int newId = StringUtils.removeUnimportantChar(age)==null?null:new Integer(StringUtils.removeUnimportantChar(id));
			Integer newAge = new Integer(StringUtils.removeUnimportantChar(age));
			Volunteer vol = new Volunteer(newId, 
					StringUtils.removeUnimportantChar(name), 
					StringUtils.removeUnimportantChar(gender), 
					newAge, 
					StringUtils.removeUnimportantChar(phone), 
					StringUtils.removeUnimportantChar(address)
					);
			volDao.updateVol(conn, vol);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.closeConnection(conn, null);
			
		}
	}
	
	public static void addTrp(String name, String gender, String age, String phone, String area, String numberPlate) {
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();
			Integer newAge = StringUtils.removeUnimportantChar(age)==null?null:new Integer(StringUtils.removeUnimportantChar(age));
			TranPerson trp = new TranPerson(0, 
					StringUtils.removeUnimportantChar(name), 
					StringUtils.removeUnimportantChar(gender), 
					newAge, 
					StringUtils.removeUnimportantChar(phone), 
					StringUtils.removeUnimportantChar(area), 
					StringUtils.removeUnimportantChar(numberPlate)
					);
			TranPersonDAOImpl trpDao = new TranPersonDAOImpl();
			trpDao.insert(conn, trp);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.closeConnection(conn, null);
			
		}
		
	}
	public static void deleteTrp(String id) {
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();
			TranPersonDAOImpl trpDao = new TranPersonDAOImpl();
			int newId = new Integer(StringUtils.removeUnimportantChar(id));
			trpDao.deleteById(conn, newId );
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.closeConnection(conn, null);
			
		}
		
	}
	public static void updateTrp(String id, String name, String gender, String age, String phone, String area, String numberPlate) {
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();
			TranPersonDAOImpl trpDao = new TranPersonDAOImpl();
			Integer newId = new Integer(id);
			Integer newAge = StringUtils.removeUnimportantChar(age)==null?null:new Integer(StringUtils.removeUnimportantChar(age));
			TranPerson trp = new TranPerson(newId, 
					StringUtils.removeUnimportantChar(name), 
					StringUtils.removeUnimportantChar(gender), 
					newAge, 
					StringUtils.removeUnimportantChar(phone), 
					StringUtils.removeUnimportantChar(area), 
					StringUtils.removeUnimportantChar(numberPlate)
					);
			trpDao.updateTrp(conn, trp);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.closeConnection(conn, null);
			
		}
		
	}
	

}