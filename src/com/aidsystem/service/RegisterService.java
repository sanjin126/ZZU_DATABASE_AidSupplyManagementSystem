package com.aidsystem.service;

import java.sql.Connection;

import com.aidsystem.bean.User;
import com.aidsystem.bean.Volunteer;
import com.aidsystem.dao.Impl.UserDAOImpl;
import com.aidsystem.dao.Impl.VolunteerDAOImpl;
import com.aidsystem.util.JDBCUtils;

public class RegisterService {
	
	public static void registerUser(int volId, String volName, String usrName, String usrPwd) throws Exception {
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();
			VolunteerDAOImpl volDao = new VolunteerDAOImpl();
			Volunteer vol = volDao.getByIdAndName(conn, volId, volName);
			if (vol != null) {
				UserDAOImpl usrDao = new UserDAOImpl();
				if (usrDao.getByVolId(conn, volId) != null) {
					throw new Exception("您已经注册过帐号了");	
				}
				if (usrDao.getName(conn, usrName) == null) {
					User user = new User(0, usrName, usrPwd, volId);
					usrDao.insert(conn, user);
					throw new Exception("注册成功");	
				} else {
					throw new Exception("存在该用户名，请换一个吧");
				}
			} else {
				throw new Exception("您尚未在志愿者组织登记哦，可以联系我们申请成为志愿者哦");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}finally {
			JDBCUtils.closeConnection(conn, null);
		}
	}

}
