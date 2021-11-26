package com.aidsystem.view.user;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.aidsystem.service.CommitInfoService;
import com.aidsystem.util.StringUtils;
import com.aidsystem.util.UIUtils;


public class MainFrame {
	
	public static void main(String[] args) {
		new MainFrame().init();
	}
	
	/**
	 * 一、主窗口所用常量
	 */
	private final int WIDTH = 550;
	private final int HEIGHT = 300;
	private JFrame jf = new JFrame("我们一定能行！");
	{
		jf.setIconImage(UIUtils.setImageSize(new ImageIcon("image/爱心.png"), 15, 15).getImage());
	}
	private JPanel jp = new JPanel(new BorderLayout(0, 10));
	private JButton btnAid = new JButton("我要捐赠");
	private JButton btnDem = new JButton("我要求助");
//	private JButton btnSrh = new JButton("我的记录");
	private JLabel lblTitle = new JLabel("应急救援",UIUtils.setImageSize(new ImageIcon("image/应急.png"), 60, 60),SwingConstants.CENTER);
	private JLabel lblDesc = new JLabel("风雨过后总有彩虹！",
			UIUtils.setImageSize(new ImageIcon("image/彩虹.png"), 50, 60),SwingConstants.LEFT);
	private Box hBox = Box.createHorizontalBox();
	private Box vBox = Box.createVerticalBox();
	private JPanel titlePanel = new JPanel(new BorderLayout());
	private Component lglue = Box.createHorizontalGlue();
	private Component rglue = Box.createHorizontalGlue();
	private Component l1strut = Box.createHorizontalStrut(50);
	private Component l2strut = Box.createHorizontalStrut(50);
	private Component r1strut = Box.createHorizontalStrut(50);
	private Component r2strut = Box.createHorizontalStrut(50);
	private Component btnstrut = Box.createVerticalStrut(30);
	
	
	public void init() {
		jf.setSize(WIDTH, HEIGHT);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.getContentPane().setBackground(new Color(250, 251, 252));
		jp.setBackground(new Color(250, 251, 252));
		titlePanel.setBackground(new Color(250, 251, 252));
		btnAid.setBackground(new Color(16, 113, 229));
		btnAid.setForeground(Color.white);
		btnDem.setBackground(new Color(16, 113, 229));
		btnDem.setForeground(Color.white);
		//组装主界面功能按钮
		btnAid.setFont(new Font("微软雅黑", Font.BOLD, 20));
		btnAid.addActionListener(new aidActionListener());
		btnDem.setFont(new Font("微软雅黑", Font.BOLD, 20));
		btnDem.addActionListener(new demActionListener());
//		btnSrh.setFont(new Font("Dialog", Font.BOLD, 15));
//		btnSrh.addActionListener(new srhActionListener()); 
		hBox.setPreferredSize(new Dimension(100, 100));
		hBox.add(l1strut);
		hBox.add(l2strut);
		hBox.add(btnAid);
		hBox.add(lglue);
		hBox.add(rglue);
		hBox.add(btnDem);
//		hBox.add(btnSrh);
		hBox.add(r1strut);
		hBox.add(r2strut);
		vBox.add(hBox);
		vBox.add(btnstrut); //增加间距
		//
//		lblTitle.setForeground(new Color(204, 204, 216));
		lblTitle.setHorizontalTextPosition(SwingConstants.LEFT);
		lblTitle.setPreferredSize(new Dimension(HEIGHT, 70));
		lblTitle.setFont(new Font("楷体", Font.BOLD, 50));
		lblDesc.setFont(new Font("楷体", Font.BOLD, 15));
		
		jp.add(vBox);
		titlePanel.add(lblTitle);
		jf.add(titlePanel,BorderLayout.NORTH);
		jf.add(jp);
		jf.add(lblDesc,BorderLayout.SOUTH);
		
		jf.setVisible(true);
	}
	
