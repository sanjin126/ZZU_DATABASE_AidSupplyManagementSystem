package com.aidsystem.view.volunteer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.plaf.metal.MetalBorders.Flush3DBorder;
import javax.swing.text.JTextComponent;

import com.aidsystem.service.GetTableOfTableService;
import com.aidsystem.service.TransSuccessService;
import com.aidsystem.util.UIUtils;

public class TransInfoPanel {
	private JPanel jp = new JPanel(new BorderLayout());
	private JPanel btnPanel = new JPanel(new FlowLayout());
	private JTable transTable;
	private JButton btnCommit =  new JButton("运输成功",UIUtils.setImageSize(new ImageIcon("image/成功.png"), 15, 15));{
//		btnCommit.setBackground(new Color(208, 223, 239));
//		btnCommit.setBorder(new LineBorder(new Color(208, 223, 239), 5));
		btnCommit.setFont(new Font("Dialog", Font.BOLD, 17));
		btnCommit.setHorizontalTextPosition(SwingConstants.LEFT);
		btnPanel.add(btnCommit);
	}
	
	
	public JPanel getTransInfoPanel(JFrame jf) {
	
		transTable = GetTableOfTableService.getTransportationInfo(jf);
		
		Box vbox = Box.createVerticalBox(); //组装a和b
		JPanel descPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));//a
		{
			JLabel lbldesc = new JLabel("您选择的信息为：");
			lbldesc.setFont(new Font("Dialog", Font.BOLD, 15));
			descPanel.add(lbldesc);
		}
		JPanel lblPanel = new JPanel(new GridLayout(5, 4));//b
		JTextField tfAidId = getUnEditableTF(5);
		JTextField tfAid = getUnEditableTF(5);
		JTextField tfPerson = getUnEditableTF(5);
		JTextField tfPhone = getUnEditableTF(5);
		JTextField tfNumber = getUnEditableTF(5);
		JTextField tfDest = getUnEditableTF(5);
		JTextField tfOrgName = getUnEditableTF(5);
		JTextField tfDirector = getUnEditableTF(5);
		JTextField tfOrgPhone = getUnEditableTF(5);
		JTextField tfStatus = getUnEditableTF(5);{
			String[] names = GetTableOfTableService.tranInfo;
			ArrayList<Component> list = getLabelList(names,tfAidId,tfAid,tfPerson,tfPhone,tfNumber,tfDest,tfOrgName,tfDirector,tfOrgPhone,tfStatus);
			fillInLblPanel(list, lblPanel);
		}
		btnCommit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (UIUtils.isTextEmpty(tfAidId)) {
					JOptionPane.showMessageDialog(jp, "您还未选择任何一项哦", "提示", JOptionPane.PLAIN_MESSAGE);
				} else if ("是".equals(tfStatus.getText())) {
					JOptionPane.showMessageDialog(jp, "师傅已成功到达目的地了，不用确认了", "提示", JOptionPane.PLAIN_MESSAGE);
				} else {
					int result = JOptionPane.showConfirmDialog(jp, "是否已成功送达救援物资", "提示", JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.YES_OPTION) {
						TransSuccessService.successByAidId(new Integer(tfAidId.getText()));					
						JOptionPane.showMessageDialog(jp, "更改状态成功", "提示", JOptionPane.PLAIN_MESSAGE);
						VolunteerFrame.refresh(3);
						System.out.println("确认成功");
					} else {
						System.out.println("取消");
					}}}
		});
		btnPanel.setBorder(new Flush3DBorder());
		vbox.add(descPanel);
		vbox.add(lblPanel);
		vbox.add(Box.createVerticalStrut(10));
		vbox.add(btnPanel);
		
		transTable.addMouseListener(UIUtils.getTableClickListener(tfAidId,tfAid,tfPerson,tfPhone,tfNumber,tfDest,tfOrgName,tfDirector,tfOrgPhone,tfStatus));
		jp.add(new JScrollPane(transTable));
		jp.add(vbox, BorderLayout.SOUTH);
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







