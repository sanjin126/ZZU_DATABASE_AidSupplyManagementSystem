package com.aidsystem.view.volunteer;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.aidsystem.bean.User;
import com.aidsystem.service.LoginService;
import com.aidsystem.service.RegisterService;
import com.aidsystem.util.StringUtils;
import com.aidsystem.util.UIUtils;

public class LoginFrame extends JFrame{
	private JPanel panel = new JPanel(null);
	private JLabel lblUsrName= new JLabel("用户名", UIUtils.setImageSize(new ImageIcon("image/登录.png"), 30, 30), SwingConstants.CENTER);
	private JLabel lblUsrPwd= new JLabel("密码", UIUtils.setImageSize(new ImageIcon("image/密码.png"), 30, 30), SwingConstants.CENTER);
	private JButton btnLogin = new JButton("登录");
	private JButton btnRegister = new JButton("注册");
	private JTextField tfUsrName = new JTextField(10);
	private JTextField tfUsrPwd = new JPasswordField(10);
	
	public static void main(String[] args) {
		LoginFrame loginFrame = new LoginFrame();
		loginFrame.setVisible(true);


	}
	
	public LoginFrame() {
		super();
		setTitle("欢迎登录");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 320);
		setLocationRelativeTo(null);
		setIconImage(UIUtils.setImageSize(new ImageIcon("image/太阳.png"), 120, 120).getImage());
		
		lblUsrName.setFont(new Font("微软雅黑", Font.BOLD, 20));
		lblUsrPwd.setFont(new Font("微软雅黑", Font.BOLD, 20));
		btnLogin.setBackground(new Color(0x7fafe7));
		btnRegister.setBackground(new Color(0x7fafe7));
		btnLogin.setForeground(Color.WHITE);
		btnRegister.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("微软雅黑", Font.BOLD, 20));
		btnRegister.setFont(new Font("微软雅黑", Font.BOLD, 20));
		lblUsrName.setBounds(50, 70, 150, 70);
		lblUsrPwd.setBounds(40, 120, 150, 70);
		tfUsrName.setBounds(185, 93, 200, 30);
		tfUsrPwd.setBounds(185, 140, 200, 30);
		btnLogin.setBounds(140, 200, 90, 40);
		btnRegister.setBounds(260, 200, 90, 40);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (UIUtils.isTextEmpty(tfUsrName)) {
					JOptionPane.showMessageDialog(panel, "请输入您的用户名");
				} else if (UIUtils.isTextEmpty(tfUsrPwd)) {
					JOptionPane.showMessageDialog(panel, "请输入您的密码");
				} else {
					String name = StringUtils.removeUnimportantChar(tfUsrName.getText());
					String pwd = StringUtils.removeUnimportantChar(tfUsrPwd.getText());
					User user = LoginService.login(name, pwd);
					if (user != null) {
						close();
						VolunteerFrame volunteerFrame = new VolunteerFrame(user.getVolId());
						volunteerFrame.init();
					} else {
						JOptionPane.showMessageDialog(panel, "密码或账号输入错误了");
		}}}});
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rgtFrame rf = new rgtFrame(panel);
				rf.setVisible(true);
			}
		});
		panel.add(lblUsrName);
		panel.add(lblUsrPwd);
		panel.add(tfUsrName);
		panel.add(tfUsrPwd);
		panel.add(btnLogin);
		panel.add(btnRegister);
		panel.setBackground(new Color(250, 251, 252));
		add(panel);
		
		
		
	}
	
	private void close() {
		this.dispose();
	}
	
	

}

