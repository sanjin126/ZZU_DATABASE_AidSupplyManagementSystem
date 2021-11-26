package com.aidsystem.view.volunteer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.plaf.metal.MetalBorders.Flush3DBorder;
import javax.swing.text.JTextComponent;

import com.aidsystem.service.GetTableOfTableService;
import com.aidsystem.service.ManageService;
import com.aidsystem.util.UIUtils;

public class ManageTrPersonPanel {
	
	private JFrame trPersonFrame = new JFrame("运输人员管理");
	private JTable trPersonTable;
	private JFrame addFrame;
	private Box vbox = Box.createVerticalBox();
	
	private JPanel lblPanel = new JPanel(new GridLayout(7, 2));
	private JTextField tftrPId = new JTextField(5);
	private JTextField tftrPName = new JTextField(5);
	private JTextField tftrPGender = new JTextField(5);
	private JTextField tftrPAge = new JTextField(5);
	private JTextField tftrPPhone = new JTextField(5);
	private JTextField tftrPArea = new JTextField(5);
	private JTextField tftrPNumPlate = new JTextField(5);
	
	private JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 0));
	private JButton btnAdd = new JButton("添加信息");
	private JButton btnDelete = new JButton("删除信息");
	private JButton btnUpdate = new JButton("修改信息");
	
	public void init(JFrame jf) {
		trPersonFrame.setSize(700, 500);
		trPersonFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		trPersonFrame.setLocationRelativeTo(jf);
		
		trPersonTable = GetTableOfTableService.getTransPersonInfo(jf);
		trPersonTable.addMouseListener(UIUtils.getTableClickListener(tftrPId,tftrPName,tftrPGender,tftrPAge,tftrPPhone,tftrPArea,tftrPNumPlate));
		
		ArrayList<Component> list = getLabelList(GetTableOfTableService.transPerson, tftrPId,tftrPName,tftrPGender,tftrPAge,tftrPPhone,tftrPArea,tftrPNumPlate);
		fillInLblPanel(list, lblPanel);
		
		
		
			btnPanel.add(btnAdd);
			btnPanel.add(btnDelete);
			btnPanel.add(btnUpdate);
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JPanel infoPanel = new JPanel(new GridLayout(8, 2));
					JButton btnAdd = new JButton("添加");
					JButton btnCancel = new JButton("取消");
					JTextField tftrPId = getUnEditableTF(5);
					tftrPId.setText("默认值");
					JTextField tftrPName = new JTextField(5);     
					JTextField tftrPGender = new JTextField(5);   
					JTextField tftrPAge = new JTextField(5);      
					JTextField tftrPPhone = new JTextField(5);    
					JTextArea tftrPArea = new JTextArea(2,10);   
					tftrPArea.setLineWrap(true);
					tftrPArea.setBorder(new LineBorder(new Color(122, 138, 153), 1));
					JTextField tftrPNumPlate = new JTextField(5);
					ArrayList<Component> list = getLabelList(GetTableOfTableService.transPerson, tftrPId,tftrPName,tftrPGender,tftrPAge,tftrPPhone,tftrPArea,tftrPNumPlate);
					fillInLblPanel(list, infoPanel);
					infoPanel.add(btnAdd);
					infoPanel.add(btnCancel);
					addFrame = new JFrame("添加运输人员");
					addFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					addFrame.setSize(300, 400);
					addFrame.setLocationRelativeTo(trPersonFrame);
					btnAdd.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if (UIUtils.isTextEmpty(tftrPName,tftrPPhone,tftrPNumPlate)) {
								JOptionPane.showMessageDialog(addFrame, "请至少输入姓名,手机号和车牌号");
							} else if(tftrPPhone.getText().length() != 11){
								JOptionPane.showMessageDialog(addFrame, "请输入正确的车牌号哦");
							} else if (tftrPNumPlate.getText().length() != 7) {
								JOptionPane.showMessageDialog(addFrame, "请输入正确的手机号哦");
							} else {
								try {
									ManageService.addTrp(
											tftrPName.getText(),
											tftrPGender.getText(), 
											tftrPAge.getText(), 
											tftrPPhone.getText(), 
											tftrPArea.getText(), 
											tftrPNumPlate.getText());
								} catch (Exception e1) {
									JOptionPane.showMessageDialog(addFrame, e1.getMessage());
									return;
								}
								JOptionPane.showMessageDialog(addFrame, "添加成功");
								new ManageTrPersonPanel().init(jf);
								trPersonFrame.dispose();
						}
					}
						});
					btnCancel.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if (addFrame!=null) {
								addFrame.dispose();								
							}
						}
					});
					addFrame.add(infoPanel);
					
					addFrame.setVisible(true);
				}
			});
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (!UIUtils.isTextEmpty(tftrPId)) {
						int result = JOptionPane.showConfirmDialog(trPersonFrame, "是否确认删除", "删除志愿者", JOptionPane.YES_NO_OPTION);
						if (result == JOptionPane.YES_OPTION) {
							ManageService.deleteVol(tftrPId.getText());
							new ManageTrPersonPanel().init(jf);
							trPersonFrame.dispose();
						}			
					}
				}
			});
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (UIUtils.isTextEmpty(tftrPId,tftrPName,tftrPNumPlate)) {
						JOptionPane.showMessageDialog(trPersonFrame, "信息不全！");
					} else {
						try {
							ManageService.updateTrp(
									tftrPId.getText(),
									tftrPName.getText(),
									tftrPGender.getText(), 
									tftrPAge.getText(), 
									tftrPPhone.getText(), 
									tftrPArea.getText(), 
									tftrPNumPlate.getText());
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(addFrame, e1.getMessage());
						}
						JOptionPane.showMessageDialog(trPersonFrame, "更新成功！");
						new ManageTrPersonPanel().init(jf);
						trPersonFrame.dispose();
					}
				}
			});
		
		
		
		trPersonFrame.add(new JScrollPane(trPersonTable));
		vbox.add(lblPanel);
		btnPanel.setBorder(new Flush3DBorder());
		vbox.add(btnPanel);
		trPersonFrame.add(vbox, BorderLayout.SOUTH);

		trPersonFrame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (addFrame!=null) {
					addFrame.dispose();
				}
			}
		});
		trPersonFrame.setVisible(true);
		
	}
	
	
	public static void main(String[] args) {
		new ManageTrPersonPanel().init(new JFrame());
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
	
	private void fillInLblPanel(ArrayList<Component> list, JComponent lblPanel) {
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
