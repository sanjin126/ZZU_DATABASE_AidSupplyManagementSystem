package com.aidsystem.view.volunteer;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.text.JTextComponent;

import com.aidsystem.service.GetTableOfTableService;
import com.aidsystem.util.UIUtils;

public class DemSupplyPanel {
	private JPanel jp = new JPanel(new BorderLayout());
	private JTable demTable;
	
	public JPanel getDemPanel(JFrame jf) {
		//获取DemanSupply信息表格
		demTable = GetTableOfTableService.getCheckedDemSupply(jf);
		
		
		Box vboxDem = Box.createVerticalBox(); //组装a和b
		JPanel descPanelDem = new JPanel(new FlowLayout(FlowLayout.LEFT));//a
		JLabel lblDemdesc = new JLabel("您选择的信息为：");{
			lblDemdesc.setFont(new Font("Dialog", Font.BOLD, 15));
			descPanelDem.add(lblDemdesc);
		}
		JPanel lblPanelDem = new JPanel(new GridLayout(5, 4));//b
		JTextField tfDemID = getUnEditableTF(5);
		JTextField tfDemName = getUnEditableTF(5);
		JTextField tfQuantity = getUnEditableTF(5);
		JTextField tfOrgName = getUnEditableTF(5);
		JTextField tfAddress = getUnEditableTF(5);
		JTextField tfDirector = getUnEditableTF(5);
		JTextField tfPhone = getUnEditableTF(5);
		JTextField tfDesc = getUnEditableTF(5);
		JTextField tfVolID = getUnEditableTF(5);{
			String[] names = GetTableOfTableService.checkeddemName;
			ArrayList<Component> list = getLabelList(names,tfDemID,tfDemName,tfQuantity,tfOrgName,tfAddress,tfDirector,tfPhone,tfDesc,tfVolID);
			fillInLblPanel(list, lblPanelDem);
		}
		
		demTable.addMouseListener(UIUtils.getTableClickListener(tfDemID,tfDemName,tfQuantity,tfOrgName,tfAddress,tfDirector,tfPhone,tfDesc,tfVolID));
		vboxDem.add(descPanelDem);
		vboxDem.add(lblPanelDem);
		jp.add(new JScrollPane(demTable));
		jp.add(vboxDem, BorderLayout.SOUTH);
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
	private ArrayList<Component> getLabelList(String[] names, JTextComponent ...args){
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
	
	private JLabel getLabelByName(String name) {
		return new JLabel(name);
	}
	
	
	
	
	
	

}




