class rgtFrame extends JFrame{
	private Box hbox1 = Box.createHorizontalBox();
	private Box hbox2 = Box.createHorizontalBox();
	private Box hbox3 = Box.createHorizontalBox();
	private Box hbox4 = Box.createHorizontalBox();
	private Box hbox5 = Box.createHorizontalBox();
	private JPanel p1 = new JPanel(null);
	private JPanel p2 = new JPanel(null);
	private JPanel p3 = new JPanel(null);
	private JPanel p4 = new JPanel(null);
	private JPanel p5 = new JPanel(null);
	private JLabel lblVolId = new JLabel("志愿者ID", SwingConstants.RIGHT);
	private JLabel lblVolName = new JLabel("姓名", SwingConstants.RIGHT);
	private JLabel lblUsrName = new JLabel("用户名", UIUtils.setImageSize(new ImageIcon("image/登录.png"), 30, 30), SwingConstants.RIGHT);
	private JLabel lblUsrPwd = new JLabel("密码", UIUtils.setImageSize(new ImageIcon("image/密码.png"), 30, 30), SwingConstants.RIGHT);
	private JTextField tfVolId = new JTextField(10);
	private JTextField tfVolName = new JTextField(10);
	private JTextField tfUsrName = new JTextField(10);
	private JTextField tfUsrPwd = new JTextField(10);
	private JButton btnCommit = new JButton("确认"); 
	private JButton btnCancel = new JButton("取消"); 
	public rgtFrame(JComponent mainFrame) {
		super();
		setLayout(new GridLayout(5, 1));
		setTitle("注册");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(450, 350);
		setLocationRelativeTo(mainFrame);
		
		btnCommit.setBackground(new Color(0x7fafe7));
		btnCancel.setBackground(new Color(0x7fafe7));
		btnCommit.setForeground(Color.WHITE);
		btnCancel.setForeground(Color.WHITE);
		btnCommit.setFont(new Font("微软雅黑", Font.BOLD, 20));
		btnCancel.setFont(new Font("微软雅黑", Font.BOLD, 20));
		
		lblVolId.setFont(new Font("微软雅黑", Font.BOLD, 20));
		lblVolName.setFont(new Font("微软雅黑", Font.BOLD, 20));
		lblUsrName.setFont(new Font("微软雅黑", Font.BOLD, 20));
		lblUsrPwd.setFont(new Font("微软雅黑", Font.BOLD, 20));
		
		
          
		lblVolId.setBounds(20, 25, 120, 30);
		lblVolName.setBounds(20, 25, 120, 30);
		lblUsrName.setBounds(20, 25, 120, 30);
		lblUsrPwd.setBounds(20, 25, 120, 30);
		
		tfVolId.setBounds(145, 25, 200, 30);
		tfVolName.setBounds(145, 25, 200, 30);
		tfUsrName.setBounds(145, 25, 200, 30);
		tfUsrPwd .setBounds(145, 25, 200, 30);
		
		btnCommit.setBounds(120, 20, 90, 40);
		btnCancel.setBounds(230, 20, 90, 40);
		
		btnCommit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (UIUtils.isTextEmpty(tfVolId,tfVolName,tfUsrName,tfUsrPwd)) {
					JOptionPane.showMessageDialog(p3, "请将信息填写完整");
				} else if (tfUsrName.getText().length() > 20 || tfUsrPwd.getText().length() > 20) {
					JOptionPane.showMessageDialog(p3, "用户名和密码最多只能有20位哦");
				} else {
					int volId = new Integer(StringUtils.removeUnimportantChar(tfVolId.getText()));
					String volName = StringUtils.removeUnimportantChar(tfVolName.getText());
					String usrName = StringUtils.removeUnimportantChar(tfUsrName.getText());
					String usrPwd = StringUtils.removeUnimportantChar(tfUsrPwd.getText());
					try {
						RegisterService.registerUser(volId, volName, usrName, usrPwd);
					} catch (Exception e1) {
//						System.out.println("exception");
						String message = e1.getMessage();
						JOptionPane.showMessageDialog(p3, message);
						if ("注册成功".equals(message)) {
							close();
						}
					}
				}
			}
		});
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		
		
		p1.add(lblVolId);
		p1.add(tfVolId);
		p2.add(lblVolName);
		p2.add(tfVolName);
		p3.add(lblUsrName);
		p3.add(tfUsrName);
		p4.add(lblUsrPwd);
		p4.add(tfUsrPwd);
		p5.add(btnCommit);
		p5.add(btnCancel);
		add(p1);
		add(p2);
		add(p3);
		add(p4);
		add(p5);
		p1.setBackground(new Color(250, 251, 252));
		p2.setBackground(new Color(250, 251, 252));
		p3.setBackground(new Color(250, 251, 252));
		p4.setBackground(new Color(250, 251, 252));
		p5.setBackground(new Color(250, 251, 252));
		this.getContentPane().setBackground(new Color(250, 251, 252));
		
	}
	
	private void close() {
		this.dispose();
	}
	
}
