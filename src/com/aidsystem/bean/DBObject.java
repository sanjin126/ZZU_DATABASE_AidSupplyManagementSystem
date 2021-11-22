package com.aidsystem.bean;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 * 
 * @Description 此类用于存放尚未关闭的PreparedStatment对象和ResultSet对象，待完全使用后将其关闭
 * @author sanjin
 * @version
 * @date 2021年11月18日上午9:39:41
 *
 */
@Deprecated
public class DBObject {
	private PreparedStatement ps;
	private ResultSet rs;
	
	public DBObject(PreparedStatement ps, ResultSet rs) {
		super();
		this.ps = ps;
		this.rs = rs;
	}

	public PreparedStatement getPs() {
		return ps;
	}

	public ResultSet getRs() {
		return rs;
	}

	@Override
	public String toString() {
		return "DBObject [ps=" + ps + ", rs=" + rs + "]";
	}
	
	
	

}
