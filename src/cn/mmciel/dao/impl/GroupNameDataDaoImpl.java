package cn.mmciel.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import cn.mmciel.bean.GroupData;
import cn.mmciel.bean.GroupNameData;
import cn.mmciel.bean.ProjectData;
import cn.mmciel.dao.GroupNameDataDao;
import cn.mmciel.utils.JdbcUtils;

public class GroupNameDataDaoImpl implements GroupNameDataDao {

	QueryRunner runner = null;
	public GroupNameDataDaoImpl() {
		runner = new QueryRunner(JdbcUtils.getDataSource());

	}
	@Override
	public boolean getFind(GroupNameData data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setGroupNameData(GroupNameData data) {
		String sql = "insert into groupnamedata values"
				+ "(?,?,?)";
		try {
			int update = runner.update(sql,
					data.getUserid(),
					data.getGroupkey(),
					data.getGroupName());
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

	@Override
	public boolean UpdateGroupNameData(GroupNameData data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean DeleteGroupNameData(GroupNameData data) {
		String sql = "delete from groupnamedata "
				+ "where userid=? and groupname=?";
		try {
			int update = runner.update(sql,
					data.getUserid(),
					data.getGroupName());
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

	@Override
	public List<GroupNameData> getGroupNameDataByUserId(String Userid) {
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "SELECT * FROM groupnamedata where userid=?";
		try {
			List<GroupNameData> list = qr.query(sql, new BeanListHandler<GroupNameData>(GroupNameData.class),Userid);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public String getGroupNameDataByGroupKey(String groupKey) {
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "SELECT * FROM groupnamedata where groupkey=?";
		try {
			List<GroupNameData> list = qr.query(sql, new BeanListHandler<GroupNameData>(GroupNameData.class),groupKey);
			return list.get(0).getGroupName();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
