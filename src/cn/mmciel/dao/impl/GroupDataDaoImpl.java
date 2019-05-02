package cn.mmciel.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.dbutils.QueryRunner;

import cn.mmciel.bean.GroupData;
import cn.mmciel.dao.GroupDataDao;
import cn.mmciel.utils.JdbcUtils;

public class GroupDataDaoImpl implements GroupDataDao {
	QueryRunner runner = null;
	public GroupDataDaoImpl() {
		runner = new QueryRunner(JdbcUtils.getDataSource());

	}
	@Override
	public GroupData getGroupData(String Group) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setGroupData(GroupData data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setGroupListData(ArrayList<GroupData> listdata) {
		String sql = "insert into groupdata values"
				+ "(?,?,?,?)";

		try {
			for(GroupData data : listdata) {
				//System.out.println(data.getName());
				int update = runner.update(sql,data.getKey(),data.getNumber(),data.getName(),data.getGrade());
				if(update != 1) {
					return false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true ;
	}

	@Override
	public boolean UpdateGroupData(GroupData data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean DeleteGroupData(GroupData data) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
