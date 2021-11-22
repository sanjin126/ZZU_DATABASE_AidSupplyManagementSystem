package com.aidsystem.service;

import java.sql.Connection;

import com.aidsystem.bean.User;
import com.aidsystem.dao.Impl.UserDAOImpl;
import com.aidsystem.util.JDBCUtils;

public class LoginService {

	public static User login(String name, String pwd){
		
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();
			UserDAOImpl usrDao = new UserDAOImpl();
			return usrDao.getByNameAndPwd(conn, name, pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JDBCUtils.closeConnection(conn, null);
		return null;
	}
}
