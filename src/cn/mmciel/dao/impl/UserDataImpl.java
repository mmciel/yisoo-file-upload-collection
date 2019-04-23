package cn.mmciel.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import cn.mmciel.bean.UserData;
import cn.mmciel.dao.UserDataDao;
import cn.mmciel.utils.JdbcUtils;

public class UserDataImpl implements UserDataDao{
	Connection con = null;
	QueryRunner runner = null;

	public UserDataImpl() {
		con = JdbcUtils.getConnection();
		runner = new QueryRunner(JdbcUtils.getDataSource());
	}
//	public UserDataImpl(UserData userdata) {
//		
//		con = JdbcUtils.getConnection();
//		runner = new QueryRunner(JdbcUtils.getDataSource());
//	}
	
	/**
	 * 查找一个用户的账户密码是否在表
	 */
	public boolean getFind(UserData data) {
		List<UserData> userdata = this.getUserData();
		Boolean result = false;
		if(userdata == null) return false;
		for(UserData ud : userdata) {
			if(ud.getUsername().equals(data.getUsername()) && ud.getPassword().equals(data.getPassword())) {
				result = true;
				break;
			}
		}
		
		return result;
	}
	/**
	 * 查找一个用户的账户密码是否在表
	 */
	public String getUserId(UserData data) {
		List<UserData> userdata = this.getUserData();
		String result = null;
		if(userdata == null) return null;
		for(UserData ud : userdata) {
			if(ud.getUsername().equals(data.getUsername()) && ud.getPassword().equals(data.getPassword())) {
				result = Integer.toString(ud.getUserid());
				break;
			}
		}
		
		return result;
	}
	/**
	 * 创建一个用户
	 */
	public boolean setUserData(UserData data) {
		String username = data.getUsername();
		String usermail = data.getUsermail();
		String password = data.getPassword();
		int permission = data.getPermission();
		String sql = "insert into userdata values(null,?,?,?,?)";
		
		try {
			int update = runner.update(sql, username,usermail,password,permission);
			if(update == 1) {
				return true;
			}else {
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean UpdateUserData(UserData data) {
		return false;
	}

	public boolean DeleteUserData(UserData data) {
		return false;
	}
	
	@Test
	public List<UserData> getUserData(){
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "SELECT * FROM userdata";
		try {
			List<UserData> list = qr.query(sql, new BeanListHandler<UserData>(UserData.class));
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
