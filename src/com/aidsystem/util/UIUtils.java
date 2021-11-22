package com.aidsystem.util;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

import org.junit.Test;

public class UIUtils {
	
	/**
	 * 
	 * @Description 传入一个图片,修改图片大小
	 * @author sanjin
	 * @param image
	 * @param width
	 * @param height
	 * @return 
	 */
	public static ImageIcon setImageSize(ImageIcon image, int width, int height) {
		image.setImage(image.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
		return image;
	}
	/**
	 * 
	 * @Description 专门用于表格的单击事件监听器，通过传入所展示的文本框，通过点击事件更新文本框的值
	 * @author sanjin
	 * @param args
	 * @return
	 */
	public static MouseAdapter getTableClickListener(JTextComponent ...args) {
		return new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JTable table = (JTable)e.getSource();
				int columnCount = table.getColumnCount();
				int selectedRow = table.getSelectedRow();
				
				for (int i = 0; i < args.length; i++) {
					Object value = table.getValueAt(selectedRow, i);
					if (value!=null) {
						args[i].setText(value.toString());
					}else {
						args[i].setText(null);
					}
				}
			}	
		};
	}
	/**
	 * 
	 * @Description 判断TextField或TextArea中所填信息是否为空
	 * @author sanjin
	 * @param args
	 * @return
	 */
	public static boolean isTextEmpty(JTextComponent ...args) {
		
		for (int i = 0; i < args.length; i++) {
			if(isEmpty(args[i].getText())) {
				return true;
			}
		}
		return false;
		
	}
	
	private static boolean isEmpty(String str){
		str = StringUtils.removeUnimportantChar(str);
		if (str!=null && str.length()>0){
			return false;
		}
			return true;
	}

}
