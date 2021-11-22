package com.aidsystem.service;

import java.sql.Connection;

import com.aidsystem.bean.ItemToType;
import com.aidsystem.dao.Impl.ItemToTypeDAOImpl;
import com.aidsystem.util.JDBCUtils;
import com.aidsystem.util.StringUtils;

public class ItemToTypeService {
	
	public static void saveType(String name,String quantity) {
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();
			ItemToTypeDAOImpl dao = new ItemToTypeDAOImpl();
			ItemToType itt = dao.getByName(conn, name);
			if (itt == null) {
				String unit = StringUtils.getOnlyStringFromString(quantity);
				if (unit != null) {
					ItemToType itemToType = new ItemToType(name, unit);
					dao.insert(conn, itemToType);	
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JDBCUtils.closeConnection(conn, null);
		
	}

}
