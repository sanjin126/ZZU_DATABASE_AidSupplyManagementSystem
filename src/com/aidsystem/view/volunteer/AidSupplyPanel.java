package com.aidsystem.view.volunteer;


import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import com.aidsystem.bean.DBObject;
import com.aidsystem.dao.Impl.VolunteerDAOImpl;
import com.aidsystem.service.GetTableOfTableService;
import com.aidsystem.util.JDBCUtils;
import com.aidsystem.util.UIUtils;


public class AidSupplyPanel {
	private JPanel jp = new JPanel(new BorderLayout()); //主面板
	private Box vbox = Box.createVerticalBox();
	private JPanel lblpanel = new JPanel(new GridLayout(4, 4)); //装填label和text，放置在panel.south
	private JPanel descpanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JLabel lbldesc = new JLabel("您选择的信息为：");
	{
		lbldesc.setFont(new Font("Dialog", Font.BOLD, 15));
		descpanel.add(lbldesc);
	}

	private JTextField tfDemID = getUnEditableTF(5);
	private JTextField tfAid = getUnEditableTF(5);
	private JTextField tfQuantity = getUnEditableTF(5);
	private JTextField tfDon = getUnEditableTF(5);
	private JTextField tfPhone = getUnEditableTF(11);
	private JTextField tfAddress = getUnEditableTF(11);
	private JTextField tfNeedCar = getUnEditableTF(1);
	private JTextField tfVolID = getUnEditableTF(4);
	
	{
		String[] names = new String[] {"物资ID","捐赠物资","数量","捐赠者","联系电话",
				"物资所在地","是否需要提供运输","审核志愿者ID"};
		ArrayList<Component> list = getLabelList(names, tfDemID,tfAid,tfQuantity,tfDon,tfPhone,tfAddress,tfNeedCar,tfVolID);
		fillInLBLPanel(list);
	}
	

	public JPanel getAidSupplyPanel(JFrame jf) {
		//获取救援物资信息表格
		JTable aidTable = GetTableOfTableService.getCheckedAidSupply(jf);
		//为表格的点击事件添加监听器
		aidTable.addMouseListener(UIUtils.getTableClickListener(tfDemID,tfAid,tfQuantity,tfDon,tfPhone,tfAddress,tfNeedCar,tfVolID));
		//组装信息显示标签和文本域
		  //创建不可编辑的文本域
		
		vbox.add(descpanel);
		vbox.add(lblpanel);

		
		
		jp.add(new JScrollPane(aidTable));

		jp.add(vbox,BorderLayout.SOUTH);
		
		return jp;
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
	
	private void fillInLBLPanel(ArrayList<Component> list) {
		for (Component component : list) {
			
			lblpanel.add(component);
		}
	}
	
	private JTextField getUnEditableTF(int columns) {
		JTextField tf = new JTextField(columns);
		tf.setEditable(false);
		return tf;
	}
	
	private JLabel getLabelByName(String name) {
		return new JLabel(name);
	}

}
