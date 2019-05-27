package cn.mmciel.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.mmciel.bean.ProjectData;
import cn.mmciel.bean.ProjectShareData;
import cn.mmciel.dao.ProjectShareDataDao;
import cn.mmciel.utils.JdbcUtils;

public class ProjectShareDataDaoImpl implements ProjectShareDataDao {
	QueryRunner runner = null;
	public ProjectShareDataDaoImpl() {
		runner = new QueryRunner(JdbcUtils.getDataSource());

	}
	@Override
	public boolean setProjectShareData(ProjectShareData data) {
		String sql = "insert into projectsharedata values"
				+ "(?,?,?)";
		try {
			int update = runner.update(sql,
					data.getProjectId(),
					data.getProjectKey(),
					"-"
					);
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
	public ProjectShareData getProjectShareDataById(String data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProjectShareData getProjectShareDataByKey(String data) {
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "SELECT * FROM projectsharedata where projectkey=?";
		try {
			List<ProjectShareData> list = qr.query(sql,
					new BeanListHandler<ProjectShareData>(ProjectShareData.class),
					data);
			return list.get(0);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getProjectIdByKey(String data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getProjectKeyById(String data) {
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "SELECT * FROM projectsharedata where projectid=?";
		try {
			List<ProjectShareData> list = qr.query(sql,
					new BeanListHandler<ProjectShareData>(ProjectShareData.class),
					data);
			
			return list.get(0).getProjectKey();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public boolean DelProjectShareDataByProjectId(String data) {
		String sql = "delete from projectsharedata where projectid=?";
		try {
			int update = runner.update(sql,data);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
