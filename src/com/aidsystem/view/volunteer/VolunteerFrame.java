package com.aidsystem.view.volunteer;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.aidsystem.service.GetTableOfTableService;
import com.aidsystem.util.UIUtils;

public class VolunteerFrame {
	static int volId; //实例化时进行初始化
	static JFrame jf = new JFrame("志愿者们辛苦了");
	{
		jf.setIconImage(UIUtils.setImageSize(new ImageIcon("image/物资管理.png"), 15, 15).getImage());
	}
	private int WIDTH = 1300;
	private int HEIGHT = 500;
	private static JTabbedPane tabPane= new JTabbedPane(JTabbedPane.TOP, JTabbedPane.WRAP_TAB_LAYOUT);
	private static CheckPanel ckp = new CheckPanel();
	private static JPanel checkPanel = ckp.getCheckPanel(jf);
	private static JPanel aidPanel = new AidSupplyPanel().getAidSupplyPanel(jf);
	private static JPanel demPanel = new DemSupplyPanel().getDemPanel(jf);
	private static JPanel transPanel = new TransInfoPanel().getTransInfoPanel(jf);
	JMenuBar mb = new JMenuBar();
	JMenu manage = new JMenu("管理");
	JMenuItem manageDistribute = new JMenuItem("物资分配");
	JMenuItem manageVol = new JMenuItem("志愿者管理");
	JMenuItem managePer = new JMenuItem("运输人员管理");
	JMenuItem freshFrame = new JMenuItem("刷新",UIUtils.setImageSize(new ImageIcon("image/刷新.png"), 15, 15));
	JMenu help = new JMenu("帮助");
	JMenuItem intro = new JMenuItem("关于我们");
	JMenuItem relativeWed = new JMenuItem("关联网站");
	
	public VolunteerFrame(int volId) {
		VolunteerFrame.volId = volId;
	}
	
	
	public void init() {
		jf.setSize(WIDTH, HEIGHT);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//各个标签页的加载
		tabPane.setFont(new Font("微软雅黑", Font.BOLD, 15)); //修改标签全局字体大小
		tabPane.addTab("待审核信息", UIUtils.setImageSize(new ImageIcon("image/check.png"), 20, 20), checkPanel, "需要志愿者进行审核");
		tabPane.addTab("捐赠信息", UIUtils.setImageSize(new ImageIcon("image/应急救援.png"), 20, 20), aidPanel, "捐赠物资信息");
		tabPane.addTab("求助信息", UIUtils.setImageSize(new ImageIcon("image/爱心.png"),20, 20), demPanel, "各地组织的需求信息");
		tabPane.addTab("运输信息", UIUtils.setImageSize(new ImageIcon("image/运输.png"),20, 20), transPanel, "物资的运输信息");
		
		//装载标签页
		jf.add(tabPane);
		//加上菜单
		manageDistribute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AidDemSplitPanel().init(jf);
			}
		});
		manageVol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ManageVolPanel().init(jf);
			}
		});
		managePer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ManageTrPersonPanel().init(jf);
			}
		});
		intro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame jf1 = new JFrame("加入我们吧");
				
				jf1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				jf1.setSize(300, 200);
				jf1.setLocationRelativeTo(jf);
				JTextArea ta = new JTextArea("在七月底的河南暴雨中，我是一名亲历者，我身边有不少的朋友也在那次暴雨中遇到了不少的麻烦我一直在想我可不可以做点什么...于是，我就做出了这个救援系统");
				ta.setEditable(false);
				ta.setLineWrap(true);
			
				jf1.add(ta);
				jf1.setVisible(true);
				
			}
		});
		relativeWed.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					JFrame frame = new JFrame();
					frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					frame.setSize(700, 500);
					frame.setLocationRelativeTo(jf);
					JEditorPane editorPane = new JEditorPane("https://yule.qlwb.com.cn/detail/17150614.html");
					editorPane.setEditable(false);
					
					frame.add(new JScrollPane(editorPane));
					frame.getContentPane().setBackground(Color.white);
					frame.setVisible(true);
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		if (volId!=1001) { //志愿者的总负责人 1001号志愿者
			manageVol.setEnabled(false);
			managePer.setEnabled(false);		
		}
		manage.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		manageDistribute.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		manageVol.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		managePer.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		help.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		intro.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		relativeWed.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		manage.add(manageDistribute);
		manage.add(manageVol);
		manage.add(managePer);
		help.add(intro);
		help.add(relativeWed);
		mb.add(manage);
		mb.add(help);
		jf.setJMenuBar(mb);
		
		jf.setVisible(true);
		
		//添加刷新功能监听器
		// Q：每次刷新后会失去选中的表格行
		tabPane.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				int selectedIndex = tabPane.getSelectedIndex();
				switch (selectedIndex) {
				case 0:
					checkPanel = new CheckPanel().getCheckPanel(jf);
					tabPane.setComponentAt(0, checkPanel);
					break;
				case 1:
					aidPanel = new AidSupplyPanel().getAidSupplyPanel(jf);
					tabPane.setComponentAt(1, aidPanel);
					break;
				case 2:
					demPanel = new DemSupplyPanel().getDemPanel(jf);
					tabPane.setComponentAt(2, demPanel);
					break;
				case 3:
					transPanel = new TransInfoPanel().getTransInfoPanel(jf);
					tabPane.setComponentAt(3, transPanel);
					break;
				default:
					break;
				}
			}
		});
		
	}
	/**
	 * 
	 * @Description 实现各子面板的刷新功能
	 * @author sanjin
	 * @param index 面板次序
	 */
	public static void refresh(int index) {
		switch (index) {
		case 0:
			checkPanel = new CheckPanel().getCheckPanel(jf);
			tabPane.setComponentAt(0, checkPanel);
//			System.out.println(tabPane.getSelectedIndex());
			break;
		case 1:
			aidPanel = new AidSupplyPanel().getAidSupplyPanel(jf);
			tabPane.setComponentAt(1, aidPanel);
//			System.out.println(tabPane.getSelectedIndex());
			break;
		case 2:
			demPanel = new DemSupplyPanel().getDemPanel(jf);
			tabPane.setComponentAt(2, demPanel);
//			System.out.println(tabPane.getSelectedIndex());
			break;
		case 3:
			transPanel = new TransInfoPanel().getTransInfoPanel(jf);
			tabPane.setComponentAt(3, transPanel);
//			System.out.println(tabPane.getSelectedIndex());
			break;
		default:
			System.out.println(tabPane.getSelectedIndex());
			break;
		}
	}
	
	public static void main(String[] args) {
		new VolunteerFrame(1008).init();
		
	}

}
