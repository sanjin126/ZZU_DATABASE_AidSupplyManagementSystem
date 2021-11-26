package com.aidsystem.service;

import java.sql.Connection;

import com.aidsystem.bean.ItemToUnit;
import com.aidsystem.dao.Impl.ItemToUnitDAOImpl;
import com.aidsystem.util.JDBCUtils;
import com.aidsystem.util.StringUtils;

public class ItemToTypeService {
	
	public static void saveType(String name,String quantity) {
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();
			ItemToUnitDAOImpl dao = new ItemToUnitDAOImpl();
			ItemToUnit itt = dao.getByName(conn, name);
			if (itt == null) {
				String unit = StringUtils.getOnlyStringFromString(quantity);
				if (unit != null) {
					ItemToUnit itemToType = new ItemToUnit(name, unit);
					dao.insert(conn, itemToType);	
				}
			}
			else {
				String unit = StringUtils.getOnlyStringFromString(quantity);
				itt.setUnit(unit);
				dao.updateItt(conn, itt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JDBCUtils.closeConnection(conn, null);
		
	}

}
