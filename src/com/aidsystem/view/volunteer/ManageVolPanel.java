package com.aidsystem.view.volunteer;

import java.awt.BorderLayout;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.plaf.metal.MetalBorders.Flush3DBorder;

import com.aidsystem.service.GetTableOfTableService;
import com.aidsystem.service.ManageService;
import com.aidsystem.util.UIUtils;

public class ManageVolPanel {
	
	private JFrame volFrame = new JFrame("志愿者管理");
	private JTable volTable;
	private JFrame addFrame = null;
	private Box vbox = Box.createVerticalBox();
	
	private JPanel lblPanel = new JPanel(new GridLayout(6, 2));
	private JTextField tfVolId = new JTextField(5);
	private JTextField tfVolName = new JTextField(5);
	private JTextField tfVolGender = new JTextField(5);
	private JTextField tfVolAge = new JTextField(5);
	private JTextField tfVolPhone = new JTextField(5);
	private JTextField tfVolAddress = new JTextField(5);
	
	private JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 0));
	private JButton btnAdd = new JButton("添加信息");
	private JButton btnDelete = new JButton("删除信息");
	private JButton btnUpdate = new JButton("修改信息");
	
	
	public void init(JFrame jf) {
		volFrame.setSize(700, 500);
		volFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		volFrame.setLocationRelativeTo(jf);
		
		volTable = GetTableOfTableService.getVolunteerInfo(jf);
		volTable.addMouseListener(UIUtils.getTableClickListener(tfVolId,tfVolName,tfVolGender, tfVolAge,tfVolPhone,tfVolAddress));
		
		ArrayList<Component> list = getLabelList(GetTableOfTableService.volunteer, tfVolId,tfVolName,tfVolGender,tfVolAge,tfVolPhone,tfVolAddress);
		fillInLblPanel(list, lblPanel);
		
		volFrame.add(new JScrollPane(volTable));
		vbox.add(lblPanel);
		btnPanel.setBorder(new Flush3DBorder());
		vbox.add(btnPanel);
		volFrame.add(vbox, BorderLayout.SOUTH);
		
		
		
			btnPanel.add(btnAdd);
			btnPanel.add(btnDelete);
			btnPanel.add(btnUpdate);
			btnAdd.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					addFrame = new JFrame("添加志愿者");
					JPanel infoPanel = new JPanel(new GridLayout(7, 2));
					JButton btnAdd = new JButton("添加");
					
					JButton btnCancel = new JButton("取消");
				
					JTextField tfVolId = getUnEditableTF(5); 
					tfVolId.setText("默认值");
					JTextField tfVolName = new JTextField(5);    
					JTextField tfVolGender = new JTextField(5);  
					JTextField tfVolAge = new JTextField(5);     
					JTextField tfVolPhone = new JTextField(5);   
					JTextField tfVolAddress = new JTextField(5); 
					ArrayList<Component> list = getLabelList(GetTableOfTableService.volunteer, tfVolId,tfVolName,tfVolGender,tfVolAge,tfVolPhone,tfVolAddress);
					fillInLblPanel(list, infoPanel);
					infoPanel.add(btnAdd);
					infoPanel.add(btnCancel);
					addFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					addFrame.setSize(300, 400);
					addFrame.setLocationRelativeTo(volFrame);
					addFrame.add(infoPanel);
					
					btnAdd.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if (UIUtils.isTextEmpty(tfVolName,tfVolPhone)) {
								JOptionPane.showMessageDialog(addFrame, "请至少输入姓名和手机号");
							} else {
								try {
									ManageService.addVol(tfVolName.getText(), 
											tfVolGender.getText(), 
											tfVolAge.getText(),
											tfVolPhone.getText(),
											tfVolAddress.getText());
								} catch (Exception e1) {
									JOptionPane.showMessageDialog(addFrame, e1.getMessage());
									return;
								}
								JOptionPane.showMessageDialog(addFrame, "添加成功");
								volFrame.dispose();
								addFrame.dispose();
								new ManageVolPanel().init(jf);
							}
						}
					});
					
					btnCancel.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							addFrame.dispose();
						}
					});
					
					addFrame.setVisible(true);
					
				}
			});
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (!UIUtils.isTextEmpty(tfVolId)) {
						int result = JOptionPane.showConfirmDialog(volFrame, "是否确认删除", "删除志愿者", JOptionPane.YES_NO_OPTION);
						if (result == JOptionPane.YES_OPTION) {
							ManageService.deleteVol(tfVolId.getText());
							volFrame.dispose();
							new ManageVolPanel().init(jf);
						}			
					}
				}
			});
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (UIUtils.isTextEmpty(tfVolName,tfVolPhone)) {
						JOptionPane.showMessageDialog(volFrame, "信息不全！");
					} else {
						try {
							ManageService.updateVol(tfVolId.getText(), tfVolName.getText(), tfVolGender.getText(), tfVolAge.getText(), tfVolPhone.getText(), tfVolAddress.getText());
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(addFrame, e1.getMessage());
							volFrame.dispose();
							new ManageVolPanel().init(jf);
							return;
						}
						JOptionPane.showMessageDialog(volFrame, "更新成功！");
						volFrame.dispose();
						new ManageVolPanel().init(jf);
					}
				}
			});
		
		
		volFrame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				if (addFrame != null)
					addFrame.dispose();
			}
		});
		volFrame.setVisible(true);
		
	}
	
	
	public static void main(String[] args) {
		new ManageVolPanel().init(new JFrame());
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
	@Deprecated
	private void clearTextField() {
		tfVolId.setText(""); 
		tfVolName.setText("");
		tfVolGender.setText("");
		tfVolAge.setText(""); 
		tfVolPhone.setText(""); 
		tfVolAddress.setText(""); 
	}
	
}
