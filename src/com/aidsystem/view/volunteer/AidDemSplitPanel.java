package com.aidsystem.view.volunteer;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.aidsystem.service.DistributeService;
import com.aidsystem.service.GetTableOfTableService;
import com.aidsystem.util.UIUtils;

public class AidDemSplitPanel {
	JFrame jf = new JFrame();
	private int WIDTH = 1000;
	private int HEIGHT = 500;
	private JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, true);
	private JPanel aidTablePanel = new JPanel(new BorderLayout());
	private JPanel demTablePanel = new JPanel(new BorderLayout());
	private JPanel bottomPanel = new JPanel();
	private JTable aidTable;
	private JTable demTable;
	private JLabel aidTitle = new JLabel("救援物资", 
			UIUtils.setImageSize(new ImageIcon("image/应急救援.png"), 20, 20), JLabel.CENTER);
	{aidTitle.setFont(new Font("Dialog", Font.BOLD, 20));}
	private JLabel demTitle = new JLabel("需求物资", 
			UIUtils.setImageSize(new ImageIcon("image/爱心.png"), 20, 20), JLabel.CENTER);
	{demTitle.setFont(new Font("Dialog", Font.BOLD, 20));}
	private JLabel lblAidId = new JLabel("救援物资ID：");
	private JLabel lblDemId = new JLabel("需求物资ID：");
	private JTextField tfAidId = new JTextField(5);
	private JTextField tfDemId = new JTextField(5);
	private JButton btnDistribute = new JButton("分配", 
			UIUtils.setImageSize(new ImageIcon("image/分配.png"), 20, 20));
	{bottomPanel.add(lblAidId);bottomPanel.add(tfAidId);
	btnDistribute.setHorizontalTextPosition(SwingConstants.LEFT);;bottomPanel.add(btnDistribute);
	bottomPanel.add(lblDemId);bottomPanel.add(tfDemId);}
	//运输人员选择框
	private JFrame perFrame;
	private JPanel perBotmPanel;
	private JTextField tfPerId;
	private JTable perTable;
	private JButton btnSelect;
	private Integer trpId;
	
	public void init(JFrame volFrame) {
		jf.setTitle("请合理分配物资");
		jf.setIconImage(new ImageIcon("image/爱心.png").getImage());
		jf.setSize(WIDTH, HEIGHT);
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jf.setLocationRelativeTo(volFrame);
		
		aidTable = GetTableOfTableService.getCheckedAidSupply(volFrame);
		aidTablePanel.add(aidTitle, BorderLayout.NORTH);
		aidTablePanel.add(new JScrollPane(aidTable));
		demTable = GetTableOfTableService.getCheckedDemSupply(volFrame);
		demTablePanel.add(demTitle, BorderLayout.NORTH);
		demTablePanel.add(new JScrollPane(demTable));
		
		aidTable.addMouseListener(UIUtils.getTableClickListener(tfAidId));
		demTable.addMouseListener(UIUtils.getTableClickListener(tfDemId));
		btnDistribute.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (UIUtils.isTextEmpty(tfAidId)) {
					JOptionPane.showMessageDialog(jf, "请选择救援物资", "提示", JOptionPane.PLAIN_MESSAGE);
				} else if(UIUtils.isTextEmpty(tfDemId)) {
					JOptionPane.showMessageDialog(jf, "请选择需求物资", "提示", JOptionPane.PLAIN_MESSAGE);
				}else {
					int result = JOptionPane.showConfirmDialog(jf, "是否确认分配", "提示", JOptionPane.OK_CANCEL_OPTION);
					if (result == JOptionPane.YES_OPTION) {
						int aidId = new Integer(tfAidId.getText());
						int demId = new Integer(tfDemId.getText());
						int selectedRow = aidTable.getSelectedRow();
						String needCar = aidTable.getValueAt(selectedRow, 6).toString();
						if ("是".equals(needCar)) {
							JOptionPane.showMessageDialog(jf, "请选择一位负责该物资的运输人员", "提示", JOptionPane.PLAIN_MESSAGE);
							transPeronFrame(volFrame);
						} else {
							DistributeService.distribute(aidId, demId, null);
							reFresh(volFrame);
						}
					} else {
//						System.out.println("取消");
					}

				}
			}
		});
		
		splitPane.setLeftComponent(aidTablePanel);
		splitPane.setRightComponent(demTablePanel);
		splitPane.setOneTouchExpandable(true);
		splitPane.setDividerSize(10);
		splitPane.setDividerLocation(250);
		jf.add(splitPane);
		jf.add(bottomPanel, BorderLayout.SOUTH);
		
		
		jf.setVisible(true);
	}
	
	public static void main(String args[]) {
		new AidDemSplitPanel().init(new JFrame());
	}
	
	public void transPeronFrame(JFrame volFrame) { //运输 人员选择框
		perFrame = new JFrame("运输人员");
		btnSelect = new JButton("选择");
		btnSelect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (UIUtils.isTextEmpty(tfPerId)) {
					JOptionPane.showMessageDialog(perFrame, "请选择一位运输人员", "提示", JOptionPane.PLAIN_MESSAGE);
				} else {
					int aidId = new Integer(tfAidId.getText());
					int demId = new Integer(tfDemId.getText());
					trpId = new Integer(tfPerId.getText());
					perFrame.dispose();
//					System.out.println(aidId+" "+demId+" "+trpId);
					DistributeService.distribute(aidId, demId, trpId);
					reFresh(volFrame);
				}
			}
		});
		perBotmPanel = new JPanel();
		JLabel lblPerId = new JLabel("人员ID:");
		tfPerId = new JTextField(5);
		perFrame.setSize(550, 300);
		perFrame.setLocationRelativeTo(jf);
		perFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		perTable = GetTableOfTableService.getFreeTransPersonInfo(perFrame);
		perTable.addMouseListener(UIUtils.getTableClickListener(tfPerId));
		
		perFrame.add(new JScrollPane(perTable));
		perBotmPanel.add(lblPerId);
		perBotmPanel.add(tfPerId);
		perBotmPanel.add(btnSelect);
		perFrame.add(perBotmPanel,BorderLayout.SOUTH);
		perFrame.setVisible(true);
	}
	
	private void reFresh(JFrame volFrame) {
		jf.dispose();
		new AidDemSplitPanel().init(volFrame);
	}

}
