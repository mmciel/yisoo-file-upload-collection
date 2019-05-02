package cn.mmciel.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import cn.mmciel.bean.GroupData;
import cn.mmciel.bean.ProjectData;
import cn.mmciel.dao.GroupDataDao;
import cn.mmciel.utils.JdbcUtils;

public class GroupDataDaoImpl implements GroupDataDao {
	QueryRunner runner = null;
	public GroupDataDaoImpl() {
		runner = new QueryRunner(JdbcUtils.getDataSource());

	}
	@Override
	public List<GroupData> getGroupData(String GroupKey) {
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "SELECT * FROM groupdata where groupkey=?";
		try {
			List<GroupData> list = qr.query(sql,
					new BeanListHandler<GroupData>(GroupData.class),
					GroupKey);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
				int update = runner.update(sql,data.getGroupkey(),data.getNumber(),data.getName(),data.getGrade());
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
		String sql = "delete from groupdata "
				+ "where groupkey=?";
		try {
			int update = runner.update(sql,
					data.getGroupkey());
			//删了多少个返回多少个
			//System.out.println(update);
			if(update != 0) {
				return true;
			}else {
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
//	@Test
//	public void sss() {
//		GroupData data = new GroupData();
//		data.setKey("738d075e5039c86444a90eb32cea96b3");
//		GroupDataDaoImpl t = new GroupDataDaoImpl();
//		boolean f = t.DeleteGroupData(data);
//		System.out.println(f);
//	}
}
