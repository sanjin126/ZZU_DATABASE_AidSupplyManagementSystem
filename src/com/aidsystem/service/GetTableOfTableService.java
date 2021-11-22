package com.aidsystem.service;

import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import com.aidsystem.bean.DBObject;
import com.aidsystem.dao.Impl.AidSupplyDAOImpl;
import com.aidsystem.dao.Impl.DemandSupplyDAOImpl;
import com.aidsystem.dao.Impl.TranPersonDAOImpl;
import com.aidsystem.dao.Impl.ViewCheckedAidDAOImpl;
import com.aidsystem.dao.Impl.ViewCheckedDemDAOImpl;
import com.aidsystem.dao.Impl.ViewTransportationDAOImpl;
import com.aidsystem.dao.Impl.ViewUnCheckedAidImpl;
import com.aidsystem.dao.Impl.ViewUncheckedDemImpl;
import com.aidsystem.dao.Impl.VolunteerDAOImpl;
import com.aidsystem.util.JDBCUtils;
import com.aidsystem.view.volunteer.ResultSetTableModel;

public class GetTableOfTableService {
	private static Connection conn = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	public static String[] uncheckedaidName = {"物资ID","捐赠物资","数量","捐赠者ID","捐赠者","联系电话","物资所在地","是否需要提供运输","审核状态"};  //填表名
	public static String[] checkedaidName = {"物资ID","捐赠物资","数量","捐赠者","联系电话","物资所在地","是否需要提供运输","审核志愿者ID"};  //填表名
	public static String[] uncheckeddemName = {"物资ID","需求物资","数量","组织ID","组织名称","组织地址","负责人","联系电话","备注","审核状态"};  //填表名
	public static String[] checkeddemName = {"物资ID","需求物资","数量","组织名称","组织地址","负责人","联系电话","备注","审核志愿者ID"};  //填表名
	public static String[] tranInfo = {"运输物资ID","运输物资","运输人员","运输人员联系方式","车牌号","运输目的地","接受组织","组织负责人","组织联系方式","是否到达目的地"};
	public static String[] transPerson = {"人员ID","姓名","性别","年龄","电话","负责区域","车牌号"};
	public static String[] volunteer  = {"志愿者ID","姓名","性别","年龄","电话","住址"};
	/**
	 * 
	 * @Description 
	 * @author sanjin
	 * @param jf
	 * @return
	 */
	public static JTable getUncheckedAidSupply(JFrame jf) {
		JDBCUtils.closeConnection(conn, ps, null);
		
		try {
			
			conn = JDBCUtils.getConnection();
//			AidSupplyDAOImpl aidDao = new AidSupplyDAOImpl();
//			ResultSet rs = aidDao.getResultSetOfUncheckedAid(conn);
			ViewUnCheckedAidImpl unaidDao = new ViewUnCheckedAidImpl();
			ResultSet rs = unaidDao.getResultSetOfAll(conn);

			ResultSetTableModel dm = new ResultSetTableModel(rs, uncheckedaidName);
			JTable table = new JTable(dm);
//			table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.getTableHeader().setFont(new Font("宋体", Font.BOLD, 15));
			table.setFont(new Font("微软雅黑", Font.PLAIN, 14));
			return table;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//当关闭窗口时，关闭连接
			jf.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					JDBCUtils.closeConnection(conn, ps, rs);
				}
			});
		}
		return null;
	}
	/**
	 * 
	 * @Description 
	 * @author sanjin
	 * @param jf
	 * @return
	 */
	public static JTable getUncheckedDemSupply(JFrame jf) {
		JDBCUtils.closeConnection(conn, ps, null); //每次调用此方法时关闭一次连接，再重新获取更新的数据
		try {
			conn = JDBCUtils.getConnection();
//			DemandSupplyDAOImpl demDao = new DemandSupplyDAOImpl();
//			ResultSet rs = demDao.getResultSetOfUncheckedDem(conn);
			ViewUncheckedDemImpl unDemDao = new ViewUncheckedDemImpl();
			ResultSet rs = unDemDao.getResultSetOfAll(conn);
			ResultSetTableModel dm = new ResultSetTableModel(rs, uncheckeddemName);
			JTable table = new JTable(dm);
			table.getTableHeader().setFont(new Font("宋体", Font.BOLD, 15));
			table.setFont(new Font("微软雅黑", Font.PLAIN, 14));
			return table;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jf.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					JDBCUtils.closeConnection(conn, ps, rs);
				}
			});
		}
		return null;
	}
	/**
	 * 
	 * @Description 
	 * @author sanjin
	 * @param jf
	 * @return
	 */
	public static JTable getCheckedAidSupply(JFrame jf) {
		JDBCUtils.closeConnection(conn, ps, null);
		
		try {
			
			conn = JDBCUtils.getConnection();
//			AidSupplyDAOImpl aidDao = new AidSupplyDAOImpl();
//			ResultSet rs = aidDao.getResultSetOfCheckedAid(conn);
			ViewCheckedAidDAOImpl aidDao = new ViewCheckedAidDAOImpl();
			ResultSet rs = aidDao.getResultSetOfAll(conn);
			ResultSetTableModel dm = new ResultSetTableModel(rs, checkedaidName);
			JTable table = new JTable(dm);
			table.getTableHeader().setFont(new Font("宋体", Font.BOLD, 15));
			table.setFont(new Font("微软雅黑", Font.PLAIN, 14));
			return table;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//当关闭窗口时，关闭连接
			jf.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					JDBCUtils.closeConnection(conn, ps, rs);
				}
			});
		}
		return null;
		
	}
	/**
	 * 
	 * @Description 
	 * @author sanjin
	 * @param jf
	 * @return
	 */
	public static JTable getCheckedDemSupply(JFrame jf) {
		JDBCUtils.closeConnection(conn, ps, null); //每次调用此方法时关闭一次连接，再重新获取更新的数据
		try {
			conn = JDBCUtils.getConnection();
//			DemandSupplyDAOImpl demDao = new DemandSupplyDAOImpl();
//			ResultSet rs = demDao.getResultSetOfCheckedDem(conn);
			ViewCheckedDemDAOImpl demDao = new ViewCheckedDemDAOImpl();
			ResultSet rs = demDao.getResultSetOfAll(conn);
			ResultSetTableModel dm = new ResultSetTableModel(rs, checkeddemName);
			JTable table = new JTable(dm);
			table.getTableHeader().setFont(new Font("宋体", Font.BOLD, 15));
			table.setFont(new Font("微软雅黑", Font.PLAIN, 14));
			return table;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jf.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					JDBCUtils.closeConnection(conn, ps, rs);
				}
			});
		}
		return null;
		
	}
	
	public static JTable getTransportationInfo(JFrame jf) {
		JDBCUtils.closeConnection(conn, ps, null); //每次调用此方法时关闭一次连接，再重新获取更新的数据
		try {
			conn = JDBCUtils.getConnection();
			ViewTransportationDAOImpl tranDao = new ViewTransportationDAOImpl();
			ResultSet rs = tranDao.getResultSetOfAll(conn);

			ResultSetTableModel dm = new ResultSetTableModel(rs, tranInfo);
			JTable table = new JTable(dm);
			table.getTableHeader().setFont(new Font("宋体", Font.BOLD, 15));
			table.setFont(new Font("微软雅黑", Font.PLAIN, 14));
			return table;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jf.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					JDBCUtils.closeConnection(conn, ps, rs);
				}
			});
		}
		return null;
	}
	
	
	public static JTable getTransPersonInfo(JFrame jf) {
		JDBCUtils.closeConnection(conn, ps, null); //每次调用此方法时关闭一次连接，再重新获取更新的数据
		try {
			conn = JDBCUtils.getConnection();
			TranPersonDAOImpl trPersonDao = new TranPersonDAOImpl();
			ResultSet rs = trPersonDao.getResultSetOfAll(conn);

			ResultSetTableModel dm = new ResultSetTableModel(rs, transPerson);
			JTable table = new JTable(dm);
			table.getTableHeader().setFont(new Font("宋体", Font.BOLD, 15));
			table.setFont(new Font("微软雅黑", Font.PLAIN, 14));
			return table;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jf.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					JDBCUtils.closeConnection(conn, ps, rs);
				}
			});
		}
		return null;
	}
	
	public static JTable getFreeTransPersonInfo(JFrame jf) {
		JDBCUtils.closeConnection(conn, ps, null); //每次调用此方法时关闭一次连接，再重新获取更新的数据
		try {
			conn = JDBCUtils.getConnection();
			TranPersonDAOImpl trPersonDao = new TranPersonDAOImpl();
			ResultSet rs = trPersonDao.getResultSetOfFreePerson(conn);

			ResultSetTableModel dm = new ResultSetTableModel(rs, transPerson);
			JTable table = new JTable(dm);
			table.getTableHeader().setFont(new Font("宋体", Font.BOLD, 15));
			table.setFont(new Font("微软雅黑", Font.PLAIN, 14));
			return table;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jf.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					JDBCUtils.closeConnection(conn, ps, rs);
				}
			});
		}
		return null;
	}
	/**
	 * 
	 * @Description 获取志愿者信息表格
	 * @author sanjin
	 * @param jf
	 * @return
	 */
	public static JTable getVolunteerInfo(JFrame jf) {
		JDBCUtils.closeConnection(conn, ps, null); //每次调用此方法时关闭一次连接，再重新获取更新的数据
		try {
			conn = JDBCUtils.getConnection();
			VolunteerDAOImpl volDao = new VolunteerDAOImpl();
			ResultSet rs = volDao.getResultSetOfAll(conn);

			ResultSetTableModel dm = new ResultSetTableModel(rs, volunteer);
			JTable table = new JTable(dm);
			table.getTableHeader().setFont(new Font("宋体", Font.BOLD, 15));
			table.setFont(new Font("微软雅黑", Font.PLAIN, 14));
			return table;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jf.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					JDBCUtils.closeConnection(conn, ps, rs);
				}
			});
		}
		return null;
	}
	

}