	/**
	 * 把各个子窗口定义为全局变量
	 * 便于提交与取消按钮的监听器调用
	 */
	private JFrame aidFrame;
	private JFrame demFrame;
	private JFrame srhFrame;
	
	
	class aidActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			aidFrame = getAidFrame();
			aidFrame.setVisible(true);
			
		}
	}
	class demActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			demFrame = getDemFrame();
			demFrame.setVisible(true);
			
		}
	}
	class srhActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("我的记录");
			
		}
	}
	
	

	
	/**
	 * 二、捐赠子窗口
	 */
	private JFrame getAidFrame() {
		JFrame jf = new JFrame("我要捐赠");
		jf.setSize(new Dimension(450, 500));
		jf.setLocationRelativeTo(this.jf);
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//将各个信息填写装填在vbox
		JPanel aidPanel = new JPanel(new BorderLayout());
		JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		Box vbox = Box.createVerticalBox();
		JLabel lblaidTitle = new JLabel("请填写以下信息");
		{
			lblaidTitle.setFont(new Font("楷体", Font.BOLD, 25));
			titlePanel.add(lblaidTitle);
		}
		JLabel lblDonName = new JLabel ("名               字*");
		JTextField tfDonName = new JTextField(15);
		JLabel lblPhone = new JLabel   ("电               话*");
		JTextField tfPhone = new JTextField(15);
		JLabel lblAidName = new JLabel ("捐赠物资名称*");
		JTextField tfAidName = new JTextField(15);
		JLabel lblQuantity = new JLabel("捐   赠   数   量");
		JTextField tfQuantity = new JTextField(15);
		JLabel lblAddress = new JLabel ("物 资 所  在 地");
		JTextArea taAddress = new JTextArea(2,15);
		{
			taAddress.setLineWrap(true);
		}


		JLabel lblNeedCar = new JLabel ("是否需要提供运输车辆");
		JComboBox<String> comboNeedCar;
		String[] isornotOpt = new String[]{"否","是"};
		{
			comboNeedCar = new JComboBox<String>(isornotOpt);
			comboNeedCar.setSelectedIndex(0);
		}
		JButton aidbtnCommit = new JButton("提交");
		JButton aidbtnCancel = new JButton("取消");
		{
			aidbtnCommit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(UIUtils.isTextEmpty(tfDonName,tfPhone,tfAidName)) {
						JOptionPane.showMessageDialog(aidFrame,
								"您的信息填写不完整，标 * 一栏必须填写",
								"完善信息后就可以捐赠了",
								JOptionPane.WARNING_MESSAGE);
					} else if (tfPhone.getText().length() != 11) {
						JOptionPane.showMessageDialog(aidFrame,"请输入正确的手机号");
					}
					else {	
						boolean commitSuccess = CommitInfoService.commitAidInfo(tfDonName.getText(), tfPhone.getText(), tfAidName.getText(),
								tfQuantity.getText(), taAddress.getText(), comboNeedCar.getSelectedIndex());
						if (commitSuccess) {
							JOptionPane.showMessageDialog(aidFrame,
									"感谢您的捐赠，我们会在找到灾区接收组织后第一时间联系您。",
									"灾难无情人有情", JOptionPane.PLAIN_MESSAGE);
							aidFrame.dispose();	
						} else {

						}
					}
				}
			});
			aidbtnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					aidFrame.dispose();
				}
			});
		}

		//组合各个信息填写栏
		titlePanel.setBackground(new Color(250, 251, 252));
		taAddress.setBorder(new LineBorder(new Color(122, 138, 153), 1));
		aidbtnCancel.setBackground(new Color(16, 113, 229));
		aidbtnCommit.setBackground(new Color(16, 113, 229));
		aidbtnCancel.setForeground(Color.white);
		aidbtnCommit.setForeground(Color.white);
		vbox.add(titlePanel);
		vbox.add(getInfoPanel(lblDonName, tfDonName));
		vbox.add(getInfoPanel(lblPhone, tfPhone));
		vbox.add(getInfoPanel(lblAidName, tfAidName));
		vbox.add(getInfoPanel(lblQuantity, tfQuantity));
		vbox.add(getInfoPanel(lblAddress, taAddress));
		vbox.add(getInfoPanel(lblNeedCar, comboNeedCar));
		vbox.add(getInfoPanel(aidbtnCommit, aidbtnCancel));
		aidPanel.add(vbox);
		jf.add(new JScrollPane(aidPanel));
		return jf;
	}
	
	/**
	 * 三、求助子窗口
	 */

	private JFrame getDemFrame() {
		JFrame jf = new JFrame("我要求助");
		jf.setSize(new Dimension(450, 550));
		jf.setLocationRelativeTo(this.jf);
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//创建各个组件
		JPanel demPanel = new JPanel(new BorderLayout());
		JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		Box vbox = Box.createVerticalBox();
		JLabel lbldemTitle = new JLabel("请填写以下信息");
		{
			lbldemTitle.setFont(new Font("楷体", Font.BOLD, 25));
			titlePanel.add(lbldemTitle);
		}
		JLabel lblOrgName = new JLabel ("组    织    名   字");
		JTextField tfOrgName = new JTextField(15);
		JLabel lblDirector = new JLabel("负        责      人*");
		JTextField tfDirector = new JTextField(15);
		JLabel lblPhone = new JLabel   ("电                  话*");
		JTextField tfPhone = new JTextField(15);
		JLabel lblAddress = new JLabel ("地                  址*");
		JTextArea taAddress = new JTextArea(2,15);
		{
			taAddress.setLineWrap(true);
		}
		JLabel lblDemName = new JLabel ("需   求    物   资*");
		JTextField tfDemName = new JTextField(15);
		JLabel lblQuantity = new JLabel("需   求     数   量");
		JTextField tfQuantity = new JTextField(15);
		JLabel lblDemDesc = new JLabel ("备                   注");
		JTextArea taDemDesc = new JTextArea(3,15);
		{
			taDemDesc.setLineWrap(true);
		}
		JButton dembtnCommit = new JButton("提交");
		JButton dembtnCancel = new JButton("取消");
		{
			dembtnCommit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (UIUtils.isTextEmpty(tfDirector,tfPhone,taAddress,tfDemName)) {
						JOptionPane.showMessageDialog(demFrame,
								"请不要着急，您的信息填写不完整，请把标 * 一栏信息填上，这样我们才可以帮到您",
								"阳光总在风雨后",
								JOptionPane.WARNING_MESSAGE,
								UIUtils.setImageSize(new ImageIcon("image/爱心.png"), 15, 15));
					} else if (tfPhone.getText().length() != 11) {
						JOptionPane.showMessageDialog(demFrame, "请输入正确的手机号");
					}
					else {
						boolean commitSuccess = CommitInfoService.commitDemInfo(tfOrgName.getText(), tfDirector.getText(), tfPhone.getText(), taAddress.getText(), tfDemName.getText(), tfQuantity.getText(), taDemDesc.getText());
						if (commitSuccess) {
							JOptionPane.showMessageDialog(demFrame,
									"您的求助我们已经收到，请保护好自己，志愿者将会在稍后联系您，并为您调配物资。",
									"一方有难，八方支援",
									JOptionPane.PLAIN_MESSAGE,
									UIUtils.setImageSize(new ImageIcon("image/爱心.png"), 15, 15));	
							demFrame.dispose();
						} else {

						}
					}
				}
			});
			dembtnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(aidFrame,
							"不要怕，千千万万的人一直在牵挂着你们❤️",
							"风雨同舟",
							JOptionPane.PLAIN_MESSAGE);
					demFrame.dispose();
				}
			});
		}
		
		
		
		titlePanel.setBackground(new Color(250, 251, 252));
		taAddress.setBorder(new LineBorder(new Color(122, 138, 153), 1));
		taDemDesc.setBorder(new LineBorder(new Color(122, 138, 153), 1));
		dembtnCancel.setBackground(new Color(16, 113, 229));
		dembtnCommit.setBackground(new Color(16, 113, 229));
		dembtnCancel.setForeground(Color.white);
		dembtnCommit.setForeground(Color.white);
		vbox.add(titlePanel);
		vbox.add(getInfoPanel(lblOrgName, tfOrgName));
		vbox.add(getInfoPanel(lblDirector, tfDirector));
		vbox.add(getInfoPanel(lblPhone, tfPhone));
		vbox.add(getInfoPanel(lblAddress, taAddress));
		vbox.add(getInfoPanel(lblDemName, tfDemName));
		vbox.add(getInfoPanel(lblQuantity, tfQuantity));
		vbox.add(getInfoPanel(lblDemDesc, taDemDesc));
		vbox.add(getInfoPanel(dembtnCommit, dembtnCancel));
		
		demPanel.add(vbox);
		jf.add(new JScrollPane(demPanel));
		return jf;
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * 
	 * @Description 该方法用于生成各表单项
	 * @author sanjin
	 * @param lbl
	 * @param tf
	 * @return
	 */
	private JPanel getInfoPanel(Component lbl, Component tf) {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		lbl.setFont(new Font("Dialog", Font.BOLD, 18));
		if (tf instanceof JButton) {
			tf.setFont(new Font("Dialog", Font.BOLD, 18));
		}
		panel.add(lbl);
		panel.add(tf);
		panel.setBackground(new Color(250, 251, 252));
		return panel;
	
	}
}
