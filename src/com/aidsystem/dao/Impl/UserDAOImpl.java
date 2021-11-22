package com.aidsystem.dao.Impl;

import java.sql.Connection;
import java.util.List;

import com.aidsystem.bean.User;
import com.aidsystem.dao.BaseDAO;
import com.aidsystem.dao.UserDAO;

public class UserDAOImpl extends BaseDAO<User> implements UserDAO {

	@Override
	public void insert(Connection conn, User user) {
		String sql = "insert into user_info values(?,?,?,?)";
		update(conn, sql, null,user.getUserName(),user.getUserPwd(),user.getVolId());

	}

	@Override
	public void deleteById(Connection conn, int id) {
		String sql = "delete from user_info where id=?";
		update(conn, sql , id);
	}

	@Override
	public void updateUsr(Connection conn, User user) {
		String sql = "update user_info set user_name=?,user_pwd=?,vol_id=? "
				+ "where id=?";
		update(conn, sql , user.getUserName(),user.getUserPwd(),user.getVolId(),user.getId());

	}

	@Override
	public User getById(Connection conn, int id) {
		String sql = "select id,user_name userName,user_pwd userPwd,vol_id volId from user_info where id=?";
		return query(conn, sql , id);
	}

	@Override
	public List<User> getAll(Connection conn) {
		String sql = "select id,user_name userName,user_pwd userPwd,vol_id volId from user_info";
		return queryList(conn, sql);
	}

	@Override
	public long getCount(Connection conn) {
		String sql = "select count(*) from user_info";
		return getValue(conn, sql);
	}

	@Override
	public User getByNameAndPwd(Connection conn, String name, String pwd) {
		String sql = "select id,user_name userName,user_pwd userPwd,vol_id volId from user_info where user_name=? and user_pwd=?";
		return query(conn, sql, name, pwd);
	}

	@Override
	public User getName(Connection conn, String name) {
		String sql = "select id,user_name userName,user_pwd userPwd,vol_id volId from user_info where user_name=?";
		return query(conn, sql, name);
	}
	@Override
	public User getByVolId(Connection conn, int id) {
		String sql = "select id,user_name userName,user_pwd userPwd,vol_id volId from user_info where vol_id=?";
		return query(conn, sql, id);
	}
	
	

}
