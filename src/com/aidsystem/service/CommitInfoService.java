package com.aidsystem.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.aidsystem.bean.AidSupply;
import com.aidsystem.bean.DemandSupply;
import com.aidsystem.bean.Donator;
import com.aidsystem.bean.Organization;
import com.aidsystem.dao.Impl.AidSupplyDAOImpl;
import com.aidsystem.dao.Impl.DemandSupplyDAOImpl;
import com.aidsystem.dao.Impl.DonatorDAOImpl;
import com.aidsystem.dao.Impl.OrganizationDAOImpl;
import com.aidsystem.util.JDBCUtils;
import com.aidsystem.util.StringUtils;

public class CommitInfoService {
	/**
	 * 
	 * @Description 
	 * @author sanjin
	 * @param donName
	 * @param phone
	 * @param aidName
	 * @param quantity
	 * @param address
	 * @param needCar
	 * @return
	 */
	public static boolean commitAidInfo(String donName, String phone, String aidName, String quantity, String address, int needCar) {
		//需要对数据进行转换
		//1.去除字符串的前后空格，
		//2.从quantity字段中筛选出数字
		//3.判断输入电话号码是否合理，利用正则表达式，最后throw Exception（“message”），交由view端去处理
		Connection conn = null;
		try {
//			System.out.println(donName+"#\n"+phone+"#\n"+aidName+"#\n"+quantity+"#\n"+address+"#\n"+needCar+"#");
			conn = JDBCUtils.getConnection();
			conn.setAutoCommit(false);
			
			DonatorDAOImpl donDao = new DonatorDAOImpl();
			AidSupplyDAOImpl aidDao = new AidSupplyDAOImpl();
			
			Donator don = new Donator(0, StringUtils.removeUnimportantChar(donName), StringUtils.removeUnimportantChar(phone));
			//先判断是否存在一位这样的捐赠者
			Integer isNull = donDao.getIdByNameAndPhone(conn, StringUtils.removeUnimportantChar(donName), StringUtils.removeUnimportantChar(phone));
			if (isNull == null) {
				donDao.insert(conn, don); //插入捐赠者ID
				Integer donId = new Integer(donDao.getLastInsertId(conn).toString()); //获取刚插入的自增ID值
				AidSupply aid = new AidSupply(0, StringUtils.removeUnimportantChar(aidName), StringUtils.getNumberFromString(quantity), StringUtils.removeUnimportantChar(address), null, needCar==1?true:false, donId, null, false, false);
				aidDao.insertAid(conn, aid);
			} else {
				Integer donId = isNull;
				AidSupply aid = new AidSupply(0, StringUtils.removeUnimportantChar(aidName), StringUtils.getNumberFromString(quantity), StringUtils.removeUnimportantChar(address), null, needCar==1?true:false, donId, null, false, false);
				aidDao.insertAid(conn, aid);
				System.out.println(donId);
				System.out.println("已存在");
			}
//			System.out.println(don);
//			System.out.println(aid);
//			System.out.println(donId);
			conn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			JDBCUtils.closeConnection(conn, null);			
		}
		return false;
	}
	/**
	 * 
	 * @Description 
	 * @author sanjin
	 * @param orgName
	 * @param director
	 * @param phone
	 * @param address
	 * @param demName
	 * @param quantity
	 * @param desc
	 * @return
	 */
	public static boolean commitDemInfo(String orgName, String director, String phone, String address, String demName, String quantity, String desc) {
		Connection conn = null;
		try {
//			System.out.println(orgName+"#\n"+director+"#\n"+phone+"#\n"+address+"#\n"+demName+"#\n"+quantity+"#\n"+desc+"#");
			
			conn = JDBCUtils.getConnection();
			conn.setAutoCommit(false); //考虑事务
			
			OrganizationDAOImpl orgDao = new OrganizationDAOImpl();
			DemandSupplyDAOImpl demDao = new DemandSupplyDAOImpl();
			
			Organization org = new Organization(0, StringUtils.removeUnimportantChar(orgName), StringUtils.removeUnimportantChar(address), StringUtils.removeUnimportantChar(director), StringUtils.removeUnimportantChar(phone), StringUtils.removeUnimportantChar(desc));
			//查找是否存在一个这样的组织
			Integer isNull = orgDao.getIdByDirectorAndPhone(conn, StringUtils.removeUnimportantChar(director), StringUtils.removeUnimportantChar(phone));
			if (isNull == null) {
				orgDao.insert(conn, org);
				int orgId = new Integer(orgDao.getLastInsertId(conn).toString());
				DemandSupply demand = new DemandSupply(0, demName, StringUtils.getNumberFromString(quantity), null, orgId , null, false, false);
				demDao.insertDemand(conn, demand);
			} else {
				int orgId = isNull;
				DemandSupply demand = new DemandSupply(0, demName, StringUtils.getNumberFromString(quantity), null, orgId , null, false, false);
				demDao.insertDemand(conn, demand);
				System.out.println(orgId);
				System.out.println("已存在");
			}
			conn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			JDBCUtils.closeConnection(conn, null);
		}
		return false;
		
	}
}
