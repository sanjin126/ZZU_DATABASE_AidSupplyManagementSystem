package com.aidsystem.view.volunteer;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Ref;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.metal.MetalBorders.Flush3DBorder;
import javax.swing.table.TableModel;

import com.aidsystem.bean.AidSupply;
import com.aidsystem.bean.DemandSupply;
import com.aidsystem.bean.ItemToUnit;
import com.aidsystem.bean.Organization;
import com.aidsystem.service.CheckService;
import com.aidsystem.service.GetTableOfTableService;
import com.aidsystem.service.ItemToTypeService;
import com.aidsystem.util.StringUtils;
import com.aidsystem.util.UIUtils;

public class CheckPanel {
	private JPanel jp = new JPanel(new BorderLayout()); //主面板,必须设置为BorderLayout，否则窗口中组件不会随着主窗口改变大小
	
	private JTabbedPane tab = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.WRAP_TAB_LAYOUT);
	//图片
	private Icon iconAid = UIUtils.setImageSize(new ImageIcon("image/test.jpg"), 15, 15);
	//（1）急求物资面板变量定义
	JPanel aidInfoPanel;
	JPanel btnAidPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 200, 5));
	private JTable aidTable;
	private JTextField tfAidID;
	private JTextField tfAidName;
	private JTextField tfAidQuantity;
	private JTextField tfDonID;
	private JTextField tfDon;
	private JTextField tfAidPhone;
	private JTextField tfAidAddress;
	private JTextField tfNeedCar;
	private JTextField tfAidCheckStatus;
	private JButton btnCommitAid = new JButton("审核");
	{
		btnCommitAid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (UIUtils.isTextEmpty(tfAidID)) {
					JOptionPane.showMessageDialog(aidInfoPanel, "您还没有选中任何一项", "提示", JOptionPane.PLAIN_MESSAGE);
					reFresh();
				} else {
					if (UIUtils.isTextEmpty(tfAidID,tfAidName,tfAidQuantity,tfDonID,tfDon,tfAidPhone,tfAidAddress,tfNeedCar,tfAidCheckStatus)) {
						JOptionPane.showMessageDialog(aidInfoPanel, "请完善物资信息", "提示", JOptionPane.PLAIN_MESSAGE);
					} else if( !("是".equals( StringUtils.removeUnimportantChar(tfNeedCar.getText()) ) || "否".equals( StringUtils.removeUnimportantChar(tfNeedCar.getText())) )) {
						JOptionPane.showMessageDialog(demInfoPanel, "是否需要提供运输一栏请填'是'或'否'");
					} else {
						int result = JOptionPane.showConfirmDialog(demInfoPanel, "您将对第"+tfAidID.getText()+"号物资进行审核通过","提示",JOptionPane.YES_NO_OPTION);
						if (result == JOptionPane.YES_OPTION) 
						{
							int id = new Integer(tfAidID.getText());
							String name = tfAidName.getText();
							Integer quantity = StringUtils.getNumberFromString(tfAidQuantity.getText());
							String address = tfAidAddress.getText();
							boolean needTransport = "是".equals(tfNeedCar.getText())?true:false;
							Integer volId = VolunteerFrame.volId;
							AidSupply aid = new AidSupply(id, name , quantity , address, null, needTransport, null, volId , true, false);
							CheckService.checkAidSupplyService(id, true, aid);
							ItemToTypeService.saveType(name, tfAidQuantity.getText()); //保存单位信息
							JOptionPane.showMessageDialog(demInfoPanel, "审核成功", "提示", JOptionPane.PLAIN_MESSAGE);
							reFresh(); //审核成功后刷新界面，更新数据
						}
					}
				}
			}
		});
	}
	private JButton btnDeleteAid = new JButton("删除信息");
	{ 
		btnDeleteAid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (UIUtils.isTextEmpty(tfAidID)) {
					JOptionPane.showMessageDialog(aidInfoPanel, "您还没有选中任何一项", "提示", JOptionPane.PLAIN_MESSAGE);
				} else {
					int result = JOptionPane.showConfirmDialog(aidInfoPanel, "请确认您是否要删除第"+tfAidID.getText()+"号救援物资", "提示", JOptionPane.OK_CANCEL_OPTION);
					if (result == JOptionPane.OK_OPTION) {
						int id = new Integer(tfAidID.getText());
						CheckService.checkAidSupplyService(id, false, null);
						JOptionPane.showMessageDialog(aidInfoPanel, "删除成功", "提示", JOptionPane.PLAIN_MESSAGE);
						reFresh();	
					} else {
//						System.out.println("取消");
					}
				}
			}
		});
	}
	
	//（2）需求物资面板变量定义
	JPanel demInfoPanel;
	private JPanel btnDemPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 200, 5));
	private JTable demTable;
	private JTextField tfDemID;
	private JTextField tfDemName;
	private JTextField tfDemQuantity;
	private JTextField tfOrgID;
	private JTextField tfOrgName;
	private JTextField tfOrgAddress;
	private JTextField tfDirector;
	private JTextField tfOrgPhone;
	private JTextField tfDesc;
	private JTextField tfDemStatus;
	private JButton btnCommitDem = new JButton("审核");{
		btnCommitDem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (UIUtils.isTextEmpty(tfDemID)) {
					JOptionPane.showMessageDialog(demInfoPanel, "您还没有选中任何一项", "提示", JOptionPane.PLAIN_MESSAGE);
					reFresh();
				} else {
					if (UIUtils.isTextEmpty(tfDemID,tfDemName,tfDemQuantity,tfOrgID,tfOrgAddress,tfDirector,tfOrgPhone,tfDemStatus)) {
						JOptionPane.showMessageDialog(demInfoPanel, "请完善物资信息", "提示", JOptionPane.PLAIN_MESSAGE);
					} else {
						int result = JOptionPane.showConfirmDialog(demInfoPanel, "您将对第"+tfDemID.getText()+"号物资进行审核通过","提示",JOptionPane.YES_NO_OPTION);
						if (result == JOptionPane.YES_OPTION) 
						{
							int demId = new Integer(tfDemID.getText());
							String demName = tfDemName.getText();
							int quantity = StringUtils.getNumberFromString(tfDemQuantity.getText());    
							int orgId = new Integer(tfOrgID.getText());
							String orgName = tfOrgName.getText();
							String orgAddress = tfOrgAddress.getText();
							String director = tfDirector.getText();
							String desc = tfDesc.getText();
							DemandSupply dem = new DemandSupply(demId, demName, quantity, null, desc, orgId, VolunteerFrame.volId, true, false);
							Organization org = new Organization(orgId, orgName, orgAddress, director, null);
							CheckService.checkDemSupplyService(demId, orgId, true, dem, org);
							ItemToTypeService.saveType(demName,StringUtils.getOnlyStringFromString(tfDemQuantity.getText()));
							JOptionPane.showMessageDialog(demInfoPanel, "审核成功", "提示", JOptionPane.PLAIN_MESSAGE);
							reFresh();
						}
					}
				}
			}
		});}
	private JButton btnDeleteDem = new JButton("删除信息");{
		btnDeleteDem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (UIUtils.isTextEmpty(tfDemID)) {
					JOptionPane.showMessageDialog(demInfoPanel, "您还没有选中任何一项", "提示", JOptionPane.PLAIN_MESSAGE);
				} else {
					int result = JOptionPane.showConfirmDialog(demInfoPanel, "请确认您将要删除第"+tfDemID.getText()+"号需求物资", "提示", JOptionPane.OK_CANCEL_OPTION);
					if (result == JOptionPane.OK_OPTION) {
						int demId = new Integer(tfDemID.getText());
						int orgId = new Integer(tfOrgID.getText());
						CheckService.checkDemSupplyService(demId, orgId, false, null, null);
						JOptionPane.showMessageDialog(demInfoPanel, "删除成功", "提示", JOptionPane.PLAIN_MESSAGE);
						reFresh();
					} else {
//						System.out.println("取消");
					}
				}
			}
		});}

	
	
	
	
	
	
	public JPanel getCheckPanel(JFrame jf) {

		//1.aidInfoPanel，里边是尚未审核的救援物资信息
		
		aidInfoPanel = getAidInfoPanel(jf);
		tab.addTab("救援物资信息", aidInfoPanel);
		
		//2.demInfoPanel
		
		demInfoPanel = getDemPanel(jf);
		tab.addTab("需求物资信息", demInfoPanel);
		//3.
		tab.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		jp.add(tab);
//		jp.add(btn,BorderLayout.SOUTH);
		//设置背景
		jp.setBackground(Color.lightGray);
//		tab.addChangeListener(new ChangeListener() { //刷新功能
//			
//			@Override
//			public void stateChanged(ChangeEvent e) {
//				reFresh();
//				
//			}
//		});
		return jp;		
	}
	
	private void reFresh() {
		int selectedIndex = tab.getSelectedIndex();
//		TableModel aidmodel = aidTable.getModel();  //resultsetmodel
//		aidmodel.getRowCount();
//		System.out.println(aidTable.getSelectionModel());
		aidInfoPanel = getAidInfoPanel(VolunteerFrame.jf);
		demInfoPanel = getDemPanel(VolunteerFrame.jf);
		tab.setComponentAt(0, aidInfoPanel);
		tab.setComponentAt(1, demInfoPanel);
//		tab.removeAll();   //比较两种方法的效率
//		tab.addTab("救援物资信息", iconAid, aidInfoPanel, "需要志愿者进行审核");
//		tab.addTab("需求物资信息", iconAid, demInfoPanel, "需要志愿者进行审核");
		tab.setSelectedIndex(selectedIndex); //保持原界面
		
//		demTable.setColumnSelectionInterval(0, 4);
	}
	
	
	
	
	
	/**
	 * 
	 * @Description 获取子面板 aidinfo
	 * @author sanjin
	 * @param jf
	 * @return
	 */
	private JPanel getAidInfoPanel(JFrame jf) {
		JPanel aidInfoPanel = new JPanel(new BorderLayout());
		aidTable = GetTableOfTableService.getUncheckedAidSupply(jf);
		Box vboxAid = Box.createVerticalBox(); //组装a和b
		JPanel descPanelAid = new JPanel(new FlowLayout(FlowLayout.LEFT));//a
		JLabel lblAiddesc = new JLabel("您选择的信息为：");{
			lblAiddesc.setFont(new Font("Dialog", Font.BOLD, 15));
			descPanelAid.add(lblAiddesc);
		}
		JPanel lblPanelAid = new JPanel(new GridLayout(3, 4));//b
		tfAidID = getUnEditableTF(5);
		tfAidName = getEditableTF(5);
		tfAidQuantity = getEditableTF(5);
		tfDonID = getUnEditableTF(5);
		tfDon = getUnEditableTF(5);
		tfAidPhone = getUnEditableTF(5);
		tfAidAddress = getEditableTF(5);
		tfNeedCar = getEditableTF(5);
		tfAidCheckStatus = getUnEditableTF(5);{
			String[] names = GetTableOfTableService.uncheckedaidName;
			ArrayList<Component> list = getLabelList(names,tfAidID,tfAidName,tfAidQuantity,tfDonID,tfDon,tfAidPhone,tfAidAddress,tfNeedCar,tfAidCheckStatus);
			fillInLblPanel(list, lblPanelAid);
		}
		
		aidTable.addMouseListener(UIUtils.getTableClickListener(tfAidID,tfAidName,tfAidQuantity,tfDonID,tfDon,tfAidPhone,tfAidAddress,tfNeedCar,tfAidCheckStatus));
		btnAidPanel.add(btnCommitAid);
		btnAidPanel.add(btnDeleteAid);
		btnAidPanel.setBorder(new Flush3DBorder());
		vboxAid.add(descPanelAid);
		vboxAid.add(lblPanelAid);
		vboxAid.add(Box.createVerticalStrut(10));
		vboxAid.add(btnAidPanel);
		aidInfoPanel.add(new JScrollPane(aidTable));
		aidInfoPanel.add(vboxAid, BorderLayout.SOUTH);
		return aidInfoPanel;
		
	}
	
	private JPanel getDemPanel(JFrame jf) {
		JPanel demInfoPanel = new JPanel(new BorderLayout());
		demTable = GetTableOfTableService.getUncheckedDemSupply(jf);
		Box vboxDem = Box.createVerticalBox(); //组装a和b
		JPanel descPanelDem = new JPanel(new FlowLayout(FlowLayout.LEFT));//a
		JLabel lblDemdesc = new JLabel("您选择的信息为：");{
			lblDemdesc.setFont(new Font("Dialog", Font.BOLD, 15));
			descPanelDem.add(lblDemdesc);
		}
		JPanel lblPanelDem = new JPanel(new GridLayout(5, 4));//b
		tfDemID = getUnEditableTF(5);
		tfDemName = getEditableTF(5);
		tfDemQuantity = getEditableTF(5);
		tfOrgID = getUnEditableTF(5);
		tfOrgName = getEditableTF(5);
		tfOrgAddress = getEditableTF(5);
		tfDirector = getEditableTF(5);
		tfOrgPhone = getUnEditableTF(5);
		tfDesc = getEditableTF(5);
		tfDemStatus = getUnEditableTF(5);{
			String[] names = GetTableOfTableService.uncheckeddemName;
			ArrayList<Component> list = getLabelList(names,tfDemID,tfDemName,tfDemQuantity,tfOrgID,tfOrgName,tfOrgAddress,tfDirector,tfOrgPhone,tfDesc,tfDemStatus);
			fillInLblPanel(list, lblPanelDem);
		}
		
		demTable.addMouseListener(UIUtils.getTableClickListener(tfDemID,tfDemName,tfDemQuantity,tfOrgID,tfOrgName,tfOrgAddress,tfDirector,tfOrgPhone,tfDesc,tfDemStatus));
		btnDemPanel.add(btnCommitDem);
		btnDemPanel.add(btnDeleteDem);
		btnDemPanel.setBorder(new Flush3DBorder());
		vboxDem.add(descPanelDem);
		vboxDem.add(lblPanelDem);
		vboxDem.add(btnDemPanel);
		demInfoPanel.add(new JScrollPane(demTable));
		demInfoPanel.add(vboxDem, BorderLayout.SOUTH);
		return demInfoPanel;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 
	 * @Description 
	 * @author sanjin
	 * @param names
	 * @param args
	 * @return
	 */
	private ArrayList<Component> getLabelList(String[] names, JTextField ...args){
		ArrayList<Component> list = new ArrayList<>();
		for (int i = 0; i < args.length; i++) {
			JLabel lbl = getLabelByName(names[i]);
			list.add(lbl);
			list.add(args[i]);
		}
		return list;
	}
	
	private void fillInLblPanel(ArrayList<Component> list, JPanel lblPanel) {
		for (Component component : list) {
			
			lblPanel.add(component);
		}
	}
	
	private JTextField getUnEditableTF(int columns) {
		JTextField tf = new JTextField(columns);
		tf.setEditable(false);
		return tf;
	}
	
	private JTextField getEditableTF(int columns) {
		JTextField tf = new JTextField(columns);
		tf.setEditable(true);
		return tf;
	}
	
	private JLabel getLabelByName(String name) {
		return new JLabel(name);
	}
	

}
